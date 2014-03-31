package com.baidu.tieba.faceshop;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ai extends com.baidu.adp.a.h {
    final /* synthetic */ FacePackageDetailActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FacePackageDetailActivity facePackageDetailActivity) {
        this.a = facePackageDetailActivity;
    }

    @Override // com.baidu.adp.a.h
    public final void a(Object obj) {
        ak akVar;
        ak akVar2;
        am amVar;
        ak akVar3;
        this.a.hideProgressBar();
        if (obj != null && (obj instanceof FaceBuyData)) {
            FaceBuyData faceBuyData = (FaceBuyData) obj;
            if (faceBuyData.errno == 0 && faceBuyData.usermsg != null) {
                String str = faceBuyData.buyInfo.buyUrl;
                String str2 = faceBuyData.buyInfo.returnUrl;
                if (faceBuyData.buyInfo.buyStatus != 2) {
                    akVar3 = this.a.a;
                    akVar3.d(String.valueOf(faceBuyData.buyInfo.orderId));
                    FaceBuyWebViewActivity.a(this.a, str, str2, this.a.getString(com.baidu.tieba.a.k.buy_package), 0, 10001);
                    return;
                }
                this.a.showToast(com.baidu.tieba.a.k.has_buy2);
                akVar = this.a.a;
                FacePackageData facePackageData = akVar.a().facePackage;
                facePackageData.buyStatus = 1;
                facePackageData.canDownload = 1;
                akVar2 = this.a.a;
                akVar2.a(facePackageData);
                amVar = this.a.b;
                amVar.b();
                return;
            } else if (faceBuyData.usermsg != null) {
                this.a.showToast(faceBuyData.usermsg);
                return;
            } else {
                this.a.showToast(com.baidu.tieba.a.k.neterror);
                return;
            }
        }
        this.a.showToast(com.baidu.tieba.a.k.neterror);
    }
}
