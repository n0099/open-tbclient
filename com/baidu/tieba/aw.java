package com.baidu.tieba;

import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.coreExtra.data.VersionData;
/* loaded from: classes.dex */
class aw implements Runnable {
    final /* synthetic */ av alH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(av avVar) {
        this.alH = avVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        UpdateDialog updateDialog;
        VersionData versionData;
        UpdateDialog updateDialog2;
        updateDialog = this.alH.this$0;
        versionData = updateDialog.alD;
        if (versionData.forceUpdate()) {
            updateDialog2 = this.alH.this$0;
            com.baidu.tbadk.core.b.b.e(updateDialog2.getPageContext().getPageActivity(), Constants.MEDIA_INFO);
        }
    }
}
