package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements Runnable {
    final /* synthetic */ TalkableActivity cYu;
    private final /* synthetic */ String cYv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(TalkableActivity talkableActivity, String str) {
        this.cYu = talkableActivity;
        this.cYv = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cYu.cYh.sendTextMessage(this.cYv);
    }
}
