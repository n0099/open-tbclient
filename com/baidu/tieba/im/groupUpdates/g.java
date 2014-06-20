package com.baidu.tieba.im.groupUpdates;

import com.baidu.tbadk.core.util.ag;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ UpdatesActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(UpdatesActivity updatesActivity) {
        this.a = updatesActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        t tVar;
        tVar = this.a.b;
        ag.a(tVar.f(), this.a.a(), 0, -1);
    }
}
