package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements Runnable {
    final /* synthetic */ TalkableActivity cNV;
    private final /* synthetic */ String cNW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(TalkableActivity talkableActivity, String str) {
        this.cNV = talkableActivity;
        this.cNW = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cNV.cNI.sendTextMessage(this.cNW);
    }
}
