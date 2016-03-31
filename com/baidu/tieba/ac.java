package com.baidu.tieba;
/* loaded from: classes.dex */
class ac implements Runnable {
    final /* synthetic */ ab aLD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.aLD = abVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        UpdateDialog updateDialog;
        UpdateDialog updateDialog2;
        updateDialog = this.aLD.this$0;
        if (updateDialog.aLz.forceUpdate()) {
            updateDialog2 = this.aLD.this$0;
            com.baidu.tbadk.core.d.b.d(updateDialog2.getPageContext().getPageActivity(), 200);
        }
    }
}
