package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ o aNC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.aNC = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        AbsMsglistView absMsglistView;
        absMsglistView = this.aNC.aNB;
        absMsglistView.sendmsgShowSoftkey();
    }
}
