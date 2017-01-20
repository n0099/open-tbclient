package com.baidu.tbadk.f;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f ayb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.ayb = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int Ef;
        TextView textView;
        String[] strArr;
        Runnable runnable;
        Ef = this.ayb.Ef();
        textView = this.ayb.apT;
        strArr = this.ayb.axY;
        textView.setText(strArr[Ef]);
        Handler handler = TbadkCoreApplication.m9getInst().handler;
        runnable = this.ayb.BU;
        handler.postDelayed(runnable, 200L);
    }
}
