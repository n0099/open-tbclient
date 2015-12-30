package com.baidu.tbadk.f;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f axd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.axd = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int CZ;
        TextView textView;
        String[] strArr;
        Runnable runnable;
        CZ = this.axd.CZ();
        textView = this.axd.api;
        strArr = this.axd.axa;
        textView.setText(strArr[CZ]);
        Handler handler = TbadkCoreApplication.m411getInst().handler;
        runnable = this.axd.Ji;
        handler.postDelayed(runnable, 200L);
    }
}
