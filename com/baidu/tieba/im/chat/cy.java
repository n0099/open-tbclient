package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class cy implements Runnable {
    final /* synthetic */ PersonalChatActivity aPW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(PersonalChatActivity personalChatActivity) {
        this.aPW = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aPW.Jz();
    }
}
