package com.baidu.tbadk.f;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f avz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.avz = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int Dk;
        TextView textView;
        String[] strArr;
        Runnable runnable;
        Dk = this.avz.Dk();
        textView = this.avz.anI;
        strArr = this.avz.avw;
        textView.setText(strArr[Dk]);
        Handler handler = TbadkCoreApplication.m411getInst().handler;
        runnable = this.avz.IR;
        handler.postDelayed(runnable, 200L);
    }
}
