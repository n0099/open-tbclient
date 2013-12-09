package com.baidu.tieba;

import com.baidu.tieba.util.DatabaseService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1430a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str) {
        this.f1430a = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        DatabaseService.o(this.f1430a);
    }
}
