package com.baidu.tbadk.widget.layout;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c aFB;
    private final /* synthetic */ int aFC;
    private final /* synthetic */ boolean aFD;
    private final /* synthetic */ boolean aFE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, int i, boolean z, boolean z2) {
        this.aFB = cVar;
        this.aFC = i;
        this.aFD = z;
        this.aFE = z2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        h hVar2;
        hVar = this.aFB.aFq;
        if (hVar != null) {
            hVar2 = this.aFB.aFq;
            hVar2.c(view, this.aFC, this.aFD && this.aFE);
        }
    }
}
