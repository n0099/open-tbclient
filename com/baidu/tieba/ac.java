package com.baidu.tieba;
/* loaded from: classes.dex */
class ac implements Runnable {
    final /* synthetic */ ab aIH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.aIH = abVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        UpdateDialog updateDialog;
        UpdateDialog updateDialog2;
        updateDialog = this.aIH.this$0;
        if (updateDialog.aID.forceUpdate()) {
            updateDialog2 = this.aIH.this$0;
            com.baidu.tbadk.core.c.b.d(updateDialog2.getPageContext().getPageActivity(), 200);
        }
    }
}
