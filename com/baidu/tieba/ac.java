package com.baidu.tieba;

import android.os.Handler;
/* loaded from: classes.dex */
class ac extends Thread {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            TiebaApplication tiebaApplication = (TiebaApplication) this.a.getApplication();
            tiebaApplication.b(tiebaApplication.D() + 1);
            if (tiebaApplication.I()) {
                com.baidu.tieba.c.k.y();
                tiebaApplication.b(0);
            }
            com.baidu.tieba.c.k.u();
            com.baidu.tieba.c.k.x();
            this.a.a(this.a.getCacheDir());
        } catch (Exception e) {
        }
        handler = this.a.k;
        handler2 = this.a.k;
        handler.sendMessage(handler2.obtainMessage());
    }
}
