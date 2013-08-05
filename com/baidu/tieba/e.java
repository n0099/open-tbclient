package com.baidu.tieba;

import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class e extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f1033a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(String str) {
        this.f1033a = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        DatabaseService.r(this.f1033a);
    }
}
