package com.baidu.tbadk.editortools;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ j aoU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.aoU = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        v dL = this.aoU.dL(3);
        if (dL != null && (dL.aox instanceof View)) {
            View view = (View) dL.aox;
            view.requestFocus();
            com.baidu.adp.lib.util.k.d(this.aoU.getContext(), view);
        }
    }
}
