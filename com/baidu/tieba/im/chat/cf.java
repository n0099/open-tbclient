package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class cf implements Runnable {
    final /* synthetic */ PersonalChatActivity aSM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(PersonalChatActivity personalChatActivity) {
        this.aSM = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.aSM.zZ;
        if (dVar != null) {
            dVar2 = this.aSM.zZ;
            dVar2.dismiss();
        }
    }
}
