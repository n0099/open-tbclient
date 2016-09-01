package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements Runnable {
    final /* synthetic */ TalkableActivity cUy;
    private final /* synthetic */ String cUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(TalkableActivity talkableActivity, String str) {
        this.cUy = talkableActivity;
        this.cUz = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cUy.cUl.sendTextMessage(this.cUz);
    }
}
