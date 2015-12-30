package com.baidu.tieba.hottopic.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ d bJm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.bJm = dVar;
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
        aVar = this.bJm.bJl;
        i = aVar.index;
        if (i > 1) {
            aVar2 = this.bJm.bJl;
            linearLayout = aVar2.bJb;
            Animation animation3 = linearLayout.getAnimation();
            aVar3 = this.bJm.bJl;
            animation = aVar3.bJh;
            if (animation3 != animation) {
                aVar4 = this.bJm.bJl;
                linearLayout2 = aVar4.bJb;
                aVar5 = this.bJm.bJl;
                animation2 = aVar5.bJh;
                linearLayout2.startAnimation(animation2);
            }
        }
    }
}
