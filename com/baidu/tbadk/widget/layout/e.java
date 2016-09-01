package com.baidu.tbadk.widget.layout;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c aHd;
    private final /* synthetic */ int aHe;
    private final /* synthetic */ boolean aHf;
    private final /* synthetic */ boolean aHg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, int i, boolean z, boolean z2) {
        this.aHd = cVar;
        this.aHe = i;
        this.aHf = z;
        this.aHg = z2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        h hVar2;
        hVar = this.aHd.aGS;
        if (hVar != null) {
            hVar2 = this.aHd.aGS;
            hVar2.c(view, this.aHe, this.aHf && this.aHg);
        }
    }
}
