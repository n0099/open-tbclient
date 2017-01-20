package com.baidu.tieba;
/* loaded from: classes.dex */
class ab implements Runnable {
    final /* synthetic */ aa aOi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.aOi = aaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        UpdateDialog updateDialog;
        UpdateDialog updateDialog2;
        updateDialog = this.aOi.this$0;
        if (updateDialog.aOe.forceUpdate()) {
            updateDialog2 = this.aOi.this$0;
            com.baidu.tbadk.core.e.b.g(updateDialog2.getPageContext().getPageActivity(), 200);
        }
    }
}
