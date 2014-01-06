package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
class ax extends com.baidu.adp.a.g {
    final /* synthetic */ int a;
    final /* synthetic */ FaceShopActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(FaceShopActivity faceShopActivity, int i) {
        this.b = faceShopActivity;
        this.a = i;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        if (obj != null && (obj instanceof FaceBuyQueryData)) {
            FaceBuyQueryData faceBuyQueryData = (FaceBuyQueryData) obj;
            if (faceBuyQueryData.errno == 0 && faceBuyQueryData.usermsg != null) {
                if (faceBuyQueryData.buyResult.status == 2) {
                    this.b.a(this.a);
                    return;
                } else {
                    this.b.a();
                    return;
                }
            }
            this.b.a();
            return;
        }
        this.b.a();
    }
}
