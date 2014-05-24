package com.baidu.tieba;

import com.baidu.tieba.data.CombineDownload;
import com.baidu.tieba.data.VersionData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements ah {
    final /* synthetic */ UpdateDialog a;

    private bb(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bb(UpdateDialog updateDialog, bb bbVar) {
        this(updateDialog);
    }

    @Override // com.baidu.tieba.ah
    public void a(boolean z) {
        boolean z2;
        CombineDownload combineDownload;
        this.a.a = true;
        UpdateDialog updateDialog = this.a;
        if (z) {
            UpdateDialog updateDialog2 = this.a;
            combineDownload = this.a.f;
            if (bd.a(updateDialog2, combineDownload)) {
                z2 = true;
                updateDialog.a(true, false, z2);
            }
        }
        z2 = false;
        updateDialog.a(true, false, z2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0037, code lost:
        if (com.baidu.tieba.bd.a(r3, r4) != false) goto L7;
     */
    @Override // com.baidu.tieba.ah
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(boolean z) {
        boolean z2;
        CombineDownload combineDownload;
        VersionData versionData;
        ac acVar;
        CombineDownload combineDownload2;
        boolean z3 = true;
        if (bd.a(this.a.getPackageManager())) {
            UpdateDialog updateDialog = this.a;
            versionData = this.a.e;
            bd.a(updateDialog, versionData);
            acVar = this.a.h;
            acVar.dismiss();
            this.a.finish();
            UpdateDialog updateDialog2 = this.a;
            if (z) {
                UpdateDialog updateDialog3 = this.a;
                combineDownload2 = this.a.f;
            }
            z3 = false;
            updateDialog2.a(false, false, z3);
            return;
        }
        UpdateDialog updateDialog4 = this.a;
        if (z) {
            UpdateDialog updateDialog5 = this.a;
            combineDownload = this.a.f;
            if (bd.a(updateDialog5, combineDownload)) {
                z2 = true;
                updateDialog4.a(false, true, z2);
            }
        }
        z2 = false;
        updateDialog4.a(false, true, z2);
    }

    @Override // com.baidu.tieba.ah
    public void b() {
        ac acVar;
        acVar = this.a.h;
        acVar.dismiss();
        this.a.finish();
    }

    @Override // com.baidu.tieba.ah
    public void c() {
        this.a.b();
    }

    @Override // com.baidu.tieba.ah
    public void a() {
        this.a.finish();
    }
}
