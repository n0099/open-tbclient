package com.baidu.tieba.chosen.posts;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class j implements a.b {
    final /* synthetic */ h aRj;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a apI;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.aRj = hVar;
        this.apI = aVar;
        this.val$position = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        e eVar;
        a aVar2;
        e eVar2;
        ChosenPostActivity chosenPostActivity;
        e eVar3;
        ChosenPostActivity chosenPostActivity2;
        this.apI.dismiss();
        eVar = this.aRj.aRi;
        aVar2 = eVar.aRd;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4101, null, null, null);
        bVar.setExtra(aVar2.getItem(this.val$position));
        eVar2 = this.aRj.aRi;
        chosenPostActivity = eVar2.aRb;
        bVar.setUniqueId(chosenPostActivity.getUniqueId());
        eVar3 = this.aRj.aRi;
        chosenPostActivity2 = eVar3.aRb;
        chosenPostActivity2.ok().dispatchMvcEvent(bVar);
    }
}
