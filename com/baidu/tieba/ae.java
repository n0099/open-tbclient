package com.baidu.tieba;

import com.baidu.tbadk.coreExtra.data.VersionData;
/* loaded from: classes.dex */
class ae implements Runnable {
    final /* synthetic */ ad avX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.avX = adVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        UpdateDialog updateDialog;
        VersionData versionData;
        UpdateDialog updateDialog2;
        updateDialog = this.avX.this$0;
        versionData = updateDialog.avT;
        if (versionData.forceUpdate()) {
            updateDialog2 = this.avX.this$0;
            com.baidu.tbadk.core.c.b.e(updateDialog2.getPageContext().getPageActivity(), 200);
        }
    }
}
