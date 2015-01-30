package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ AbsMsglistView aRm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(AbsMsglistView absMsglistView) {
        this.aRm = absMsglistView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aRm.sendmsgShowMore();
    }
}
