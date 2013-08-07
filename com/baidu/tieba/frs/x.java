package com.baidu.tieba.frs;

import com.baidu.tieba.util.NetWorkCore;
/* loaded from: classes.dex */
class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f1098a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, String str) {
        this.f1098a = wVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        new NetWorkCore(this.b).t();
    }
}
