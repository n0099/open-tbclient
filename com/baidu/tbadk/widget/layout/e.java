package com.baidu.tbadk.widget.layout;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c aGM;
    private final /* synthetic */ int aGN;
    private final /* synthetic */ boolean aGO;
    private final /* synthetic */ boolean aGP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, int i, boolean z, boolean z2) {
        this.aGM = cVar;
        this.aGN = i;
        this.aGO = z;
        this.aGP = z2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        h hVar2;
        hVar = this.aGM.aGB;
        if (hVar != null) {
            hVar2 = this.aGM.aGB;
            hVar2.c(view, this.aGN, this.aGO && this.aGP);
        }
    }
}
