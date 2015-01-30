package com.baidu.tieba.im.floatwindow.view;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity bab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.bab = floatingPersonalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.bab.Kj();
    }
}
