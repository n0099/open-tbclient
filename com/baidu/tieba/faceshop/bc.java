package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
class bc implements com.baidu.tbadk.core.view.u {
    final /* synthetic */ FaceShopActivity aux;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(FaceShopActivity faceShopActivity) {
        this.aux = faceShopActivity;
    }

    @Override // com.baidu.tbadk.core.view.u
    public void aa(boolean z) {
        bq bqVar;
        bq bqVar2;
        if (z) {
            bqVar = this.aux.auu;
            if (bqVar != null) {
                bqVar2 = this.aux.auu;
                bqVar2.DC();
            }
        }
    }
}
