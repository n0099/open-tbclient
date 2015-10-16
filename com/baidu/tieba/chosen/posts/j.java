package com.baidu.tieba.chosen.posts;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class j implements a.b {
    final /* synthetic */ h aJV;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a amm;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.aJV = hVar;
        this.amm = aVar;
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
        this.amm.dismiss();
        eVar = this.aJV.aJU;
        aVar2 = eVar.aJP;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4101, null, null, null);
        bVar.setExtra(aVar2.getItem(this.val$position));
        eVar2 = this.aJV.aJU;
        chosenPostActivity = eVar2.aJN;
        bVar.setUniqueId(chosenPostActivity.getUniqueId());
        eVar3 = this.aJV.aJU;
        chosenPostActivity2 = eVar3.aJN;
        chosenPostActivity2.oF().dispatchMvcEvent(bVar);
    }
}
