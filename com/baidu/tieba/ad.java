package com.baidu.tieba;

import android.os.Handler;
/* loaded from: classes.dex */
class ad implements Runnable {
    final /* synthetic */ GuideActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        handler = this.a.n;
        handler.sendEmptyMessage(3);
    }
}
