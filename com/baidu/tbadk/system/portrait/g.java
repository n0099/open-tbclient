package com.baidu.tbadk.system.portrait;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class g implements a.b {
    final /* synthetic */ ChangeSystemPhotoActivity ayX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.ayX = changeSystemPhotoActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.ayX.setResult(0);
        this.ayX.finish();
    }
}
