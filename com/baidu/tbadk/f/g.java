package com.baidu.tbadk.f;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f auC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.auC = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int CV;
        TextView textView;
        String[] strArr;
        Runnable runnable;
        CV = this.auC.CV();
        textView = this.auC.amg;
        strArr = this.auC.auz;
        textView.setText(strArr[CV]);
        Handler handler = TbadkCoreApplication.m11getInst().handler;
        runnable = this.auC.zT;
        handler.postDelayed(runnable, 200L);
    }
}
