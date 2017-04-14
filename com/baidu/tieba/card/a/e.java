package com.baidu.tieba.card.a;

import android.view.View;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ a buH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.buH = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        Animation animation;
        view = this.buH.aTd;
        if (view != null) {
            view2 = this.buH.aTd;
            animation = this.buH.aTh;
            view2.startAnimation(animation);
        }
    }
}
