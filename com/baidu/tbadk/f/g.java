package com.baidu.tbadk.f;

import android.os.Handler;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ f azJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.azJ = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        int EC;
        TextView textView;
        String[] strArr;
        Runnable runnable;
        EC = this.azJ.EC();
        textView = this.azJ.ark;
        strArr = this.azJ.azG;
        textView.setText(strArr[EC]);
        Handler handler = TbadkCoreApplication.m9getInst().handler;
        runnable = this.azJ.CI;
        handler.postDelayed(runnable, 200L);
    }
}
