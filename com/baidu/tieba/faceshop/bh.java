package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
class bh extends com.baidu.adp.base.h {
    private final /* synthetic */ int BF;
    final /* synthetic */ FaceShopActivity auo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(FaceShopActivity faceShopActivity, int i) {
        this.auo = faceShopActivity;
        this.BF = i;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        if (obj != null && (obj instanceof FaceBuyQueryData)) {
            FaceBuyQueryData faceBuyQueryData = (FaceBuyQueryData) obj;
            if (faceBuyQueryData.errno == 0 && faceBuyQueryData.usermsg != null) {
                if (faceBuyQueryData.buy_result.status == 2) {
                    this.auo.eu(this.BF);
                    return;
                } else {
                    this.auo.CX();
                    return;
                }
            }
            this.auo.CX();
            return;
        }
        this.auo.CX();
    }
}
