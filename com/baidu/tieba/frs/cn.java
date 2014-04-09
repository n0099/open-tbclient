package com.baidu.tieba.frs;
/* loaded from: classes.dex */
final class cn implements Runnable {
    final /* synthetic */ cm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(cm cmVar) {
        this.a = cmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.c();
    }
}
