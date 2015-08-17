package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements Runnable {
    final /* synthetic */ TalkableActivity boV;
    private final /* synthetic */ String val$content;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(TalkableActivity talkableActivity, String str) {
        this.boV = talkableActivity;
        this.val$content = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.boV.mListModel.sendTextMessage(this.val$content);
    }
}
