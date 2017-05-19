package com.baidu.tieba.frs;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ch {
    private TranslateAnimation bRo;
    private View bRl = null;
    private int bRm = 2000;
    private Runnable bRp = new ci(this);
    private ValueAnimator bRn = new ValueAnimator();

    public ch() {
        this.bRn.setFloatValues(1.0f, 0.0f);
        this.bRn.setDuration(400L);
        this.bRn.addUpdateListener(new cj(this));
        this.bRn.addListener(new ck(this));
        this.bRo = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds56), 0.0f);
        this.bRo.setDuration(400L);
        this.bRo.setAnimationListener(new cl(this));
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.bRl = view;
            aaf();
            viewGroup.addView(this.bRl, layoutParams);
            this.bRl.setVisibility(0);
            this.bRm = i;
            com.baidu.adp.lib.g.h.fS().removeCallbacks(this.bRp);
            com.baidu.adp.lib.g.h.fS().postDelayed(this.bRp, this.bRm);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.bRp);
        if (this.bRl != null && this.bRl.getParent() != null && this.bRl.getVisibility() == 0 && !this.bRn.isRunning()) {
            this.bRn.start();
        }
    }

    public void aaf() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.bRp);
        if (this.bRl != null) {
            if (this.bRn != null && this.bRn.isRunning()) {
                this.bRn.cancel();
            }
            this.bRl.clearAnimation();
            if (this.bRl.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bRl.getParent()).removeView(this.bRl);
            }
            this.bRl.setVisibility(8);
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.h.fS().removeCallbacks(this.bRp);
    }
}
