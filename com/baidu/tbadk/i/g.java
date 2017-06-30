package com.baidu.tbadk.i;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f aEO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.aEO = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int Er;
        TextView textView;
        String[] strArr;
        Runnable runnable;
        Er = this.aEO.Er();
        textView = this.aEO.aww;
        strArr = this.aEO.aEK;
        textView.setText(strArr[Er]);
        Handler handler = TbadkCoreApplication.m9getInst().handler;
        runnable = this.aEO.aEN;
        handler.postDelayed(runnable, 200L);
    }
}
