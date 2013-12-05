package com.baidu.tieba;

import android.content.DialogInterface;
import com.baidu.tieba.data.VersionData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f1165a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(UpdateDialog updateDialog) {
        this.f1165a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        av avVar;
        VersionData versionData;
        avVar = this.f1165a.c;
        avVar.dismiss();
        versionData = this.f1165a.f1016a;
        if (versionData.getForce_update() == 1) {
            MainTabActivity.a(this.f1165a, 200);
        }
    }
}
