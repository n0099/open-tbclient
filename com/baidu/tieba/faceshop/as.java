package com.baidu.tieba.faceshop;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class as extends com.baidu.adp.a.g {
    final /* synthetic */ FaceShopActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(FaceShopActivity faceShopActivity) {
        this.a = faceShopActivity;
    }

    @Override // com.baidu.adp.a.g
    public final void a(Object obj) {
        be beVar;
        be beVar2;
        be beVar3;
        bc bcVar;
        be beVar4;
        be beVar5;
        be beVar6;
        this.a.hideProgressBar();
        if (obj != null && (obj instanceof FaceShopData)) {
            beVar2 = this.a.a;
            if (beVar2 != null) {
                FaceShopData faceShopData = (FaceShopData) obj;
                if (faceShopData.errno == 0 && faceShopData.usermsg != null) {
                    bcVar = this.a.b;
                    if (bcVar.b()) {
                        beVar6 = this.a.a;
                        beVar6.e();
                    } else {
                        beVar4 = this.a.a;
                        beVar4.d();
                    }
                    beVar5 = this.a.a;
                    beVar5.a(faceShopData);
                    return;
                }
                if (faceShopData.usermsg != null) {
                    this.a.showToast(faceShopData.usermsg);
                } else {
                    this.a.showToast(R.string.neterror);
                }
                beVar3 = this.a.a;
                beVar3.b();
                return;
            }
            return;
        }
        this.a.showToast(R.string.neterror);
        beVar = this.a.a;
        beVar.b();
    }
}
