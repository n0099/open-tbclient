package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements Runnable {
    final /* synthetic */ TalkableActivity bti;
    private final /* synthetic */ String btj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(TalkableActivity talkableActivity, String str) {
        this.bti = talkableActivity;
        this.btj = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bti.mListModel.sendTextMessage(this.btj);
    }
}
