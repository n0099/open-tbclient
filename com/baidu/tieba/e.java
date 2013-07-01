package com.baidu.tieba;

import com.baidu.tieba.util.DatabaseService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f807a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(String str) {
        this.f807a = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        DatabaseService.r(this.f807a);
    }
}
