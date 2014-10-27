package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
class bd extends com.baidu.adp.base.h {
    final /* synthetic */ FaceShopActivity auo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(FaceShopActivity faceShopActivity) {
        this.auo = faceShopActivity;
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
        this.auo.hideProgressBar();
        if (obj != null && (obj instanceof FaceShopData)) {
            bqVar2 = this.auo.aul;
            if (bqVar2 != null) {
                FaceShopData faceShopData = (FaceShopData) obj;
                if (faceShopData.errno == 0 && faceShopData.usermsg != null) {
                    boVar = this.auo.aum;
                    if (boVar.getHasMore()) {
                        bqVar6 = this.auo.aul;
                        bqVar6.DD();
                    } else {
                        bqVar4 = this.auo.aul;
                        bqVar4.DC();
                    }
                    bqVar5 = this.auo.aul;
                    bqVar5.c(faceShopData);
                    return;
                }
                if (faceShopData.usermsg != null) {
                    this.auo.showToast(faceShopData.usermsg);
                } else {
                    this.auo.showToast(cb.neterror);
                }
                bqVar3 = this.auo.aul;
                bqVar3.Dv();
                return;
            }
            return;
        }
        this.auo.showToast(cb.neterror);
        bqVar = this.auo.aul;
        bqVar.Dv();
    }
}
