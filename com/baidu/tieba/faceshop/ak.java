package com.baidu.tieba.faceshop;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends com.baidu.adp.base.h {
    final /* synthetic */ FacePackageDetailActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(FacePackageDetailActivity facePackageDetailActivity) {
        this.a = facePackageDetailActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        am amVar;
        am amVar2;
        ao aoVar;
        am amVar3;
        this.a.hideProgressBar();
        if (obj != null && (obj instanceof FaceBuyData)) {
            FaceBuyData faceBuyData = (FaceBuyData) obj;
            if (faceBuyData.errno == 0 && faceBuyData.usermsg != null) {
                String str = faceBuyData.buyInfo.buyUrl;
                String str2 = faceBuyData.buyInfo.returnUrl;
                if (faceBuyData.buyInfo.buyStatus != 2) {
                    amVar3 = this.a.a;
                    amVar3.d(String.valueOf(faceBuyData.buyInfo.orderId));
                    FaceBuyWebViewActivity.a(this.a, str, str2, this.a.getString(com.baidu.tieba.y.buy_package), 0, 10001);
                    return;
                }
                this.a.showToast(com.baidu.tieba.y.has_buy2);
                amVar = this.a.a;
                FacePackageData facePackageData = amVar.a().facePackage;
                facePackageData.buyStatus = 1;
                facePackageData.canDownload = 1;
                amVar2 = this.a.a;
                amVar2.a(facePackageData);
                aoVar = this.a.b;
                aoVar.d();
                return;
            } else if (faceBuyData.usermsg != null) {
                this.a.showToast(faceBuyData.usermsg);
                return;
            } else {
                this.a.showToast(com.baidu.tieba.y.neterror);
                return;
            }
        }
        this.a.showToast(com.baidu.tieba.y.neterror);
    }
}
