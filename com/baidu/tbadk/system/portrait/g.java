package com.baidu.tbadk.system.portrait;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class g implements a.b {
    final /* synthetic */ ChangeSystemPhotoActivity aAk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aAk = changeSystemPhotoActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aAk.setResult(0);
        this.aAk.finish();
    }
}
