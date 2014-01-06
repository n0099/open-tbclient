package com.baidu.tieba.faceshop;

import com.baidu.android.pushservice.PushConstants;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.adp.a.g {
    final /* synthetic */ FacePackageDetailActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FacePackageDetailActivity facePackageDetailActivity) {
        this.a = facePackageDetailActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        w wVar;
        w wVar2;
        z zVar;
        w wVar3;
        this.a.hideProgressBar();
        if (obj != null && (obj instanceof FaceBuyData)) {
            FaceBuyData faceBuyData = (FaceBuyData) obj;
            if (faceBuyData.errno == 0 && faceBuyData.usermsg != null) {
                String str = faceBuyData.buyInfo.buyUrl;
                String str2 = faceBuyData.buyInfo.returnUrl;
                if (faceBuyData.buyInfo.buyStatus != 2) {
                    wVar3 = this.a.a;
                    wVar3.d(String.valueOf(faceBuyData.buyInfo.orderId));
                    FaceBuyWebViewActivity.a(this.a, str, str2, this.a.getString(R.string.buy_package), 0, PushConstants.ERROR_NETWORK_ERROR);
                    return;
                }
                this.a.showToast(R.string.has_buy2);
                wVar = this.a.a;
                FacePackageData facePackageData = wVar.a().facePackage;
                facePackageData.buyStatus = 1;
                facePackageData.canDownload = 1;
                wVar2 = this.a.a;
                wVar2.a(facePackageData);
                zVar = this.a.b;
                zVar.d();
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
