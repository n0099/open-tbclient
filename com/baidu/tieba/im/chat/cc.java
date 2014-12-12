package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class cc implements Runnable {
    final /* synthetic */ PersonalChatActivity aRE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(PersonalChatActivity personalChatActivity) {
        this.aRE = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.aRE.Ac;
        if (dVar != null) {
            dVar2 = this.aRE.Ac;
            dVar2.dismiss();
        }
    }
}
