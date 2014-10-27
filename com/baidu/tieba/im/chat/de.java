package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class de implements Runnable {
    final /* synthetic */ PersonalChatActivity aPI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public de(PersonalChatActivity personalChatActivity) {
        this.aPI = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aPI.Ho();
    }
}
