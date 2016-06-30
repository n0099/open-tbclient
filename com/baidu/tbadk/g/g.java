package com.baidu.tbadk.g;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f avs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.avs = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int De;
        TextView textView;
        String[] strArr;
        Runnable runnable;
        De = this.avs.De();
        textView = this.avs.amM;
        strArr = this.avs.avp;
        textView.setText(strArr[De]);
        Handler handler = TbadkCoreApplication.m9getInst().handler;
        runnable = this.avs.zS;
        handler.postDelayed(runnable, 200L);
    }
}
