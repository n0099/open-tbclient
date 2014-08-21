package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
class cy implements Runnable {
    final /* synthetic */ PersonalChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(PersonalChatActivity personalChatActivity) {
        this.a = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = this.a.n;
        if (dVar != null) {
            dVar2 = this.a.n;
            dVar2.a();
        }
    }
}
