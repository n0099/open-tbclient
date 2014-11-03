package com.baidu.tieba.faceshop;
/* loaded from: classes.dex */
class ae implements com.baidu.tbadk.core.view.u {
    final /* synthetic */ FacePackageDetailActivity att;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FacePackageDetailActivity facePackageDetailActivity) {
        this.att = facePackageDetailActivity;
    }

    @Override // com.baidu.tbadk.core.view.u
    public void aa(boolean z) {
        if (z) {
            this.att.refresh();
        }
    }
}
