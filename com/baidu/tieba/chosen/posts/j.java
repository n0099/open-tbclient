package com.baidu.tieba.chosen.posts;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class j implements a.b {
    private final /* synthetic */ int YA;
    final /* synthetic */ h aTq;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aqA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.aTq = hVar;
        this.aqA = aVar;
        this.YA = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        e eVar;
        a aVar2;
        e eVar2;
        ChosenPostActivity chosenPostActivity;
        e eVar3;
        ChosenPostActivity chosenPostActivity2;
        this.aqA.dismiss();
        eVar = this.aTq.aTp;
        aVar2 = eVar.aTk;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4101, null, null, null);
        bVar.setExtra(aVar2.getItem(this.YA));
        eVar2 = this.aTq.aTp;
        chosenPostActivity = eVar2.aTi;
        bVar.setUniqueId(chosenPostActivity.getUniqueId());
        eVar3 = this.aTq.aTp;
        chosenPostActivity2 = eVar3.aTi;
        chosenPostActivity2.oF().dispatchMvcEvent(bVar);
    }
}
