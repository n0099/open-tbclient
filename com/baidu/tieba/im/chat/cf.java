package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class cf implements Runnable {
    final /* synthetic */ PersonalChatActivity aSN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(PersonalChatActivity personalChatActivity) {
        this.aSN = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.aSN.Ac;
        if (dVar != null) {
            dVar2 = this.aSN.Ac;
            dVar2.dismiss();
        }
    }
}
