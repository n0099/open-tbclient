package com.baidu.tieba.frs.acrossForum;

import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ j bWU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar) {
        this.bWU = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        viewGroup = this.bWU.bWP;
        if (viewGroup != null) {
            viewGroup2 = this.bWU.bWP;
            viewGroup2.requestLayout();
        }
    }
}
