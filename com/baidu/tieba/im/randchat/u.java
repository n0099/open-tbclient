package com.baidu.tieba.im.randchat;
/* loaded from: classes.dex */
final class u implements Runnable {
    final /* synthetic */ WaittingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(WaittingActivity waittingActivity) {
        this.a = waittingActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        fVar = this.a.a;
        fVar.a();
    }
}
