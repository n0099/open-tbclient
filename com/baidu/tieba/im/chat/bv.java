package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements Runnable {
    final /* synthetic */ TalkableActivity caU;
    private final /* synthetic */ String caV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(TalkableActivity talkableActivity, String str) {
        this.caU = talkableActivity;
        this.caV = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.caU.caH.sendTextMessage(this.caV);
    }
}
