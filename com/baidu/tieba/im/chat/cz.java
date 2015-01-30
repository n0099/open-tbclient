package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cz implements Runnable {
    final /* synthetic */ TalkableActivity aTf;
    private final /* synthetic */ String val$content;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(TalkableActivity talkableActivity, String str) {
        this.aTf = talkableActivity;
        this.val$content = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aTf.mListModel.sendTextMessage(this.val$content);
    }
}
