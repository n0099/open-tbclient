package com.baidu.tieba.hottopic.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ f bMT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.bMT = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar;
        int i;
        c cVar2;
        LinearLayout linearLayout;
        c cVar3;
        Animation animation;
        c cVar4;
        LinearLayout linearLayout2;
        c cVar5;
        Animation animation2;
        cVar = this.bMT.bMS;
        i = cVar.index;
        if (i > 1) {
            cVar2 = this.bMT.bMS;
            linearLayout = cVar2.bMI;
            Animation animation3 = linearLayout.getAnimation();
            cVar3 = this.bMT.bMS;
            animation = cVar3.bMO;
            if (animation3 != animation) {
                cVar4 = this.bMT.bMS;
                linearLayout2 = cVar4.bMI;
                cVar5 = this.bMT.bMS;
                animation2 = cVar5.bMO;
                linearLayout2.startAnimation(animation2);
            }
        }
    }
}
