package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
class aj extends com.baidu.adp.base.h {
    final /* synthetic */ FacePackageDetailActivity atk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FacePackageDetailActivity facePackageDetailActivity) {
        this.atk = facePackageDetailActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        if (obj != null && (obj instanceof FaceBuyQueryData)) {
            FaceBuyQueryData faceBuyQueryData = (FaceBuyQueryData) obj;
            if (faceBuyQueryData.errno == 0 && faceBuyQueryData.usermsg != null) {
                if (faceBuyQueryData.buy_result.status == 2) {
                    this.atk.CW();
                    return;
                } else {
                    this.atk.CX();
                    return;
                }
            }
            this.atk.CX();
            return;
        }
        this.atk.CX();
    }
}
