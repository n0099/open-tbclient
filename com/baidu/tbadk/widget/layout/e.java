package com.baidu.tbadk.widget.layout;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c aLD;
    private final /* synthetic */ int aLE;
    private final /* synthetic */ boolean aLF;
    private final /* synthetic */ boolean aLG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, int i, boolean z, boolean z2) {
        this.aLD = cVar;
        this.aLE = i;
        this.aLF = z;
        this.aLG = z2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        g gVar2;
        gVar = this.aLD.aLq;
        if (gVar != null) {
            gVar2 = this.aLD.aLq;
            gVar2.c(view, this.aLE, this.aLF && this.aLG);
        }
    }
}
