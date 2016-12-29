package com.baidu.tieba.frs;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class cs {
    private TranslateAnimation bCt;
    private View bCq = null;
    private int bCr = 2000;
    private Runnable bCu = new ct(this);
    private ValueAnimator bCs = new ValueAnimator();

    public cs() {
        this.bCs.setFloatValues(1.0f, 0.0f);
        this.bCs.setDuration(400L);
        this.bCs.addUpdateListener(new cu(this));
        this.bCs.addListener(new cv(this));
        this.bCt = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.m9getInst().getResources().getDimension(r.e.ds56), 0.0f);
        this.bCt.setDuration(400L);
        this.bCt.setAnimationListener(new cw(this));
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.bCq = view;
            Yj();
            viewGroup.addView(this.bCq, layoutParams);
            this.bCq.setVisibility(0);
            this.bCr = i;
            com.baidu.adp.lib.h.h.eG().removeCallbacks(this.bCu);
            com.baidu.adp.lib.h.h.eG().postDelayed(this.bCu, this.bCr);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.bCu);
        if (this.bCq != null && this.bCq.getParent() != null && this.bCq.getVisibility() == 0 && !this.bCs.isRunning()) {
            this.bCs.start();
        }
    }

    public void Yj() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.bCu);
        if (this.bCq != null) {
            if (this.bCs != null && this.bCs.isRunning()) {
                this.bCs.cancel();
            }
            this.bCq.clearAnimation();
            if (this.bCq.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bCq.getParent()).removeView(this.bCq);
            }
            this.bCq.setVisibility(8);
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.bCu);
    }
}
