package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dh implements Runnable {
    final /* synthetic */ dd a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dh(dd ddVar, String str) {
        this.a = ddVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.e.d(this.b);
    }
}
