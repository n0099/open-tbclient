package com.baidu.tieba;
/* loaded from: classes.dex */
class ae implements Runnable {
    final /* synthetic */ ad aIq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.aIq = adVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        UpdateDialog updateDialog;
        UpdateDialog updateDialog2;
        updateDialog = this.aIq.this$0;
        if (updateDialog.aIm.forceUpdate()) {
            updateDialog2 = this.aIq.this$0;
            com.baidu.tbadk.core.d.b.d(updateDialog2.getPageContext().getPageActivity(), 200);
        }
    }
}
