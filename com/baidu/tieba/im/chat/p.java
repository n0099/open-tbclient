package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ o aNQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.aNQ = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        AbsMsglistView absMsglistView;
        absMsglistView = this.aNQ.aNP;
        absMsglistView.sendmsgShowSoftkey();
    }
}
