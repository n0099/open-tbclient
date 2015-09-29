package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements Runnable {
    final /* synthetic */ TalkableActivity bst;
    private final /* synthetic */ String bsu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(TalkableActivity talkableActivity, String str) {
        this.bst = talkableActivity;
        this.bsu = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bst.mListModel.sendTextMessage(this.bsu);
    }
}
