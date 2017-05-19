package com.baidu.tieba.g;

import android.content.Context;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ d dOW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.dOW = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        d dVar = this.dOW;
        context = this.dOW.mContext;
        dVar.mE(context.getString(w.l.data_init));
    }
}
