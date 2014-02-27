package com.baidu.tieba;

import android.content.DialogInterface;
import com.baidu.tieba.data.VersionData;
/* loaded from: classes.dex */
final class bd implements DialogInterface.OnDismissListener {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        an anVar;
        VersionData versionData;
        anVar = this.a.c;
        anVar.dismiss();
        versionData = this.a.a;
        if (versionData.getForce_update() == 1) {
            com.baidu.tieba.mainentrance.d.a(this.a, 200);
        }
    }
}
