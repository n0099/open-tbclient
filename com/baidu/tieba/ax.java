package com.baidu.tieba;

import android.content.DialogInterface;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tieba.data.VersionData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements DialogInterface.OnDismissListener {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        ac acVar;
        VersionData versionData;
        acVar = this.a.h;
        acVar.dismiss();
        versionData = this.a.e;
        if (versionData.forceUpdate()) {
            com.baidu.tbadk.core.b.b.a(this.a, Constants.MEDIA_INFO);
        }
    }
}
