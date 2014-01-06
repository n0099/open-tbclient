package com.baidu.tieba.faceshop;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class aw extends com.baidu.adp.a.g {
    final /* synthetic */ FaceShopActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(FaceShopActivity faceShopActivity) {
        this.a = faceShopActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        bh bhVar;
        bh bhVar2;
        bh bhVar3;
        be beVar;
        bh bhVar4;
        bh bhVar5;
        bh bhVar6;
        this.a.hideProgressBar();
        if (obj != null && (obj instanceof FaceShopData)) {
            bhVar2 = this.a.a;
            if (bhVar2 != null) {
                FaceShopData faceShopData = (FaceShopData) obj;
                if (faceShopData.errno == 0 && faceShopData.usermsg != null) {
                    beVar = this.a.b;
                    if (beVar.b()) {
                        bhVar6 = this.a.a;
                        bhVar6.e();
                    } else {
                        bhVar4 = this.a.a;
                        bhVar4.d();
                    }
                    bhVar5 = this.a.a;
                    bhVar5.a(faceShopData);
                    return;
                }
                if (faceShopData.usermsg != null) {
                    this.a.showToast(faceShopData.usermsg);
                } else {
                    this.a.showToast(R.string.neterror);
                }
                bhVar3 = this.a.a;
                bhVar3.b();
                return;
            }
            return;
        }
        this.a.showToast(R.string.neterror);
        bhVar = this.a.a;
        bhVar.b();
    }
}
