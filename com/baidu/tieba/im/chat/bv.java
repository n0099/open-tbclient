package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements Runnable {
    final /* synthetic */ TalkableActivity bsE;
    private final /* synthetic */ String bsF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(TalkableActivity talkableActivity, String str) {
        this.bsE = talkableActivity;
        this.bsF = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bsE.mListModel.sendTextMessage(this.bsF);
    }
}
