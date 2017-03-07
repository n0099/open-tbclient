package com.baidu.tieba.card.a;

import android.view.View;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ a buP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.buP = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        Animation animation;
        view = this.buP.aSN;
        if (view != null) {
            view2 = this.buP.aSN;
            animation = this.buP.aSS;
            view2.startAnimation(animation);
        }
    }
}
