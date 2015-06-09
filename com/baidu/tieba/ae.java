package com.baidu.tieba;

import com.baidu.tbadk.coreExtra.data.VersionData;
/* loaded from: classes.dex */
class ae implements Runnable {
    final /* synthetic */ ad avY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.avY = adVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        UpdateDialog updateDialog;
        VersionData versionData;
        UpdateDialog updateDialog2;
        updateDialog = this.avY.this$0;
        versionData = updateDialog.avU;
        if (versionData.forceUpdate()) {
            updateDialog2 = this.avY.this$0;
            com.baidu.tbadk.core.c.b.e(updateDialog2.getPageContext().getPageActivity(), 200);
        }
    }
}
