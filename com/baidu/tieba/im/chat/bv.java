package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements Runnable {
    final /* synthetic */ TalkableActivity bLV;
    private final /* synthetic */ String bLW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(TalkableActivity talkableActivity, String str) {
        this.bLV = talkableActivity;
        this.bLW = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bLV.mListModel.sendTextMessage(this.bLW);
    }
}
