package com.baidu.tieba.frs;

import com.baidu.tieba.util.NetWorkCore;
/* loaded from: classes.dex */
class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f1119a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar, String str) {
        this.f1119a = yVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        NetWorkCore netWorkCore = new NetWorkCore(new com.baidu.tieba.util.ad());
        netWorkCore.a(this.b);
        netWorkCore.t();
    }
}
