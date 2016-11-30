package com.baidu.tieba.frs;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class cs {
    private TranslateAnimation bWj;
    private View bWg = null;
    private int bWh = 2000;
    private Runnable bWk = new ct(this);
    private ValueAnimator bWi = new ValueAnimator();

    public cs() {
        this.bWi.setFloatValues(1.0f, 0.0f);
        this.bWi.setDuration(400L);
        this.bWi.addUpdateListener(new cu(this));
        this.bWi.addListener(new cv(this));
        this.bWj = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.m9getInst().getResources().getDimension(r.e.ds56), 0.0f);
        this.bWj.setDuration(400L);
        this.bWj.setAnimationListener(new cw(this));
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.bWg = view;
            adP();
            viewGroup.addView(this.bWg, layoutParams);
            this.bWg.setVisibility(0);
            this.bWh = i;
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.bWk);
            com.baidu.adp.lib.h.h.eG().postDelayed(this.bWk, this.bWh);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.bWk);
        if (this.bWg != null && this.bWg.getParent() != null && this.bWg.getVisibility() == 0 && !this.bWi.isRunning()) {
            this.bWi.start();
        }
    }

    public void adP() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.bWk);
        if (this.bWg != null) {
            if (this.bWi != null && this.bWi.isRunning()) {
                this.bWi.cancel();
            }
            this.bWg.clearAnimation();
            if (this.bWg.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bWg.getParent()).removeView(this.bWg);
            }
            this.bWg.setVisibility(8);
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.bWk);
    }
}
