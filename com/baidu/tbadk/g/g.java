package com.baidu.tbadk.g;

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
        int Dd;
        TextView textView;
        String[] strArr;
        Runnable runnable;
        Dd = this.awh.Dd();
        textView = this.awh.anB;
        strArr = this.awh.awe;
        textView.setText(strArr[Dd]);
        Handler handler = TbadkCoreApplication.m10getInst().handler;
        runnable = this.awh.Au;
        handler.postDelayed(runnable, 200L);
    }
}
