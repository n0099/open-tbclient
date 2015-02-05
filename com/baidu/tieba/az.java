package com.baidu.tieba;

import com.baidu.tbadk.coreExtra.data.VersionData;
/* loaded from: classes.dex */
class az implements Runnable {
    final /* synthetic */ ay amy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ay ayVar) {
        this.amy = ayVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        UpdateDialog updateDialog;
        VersionData versionData;
        UpdateDialog updateDialog2;
        updateDialog = this.amy.this$0;
        versionData = updateDialog.amu;
        if (versionData.forceUpdate()) {
            updateDialog2 = this.amy.this$0;
            com.baidu.tbadk.core.b.b.e(updateDialog2.getPageContext().getPageActivity(), 200);
        }
    }
}
