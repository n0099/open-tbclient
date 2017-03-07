package com.baidu.tbadk.widget.layout;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c aKY;
    private final /* synthetic */ int aKZ;
    private final /* synthetic */ boolean aLa;
    private final /* synthetic */ boolean aLb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, int i, boolean z, boolean z2) {
        this.aKY = cVar;
        this.aKZ = i;
        this.aLa = z;
        this.aLb = z2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        h hVar2;
        hVar = this.aKY.aKN;
        if (hVar != null) {
            hVar2 = this.aKY.aKN;
            hVar2.c(view, this.aKZ, this.aLa && this.aLb);
        }
    }
}
