package com.baidu.tieba;

import android.app.Activity;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements ab {
    final /* synthetic */ UpdateDialog this$0;

    private ah(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ah(UpdateDialog updateDialog, ah ahVar) {
        this(updateDialog);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0034  */
    @Override // com.baidu.tieba.ab
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void br(boolean z) {
        boolean z2;
        boolean z3;
        w wVar;
        CombineDownload combineDownload;
        this.this$0.avq = true;
        UpdateDialog updateDialog = this.this$0;
        if (z) {
            Activity pageActivity = this.this$0.getPageContext().getPageActivity();
            combineDownload = this.this$0.mCombineDownload;
            if (aj.a(pageActivity, combineDownload)) {
                z2 = true;
                updateDialog.b(true, false, z2);
                this.this$0.showToast(t.download_begin_tip);
                z3 = this.this$0.avr;
                if (z3) {
                    wVar = this.this$0.avV;
                    wVar.dismiss();
                    this.this$0.finish();
                    return;
                }
                return;
            }
        }
        z2 = false;
        updateDialog.b(true, false, z2);
        this.this$0.showToast(t.download_begin_tip);
        z3 = this.this$0.avr;
        if (z3) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0058, code lost:
        if (com.baidu.tieba.aj.a(r3, r4) != false) goto L12;
     */
    @Override // com.baidu.tieba.ab
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bs(boolean z) {
        boolean EV;
        boolean z2;
        CombineDownload combineDownload;
        boolean z3;
        w wVar;
        VersionData versionData;
        CombineDownload combineDownload2;
        w wVar2;
        boolean z4 = true;
        EV = this.this$0.EV();
        if (EV) {
            wVar2 = this.this$0.avV;
            wVar2.dismiss();
            this.this$0.finish();
            return;
        }
        if (aj.a(this.this$0.getPageContext().getPageActivity().getPackageManager())) {
            Activity pageActivity = this.this$0.getPageContext().getPageActivity();
            versionData = this.this$0.avT;
            aj.a(pageActivity, versionData);
            UpdateDialog updateDialog = this.this$0;
            if (z) {
                Activity pageActivity2 = this.this$0.getPageContext().getPageActivity();
                combineDownload2 = this.this$0.mCombineDownload;
            }
            z4 = false;
            updateDialog.b(false, false, z4);
        } else {
            UpdateDialog updateDialog2 = this.this$0;
            if (z) {
                Activity pageActivity3 = this.this$0.getPageContext().getPageActivity();
                combineDownload = this.this$0.mCombineDownload;
                if (aj.a(pageActivity3, combineDownload)) {
                    z2 = true;
                    updateDialog2.b(false, true, z2);
                }
            }
            z2 = false;
            updateDialog2.b(false, true, z2);
        }
        z3 = this.this$0.avr;
        if (!z3) {
            wVar = this.this$0.avV;
            wVar.dismiss();
            this.this$0.finish();
        }
    }

    @Override // com.baidu.tieba.ab
    public void ES() {
        w wVar;
        wVar = this.this$0.avV;
        wVar.dismiss();
        this.this$0.finish();
    }

    @Override // com.baidu.tieba.ab
    public void stopService() {
        this.this$0.EU();
    }

    @Override // com.baidu.tieba.ab
    public void ER() {
        this.this$0.finish();
    }
}
