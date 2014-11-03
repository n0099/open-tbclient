package com.baidu.tieba.bubble;

import android.app.Activity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    private final /* synthetic */ Activity Fu;
    private final /* synthetic */ boolean ajp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Activity activity, boolean z) {
        this.Fu = activity;
        this.ajp = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        h.a(this.Fu, this.ajp);
    }
}
