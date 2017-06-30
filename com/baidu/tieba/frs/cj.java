package com.baidu.tieba.frs;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class cj {
    private TranslateAnimation cfn;
    private View cfk = null;
    private int cfl = 2000;
    private Runnable cfo = new ck(this);
    private ValueAnimator cfm = new ValueAnimator();

    public cj() {
        this.cfm.setFloatValues(1.0f, 0.0f);
        this.cfm.setDuration(400L);
        this.cfm.addUpdateListener(new cl(this));
        this.cfm.addListener(new cm(this));
        this.cfn = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds56), 0.0f);
        this.cfn.setDuration(400L);
        this.cfn.setAnimationListener(new cn(this));
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.cfk = view;
            aeY();
            viewGroup.addView(this.cfk, layoutParams);
            this.cfk.setVisibility(0);
            this.cfl = i;
            com.baidu.adp.lib.g.h.fR().removeCallbacks(this.cfo);
            com.baidu.adp.lib.g.h.fR().postDelayed(this.cfo, this.cfl);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.cfo);
        if (this.cfk != null && this.cfk.getParent() != null && this.cfk.getVisibility() == 0 && !this.cfm.isRunning()) {
            this.cfm.start();
        }
    }

    public void aeY() {
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.cfo);
        if (this.cfk != null) {
            if (this.cfm != null && this.cfm.isRunning()) {
                this.cfm.cancel();
            }
            this.cfk.clearAnimation();
            if (this.cfk.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.cfk.getParent()).removeView(this.cfk);
            }
            this.cfk.setVisibility(8);
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.cfo);
    }
}
