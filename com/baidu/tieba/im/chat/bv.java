package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements Runnable {
    final /* synthetic */ TalkableActivity cQk;
    private final /* synthetic */ String cQl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(TalkableActivity talkableActivity, String str) {
        this.cQk = talkableActivity;
        this.cQl = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cQk.cPX.sendTextMessage(this.cQl);
    }
}
