package com.baidu.tieba;

import android.os.Handler;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class ag extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f689a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(LogoActivity logoActivity) {
        this.f689a = logoActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            TiebaApplication tiebaApplication = (TiebaApplication) this.f689a.getApplication();
            tiebaApplication.d(tiebaApplication.I() + 1);
            if (tiebaApplication.N()) {
                DatabaseService.z();
                tiebaApplication.d(0);
            }
            DatabaseService.v();
            DatabaseService.y();
            this.f689a.a(this.f689a.getCacheDir());
        } catch (Exception e) {
        }
        handler = this.f689a.k;
        handler2 = this.f689a.k;
        handler.sendMessage(handler2.obtainMessage());
    }
}
