package com.baidu.tieba.faceshop;

import com.baidu.android.pushservice.PushConstants;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t extends com.baidu.adp.a.g {
    final /* synthetic */ FacePackageDetailActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FacePackageDetailActivity facePackageDetailActivity) {
        this.a = facePackageDetailActivity;
    }

    @Override // com.baidu.adp.a.g
    public final void a(Object obj) {
        v vVar;
        v vVar2;
        x xVar;
        v vVar3;
        this.a.hideProgressBar();
        if (obj != null && (obj instanceof FaceBuyData)) {
            FaceBuyData faceBuyData = (FaceBuyData) obj;
            if (faceBuyData.errno == 0 && faceBuyData.usermsg != null) {
                String str = faceBuyData.buyInfo.buyUrl;
                String str2 = faceBuyData.buyInfo.returnUrl;
                if (faceBuyData.buyInfo.buyStatus != 2) {
                    vVar3 = this.a.a;
                    vVar3.d(String.valueOf(faceBuyData.buyInfo.orderId));
                    FaceBuyWebViewActivity.a(this.a, str, str2, this.a.getString(R.string.buy_package), 0, PushConstants.ERROR_NETWORK_ERROR);
                    return;
                }
                this.a.showToast(R.string.has_buy2);
                vVar = this.a.a;
                FacePackageData facePackageData = vVar.a().facePackage;
                facePackageData.buyStatus = 1;
                facePackageData.canDownload = 1;
                vVar2 = this.a.a;
                vVar2.a(facePackageData);
                xVar = this.a.b;
                xVar.b();
                return;
            } else if (faceBuyData.usermsg != null) {
                this.a.showToast(faceBuyData.usermsg);
                return;
            } else {
                this.a.showToast(R.string.neterror);
                return;
            }
        }
        this.a.showToast(R.string.neterror);
    }
}
