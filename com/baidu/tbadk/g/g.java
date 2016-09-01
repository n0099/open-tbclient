package com.baidu.tbadk.g;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f azo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.azo = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int Ex;
        TextView textView;
        String[] strArr;
        Runnable runnable;
        Ex = this.azo.Ex();
        textView = this.azo.aqI;
        strArr = this.azo.azl;
        textView.setText(strArr[Ex]);
        Handler handler = TbadkCoreApplication.m9getInst().handler;
        runnable = this.azo.CI;
        handler.postDelayed(runnable, 200L);
    }
}
