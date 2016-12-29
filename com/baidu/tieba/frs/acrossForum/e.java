package com.baidu.tieba.frs.acrossForum;

import android.animation.Animator;
import com.baidu.tbadk.gif.GifView;
/* loaded from: classes.dex */
class e implements Animator.AnimatorListener {
    final /* synthetic */ d bCU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.bCU = dVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        c cVar;
        GifView gifView;
        c cVar2;
        GifView gifView2;
        cVar = this.bCU.bCT;
        gifView = cVar.bCO;
        if (gifView != null) {
            cVar2 = this.bCU.bCT;
            gifView2 = cVar2.bCO;
            gifView2.setClickable(false);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        c cVar;
        GifView gifView;
        c cVar2;
        GifView gifView2;
        c cVar3;
        cVar = this.bCU.bCT;
        gifView = cVar.bCO;
        if (gifView != null) {
            cVar2 = this.bCU.bCT;
            gifView2 = cVar2.bCO;
            gifView2.setClickable(true);
            cVar3 = this.bCU.bCT;
            cVar3.bCP = false;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }
}
