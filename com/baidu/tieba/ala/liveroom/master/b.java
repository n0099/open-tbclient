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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.ala.liveroom.a {
    private int ags;
    private TextView eEV;
    private boolean fCW;
    private ObjectAnimator grg;
    private int grh;
    private Context mContext;
    private View mRootView;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext);
        this.grh = 4000;
        this.fCW = true;
        this.mContext = tbPageContext.getPageActivity();
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_liveroom_translate_view, (ViewGroup) null);
        this.eEV = (TextView) this.mRootView.findViewById(a.g.translate_content);
        ax(viewGroup);
    }

    public void ax(ViewGroup viewGroup) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds56));
        layoutParams.addRule(3, a.g.guard_club_entry_id);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        viewGroup.addView(this.mRootView, layoutParams);
        this.mRootView.setVisibility(8);
    }

    public void aC(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (i > 0) {
                this.grh = i;
            }
            if (this.fCW) {
                this.mRootView.setVisibility(0);
            }
            this.eEV.setText(str);
            bKB();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.grg != null) {
            this.grg.cancel();
            this.grg = null;
        }
    }

    private void bKB() {
        this.ags = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
        this.grg = ObjectAnimator.ofFloat(this.mRootView, "TranslationX", this.ags, -this.ags);
        this.grg.setDuration(this.grh);
        this.grg.start();
    }

    public void setCanVisible(boolean z) {
        this.fCW = z;
    }

    public void setVisible(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}
