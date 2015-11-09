package com.baidu.tieba.chosen.posts;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class j implements a.b {
    final /* synthetic */ h aIP;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a amr;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.aIP = hVar;
        this.amr = aVar;
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
        this.amr.dismiss();
        eVar = this.aIP.aIO;
        aVar2 = eVar.aIJ;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4101, null, null, null);
        bVar.setExtra(aVar2.getItem(this.val$position));
        eVar2 = this.aIP.aIO;
        chosenPostActivity = eVar2.aIH;
        bVar.setUniqueId(chosenPostActivity.getUniqueId());
        eVar3 = this.aIP.aIO;
        chosenPostActivity2 = eVar3.aIH;
        chosenPostActivity2.oG().dispatchMvcEvent(bVar);
    }
}
