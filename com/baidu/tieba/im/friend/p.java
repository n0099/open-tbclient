package com.baidu.tieba.im.friend;
/* loaded from: classes.dex */
final class p implements Runnable {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a.finish();
    }
}
