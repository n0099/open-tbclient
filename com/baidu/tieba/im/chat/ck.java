package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements Runnable {
    final /* synthetic */ TalkableActivity aYd;
    private final /* synthetic */ String val$content;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(TalkableActivity talkableActivity, String str) {
        this.aYd = talkableActivity;
        this.val$content = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aYd.mListModel.sendTextMessage(this.val$content);
    }
}
