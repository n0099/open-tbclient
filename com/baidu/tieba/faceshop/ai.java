package com.baidu.tieba.faceshop;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends com.baidu.adp.base.h {
    final /* synthetic */ FacePackageDetailActivity att;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FacePackageDetailActivity facePackageDetailActivity) {
        this.att = facePackageDetailActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        ak akVar;
        ak akVar2;
        am amVar;
        ak akVar3;
        this.att.hideProgressBar();
        if (obj != null && (obj instanceof FaceBuyData)) {
            FaceBuyData faceBuyData = (FaceBuyData) obj;
            if (faceBuyData.errno == 0 && faceBuyData.usermsg != null) {
                String str = faceBuyData.buy_info.buy_url;
                String str2 = faceBuyData.buy_info.return_url;
                if (faceBuyData.buy_info.buy_status != 2) {
                    akVar3 = this.att.atj;
                    akVar3.eR(String.valueOf(faceBuyData.buy_info.order_id));
                    FaceBuyWebViewActivity.a(this.att, str, str2, this.att.getString(cb.buy_package), 0, 10001);
                    return;
                }
                this.att.showToast(cb.has_buy2);
                akVar = this.att.atj;
                FacePackageData facePackageData = akVar.Da().faces_list;
                facePackageData.buy_status = 1;
                facePackageData.can_download = 1;
                akVar2 = this.att.atj;
                akVar2.a(facePackageData);
                amVar = this.att.atk;
                amVar.Dj();
                return;
            } else if (faceBuyData.usermsg != null) {
                this.att.showToast(faceBuyData.usermsg);
                return;
            } else {
                this.att.showToast(cb.neterror);
                return;
            }
        }
        this.att.showToast(cb.neterror);
    }
}
