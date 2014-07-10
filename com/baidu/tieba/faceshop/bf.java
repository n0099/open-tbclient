package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
class bf implements com.baidu.tbadk.core.view.m {
    final /* synthetic */ FaceShopActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(FaceShopActivity faceShopActivity) {
        this.a = faceShopActivity;
    }

    @Override // com.baidu.tbadk.core.view.m
    public void a(boolean z) {
        bt btVar;
        bt btVar2;
        if (z) {
            btVar = this.a.a;
            if (btVar != null) {
                btVar2 = this.a.a;
                btVar2.c();
            }
        }
    }
}
