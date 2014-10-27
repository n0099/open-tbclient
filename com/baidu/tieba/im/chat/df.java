package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class df implements Runnable {
    final /* synthetic */ PersonalChatActivity aPI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(PersonalChatActivity personalChatActivity) {
        this.aPI = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.aPI.aHF;
        if (dVar != null) {
            dVar2 = this.aPI.aHF;
            dVar2.dismiss();
        }
    }
}
