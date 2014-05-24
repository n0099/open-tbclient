package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
class bk extends com.baidu.adp.base.e {
    final /* synthetic */ FaceShopActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(FaceShopActivity faceShopActivity) {
        this.a = faceShopActivity;
    }

    @Override // com.baidu.adp.base.e
    public void a(Object obj) {
        bx bxVar;
        bx bxVar2;
        bx bxVar3;
        bv bvVar;
        bx bxVar4;
        bx bxVar5;
        bx bxVar6;
        this.a.hideProgressBar();
        if (obj != null && (obj instanceof FaceShopData)) {
            bxVar2 = this.a.a;
            if (bxVar2 != null) {
                FaceShopData faceShopData = (FaceShopData) obj;
                if (faceShopData.errno == 0 && faceShopData.usermsg != null) {
                    bvVar = this.a.b;
                    if (bvVar.b()) {
                        bxVar6 = this.a.a;
                        bxVar6.f();
                    } else {
                        bxVar4 = this.a.a;
                        bxVar4.e();
                    }
                    bxVar5 = this.a.a;
                    bxVar5.a(faceShopData);
                    return;
                }
                if (faceShopData.usermsg != null) {
                    this.a.showToast(faceShopData.usermsg);
                } else {
                    this.a.showToast(com.baidu.tieba.y.neterror);
                }
                bxVar3 = this.a.a;
                bxVar3.b();
                return;
            }
            return;
        }
        this.a.showToast(com.baidu.tieba.y.neterror);
        bxVar = this.a.a;
        bxVar.b();
    }
}
