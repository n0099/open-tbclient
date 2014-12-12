package com.baidu.tieba.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f aYr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.aYr = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Animation NA;
        if (this.aYr.Nm()) {
            linearLayout = this.aYr.aYh;
            linearLayout.clearAnimation();
            linearLayout2 = this.aYr.aYh;
            NA = this.aYr.NA();
            linearLayout2.startAnimation(NA);
        }
    }
}
