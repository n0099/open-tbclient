package com.baidu.tieba.d.b;

import android.view.View;
/* loaded from: classes.dex */
class e implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ int BF;
    private final /* synthetic */ View aeq;
    private final /* synthetic */ com.baidu.tieba.d.a.f bHt;
    private final /* synthetic */ com.baidu.tieba.d.c.a bHu;
    final /* synthetic */ d bHw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, View view, com.baidu.tieba.d.a.f fVar, int i, com.baidu.tieba.d.c.a aVar) {
        this.bHw = dVar;
        this.aeq = view;
        this.bHt = fVar;
        this.BF = i;
        this.bHu = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        com.baidu.tbadk.distribute.a.ra().a(this.aeq.getContext(), this.bHt.abw(), "btn_download", "pb", this.bHt.bHq, this.bHt.threadId);
        com.baidu.tbadk.distribute.a.ra().a(this.bHt.abw(), this.bHt.bHq, this.bHt.threadId, "PB", "download");
        com.baidu.tieba.d.b.a(this.aeq.getContext(), this.bHt, this.BF);
        this.bHu.refresh();
    }
}
