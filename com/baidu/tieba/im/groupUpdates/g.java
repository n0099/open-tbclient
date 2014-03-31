package com.baidu.tieba.im.groupUpdates;

import com.baidu.tbadk.core.util.ac;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements Runnable {
    final /* synthetic */ UpdatesActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(UpdatesActivity updatesActivity) {
        this.a = updatesActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t tVar;
        tVar = this.a.b;
        ac.a(tVar.g(), this.a.a(), 0, -1);
    }
}
