package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dq implements Runnable {
    final /* synthetic */ TalkableActivity aQc;
    private final /* synthetic */ String aQd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dq(TalkableActivity talkableActivity, String str) {
        this.aQc = talkableActivity;
        this.aQd = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aQc.aPQ.sendTextMessage(this.aQd);
    }
}
