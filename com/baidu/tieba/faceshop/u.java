package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
final class u extends com.baidu.adp.a.g {
    final /* synthetic */ FacePackageDetailActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FacePackageDetailActivity facePackageDetailActivity) {
        this.a = facePackageDetailActivity;
    }

    @Override // com.baidu.adp.a.g
    public final void a(Object obj) {
        if (obj != null && (obj instanceof FaceBuyQueryData)) {
            FaceBuyQueryData faceBuyQueryData = (FaceBuyQueryData) obj;
            if (faceBuyQueryData.errno == 0 && faceBuyQueryData.usermsg != null) {
                if (faceBuyQueryData.buyResult.status == 2) {
                    this.a.b();
                    return;
                } else {
                    this.a.c();
                    return;
                }
            }
            this.a.c();
            return;
        }
        this.a.c();
    }
}
