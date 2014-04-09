package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class dn implements Runnable {
    final /* synthetic */ dj a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(dj djVar, String str) {
        this.a = djVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.e.d(this.b);
    }
}
