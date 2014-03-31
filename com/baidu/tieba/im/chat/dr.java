package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class dr implements Runnable {
    final /* synthetic */ dn a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dr(dn dnVar, String str) {
        this.a = dnVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.e.d(this.b);
    }
}
