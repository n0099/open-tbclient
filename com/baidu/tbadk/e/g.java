package com.baidu.tbadk.e;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f auH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.auH = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int Cq;
        TextView textView;
        String[] strArr;
        Runnable runnable;
        Cq = this.auH.Cq();
        textView = this.auH.alQ;
        strArr = this.auH.auE;
        textView.setText(strArr[Cq]);
        Handler handler = TbadkCoreApplication.m411getInst().handler;
        runnable = this.auH.Iy;
        handler.postDelayed(runnable, 200L);
    }
}
