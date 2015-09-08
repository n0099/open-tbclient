package com.baidu.tieba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ LogoActivity aEg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LogoActivity logoActivity) {
        this.aEg = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aEg.FO();
    }
}
