package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements Runnable {
    final /* synthetic */ TalkableActivity bIo;
    private final /* synthetic */ String bIp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(TalkableActivity talkableActivity, String str) {
        this.bIo = talkableActivity;
        this.bIp = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bIo.mListModel.sendTextMessage(this.bIp);
    }
}
