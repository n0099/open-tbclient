package com.baidu.tbadk.f;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f aDv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.aDv = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int Ey;
        TextView textView;
        String[] strArr;
        Runnable runnable;
        Ey = this.aDv.Ey();
        textView = this.aDv.avn;
        strArr = this.aDv.aDs;
        textView.setText(strArr[Ey]);
        Handler handler = TbadkCoreApplication.m9getInst().handler;
        runnable = this.aDv.Jj;
        handler.postDelayed(runnable, 200L);
    }
}
