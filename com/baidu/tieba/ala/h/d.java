package com.baidu.tieba.ala.h;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
/* loaded from: classes10.dex */
public class d {
    private AnimatorSet iiB = null;
    private AnimatorSet iiC = null;
    private AnimatorSet iiD = null;
    private View iiE;

    public d(View view) {
        this.iiE = view;
    }

    public void startAnim() {
        if (this.iiB == null) {
            this.iiB = new AnimatorSet();
            this.iiC = new AnimatorSet();
            this.iiD = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.iiE, "scaleX", 1.06f, 0.92f, 1.06f);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.iiE, "scaleY", 1.06f, 0.92f, 1.06f);
            ofFloat2.setRepeatCount(-1);
            this.iiC.playTogether(ofFloat, ofFloat2);
            this.iiC.setDuration(1000L);
            this.iiB.play(this.iiC);
        }
        this.iiB.start();
    }

    public void stopAnim() {
        if (this.iiB != null && this.iiB.isRunning()) {
            this.iiB.end();
        }
    }

    public void release() {
        this.iiB = null;
        this.iiC = null;
        this.iiE = null;
    }
}
