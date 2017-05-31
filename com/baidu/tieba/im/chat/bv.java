package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements Runnable {
    final /* synthetic */ TalkableActivity cQy;
    private final /* synthetic */ String cQz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(TalkableActivity talkableActivity, String str) {
        this.cQy = talkableActivity;
        this.cQz = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cQy.cQl.sendTextMessage(this.cQz);
    }
}
