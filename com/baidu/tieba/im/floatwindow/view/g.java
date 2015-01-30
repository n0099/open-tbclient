package com.baidu.tieba.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f aZN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.aZN = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Animation NW;
        if (this.aZN.NI()) {
            linearLayout = this.aZN.aZD;
            linearLayout.clearAnimation();
            linearLayout2 = this.aZN.aZD;
            NW = this.aZN.NW();
            linearLayout2.startAnimation(NW);
        }
    }
}
