package com.baidu.tieba.ala.h;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
/* loaded from: classes11.dex */
public class d {
    private AnimatorSet igS = null;
    private AnimatorSet igT = null;
    private AnimatorSet igU = null;
    private View igV;

    public d(View view) {
        this.igV = view;
    }

    public void startAnim() {
        if (this.igS == null) {
            this.igS = new AnimatorSet();
            this.igT = new AnimatorSet();
            this.igU = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.igV, "scaleX", 1.06f, 0.92f, 1.06f);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.igV, "scaleY", 1.06f, 0.92f, 1.06f);
            ofFloat2.setRepeatCount(-1);
            this.igT.playTogether(ofFloat, ofFloat2);
            this.igT.setDuration(1000L);
            this.igS.play(this.igT);
        }
        this.igS.start();
    }

    public void stopAnim() {
        if (this.igS != null && this.igS.isRunning()) {
            this.igS.end();
        }
    }

    public void release() {
        this.igS = null;
        this.igT = null;
        this.igV = null;
    }
}
