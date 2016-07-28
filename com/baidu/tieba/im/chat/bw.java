package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements Runnable {
    final /* synthetic */ TalkableActivity cIT;
    private final /* synthetic */ String cIU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(TalkableActivity talkableActivity, String str) {
        this.cIT = talkableActivity;
        this.cIU = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cIT.cIG.sendTextMessage(this.cIU);
    }
}
