package com.baidu.tbadk.widget.layout;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c aCF;
    private final /* synthetic */ int aCG;
    private final /* synthetic */ boolean aCH;
    private final /* synthetic */ boolean aCI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, int i, boolean z, boolean z2) {
        this.aCF = cVar;
        this.aCG = i;
        this.aCH = z;
        this.aCI = z2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        g gVar2;
        gVar = this.aCF.aCu;
        if (gVar != null) {
            gVar2 = this.aCF.aCu;
            gVar2.c(view, this.aCG, this.aCH && this.aCI);
        }
    }
}
