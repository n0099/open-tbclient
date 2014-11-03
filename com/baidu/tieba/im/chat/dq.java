package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dq implements Runnable {
    final /* synthetic */ TalkableActivity aQq;
    private final /* synthetic */ String aQr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dq(TalkableActivity talkableActivity, String str) {
        this.aQq = talkableActivity;
        this.aQr = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aQq.aQe.sendTextMessage(this.aQr);
    }
}
