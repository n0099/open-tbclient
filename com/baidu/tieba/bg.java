package com.baidu.tieba;

import android.content.DialogInterface;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tieba.data.VersionData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements DialogInterface.OnDismissListener {
    final /* synthetic */ UpdateDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        ac acVar;
        VersionData versionData;
        acVar = this.this$0.aeo;
        acVar.dismiss();
        versionData = this.this$0.aem;
        if (versionData.forceUpdate()) {
            com.baidu.tbadk.core.b.b.d(this.this$0, Constants.MEDIA_INFO);
        }
    }
}
