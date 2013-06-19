package com.baidu.tieba;

import android.os.Handler;
/* loaded from: classes.dex */
class ad extends Thread {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            TiebaApplication tiebaApplication = (TiebaApplication) this.a.getApplication();
            tiebaApplication.d(tiebaApplication.H() + 1);
            if (tiebaApplication.M()) {
                com.baidu.tieba.d.k.x();
                tiebaApplication.d(0);
            }
            com.baidu.tieba.d.k.t();
            com.baidu.tieba.d.k.w();
            this.a.a(this.a.getCacheDir());
        } catch (Exception e) {
        }
        handler = this.a.k;
        handler2 = this.a.k;
        handler.sendMessage(handler2.obtainMessage());
    }
}
