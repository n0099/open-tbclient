package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements ak {
    final /* synthetic */ UpdateDialog this$0;

    private az(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ az(UpdateDialog updateDialog, az azVar) {
        this(updateDialog);
    }

    @Override // com.baidu.tieba.ak
    public void bb(boolean z) {
        boolean z2;
        CombineDownload combineDownload;
        this.this$0.akM = true;
        UpdateDialog updateDialog = this.this$0;
        if (z) {
            Activity pageActivity = this.this$0.getPageContext().getPageActivity();
            combineDownload = this.this$0.mCombineDownload;
            if (bb.a(pageActivity, combineDownload)) {
                z2 = true;
                updateDialog.b(true, false, z2);
            }
        }
        z2 = false;
        updateDialog.b(true, false, z2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x004f, code lost:
        if (com.baidu.tieba.bb.a(r3, r4) != false) goto L7;
     */
    @Override // com.baidu.tieba.ak
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bc(boolean z) {
        boolean z2;
        CombineDownload combineDownload;
        VersionData versionData;
        af afVar;
        CombineDownload combineDownload2;
        boolean z3 = true;
        if (bb.a(this.this$0.getPageContext().getPageActivity().getPackageManager())) {
            Activity pageActivity = this.this$0.getPageContext().getPageActivity();
            versionData = this.this$0.alD;
            bb.a(pageActivity, versionData);
            afVar = this.this$0.alF;
            afVar.dismiss();
            this.this$0.finish();
            UpdateDialog updateDialog = this.this$0;
            if (z) {
                Activity pageActivity2 = this.this$0.getPageContext().getPageActivity();
                combineDownload2 = this.this$0.mCombineDownload;
            }
            z3 = false;
            updateDialog.b(false, false, z3);
            return;
        }
        UpdateDialog updateDialog2 = this.this$0;
        if (z) {
            Activity pageActivity3 = this.this$0.getPageContext().getPageActivity();
            combineDownload = this.this$0.mCombineDownload;
            if (bb.a(pageActivity3, combineDownload)) {
                z2 = true;
                updateDialog2.b(false, true, z2);
            }
        }
        z2 = false;
        updateDialog2.b(false, true, z2);
    }

    @Override // com.baidu.tieba.ak
    public void Ap() {
        af afVar;
        afVar = this.this$0.alF;
        afVar.dismiss();
        this.this$0.finish();
    }

    @Override // com.baidu.tieba.ak
    public void stopService() {
        this.this$0.Aw();
    }

    @Override // com.baidu.tieba.ak
    public void Ao() {
        this.this$0.finish();
    }
}
