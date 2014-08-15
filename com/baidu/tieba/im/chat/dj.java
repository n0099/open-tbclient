package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dj implements Runnable {
    final /* synthetic */ TalkableActivity a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dj(TalkableActivity talkableActivity, String str) {
        this.a = talkableActivity;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.e.d(this.b);
    }
}
