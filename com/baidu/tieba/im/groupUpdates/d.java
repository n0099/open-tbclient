package com.baidu.tieba.im.groupUpdates;

import com.baidu.tieba.util.an;
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
        n nVar;
        nVar = this.a.b;
        an.a(nVar.i(), this.a.a(), 0, -1);
    }
}
