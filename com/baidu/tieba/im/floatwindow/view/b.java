package com.baidu.tieba.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aZC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aZC = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrameLayout frameLayout;
        Animation NW;
        frameLayout = this.aZC.aZp;
        NW = this.aZC.NW();
        frameLayout.startAnimation(NW);
    }
}
