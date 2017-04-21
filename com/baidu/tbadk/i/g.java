package com.baidu.tbadk.i;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f aDN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.aDN = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int EW;
        TextView textView;
        String[] strArr;
        Runnable runnable;
        EW = this.aDN.EW();
        textView = this.aDN.avF;
        strArr = this.aDN.aDK;
        textView.setText(strArr[EW]);
        Handler handler = TbadkCoreApplication.m9getInst().handler;
        runnable = this.aDN.IL;
        handler.postDelayed(runnable, 200L);
    }
}
