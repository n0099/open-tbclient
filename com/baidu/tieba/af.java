package com.baidu.tieba;
/* loaded from: classes.dex */
class af implements Runnable {
    final /* synthetic */ ae aTC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar) {
        this.aTC = aeVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        UpdateDialog updateDialog;
        UpdateDialog updateDialog2;
        updateDialog = this.aTC.this$0;
        if (updateDialog.aTy.forceUpdate()) {
            updateDialog2 = this.aTC.this$0;
            com.baidu.tbadk.core.e.b.i(updateDialog2.getPageContext().getPageActivity(), 200);
        }
    }
}
