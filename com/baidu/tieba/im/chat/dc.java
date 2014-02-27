package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class dc implements Runnable {
    final /* synthetic */ cy a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc(cy cyVar, String str) {
        this.a = cyVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.e.c(this.b);
    }
}
