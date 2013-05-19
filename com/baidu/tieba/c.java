package com.baidu.tieba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends Thread {
    private final /* synthetic */ String a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str) {
        this.a = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.d.k.o(this.a);
    }
}
