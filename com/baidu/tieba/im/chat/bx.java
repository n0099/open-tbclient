package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class bx implements Runnable {
    final /* synthetic */ PersonalChatActivity aRE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(PersonalChatActivity personalChatActivity) {
        this.aRE = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aRE.JO();
    }
}
