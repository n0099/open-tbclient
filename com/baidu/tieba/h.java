package com.baidu.tieba;

import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class h extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f1182a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str) {
        this.f1182a = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        DatabaseService.p(this.f1182a);
    }
}
