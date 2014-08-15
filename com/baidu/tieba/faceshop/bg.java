package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
class bg extends com.baidu.adp.base.h {
    final /* synthetic */ FaceShopActivity a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(FaceShopActivity faceShopActivity, int i) {
        this.a = faceShopActivity;
        this.b = i;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        if (obj != null && (obj instanceof FaceBuyQueryData)) {
            FaceBuyQueryData faceBuyQueryData = (FaceBuyQueryData) obj;
            if (faceBuyQueryData.errno == 0 && faceBuyQueryData.usermsg != null) {
                if (faceBuyQueryData.buyResult.status == 2) {
                    this.a.a(this.b);
                    return;
                } else {
                    this.a.a();
                    return;
                }
            }
            this.a.a();
            return;
        }
        this.a.a();
    }
}
