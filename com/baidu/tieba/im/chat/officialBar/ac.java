package com.baidu.tieba.im.chat.officialBar;
/* loaded from: classes.dex */
final class ac implements Runnable {
    final /* synthetic */ ab a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.a = abVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ai aiVar;
        aiVar = this.a.a.b;
        if (!aiVar.a()) {
            this.a.a.a();
        }
    }
}
