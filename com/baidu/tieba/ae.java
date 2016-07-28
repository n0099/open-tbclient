package com.baidu.tieba;
/* loaded from: classes.dex */
class ae implements Runnable {
    final /* synthetic */ ad aJh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.aJh = adVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        UpdateDialog updateDialog;
        UpdateDialog updateDialog2;
        updateDialog = this.aJh.this$0;
        if (updateDialog.aJd.forceUpdate()) {
            updateDialog2 = this.aJh.this$0;
            com.baidu.tbadk.core.d.b.d(updateDialog2.getPageContext().getPageActivity(), 200);
        }
    }
}
