package com.baidu.tbadk.system.portrait;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class g implements a.b {
    final /* synthetic */ ChangeSystemPhotoActivity aJP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aJP = changeSystemPhotoActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aJP.setResult(0);
        this.aJP.finish();
    }
}
