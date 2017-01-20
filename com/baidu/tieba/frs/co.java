package com.baidu.tieba.frs;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class co {
    private TranslateAnimation bJJ;
    private View bJG = null;
    private int bJH = 2000;
    private Runnable bJK = new cp(this);
    private ValueAnimator bJI = new ValueAnimator();

    public co() {
        this.bJI.setFloatValues(1.0f, 0.0f);
        this.bJI.setDuration(400L);
        this.bJI.addUpdateListener(new cq(this));
        this.bJI.addListener(new cr(this));
        this.bJJ = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.m9getInst().getResources().getDimension(r.f.ds56), 0.0f);
        this.bJJ.setDuration(400L);
        this.bJJ.setAnimationListener(new cs(this));
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.bJG = view;
            Zs();
            viewGroup.addView(this.bJG, layoutParams);
            this.bJG.setVisibility(0);
            this.bJH = i;
            com.baidu.adp.lib.g.h.eE().removeCallbacks(this.bJK);
            com.baidu.adp.lib.g.h.eE().postDelayed(this.bJK, this.bJH);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.bJK);
        if (this.bJG != null && this.bJG.getParent() != null && this.bJG.getVisibility() == 0 && !this.bJI.isRunning()) {
            this.bJI.start();
        }
    }

    public void Zs() {
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.bJK);
        if (this.bJG != null) {
            if (this.bJI != null && this.bJI.isRunning()) {
                this.bJI.cancel();
            }
            this.bJG.clearAnimation();
            if (this.bJG.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bJG.getParent()).removeView(this.bJG);
            }
            this.bJG.setVisibility(8);
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.h.eE().removeCallbacks(this.bJK);
    }
}
