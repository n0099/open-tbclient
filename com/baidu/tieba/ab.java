package com.baidu.tieba;
/* loaded from: classes.dex */
class ab implements Runnable {
    final /* synthetic */ aa aNI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.aNI = aaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        UpdateDialog updateDialog;
        UpdateDialog updateDialog2;
        updateDialog = this.aNI.this$0;
        if (updateDialog.aNE.forceUpdate()) {
            updateDialog2 = this.aNI.this$0;
            com.baidu.tbadk.core.d.b.f(updateDialog2.getPageContext().getPageActivity(), 200);
        }
    }
}
