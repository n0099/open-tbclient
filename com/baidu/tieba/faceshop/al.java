package com.baidu.tieba.faceshop;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends com.baidu.adp.base.g {
    final /* synthetic */ FacePackageDetailActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FacePackageDetailActivity facePackageDetailActivity) {
        this.a = facePackageDetailActivity;
    }

    @Override // com.baidu.adp.base.g
    public void a(Object obj) {
        an anVar;
        an anVar2;
        ap apVar;
        an anVar3;
        this.a.hideProgressBar();
        if (obj != null && (obj instanceof FaceBuyData)) {
            FaceBuyData faceBuyData = (FaceBuyData) obj;
            if (faceBuyData.errno == 0 && faceBuyData.usermsg != null) {
                String str = faceBuyData.buyInfo.buyUrl;
                String str2 = faceBuyData.buyInfo.returnUrl;
                if (faceBuyData.buyInfo.buyStatus != 2) {
                    anVar3 = this.a.a;
                    anVar3.d(String.valueOf(faceBuyData.buyInfo.orderId));
                    FaceBuyWebViewActivity.a(this.a, str, str2, this.a.getString(com.baidu.tieba.u.buy_package), 0, 10001);
                    return;
                }
                this.a.showToast(com.baidu.tieba.u.has_buy2);
                anVar = this.a.a;
                FacePackageData facePackageData = anVar.a().facePackage;
                facePackageData.buyStatus = 1;
                facePackageData.canDownload = 1;
                anVar2 = this.a.a;
                anVar2.a(facePackageData);
                apVar = this.a.b;
                apVar.d();
                return;
            } else if (faceBuyData.usermsg != null) {
                this.a.showToast(faceBuyData.usermsg);
                return;
            } else {
                this.a.showToast(com.baidu.tieba.u.neterror);
                return;
            }
        }
        this.a.showToast(com.baidu.tieba.u.neterror);
    }
}
