package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
class bj implements com.baidu.tbadk.core.view.m {
    final /* synthetic */ FaceShopActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(FaceShopActivity faceShopActivity) {
        this.a = faceShopActivity;
    }

    @Override // com.baidu.tbadk.core.view.m
    public void a(boolean z) {
        bx bxVar;
        bx bxVar2;
        if (z) {
            bxVar = this.a.a;
            if (bxVar != null) {
                bxVar2 = this.a.a;
                bxVar2.c();
            }
        }
    }
}
