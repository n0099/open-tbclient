package com.baidu.tieba.ala.liveroom.master;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.mapapi.UIMsg;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.ala.liveroom.a {
    private int GP;
    private TextView cJp;
    private boolean dXX;
    private ObjectAnimator ejL;
    private int ejM;
    private Context mContext;
    private View mRootView;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext);
        this.ejM = UIMsg.m_AppUI.MSG_APP_SAVESCREEN;
        this.dXX = true;
        this.mContext = tbPageContext.getPageActivity();
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_liveroom_translate_view, (ViewGroup) null);
        this.cJp = (TextView) this.mRootView.findViewById(a.g.translate_content);
        ag(viewGroup);
    }

    public void ag(ViewGroup viewGroup) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds56));
        layoutParams.addRule(3, a.g.guard_club_entry_id);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        viewGroup.addView(this.mRootView, layoutParams);
        this.mRootView.setVisibility(8);
    }

    public void al(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (i > 0) {
                this.ejM = i;
            }
            if (this.dXX) {
                this.mRootView.setVisibility(0);
            }
            this.cJp.setText(str);
            aUk();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.ejL != null) {
            this.ejL.cancel();
            this.ejL = null;
        }
    }

    private void aUk() {
        this.GP = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
        this.ejL = ObjectAnimator.ofFloat(this.mRootView, "TranslationX", this.GP, -this.GP);
        this.ejL.setDuration(this.ejM);
        this.ejL.start();
    }

    public void setCanVisible(boolean z) {
        this.dXX = z;
    }

    public void setVisible(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}
