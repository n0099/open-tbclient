package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class ct implements Runnable {
    final /* synthetic */ cs bCv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cs csVar) {
        this.bCv = csVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bCv.hideTip();
    }
}
