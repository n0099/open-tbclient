package com.baidu.tbadk.widget.layout;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c aGI;
    private final /* synthetic */ int aGJ;
    private final /* synthetic */ boolean aGK;
    private final /* synthetic */ boolean aGL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, int i, boolean z, boolean z2) {
        this.aGI = cVar;
        this.aGJ = i;
        this.aGK = z;
        this.aGL = z2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        g gVar2;
        gVar = this.aGI.aGx;
        if (gVar != null) {
            gVar2 = this.aGI.aGx;
            gVar2.c(view, this.aGJ, this.aGK && this.aGL);
        }
    }
}
