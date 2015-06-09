package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements Runnable {
    final /* synthetic */ TalkableActivity bbb;
    private final /* synthetic */ String val$content;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(TalkableActivity talkableActivity, String str) {
        this.bbb = talkableActivity;
        this.val$content = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bbb.mListModel.sendTextMessage(this.val$content);
    }
}
