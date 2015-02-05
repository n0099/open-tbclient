package com.baidu.tieba.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aZB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aZB = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrameLayout frameLayout;
        Animation NR;
        frameLayout = this.aZB.aZo;
        NR = this.aZB.NR();
        frameLayout.startAnimation(NR);
    }
}
