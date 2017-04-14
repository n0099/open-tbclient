package com.baidu.tieba.frs;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class cq {
    private TranslateAnimation bQE;
    private View bQB = null;
    private int bQC = 2000;
    private Runnable bQF = new cr(this);
    private ValueAnimator bQD = new ValueAnimator();

    public cq() {
        this.bQD.setFloatValues(1.0f, 0.0f);
        this.bQD.setDuration(400L);
        this.bQD.addUpdateListener(new cs(this));
        this.bQD.addListener(new ct(this));
        this.bQE = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds56), 0.0f);
        this.bQE.setDuration(400L);
        this.bQE.setAnimationListener(new cu(this));
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.bQB = view;
            aaN();
            viewGroup.addView(this.bQB, layoutParams);
            this.bQB.setVisibility(0);
            this.bQC = i;
            com.baidu.adp.lib.g.h.fR().removeCallbacks(this.bQF);
            com.baidu.adp.lib.g.h.fR().postDelayed(this.bQF, this.bQC);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.bQF);
        if (this.bQB != null && this.bQB.getParent() != null && this.bQB.getVisibility() == 0 && !this.bQD.isRunning()) {
            this.bQD.start();
        }
    }

    public void aaN() {
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.bQF);
        if (this.bQB != null) {
            if (this.bQD != null && this.bQD.isRunning()) {
                this.bQD.cancel();
            }
            this.bQB.clearAnimation();
            if (this.bQB.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bQB.getParent()).removeView(this.bQB);
            }
            this.bQB.setVisibility(8);
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.bQF);
    }
}
