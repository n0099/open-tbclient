package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1113a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.f1113a = frsActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        be beVar;
        beVar = this.f1113a.I;
        beVar.a();
    }
}
