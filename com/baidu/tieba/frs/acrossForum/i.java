package com.baidu.tieba.frs.acrossForum;

import android.animation.Animator;
import com.baidu.tbadk.gif.GifView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Animator.AnimatorListener {
    final /* synthetic */ c bWJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c cVar) {
        this.bWJ = cVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        GifView gifView;
        GifView gifView2;
        gifView = this.bWJ.bWE;
        if (gifView != null) {
            gifView2 = this.bWJ.bWE;
            gifView2.setClickable(false);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        GifView gifView;
        GifView gifView2;
        this.bWJ.bWF = true;
        gifView = this.bWJ.bWE;
        if (gifView != null) {
            gifView2 = this.bWJ.bWE;
            gifView2.setClickable(true);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }
}
