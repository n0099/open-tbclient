package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements Runnable {
    final /* synthetic */ TalkableActivity dbD;
    private final /* synthetic */ String dbE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(TalkableActivity talkableActivity, String str) {
        this.dbD = talkableActivity;
        this.dbE = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.dbD.dbq.sendTextMessage(this.dbE);
    }
}
