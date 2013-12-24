package com.baidu.tieba;

import android.content.DialogInterface;
import com.baidu.browser.webpool.BdWebPoolView;
import com.baidu.tieba.data.VersionData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements DialogInterface.OnDismissListener {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        au auVar;
        VersionData versionData;
        auVar = this.a.c;
        auVar.dismiss();
        versionData = this.a.a;
        if (versionData.getForce_update() == 1) {
            MainTabActivity.a(this.a, (int) BdWebPoolView.DELAYED_TIME);
        }
    }
}
