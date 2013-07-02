package com.baidu.tieba;

import android.os.Handler;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class ag extends Thread {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            TiebaApplication tiebaApplication = (TiebaApplication) this.a.getApplication();
            tiebaApplication.d(tiebaApplication.I() + 1);
            if (tiebaApplication.N()) {
                DatabaseService.z();
                tiebaApplication.d(0);
            }
            DatabaseService.v();
            DatabaseService.y();
            this.a.a(this.a.getCacheDir());
        } catch (Exception e) {
        }
        handler = this.a.k;
        handler2 = this.a.k;
        handler.sendMessage(handler2.obtainMessage());
    }
}
