package com.baidu.tbadk.i;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f aDN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.aDN = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int Ea;
        TextView textView;
        String[] strArr;
        Runnable runnable;
        Ea = this.aDN.Ea();
        textView = this.aDN.avJ;
        strArr = this.aDN.aDJ;
        textView.setText(strArr[Ea]);
        Handler handler = TbadkCoreApplication.m9getInst().handler;
        runnable = this.aDN.aDM;
        handler.postDelayed(runnable, 200L);
    }
}
