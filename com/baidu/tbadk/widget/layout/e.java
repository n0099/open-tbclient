package com.baidu.tbadk.widget.layout;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c aLq;
    private final /* synthetic */ int aLr;
    private final /* synthetic */ boolean aLs;
    private final /* synthetic */ boolean aLt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, int i, boolean z, boolean z2) {
        this.aLq = cVar;
        this.aLr = i;
        this.aLs = z;
        this.aLt = z2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        g gVar2;
        gVar = this.aLq.aLf;
        if (gVar != null) {
            gVar2 = this.aLq.aLf;
            gVar2.c(view, this.aLr, this.aLs && this.aLt);
        }
    }
}
