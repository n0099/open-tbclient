package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class ca implements Runnable {
    final /* synthetic */ PersonalChatActivity aSM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(PersonalChatActivity personalChatActivity) {
        this.aSM = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aSM.Ke();
    }
}
