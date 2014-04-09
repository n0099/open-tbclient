package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
final class bj extends com.baidu.adp.a.h {
    final /* synthetic */ FaceShopActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(FaceShopActivity faceShopActivity) {
        this.a = faceShopActivity;
    }

    @Override // com.baidu.adp.a.h
    public final void a(Object obj) {
        bw bwVar;
        bw bwVar2;
        bw bwVar3;
        bu buVar;
        bw bwVar4;
        bw bwVar5;
        bw bwVar6;
        this.a.hideProgressBar();
        if (obj != null && (obj instanceof FaceShopData)) {
            bwVar2 = this.a.a;
            if (bwVar2 != null) {
                FaceShopData faceShopData = (FaceShopData) obj;
                if (faceShopData.errno == 0 && faceShopData.usermsg != null) {
                    buVar = this.a.b;
                    if (buVar.b()) {
                        bwVar6 = this.a.a;
                        bwVar6.f();
                    } else {
                        bwVar4 = this.a.a;
                        bwVar4.e();
                    }
                    bwVar5 = this.a.a;
                    bwVar5.a(faceShopData);
                    return;
                }
                if (faceShopData.usermsg != null) {
                    this.a.showToast(faceShopData.usermsg);
                } else {
                    this.a.showToast(com.baidu.tieba.a.k.neterror);
                }
                bwVar3 = this.a.a;
                bwVar3.b();
                return;
            }
            return;
        }
        this.a.showToast(com.baidu.tieba.a.k.neterror);
        bwVar = this.a.a;
        bwVar.b();
    }
}
