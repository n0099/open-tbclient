package com.baidu.tieba;
/* loaded from: classes.dex */
class ad implements Runnable {
    final /* synthetic */ ac aMy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.aMy = acVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        UpdateDialog updateDialog;
        UpdateDialog updateDialog2;
        updateDialog = this.aMy.this$0;
        if (updateDialog.aMu.forceUpdate()) {
            updateDialog2 = this.aMy.this$0;
            com.baidu.tbadk.core.d.b.f(updateDialog2.getPageContext().getPageActivity(), 200);
        }
    }
}
