package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements Runnable {
    final /* synthetic */ TalkableActivity bPX;
    private final /* synthetic */ String bPY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(TalkableActivity talkableActivity, String str) {
        this.bPX = talkableActivity;
        this.bPY = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bPX.bPK.sendTextMessage(this.bPY);
    }
}
