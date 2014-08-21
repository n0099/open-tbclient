package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
class bb implements com.baidu.tbadk.core.view.r {
    final /* synthetic */ FaceShopActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(FaceShopActivity faceShopActivity) {
        this.a = faceShopActivity;
    }

    @Override // com.baidu.tbadk.core.view.r
    public void a(boolean z) {
        bp bpVar;
        bp bpVar2;
        if (z) {
            bpVar = this.a.a;
            if (bpVar != null) {
                bpVar2 = this.a.a;
                bpVar2.c();
            }
        }
    }
}
