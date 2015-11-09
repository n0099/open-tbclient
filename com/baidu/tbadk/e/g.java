package com.baidu.tbadk.e;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f atv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.atv = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int Cj;
        TextView textView;
        String[] strArr;
        Runnable runnable;
        Cj = this.atv.Cj();
        textView = this.atv.alV;
        strArr = this.atv.ats;
        textView.setText(strArr[Cj]);
        Handler handler = TbadkCoreApplication.m411getInst().handler;
        runnable = this.atv.Iz;
        handler.postDelayed(runnable, 200L);
    }
}
