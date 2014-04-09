package com.baidu.tieba;

import android.content.DialogInterface;
import com.baidu.tieba.data.VersionData;
/* loaded from: classes.dex */
final class af implements DialogInterface.OnDismissListener {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        k kVar;
        VersionData versionData;
        kVar = this.a.c;
        kVar.dismiss();
        versionData = this.a.a;
        if (versionData.getForce_update() == 1) {
            com.baidu.tbadk.core.d.b.a(this.a, 200);
        }
    }
}
