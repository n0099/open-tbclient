package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
final class bh extends com.baidu.adp.a.h {
    final /* synthetic */ FaceShopActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(FaceShopActivity faceShopActivity) {
        this.a = faceShopActivity;
    }

    @Override // com.baidu.adp.a.h
    public final void a(Object obj) {
        bu buVar;
        bu buVar2;
        bu buVar3;
        bs bsVar;
        bu buVar4;
        bu buVar5;
        bu buVar6;
        this.a.hideProgressBar();
        if (obj != null && (obj instanceof FaceShopData)) {
            buVar2 = this.a.a;
            if (buVar2 != null) {
                FaceShopData faceShopData = (FaceShopData) obj;
                if (faceShopData.errno == 0 && faceShopData.usermsg != null) {
                    bsVar = this.a.b;
                    if (bsVar.b()) {
                        buVar6 = this.a.a;
                        buVar6.e();
                    } else {
                        buVar4 = this.a.a;
                        buVar4.d();
                    }
                    buVar5 = this.a.a;
                    buVar5.a(faceShopData);
                    return;
                }
                if (faceShopData.usermsg != null) {
                    this.a.showToast(faceShopData.usermsg);
                } else {
                    this.a.showToast(com.baidu.tieba.a.k.neterror);
                }
                buVar3 = this.a.a;
                buVar3.b();
                return;
            }
            return;
        }
        this.a.showToast(com.baidu.tieba.a.k.neterror);
        buVar = this.a.a;
        buVar.b();
    }
}
