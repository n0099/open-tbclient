package com.baidu.tieba.im.groupUpdates;

import com.baidu.tieba.util.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdatesActivity f1623a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(UpdatesActivity updatesActivity) {
        this.f1623a = updatesActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        n nVar;
        nVar = this.f1623a.b;
        ab.a(nVar.i(), this.f1623a.b(), 0, -1);
    }
}
