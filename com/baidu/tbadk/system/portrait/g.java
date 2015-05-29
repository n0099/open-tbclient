package com.baidu.tbadk.system.portrait;
/* loaded from: classes.dex */
class g implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ ChangeSystemPhotoActivity arP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.arP = changeSystemPhotoActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.arP.setResult(0);
        this.arP.finish();
    }
}
