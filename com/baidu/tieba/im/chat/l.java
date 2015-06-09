package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ AbsMsglistView aZp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(AbsMsglistView absMsglistView) {
        this.aZp = absMsglistView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aZp.sendmsgShowMore();
    }
}
