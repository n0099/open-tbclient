package com.baidu.tieba;

import android.content.DialogInterface;
import com.baidu.tieba.data.VersionData;
/* loaded from: classes.dex */
final class ah implements DialogInterface.OnDismissListener {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        m mVar;
        VersionData versionData;
        mVar = this.a.c;
        mVar.dismiss();
        versionData = this.a.a;
        if (versionData.getForce_update() == 1) {
            com.baidu.tbadk.core.d.b.a(this.a, 200);
        }
    }
}
