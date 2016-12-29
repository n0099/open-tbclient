package com.baidu.tbadk.f;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f azg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.azg = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int Ek;
        TextView textView;
        String[] strArr;
        Runnable runnable;
        Ek = this.azg.Ek();
        textView = this.azg.aqN;
        strArr = this.azg.azd;
        textView.setText(strArr[Ek]);
        Handler handler = TbadkCoreApplication.m9getInst().handler;
        runnable = this.azg.CJ;
        handler.postDelayed(runnable, 200L);
    }
}
