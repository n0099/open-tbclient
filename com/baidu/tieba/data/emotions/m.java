package com.baidu.tieba.data.emotions;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m implements Runnable {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.c();
    }
}
