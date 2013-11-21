package com.baidu.tieba;

import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
final class h extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1376a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str) {
        this.f1376a = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        DatabaseService.q(this.f1376a);
    }
}
