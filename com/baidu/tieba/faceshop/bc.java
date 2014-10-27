package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
class bc implements com.baidu.tbadk.core.view.u {
    final /* synthetic */ FaceShopActivity auo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(FaceShopActivity faceShopActivity) {
        this.auo = faceShopActivity;
    }

    @Override // com.baidu.tbadk.core.view.u
    public void aa(boolean z) {
        bq bqVar;
        bq bqVar2;
        if (z) {
            bqVar = this.auo.aul;
            if (bqVar != null) {
                bqVar2 = this.auo.aul;
                bqVar2.DA();
            }
        }
    }
}
