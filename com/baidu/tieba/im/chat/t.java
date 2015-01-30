package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ AbsMsglistView aRm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(AbsMsglistView absMsglistView) {
        this.aRm = absMsglistView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aRm.sendmsgShowSoftkey();
    }
}
