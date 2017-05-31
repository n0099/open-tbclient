package com.baidu.tieba.card.a;

import android.view.View;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ a bCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.bCT = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        View view2;
        Animation animation;
        view = this.bCT.bCG;
        if (view != null) {
            view2 = this.bCT.bCG;
            animation = this.bCT.bCJ;
            view2.startAnimation(animation);
        }
    }
}
