package com.baidu.tieba.d.b;

import android.view.View;
/* loaded from: classes.dex */
class b implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ int BG;
    private final /* synthetic */ View aey;
    final /* synthetic */ a bHG;
    private final /* synthetic */ com.baidu.tieba.d.a.f bHH;
    private final /* synthetic */ com.baidu.tieba.d.c.a bHI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, View view, com.baidu.tieba.d.a.f fVar, int i, com.baidu.tieba.d.c.a aVar2) {
        this.bHG = aVar;
        this.aey = view;
        this.bHH = fVar;
        this.BG = i;
        this.bHI = aVar2;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        com.baidu.tbadk.distribute.a.rc().a(this.aey.getContext(), this.bHH.abz(), "area_download", "pb", this.bHH.bHE, this.bHH.threadId);
        com.baidu.tbadk.distribute.a.rc().a(this.bHH.abz(), this.bHH.bHE, this.bHH.threadId, "PB", "download");
        com.baidu.tieba.d.b.a(this.aey.getContext(), this.bHH, this.BG);
        this.bHI.refresh();
    }
}
