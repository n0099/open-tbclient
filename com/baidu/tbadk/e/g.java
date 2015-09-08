package com.baidu.tbadk.e;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f awh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.awh = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int CH;
        TextView textView;
        String[] strArr;
        Runnable runnable;
        CH = this.awh.CH();
        textView = this.awh.any;
        strArr = this.awh.acW;
        textView.setText(strArr[CH]);
        Handler handler = TbadkCoreApplication.m411getInst().handler;
        runnable = this.awh.Ix;
        handler.postDelayed(runnable, 200L);
    }
}
