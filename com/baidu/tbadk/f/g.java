package com.baidu.tbadk.f;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f ayR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.ayR = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int Ex;
        TextView textView;
        String[] strArr;
        Runnable runnable;
        Ex = this.ayR.Ex();
        textView = this.ayR.aqq;
        strArr = this.ayR.ayO;
        textView.setText(strArr[Ex]);
        Handler handler = TbadkCoreApplication.m9getInst().handler;
        runnable = this.ayR.CI;
        handler.postDelayed(runnable, 200L);
    }
}
