package com.baidu.tieba.im.chat.snapGroup;
/* loaded from: classes.dex */
final class i implements Runnable {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        this.a.a.finish();
        z = this.a.a.s;
        if (z) {
            this.a.a.showToast(this.a.a.getString(com.baidu.tieba.im.j.snap_group_chat_kick_out_by_silence), false);
        }
    }
}
