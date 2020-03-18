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
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.ala.liveroom.a {
    private int ME;
    private TextView dBL;
    private boolean eUh;
    private ObjectAnimator fgJ;
    private int fgK;
    private Context mContext;
    private View mRootView;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext);
        this.fgK = 4000;
        this.eUh = true;
        this.mContext = tbPageContext.getPageActivity();
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_liveroom_translate_view, (ViewGroup) null);
        this.dBL = (TextView) this.mRootView.findViewById(a.g.translate_content);
        al(viewGroup);
    }

    public void al(ViewGroup viewGroup) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds56));
        layoutParams.addRule(3, a.g.guard_club_entry_id);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        viewGroup.addView(this.mRootView, layoutParams);
        this.mRootView.setVisibility(8);
    }

    public void at(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (i > 0) {
                this.fgK = i;
            }
            if (this.eUh) {
                this.mRootView.setVisibility(0);
            }
            this.dBL.setText(str);
            enterAnimation();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.fgJ != null) {
            this.fgJ.cancel();
            this.fgJ = null;
        }
    }

    private void enterAnimation() {
        this.ME = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
        this.fgJ = ObjectAnimator.ofFloat(this.mRootView, "TranslationX", this.ME, -this.ME);
        this.fgJ.setDuration(this.fgK);
        this.fgJ.start();
    }

    public void setCanVisible(boolean z) {
        this.eUh = z;
    }

    public void setVisible(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}
