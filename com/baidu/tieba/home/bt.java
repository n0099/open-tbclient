package com.baidu.tieba.home;

import android.content.Context;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements Runnable {
    final /* synthetic */ bq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bq bqVar) {
        this.a = bqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        ProgressBar progressBar;
        context = this.a.c;
        int a = com.baidu.adp.lib.g.g.a(context, 6.0f);
        context2 = this.a.c;
        int a2 = com.baidu.adp.lib.g.g.a(context2, 100.0f);
        int i = a2 - (a * 2);
        int i2 = (a2 - i) / 2;
        progressBar = this.a.d;
        progressBar.getProgressDrawable().setBounds(i2, i2, i2 + i, i + i2);
    }
}
