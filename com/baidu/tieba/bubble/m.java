package com.baidu.tieba.bubble;

import android.app.Activity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    private final /* synthetic */ Activity a;
    private final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Activity activity, boolean z) {
        this.a = activity;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        h.b(this.a, this.b);
    }
}
