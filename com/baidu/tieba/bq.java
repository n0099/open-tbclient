package com.baidu.tieba;

import android.content.DialogInterface;
import com.baidu.tieba.data.VersionData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements DialogInterface.OnDismissListener {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        ay ayVar;
        VersionData versionData;
        ayVar = this.a.c;
        ayVar.dismiss();
        versionData = this.a.a;
        if (versionData.getForce_update() == 1) {
            MainTabActivity.a(this.a, 200);
        }
    }
}
