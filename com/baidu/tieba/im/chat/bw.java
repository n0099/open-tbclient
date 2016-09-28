package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements Runnable {
    final /* synthetic */ TalkableActivity cVS;
    private final /* synthetic */ String cVT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(TalkableActivity talkableActivity, String str) {
        this.cVS = talkableActivity;
        this.cVT = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.cVS.cVF.sendTextMessage(this.cVT);
    }
}
