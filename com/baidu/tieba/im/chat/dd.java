package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dd implements Runnable {
    final /* synthetic */ cz a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(cz czVar, String str) {
        this.a = czVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.e.c(this.b);
    }
}
