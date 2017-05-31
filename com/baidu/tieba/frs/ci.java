package com.baidu.tieba.frs;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ci {
    private TranslateAnimation bXe;
    private View bXb = null;
    private int bXc = 2000;
    private Runnable bXf = new cj(this);
    private ValueAnimator bXd = new ValueAnimator();

    public ci() {
        this.bXd.setFloatValues(1.0f, 0.0f);
        this.bXd.setDuration(400L);
        this.bXd.addUpdateListener(new ck(this));
        this.bXd.addListener(new cl(this));
        this.bXe = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds56), 0.0f);
        this.bXe.setDuration(400L);
        this.bXe.setAnimationListener(new cm(this));
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.bXb = view;
            abh();
            viewGroup.addView(this.bXb, layoutParams);
            this.bXb.setVisibility(0);
            this.bXc = i;
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.bXf);
            com.baidu.adp.lib.g.h.fS().postDelayed(this.bXf, this.bXc);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.bXf);
        if (this.bXb != null && this.bXb.getParent() != null && this.bXb.getVisibility() == 0 && !this.bXd.isRunning()) {
            this.bXd.start();
        }
    }

    public void abh() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.bXf);
        if (this.bXb != null) {
            if (this.bXd != null && this.bXd.isRunning()) {
                this.bXd.cancel();
            }
            this.bXb.clearAnimation();
            if (this.bXb.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bXb.getParent()).removeView(this.bXb);
            }
            this.bXb.setVisibility(8);
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.bXf);
    }
}
