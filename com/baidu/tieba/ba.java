package com.baidu.tieba;

import com.baidu.tieba.data.CombineDownload;
import com.baidu.tieba.data.VersionData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements ah {
    final /* synthetic */ UpdateDialog this$0;

    private ba(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ba(UpdateDialog updateDialog, ba baVar) {
        this(updateDialog);
    }

    @Override // com.baidu.tieba.ah
    public void aL(boolean z) {
        boolean z2;
        CombineDownload combineDownload;
        this.this$0.acU = true;
        UpdateDialog updateDialog = this.this$0;
        if (z) {
            UpdateDialog updateDialog2 = this.this$0;
            combineDownload = this.this$0.ady;
            if (bc.a(updateDialog2, combineDownload)) {
                z2 = true;
                updateDialog.b(true, false, z2);
            }
        }
        z2 = false;
        updateDialog.b(true, false, z2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0037, code lost:
        if (com.baidu.tieba.bc.a(r3, r4) != false) goto L7;
     */
    @Override // com.baidu.tieba.ah
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void aM(boolean z) {
        boolean z2;
        CombineDownload combineDownload;
        VersionData versionData;
        ac acVar;
        CombineDownload combineDownload2;
        boolean z3 = true;
        if (bc.a(this.this$0.getPackageManager())) {
            UpdateDialog updateDialog = this.this$0;
            versionData = this.this$0.aee;
            bc.a(updateDialog, versionData);
            acVar = this.this$0.aeg;
            acVar.dismiss();
            this.this$0.finish();
            UpdateDialog updateDialog2 = this.this$0;
            if (z) {
                UpdateDialog updateDialog3 = this.this$0;
                combineDownload2 = this.this$0.ady;
            }
            z3 = false;
            updateDialog2.b(false, false, z3);
            return;
        }
        UpdateDialog updateDialog4 = this.this$0;
        if (z) {
            UpdateDialog updateDialog5 = this.this$0;
            combineDownload = this.this$0.ady;
            if (bc.a(updateDialog5, combineDownload)) {
                z2 = true;
                updateDialog4.b(false, true, z2);
            }
        }
        z2 = false;
        updateDialog4.b(false, true, z2);
    }

    @Override // com.baidu.tieba.ah
    public void we() {
        ac acVar;
        acVar = this.this$0.aeg;
        acVar.dismiss();
        this.this$0.finish();
    }

    @Override // com.baidu.tieba.ah
    public void stopService() {
        this.this$0.wZ();
    }

    @Override // com.baidu.tieba.ah
    public void wd() {
        this.this$0.finish();
    }
}
