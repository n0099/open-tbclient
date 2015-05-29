package com.baidu.tieba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ LogoActivity avg;

    private h(LogoActivity logoActivity) {
        this.avg = logoActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(LogoActivity logoActivity, h hVar) {
        this(logoActivity);
    }

    @Override // java.lang.Runnable
    public void run() {
        LogoActivity.c(this.avg);
    }
}
