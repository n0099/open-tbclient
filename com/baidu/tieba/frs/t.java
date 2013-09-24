package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1161a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.f1161a = frsActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bd bdVar;
        bdVar = this.f1161a.I;
        bdVar.a();
    }
}
