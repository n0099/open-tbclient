package com.baidu.tieba.im.groupUpdates;

import com.baidu.tieba.util.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdatesActivity f1710a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(UpdatesActivity updatesActivity) {
        this.f1710a = updatesActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        n nVar;
        nVar = this.f1710a.b;
        ak.a(nVar.i(), this.f1710a.a(), 0, -1);
    }
}
