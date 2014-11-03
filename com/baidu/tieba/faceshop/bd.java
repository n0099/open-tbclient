package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
class bd extends com.baidu.adp.base.h {
    final /* synthetic */ FaceShopActivity aux;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(FaceShopActivity faceShopActivity) {
        this.aux = faceShopActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        bo boVar;
        bq bqVar4;
        bq bqVar5;
        bq bqVar6;
        this.aux.hideProgressBar();
        if (obj != null && (obj instanceof FaceShopData)) {
            bqVar2 = this.aux.auu;
            if (bqVar2 != null) {
                FaceShopData faceShopData = (FaceShopData) obj;
                if (faceShopData.errno == 0 && faceShopData.usermsg != null) {
                    boVar = this.aux.auv;
                    if (boVar.getHasMore()) {
                        bqVar6 = this.aux.auu;
                        bqVar6.DF();
                    } else {
                        bqVar4 = this.aux.auu;
                        bqVar4.DE();
                    }
                    bqVar5 = this.aux.auu;
                    bqVar5.c(faceShopData);
                    return;
                }
                if (faceShopData.usermsg != null) {
                    this.aux.showToast(faceShopData.usermsg);
                } else {
                    this.aux.showToast(cb.neterror);
                }
                bqVar3 = this.aux.auu;
                bqVar3.Dx();
                return;
            }
            return;
        }
        this.aux.showToast(cb.neterror);
        bqVar = this.aux.auu;
        bqVar.Dx();
    }
}
