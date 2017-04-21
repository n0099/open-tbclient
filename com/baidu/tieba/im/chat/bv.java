package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements Runnable {
    final /* synthetic */ TalkableActivity cQY;
    private final /* synthetic */ String cQZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(TalkableActivity talkableActivity, String str) {
        this.cQY = talkableActivity;
        this.cQZ = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cQY.cQL.sendTextMessage(this.cQZ);
    }
}
