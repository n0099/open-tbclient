package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements Runnable {
    final /* synthetic */ TalkableActivity cLa;
    private final /* synthetic */ String cLb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(TalkableActivity talkableActivity, String str) {
        this.cLa = talkableActivity;
        this.cLb = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cLa.cKN.sendTextMessage(this.cLb);
    }
}
