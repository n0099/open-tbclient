package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class df implements Runnable {
    final /* synthetic */ PersonalChatActivity aPW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(PersonalChatActivity personalChatActivity) {
        this.aPW = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.aPW.aHP;
        if (dVar != null) {
            dVar2 = this.aPW.aHP;
            dVar2.dismiss();
        }
    }
}
