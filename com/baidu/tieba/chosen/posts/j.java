package com.baidu.tieba.chosen.posts;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class j implements a.b {
    final /* synthetic */ h aJK;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aml;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.aJK = hVar;
        this.aml = aVar;
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
        this.aml.dismiss();
        eVar = this.aJK.aJJ;
        aVar2 = eVar.aJE;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4101, null, null, null);
        bVar.setExtra(aVar2.getItem(this.val$position));
        eVar2 = this.aJK.aJJ;
        chosenPostActivity = eVar2.aJC;
        bVar.setUniqueId(chosenPostActivity.getUniqueId());
        eVar3 = this.aJK.aJJ;
        chosenPostActivity2 = eVar3.aJC;
        chosenPostActivity2.oF().dispatchMvcEvent(bVar);
    }
}
