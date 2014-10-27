package com.baidu.tieba.d.b;

import android.view.View;
/* loaded from: classes.dex */
class b implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ int BF;
    private final /* synthetic */ View aeq;
    final /* synthetic */ a bHs;
    private final /* synthetic */ com.baidu.tieba.d.a.f bHt;
    private final /* synthetic */ com.baidu.tieba.d.c.a bHu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, View view, com.baidu.tieba.d.a.f fVar, int i, com.baidu.tieba.d.c.a aVar2) {
        this.bHs = aVar;
        this.aeq = view;
        this.bHt = fVar;
        this.BF = i;
        this.bHu = aVar2;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        com.baidu.tbadk.distribute.a.ra().a(this.aeq.getContext(), this.bHt.abw(), "area_download", "pb", this.bHt.bHq, this.bHt.threadId);
        com.baidu.tbadk.distribute.a.ra().a(this.bHt.abw(), this.bHt.bHq, this.bHt.threadId, "PB", "download");
        com.baidu.tieba.d.b.a(this.aeq.getContext(), this.bHt, this.BF);
        this.bHu.refresh();
    }
}
