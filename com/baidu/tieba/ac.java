package com.baidu.tieba;

import android.os.Handler;
/* loaded from: classes.dex */
class ac implements Runnable {
    final /* synthetic */ GuideActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        handler = this.a.m;
        handler.sendEmptyMessage(3);
    }
}
