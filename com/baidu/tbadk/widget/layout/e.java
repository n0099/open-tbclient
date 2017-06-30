package com.baidu.tbadk.widget.layout;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c aMI;
    private final /* synthetic */ int aMJ;
    private final /* synthetic */ boolean aMK;
    private final /* synthetic */ boolean aML;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, int i, boolean z, boolean z2) {
        this.aMI = cVar;
        this.aMJ = i;
        this.aMK = z;
        this.aML = z2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        g gVar2;
        gVar = this.aMI.aMv;
        if (gVar != null) {
            gVar2 = this.aMI.aMv;
            gVar2.c(view, this.aMJ, this.aMK && this.aML);
        }
    }
}
