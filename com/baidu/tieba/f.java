package com.baidu.tieba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ LogoActivity aDw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LogoActivity logoActivity) {
        this.aDw = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aDw.FE();
    }
}
