package com.baidu.tieba.card.a;

import android.view.View;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ a bwW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.bwW = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        Animation animation;
        view = this.bwW.aTA;
        if (view != null) {
            view2 = this.bwW.aTA;
            animation = this.bwW.aTE;
            view2.startAnimation(animation);
        }
    }
}
