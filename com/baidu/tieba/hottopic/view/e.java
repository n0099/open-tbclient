package com.baidu.tieba.hottopic.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ d bFF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.bFF = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        int i;
        a aVar2;
        LinearLayout linearLayout;
        a aVar3;
        Animation animation;
        a aVar4;
        LinearLayout linearLayout2;
        a aVar5;
        Animation animation2;
        aVar = this.bFF.bFE;
        i = aVar.index;
        if (i > 1) {
            aVar2 = this.bFF.bFE;
            linearLayout = aVar2.bFu;
            Animation animation3 = linearLayout.getAnimation();
            aVar3 = this.bFF.bFE;
            animation = aVar3.bFA;
            if (animation3 != animation) {
                aVar4 = this.bFF.bFE;
                linearLayout2 = aVar4.bFu;
                aVar5 = this.bFF.bFE;
                animation2 = aVar5.bFA;
                linearLayout2.startAnimation(animation2);
            }
        }
    }
}
