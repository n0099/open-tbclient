package com.baidu.tbadk.f;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f axU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.axU = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int Er;
        TextView textView;
        String[] strArr;
        Runnable runnable;
        Er = this.axU.Er();
        textView = this.axU.aqb;
        strArr = this.axU.axR;
        textView.setText(strArr[Er]);
        Handler handler = TbadkCoreApplication.m411getInst().handler;
        runnable = this.axU.Jx;
        handler.postDelayed(runnable, 200L);
    }
}
