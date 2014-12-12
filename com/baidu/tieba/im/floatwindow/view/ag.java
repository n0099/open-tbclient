package com.baidu.tieba.im.floatwindow.view;
/* loaded from: classes.dex */
class ag implements Runnable {
    final /* synthetic */ FloatingPersonalChatView aYV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(FloatingPersonalChatView floatingPersonalChatView) {
        this.aYV = floatingPersonalChatView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.im.floatwindow.b.MX().cF(false);
        this.aYV.NP();
    }
}
