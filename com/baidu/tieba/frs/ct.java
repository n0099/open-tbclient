package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class ct implements Runnable {
    final /* synthetic */ cs bWl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cs csVar) {
        this.bWl = csVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bWl.hideTip();
    }
}
