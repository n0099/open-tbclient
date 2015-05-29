package com.baidu.tbadk.system.portrait;
/* loaded from: classes.dex */
class a extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ ChangeSystemPhotoActivity arP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.arP = changeSystemPhotoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        h hVar;
        h hVar2;
        h hVar3;
        super.a((a) aVar, str, i);
        if (aVar != null) {
            this.arP.arM = aVar;
            hVar = this.arP.arL;
            if (hVar != null) {
                hVar3 = this.arP.arL;
                hVar3.cancel();
            }
            this.arP.arL = new h(this.arP, null);
            hVar2 = this.arP.arL;
            hVar2.execute(new String[0]);
        }
    }
}
