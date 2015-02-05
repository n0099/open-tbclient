package com.baidu.tieba.im.floatwindow.view;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity baa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.baa = floatingPersonalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.baa.Ke();
    }
}
