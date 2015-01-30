package com.baidu.tbadk.d;

import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f acf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.acf = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int wr;
        TextView textView;
        String[] strArr;
        TextView textView2;
        Runnable runnable;
        wr = this.acf.wr();
        textView = this.acf.Vy;
        strArr = this.acf.LE;
        textView.setText(strArr[wr]);
        textView2 = this.acf.Vy;
        runnable = this.acf.yd;
        textView2.postDelayed(runnable, 200L);
    }
}
