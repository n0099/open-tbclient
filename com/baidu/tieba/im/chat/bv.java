package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements Runnable {
    final /* synthetic */ TalkableActivity cOH;
    private final /* synthetic */ String cOI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(TalkableActivity talkableActivity, String str) {
        this.cOH = talkableActivity;
        this.cOI = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cOH.cOu.sendTextMessage(this.cOI);
    }
}
