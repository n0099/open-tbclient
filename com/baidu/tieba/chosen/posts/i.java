package com.baidu.tieba.chosen.posts;
/* loaded from: classes.dex */
class i implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ int Rx;
    final /* synthetic */ g aBk;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a aBl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, int i, com.baidu.tbadk.core.dialog.a aVar) {
        this.aBk = gVar;
        this.Rx = i;
        this.aBl = aVar;
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
        dVar = this.aBk.aBj;
        aVar2 = dVar.aBh;
        dVar2 = this.aBk.aBj;
        aVar3 = dVar2.aBh;
        aVar2.x(aVar3.getItem(this.Rx));
        dVar3 = this.aBk.aBj;
        aVar4 = dVar3.aBh;
        if (aVar4.getCount() <= 5) {
            dVar4 = this.aBk.aBj;
            dVar4.FN();
        }
        this.aBl.dismiss();
    }
}
