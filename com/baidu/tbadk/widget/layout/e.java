package com.baidu.tbadk.widget.layout;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c aLo;
    private final /* synthetic */ int aLp;
    private final /* synthetic */ boolean aLq;
    private final /* synthetic */ boolean aLr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, int i, boolean z, boolean z2) {
        this.aLo = cVar;
        this.aLp = i;
        this.aLq = z;
        this.aLr = z2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        g gVar2;
        gVar = this.aLo.aLd;
        if (gVar != null) {
            gVar2 = this.aLo.aLd;
            gVar2.c(view, this.aLp, this.aLq && this.aLr);
        }
    }
}
