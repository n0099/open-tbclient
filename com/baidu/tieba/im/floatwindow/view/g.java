package com.baidu.tieba.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f aZM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.aZM = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Animation NR;
        if (this.aZM.ND()) {
            linearLayout = this.aZM.aZC;
            linearLayout.clearAnimation();
            linearLayout2 = this.aZM.aZC;
            NR = this.aZM.NR();
            linearLayout2.startAnimation(NR);
        }
    }
}
