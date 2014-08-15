package com.baidu.tieba;

import android.content.DialogInterface;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tieba.data.VersionData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements DialogInterface.OnDismissListener {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        ab abVar;
        VersionData versionData;
        abVar = this.a.h;
        abVar.dismiss();
        versionData = this.a.e;
        if (versionData.forceUpdate()) {
            com.baidu.tbadk.core.b.b.a(this.a, Constants.MEDIA_INFO);
        }
    }
}
