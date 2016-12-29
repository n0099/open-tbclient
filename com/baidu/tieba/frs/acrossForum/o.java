package com.baidu.tieba.frs.acrossForum;

import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ j bDe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar) {
        this.bDe = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        viewGroup = this.bDe.bCZ;
        if (viewGroup != null) {
            viewGroup2 = this.bDe.bCZ;
            viewGroup2.requestLayout();
        }
    }
}
