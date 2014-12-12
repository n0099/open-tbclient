package com.baidu.tieba.im.floatwindow.view;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ FloatingPersonalChatActivity aYF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.aYF = floatingPersonalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aYF.JO();
    }
}
