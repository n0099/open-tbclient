package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements Runnable {
    final /* synthetic */ TalkableActivity cGe;
    private final /* synthetic */ String cGf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(TalkableActivity talkableActivity, String str) {
        this.cGe = talkableActivity;
        this.cGf = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cGe.cFR.sendTextMessage(this.cGf);
    }
}
