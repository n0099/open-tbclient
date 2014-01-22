package com.baidu.tieba;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements Runnable {
    final /* synthetic */ GuideActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        handler = this.a.n;
        handler.sendEmptyMessage(2);
    }
}
