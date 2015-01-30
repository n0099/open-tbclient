package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements an {
    final /* synthetic */ UpdateDialog this$0;

    private bc(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bc(UpdateDialog updateDialog, bc bcVar) {
        this(updateDialog);
    }

    @Override // com.baidu.tieba.an
    public void bd(boolean z) {
        boolean z2;
        CombineDownload combineDownload;
        this.this$0.alG = true;
        UpdateDialog updateDialog = this.this$0;
        if (z) {
            Activity pageActivity = this.this$0.getPageContext().getPageActivity();
            combineDownload = this.this$0.mCombineDownload;
            if (be.a(pageActivity, combineDownload)) {
                z2 = true;
                updateDialog.b(true, false, z2);
            }
        }
        z2 = false;
        updateDialog.b(true, false, z2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x004f, code lost:
        if (com.baidu.tieba.be.a(r3, r4) != false) goto L7;
     */
    @Override // com.baidu.tieba.an
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void be(boolean z) {
        boolean z2;
        CombineDownload combineDownload;
        VersionData versionData;
        ai aiVar;
        CombineDownload combineDownload2;
        boolean z3 = true;
        if (be.a(this.this$0.getPageContext().getPageActivity().getPackageManager())) {
            Activity pageActivity = this.this$0.getPageContext().getPageActivity();
            versionData = this.this$0.amx;
            be.a(pageActivity, versionData);
            aiVar = this.this$0.amz;
            aiVar.dismiss();
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
            if (be.a(pageActivity3, combineDownload)) {
                z2 = true;
                updateDialog2.b(false, true, z2);
            }
        }
        z2 = false;
        updateDialog2.b(false, true, z2);
    }

    @Override // com.baidu.tieba.an
    public void AN() {
        ai aiVar;
        aiVar = this.this$0.amz;
        aiVar.dismiss();
        this.this$0.finish();
    }

    @Override // com.baidu.tieba.an
    public void stopService() {
        this.this$0.AU();
    }

    @Override // com.baidu.tieba.an
    public void AM() {
        this.this$0.finish();
    }
}
