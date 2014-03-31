package com.baidu.tieba.im.randchat;
/* loaded from: classes.dex */
final class w implements Runnable {
    final /* synthetic */ WaittingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(WaittingActivity waittingActivity) {
        this.a = waittingActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        fVar = this.a.a;
        fVar.a();
    }
}
