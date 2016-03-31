package com.baidu.tbadk.f;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f ayB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.ayB = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int Fd;
        TextView textView;
        String[] strArr;
        Runnable runnable;
        Fd = this.ayB.Fd();
        textView = this.ayB.aqs;
        strArr = this.ayB.ayy;
        textView.setText(strArr[Fd]);
        Handler handler = TbadkCoreApplication.m411getInst().handler;
        runnable = this.ayB.JD;
        handler.postDelayed(runnable, 200L);
    }
}
