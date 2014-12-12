package com.baidu.tieba.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aYg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aYg = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrameLayout frameLayout;
        Animation NA;
        frameLayout = this.aYg.aXT;
        NA = this.aYg.NA();
        frameLayout.startAnimation(NA);
    }
}
