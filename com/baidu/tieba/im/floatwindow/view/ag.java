package com.baidu.tieba.im.floatwindow.view;
/* loaded from: classes.dex */
class ag implements Runnable {
    final /* synthetic */ FloatingPersonalChatView baq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(FloatingPersonalChatView floatingPersonalChatView) {
        this.baq = floatingPersonalChatView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.im.floatwindow.b.No().cK(false);
        this.baq.Og();
    }
}
