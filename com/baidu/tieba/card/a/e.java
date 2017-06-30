package com.baidu.tieba.card.a;

import android.view.View;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ a bDM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.bDM = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        Animation animation;
        view = this.bDM.bDz;
        if (view != null) {
            view2 = this.bDM.bDz;
            animation = this.bDM.bDC;
            view2.startAnimation(animation);
        }
    }
}
