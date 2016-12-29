package com.baidu.tieba;
/* loaded from: classes.dex */
class ab implements Runnable {
    final /* synthetic */ aa aPf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.aPf = aaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        UpdateDialog updateDialog;
        UpdateDialog updateDialog2;
        updateDialog = this.aPf.this$0;
        if (updateDialog.aPb.forceUpdate()) {
            updateDialog2 = this.aPf.this$0;
            com.baidu.tbadk.core.d.b.f(updateDialog2.getPageContext().getPageActivity(), 200);
        }
    }
}
