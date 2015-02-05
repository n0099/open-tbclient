package com.baidu.tbadk.d;

import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f acc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.acc = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int wl;
        TextView textView;
        String[] strArr;
        TextView textView2;
        Runnable runnable;
        wl = this.acc.wl();
        textView = this.acc.Vv;
        strArr = this.acc.LA;
        textView.setText(strArr[wl]);
        textView2 = this.acc.Vv;
        runnable = this.acc.ya;
        textView2.postDelayed(runnable, 200L);
    }
}
