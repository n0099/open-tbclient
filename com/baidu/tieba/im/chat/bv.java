package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements Runnable {
    final /* synthetic */ TalkableActivity cap;
    private final /* synthetic */ String caq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(TalkableActivity talkableActivity, String str) {
        this.cap = talkableActivity;
        this.caq = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cap.cac.sendTextMessage(this.caq);
    }
}
