package com.baidu.tieba;
/* loaded from: classes.dex */
class af implements Runnable {
    final /* synthetic */ ae aUH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar) {
        this.aUH = aeVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        UpdateDialog updateDialog;
        UpdateDialog updateDialog2;
        updateDialog = this.aUH.this$0;
        if (updateDialog.aUD.forceUpdate()) {
            updateDialog2 = this.aUH.this$0;
            com.baidu.tbadk.core.f.b.i(updateDialog2.getPageContext().getPageActivity(), 200);
        }
    }
}
