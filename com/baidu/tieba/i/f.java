package com.baidu.tieba.i;

import android.content.Context;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ d ecQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.ecQ = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        d dVar = this.ecQ;
        context = this.ecQ.mContext;
        dVar.nE(context.getString(w.l.data_init));
    }
}
