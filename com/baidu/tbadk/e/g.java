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
        int Ct;
        TextView textView;
        String[] strArr;
        Runnable runnable;
        Ct = this.auH.Ct();
        textView = this.auH.alQ;
        strArr = this.auH.auE;
        textView.setText(strArr[Ct]);
        Handler handler = TbadkCoreApplication.m411getInst().handler;
        runnable = this.auH.Iy;
        handler.postDelayed(runnable, 200L);
    }
}
