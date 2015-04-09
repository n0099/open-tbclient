package com.baidu.tieba.chosen.posts;
/* loaded from: classes.dex */
class i implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ int Rz;
    final /* synthetic */ g aBs;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aBt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, int i, com.baidu.tbadk.core.dialog.a aVar) {
        this.aBs = gVar;
        this.Rz = i;
        this.aBt = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        d dVar;
        a aVar2;
        d dVar2;
        a aVar3;
        d dVar3;
        a aVar4;
        d dVar4;
        dVar = this.aBs.aBr;
        aVar2 = dVar.aBp;
        dVar2 = this.aBs.aBr;
        aVar3 = dVar2.aBp;
        aVar2.x(aVar3.getItem(this.Rz));
        dVar3 = this.aBs.aBr;
        aVar4 = dVar3.aBp;
        if (aVar4.getCount() <= 5) {
            dVar4 = this.aBs.aBr;
            dVar4.FT();
        }
        this.aBt.dismiss();
    }
}
