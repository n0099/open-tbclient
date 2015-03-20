package com.baidu.tieba;

import com.baidu.tbadk.coreExtra.data.VersionData;
/* loaded from: classes.dex */
class aj implements Runnable {
    final /* synthetic */ ai aum;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar) {
        this.aum = aiVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        UpdateDialog updateDialog;
        VersionData versionData;
        UpdateDialog updateDialog2;
        updateDialog = this.aum.this$0;
        versionData = updateDialog.aui;
        if (versionData.forceUpdate()) {
            updateDialog2 = this.aum.this$0;
            com.baidu.tbadk.core.c.b.e(updateDialog2.getPageContext().getPageActivity(), 200);
        }
    }
}
