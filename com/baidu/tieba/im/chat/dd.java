package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class dd implements Runnable {
    final /* synthetic */ PersonalChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(PersonalChatActivity personalChatActivity) {
        this.a = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.w();
    }
}
