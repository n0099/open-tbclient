package com.baidu.tieba.card.a;

import android.view.View;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ a bnT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.bnT = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        Animation animation;
        view = this.bnT.aNa;
        if (view != null) {
            view2 = this.bnT.aNa;
            animation = this.bnT.aNf;
            view2.startAnimation(animation);
        }
    }
}
