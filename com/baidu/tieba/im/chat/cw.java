package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cw implements Runnable {
    final /* synthetic */ TalkableActivity aRW;
    private final /* synthetic */ String val$content;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(TalkableActivity talkableActivity, String str) {
        this.aRW = talkableActivity;
        this.val$content = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aRW.mListModel.sendTextMessage(this.val$content);
    }
}
