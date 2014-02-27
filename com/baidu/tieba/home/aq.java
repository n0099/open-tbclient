package com.baidu.tieba.home;
/* loaded from: classes.dex */
final class aq implements Runnable {
    final /* synthetic */ ao a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ao aoVar) {
        this.a = aoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.postDelayed(this, 2000L);
    }
}
