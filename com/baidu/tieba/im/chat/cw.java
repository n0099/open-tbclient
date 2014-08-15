package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class cw implements Runnable {
    final /* synthetic */ PersonalChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(PersonalChatActivity personalChatActivity) {
        this.a = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.y();
    }
}
