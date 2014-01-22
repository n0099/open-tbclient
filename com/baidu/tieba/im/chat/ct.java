package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ cp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cp cpVar, String str) {
        this.b = cpVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.e.c(this.a);
    }
}
