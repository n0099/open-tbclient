package com.baidu.tbadk.e;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f auG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.auG = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int Ct;
        TextView textView;
        String[] strArr;
        Runnable runnable;
        Ct = this.auG.Ct();
        textView = this.auG.alP;
        strArr = this.auG.auD;
        textView.setText(strArr[Ct]);
        Handler handler = TbadkCoreApplication.m411getInst().handler;
        runnable = this.auG.Ix;
        handler.postDelayed(runnable, 200L);
    }
}
