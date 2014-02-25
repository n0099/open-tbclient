package com.baidu.tieba.im.groupUpdates;

import com.baidu.tieba.util.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ UpdatesActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(UpdatesActivity updatesActivity) {
        this.a = updatesActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        q qVar;
        qVar = this.a.b;
        ap.a(qVar.i(), this.a.a(), 0, -1);
    }
}
