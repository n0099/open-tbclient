package com.baidu.tbadk.i;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f aDA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.aDA = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int DU;
        TextView textView;
        String[] strArr;
        Runnable runnable;
        DU = this.aDA.DU();
        textView = this.aDA.avt;
        strArr = this.aDA.aDw;
        textView.setText(strArr[DU]);
        Handler handler = TbadkCoreApplication.m9getInst().handler;
        runnable = this.aDA.aDz;
        handler.postDelayed(runnable, 200L);
    }
}
