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
/* loaded from: classes7.dex */
public class b extends com.baidu.tieba.ala.liveroom.a {
    private int ahA;
    private TextView ePw;
    private boolean fOn;
    private ObjectAnimator gEa;
    private int gEb;
    private Context mContext;
    private View mRootView;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext);
        this.gEb = 4000;
        this.fOn = true;
        this.mContext = tbPageContext.getPageActivity();
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_liveroom_translate_view, (ViewGroup) null);
        this.ePw = (TextView) this.mRootView.findViewById(a.g.translate_content);
        ay(viewGroup);
    }

    public void ay(ViewGroup viewGroup) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds56));
        layoutParams.addRule(3, a.g.guard_club_entry_id);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        viewGroup.addView(this.mRootView, layoutParams);
        this.mRootView.setVisibility(8);
    }

    public void aF(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (i > 0) {
                this.gEb = i;
            }
            if (this.fOn) {
                this.mRootView.setVisibility(0);
            }
            this.ePw.setText(str);
            bUE();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.gEa != null) {
            this.gEa.cancel();
            this.gEa = null;
        }
    }

    private void bUE() {
        this.ahA = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
        this.gEa = ObjectAnimator.ofFloat(this.mRootView, "TranslationX", this.ahA, -this.ahA);
        this.gEa.setDuration(this.gEb);
        this.gEa.start();
    }

    public void setCanVisible(boolean z) {
        this.fOn = z;
    }

    public void setVisible(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}
