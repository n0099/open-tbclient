package com.baidu.tbadk.editortools;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ j aqF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.aqF = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        v dT = this.aqF.dT(3);
        if (dT != null && (dT.aqi instanceof View)) {
            View view = (View) dT.aqi;
            view.requestFocus();
            com.baidu.adp.lib.util.k.d(this.aqF.getContext(), view);
        }
    }
}
