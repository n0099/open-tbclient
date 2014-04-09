package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
final class bi implements com.baidu.tbadk.core.view.m {
    final /* synthetic */ FaceShopActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(FaceShopActivity faceShopActivity) {
        this.a = faceShopActivity;
    }

    @Override // com.baidu.tbadk.core.view.m
    public final void a(boolean z) {
        bw bwVar;
        bw bwVar2;
        if (z) {
            bwVar = this.a.a;
            if (bwVar != null) {
                bwVar2 = this.a.a;
                bwVar2.c();
            }
        }
    }
}
