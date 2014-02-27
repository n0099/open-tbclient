package com.baidu.tieba.home;

import android.content.Context;
import android.widget.ProgressBar;
import com.baidu.adp.lib.util.BdUtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ar implements Runnable {
    final /* synthetic */ ao a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ao aoVar) {
        this.a = aoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        ProgressBar progressBar;
        context = this.a.c;
        int a = BdUtilHelper.a(context, 6.0f);
        context2 = this.a.c;
        int a2 = BdUtilHelper.a(context2, 100.0f);
        int i = a2 - (a * 2);
        int i2 = (a2 - i) / 2;
        int i3 = i + i2;
        progressBar = this.a.d;
        progressBar.getProgressDrawable().setBounds(i2, i2, i3, i3);
    }
}
