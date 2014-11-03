package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ s aNR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.aNR = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        AbsMsglistView absMsglistView;
        absMsglistView = this.aNR.aNP;
        absMsglistView.sendmsgShowMore();
    }
}
