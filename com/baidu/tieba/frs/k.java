package com.baidu.tieba.frs;

import com.baidu.tieba.util.NetWorkCore;
/* loaded from: classes.dex */
class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1355a;
    final /* synthetic */ j b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, String str) {
        this.b = jVar;
        this.f1355a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        NetWorkCore netWorkCore = new NetWorkCore(new com.baidu.tieba.util.az());
        netWorkCore.b(this.f1355a);
        netWorkCore.w();
    }
}
