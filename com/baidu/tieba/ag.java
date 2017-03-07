package com.baidu.tieba;
/* loaded from: classes.dex */
class ag implements Runnable {
    final /* synthetic */ af aTV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.aTV = afVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        UpdateDialog updateDialog;
        UpdateDialog updateDialog2;
        updateDialog = this.aTV.this$0;
        if (updateDialog.aTR.forceUpdate()) {
            updateDialog2 = this.aTV.this$0;
            com.baidu.tbadk.core.e.b.i(updateDialog2.getPageContext().getPageActivity(), 200);
        }
    }
}
