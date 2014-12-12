package com.baidu.tbadk.d;

import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f abI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.abI = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int vZ;
        TextView textView;
        String[] strArr;
        TextView textView2;
        Runnable runnable;
        vZ = this.abI.vZ();
        textView = this.abI.UT;
        strArr = this.abI.Lj;
        textView.setText(strArr[vZ]);
        textView2 = this.abI.UT;
        runnable = this.abI.yd;
        textView2.postDelayed(runnable, 200L);
    }
}
