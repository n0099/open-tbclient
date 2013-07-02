package com.baidu.tieba;

import com.baidu.tieba.util.DatabaseService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends Thread {
    private final /* synthetic */ String a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(String str) {
        this.a = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        DatabaseService.r(this.a);
    }
}
