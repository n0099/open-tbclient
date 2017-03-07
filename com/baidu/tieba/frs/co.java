package com.baidu.tieba.frs;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class co {
    private TranslateAnimation bQP;
    private View bQM = null;
    private int bQN = 2000;
    private Runnable bQQ = new cp(this);
    private ValueAnimator bQO = new ValueAnimator();

    public co() {
        this.bQO.setFloatValues(1.0f, 0.0f);
        this.bQO.setDuration(400L);
        this.bQO.addUpdateListener(new cq(this));
        this.bQO.addListener(new cr(this));
        this.bQP = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.m9getInst().getResources().getDimension(w.f.ds56), 0.0f);
        this.bQP.setDuration(400L);
        this.bQP.setAnimationListener(new cs(this));
    }

    public void a(View view, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i) {
        if (viewGroup != null && view != null) {
            this.bQM = view;
            aap();
            viewGroup.addView(this.bQM, layoutParams);
            this.bQM.setVisibility(0);
            this.bQN = i;
            com.baidu.adp.lib.g.h.fM().removeCallbacks(this.bQQ);
            com.baidu.adp.lib.g.h.fM().postDelayed(this.bQQ, this.bQN);
        }
    }

    public void hideTip() {
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.bQQ);
        if (this.bQM != null && this.bQM.getParent() != null && this.bQM.getVisibility() == 0 && !this.bQO.isRunning()) {
            this.bQO.start();
        }
    }

    public void aap() {
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.bQQ);
        if (this.bQM != null) {
            if (this.bQO != null && this.bQO.isRunning()) {
                this.bQO.cancel();
            }
            this.bQM.clearAnimation();
            if (this.bQM.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.bQM.getParent()).removeView(this.bQM);
            }
            this.bQM.setVisibility(8);
        }
    }

    public void onDestroy() {
        com.baidu.adp.lib.g.h.fM().removeCallbacks(this.bQQ);
    }
}
