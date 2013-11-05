package com.baidu.tieba;

import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
final class h extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1317a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str) {
        this.f1317a = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        DatabaseService.p(this.f1317a);
    }
}
