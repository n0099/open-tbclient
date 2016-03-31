package com.baidu.tbadk.system.portrait;

import com.baidu.tbadk.core.dialog.a;
/* loaded from: classes.dex */
class g implements a.b {
    final /* synthetic */ ChangeSystemPhotoActivity aDF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChangeSystemPhotoActivity changeSystemPhotoActivity) {
        this.aDF = changeSystemPhotoActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        this.aDF.setResult(0);
        this.aDF.finish();
    }
}
