package com.baidu.tieba;
/* loaded from: classes.dex */
class ac implements Runnable {
    final /* synthetic */ ab aHO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.aHO = abVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        UpdateDialog updateDialog;
        UpdateDialog updateDialog2;
        updateDialog = this.aHO.this$0;
        if (updateDialog.aHK.forceUpdate()) {
            updateDialog2 = this.aHO.this$0;
            com.baidu.tbadk.core.e.b.d(updateDialog2.getPageContext().getPageActivity(), 200);
        }
    }
}
