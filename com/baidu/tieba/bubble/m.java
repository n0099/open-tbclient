package com.baidu.tieba.bubble;

import android.app.Activity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    private final /* synthetic */ Activity Ft;
    private final /* synthetic */ boolean ajg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Activity activity, boolean z) {
        this.Ft = activity;
        this.ajg = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        h.a(this.Ft, this.ajg);
    }
}
