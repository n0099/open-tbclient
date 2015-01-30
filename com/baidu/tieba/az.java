package com.baidu.tieba;

import com.baidu.tbadk.coreExtra.data.VersionData;
/* loaded from: classes.dex */
class az implements Runnable {
    final /* synthetic */ ay amB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ay ayVar) {
        this.amB = ayVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        UpdateDialog updateDialog;
        VersionData versionData;
        UpdateDialog updateDialog2;
        updateDialog = this.amB.this$0;
        versionData = updateDialog.amx;
        if (versionData.forceUpdate()) {
            updateDialog2 = this.amB.this$0;
            com.baidu.tbadk.core.b.b.e(updateDialog2.getPageContext().getPageActivity(), 200);
        }
    }
}
