package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
class bc extends com.baidu.adp.base.h {
    final /* synthetic */ FaceShopActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(FaceShopActivity faceShopActivity) {
        this.a = faceShopActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        bp bpVar;
        bp bpVar2;
        bp bpVar3;
        bn bnVar;
        bp bpVar4;
        bp bpVar5;
        bp bpVar6;
        this.a.hideProgressBar();
        if (obj != null && (obj instanceof FaceShopData)) {
            bpVar2 = this.a.a;
            if (bpVar2 != null) {
                FaceShopData faceShopData = (FaceShopData) obj;
                if (faceShopData.errno == 0 && faceShopData.usermsg != null) {
                    bnVar = this.a.b;
                    if (bnVar.b()) {
                        bpVar6 = this.a.a;
                        bpVar6.f();
                    } else {
                        bpVar4 = this.a.a;
                        bpVar4.e();
                    }
                    bpVar5 = this.a.a;
                    bpVar5.a(faceShopData);
                    return;
                }
                if (faceShopData.usermsg != null) {
                    this.a.showToast(faceShopData.usermsg);
                } else {
                    this.a.showToast(com.baidu.tieba.x.neterror);
                }
                bpVar3 = this.a.a;
                bpVar3.b();
                return;
            }
            return;
        }
        this.a.showToast(com.baidu.tieba.x.neterror);
        bpVar = this.a.a;
        bpVar.b();
    }
}
