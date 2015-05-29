package com.baidu.tieba.chosen.posts;
/* loaded from: classes.dex */
class i implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ int RY;
    final /* synthetic */ g aDg;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aDh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, com.baidu.tbadk.core.dialog.a aVar, int i) {
        this.aDg = gVar;
        this.aDh = aVar;
        this.RY = i;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        e eVar;
        a aVar2;
        e eVar2;
        e eVar3;
        this.aDh.dismiss();
        eVar = this.aDg.aDf;
        aVar2 = eVar.aDc;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4101, null, null, null);
        bVar.setExtra(aVar2.getItem(this.RY));
        eVar2 = this.aDg.aDf;
        bVar.setUniqueId(eVar2.getUniqueId());
        eVar3 = this.aDg.aDf;
        eVar3.AL().dispatchMvcEvent(bVar);
    }
}
