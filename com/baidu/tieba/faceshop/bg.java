package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
class bg extends com.baidu.adp.base.h {
    final /* synthetic */ FaceShopActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(FaceShopActivity faceShopActivity) {
        this.a = faceShopActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        bt btVar;
        bt btVar2;
        bt btVar3;
        br brVar;
        bt btVar4;
        bt btVar5;
        bt btVar6;
        this.a.hideProgressBar();
        if (obj != null && (obj instanceof FaceShopData)) {
            btVar2 = this.a.a;
            if (btVar2 != null) {
                FaceShopData faceShopData = (FaceShopData) obj;
                if (faceShopData.errno == 0 && faceShopData.usermsg != null) {
                    brVar = this.a.b;
                    if (brVar.b()) {
                        btVar6 = this.a.a;
                        btVar6.f();
                    } else {
                        btVar4 = this.a.a;
                        btVar4.e();
                    }
                    btVar5 = this.a.a;
                    btVar5.a(faceShopData);
                    return;
                }
                if (faceShopData.usermsg != null) {
                    this.a.showToast(faceShopData.usermsg);
                } else {
                    this.a.showToast(com.baidu.tieba.y.neterror);
                }
                btVar3 = this.a.a;
                btVar3.b();
                return;
            }
            return;
        }
        this.a.showToast(com.baidu.tieba.y.neterror);
        btVar = this.a.a;
        btVar.b();
    }
}
