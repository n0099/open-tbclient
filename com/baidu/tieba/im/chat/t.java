package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ s aND;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.aND = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        AbsMsglistView absMsglistView;
        absMsglistView = this.aND.aNB;
        absMsglistView.sendmsgShowMore();
    }
}
