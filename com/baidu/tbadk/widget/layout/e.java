package com.baidu.tbadk.widget.layout;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c aGC;
    private final /* synthetic */ int aGD;
    private final /* synthetic */ boolean aGE;
    private final /* synthetic */ boolean aGF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, int i, boolean z, boolean z2) {
        this.aGC = cVar;
        this.aGD = i;
        this.aGE = z;
        this.aGF = z2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        h hVar2;
        hVar = this.aGC.aGr;
        if (hVar != null) {
            hVar2 = this.aGC.aGr;
            hVar2.c(view, this.aGD, this.aGE && this.aGF);
        }
    }
}
