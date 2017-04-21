package com.baidu.tieba.card.a;

import android.view.View;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ a bwY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.bwY = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        Animation animation;
        view = this.bwY.aTf;
        if (view != null) {
            view2 = this.bwY.aTf;
            animation = this.bwY.aTj;
            view2.startAnimation(animation);
        }
    }
}
