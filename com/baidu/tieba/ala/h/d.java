package com.baidu.tieba.ala.h;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
/* loaded from: classes11.dex */
public class d {
    private AnimatorSet igE = null;
    private AnimatorSet igF = null;
    private AnimatorSet igG = null;
    private View igH;

    public d(View view) {
        this.igH = view;
    }

    public void startAnim() {
        if (this.igE == null) {
            this.igE = new AnimatorSet();
            this.igF = new AnimatorSet();
            this.igG = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.igH, "scaleX", 1.06f, 0.92f, 1.06f);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.igH, "scaleY", 1.06f, 0.92f, 1.06f);
            ofFloat2.setRepeatCount(-1);
            this.igF.playTogether(ofFloat, ofFloat2);
            this.igF.setDuration(1000L);
            this.igE.play(this.igF);
        }
        this.igE.start();
    }

    public void stopAnim() {
        if (this.igE != null && this.igE.isRunning()) {
            this.igE.end();
        }
    }

    public void release() {
        this.igE = null;
        this.igF = null;
        this.igH = null;
    }
}
