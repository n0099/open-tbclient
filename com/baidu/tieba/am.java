package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements ag {
    final /* synthetic */ UpdateDialog this$0;

    private am(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ am(UpdateDialog updateDialog, am amVar) {
        this(updateDialog);
    }

    @Override // com.baidu.tieba.ag
    public void bi(boolean z) {
        boolean z2;
        CombineDownload combineDownload;
        this.this$0.atI = true;
        UpdateDialog updateDialog = this.this$0;
        if (z) {
            Activity pageActivity = this.this$0.getPageContext().getPageActivity();
            combineDownload = this.this$0.mCombineDownload;
            if (ao.a(pageActivity, combineDownload)) {
                z2 = true;
                updateDialog.b(true, false, z2);
            }
        }
        z2 = false;
        updateDialog.b(true, false, z2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0066, code lost:
        if (com.baidu.tieba.ao.a(r3, r4) != false) goto L12;
     */
    @Override // com.baidu.tieba.ag
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bj(boolean z) {
        boolean Ec;
        boolean z2;
        CombineDownload combineDownload;
        VersionData versionData;
        ab abVar;
        CombineDownload combineDownload2;
        ab abVar2;
        boolean z3 = true;
        Ec = this.this$0.Ec();
        if (Ec) {
            abVar2 = this.this$0.auk;
            abVar2.dismiss();
            this.this$0.finish();
        } else if (ao.a(this.this$0.getPageContext().getPageActivity().getPackageManager())) {
            Activity pageActivity = this.this$0.getPageContext().getPageActivity();
            versionData = this.this$0.aui;
            ao.a(pageActivity, versionData);
            abVar = this.this$0.auk;
            abVar.dismiss();
            this.this$0.finish();
            UpdateDialog updateDialog = this.this$0;
            if (z) {
                Activity pageActivity2 = this.this$0.getPageContext().getPageActivity();
                combineDownload2 = this.this$0.mCombineDownload;
            }
            z3 = false;
            updateDialog.b(false, false, z3);
        } else {
            UpdateDialog updateDialog2 = this.this$0;
            if (z) {
                Activity pageActivity3 = this.this$0.getPageContext().getPageActivity();
                combineDownload = this.this$0.mCombineDownload;
                if (ao.a(pageActivity3, combineDownload)) {
                    z2 = true;
                    updateDialog2.b(false, true, z2);
                }
            }
            z2 = false;
            updateDialog2.b(false, true, z2);
        }
    }

    @Override // com.baidu.tieba.ag
    public void DY() {
        ab abVar;
        abVar = this.this$0.auk;
        abVar.dismiss();
        this.this$0.finish();
    }

    @Override // com.baidu.tieba.ag
    public void stopService() {
        this.this$0.Eb();
    }

    @Override // com.baidu.tieba.ag
    public void DX() {
        this.this$0.finish();
    }
}
