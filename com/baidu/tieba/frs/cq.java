package com.baidu.tieba.frs;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class cq {
    private TranslateAnimation bSV;
    private View bSS = null;
    private int bST = 2000;
    private Runnable bSW = new cr(this);
    private ValueAnimator bSU = new ValueAnimator();

    public cq() {
        this.bSU.setFloatValues(1.0f, 0.0f);
        this.bSU.setDuration(400L);
        this.bSU.addUpdateListener(new cs(this));
        this.bSU.addListener(new ct(this));
        this.bSV = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds56), 0.0f);
        this.bSV.setDuration(400L);
        this.bSV.setAnimationListener(new cu(this));
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.bSS = view;
            abO();
            viewGroup.addView(this.bSS, layoutParams);
            this.bSS.setVisibility(0);
            this.bST = i;
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.bSW);
            com.baidu.adp.lib.g.h.fS().postDelayed(this.bSW, this.bST);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.bSW);
        if (this.bSS != null && this.bSS.getParent() != null && this.bSS.getVisibility() == 0 && !this.bSU.isRunning()) {
            this.bSU.start();
        }
    }

    public void abO() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.bSW);
        if (this.bSS != null) {
            if (this.bSU != null && this.bSU.isRunning()) {
                this.bSU.cancel();
            }
            this.bSS.clearAnimation();
            if (this.bSS.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bSS.getParent()).removeView(this.bSS);
            }
            this.bSS.setVisibility(8);
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.bSW);
    }
}
