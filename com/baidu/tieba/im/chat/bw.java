package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements Runnable {
    final /* synthetic */ TalkableActivity cGN;
    private final /* synthetic */ String cGO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(TalkableActivity talkableActivity, String str) {
        this.cGN = talkableActivity;
        this.cGO = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cGN.cGA.sendTextMessage(this.cGO);
    }
}
