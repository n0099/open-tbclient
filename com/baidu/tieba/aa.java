package com.baidu.tieba;

import android.os.Handler;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class aa extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f1003a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(LogoActivity logoActivity) {
        this.f1003a = logoActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            TiebaApplication tiebaApplication = (TiebaApplication) this.f1003a.getApplication();
            tiebaApplication.b(tiebaApplication.I() + 1);
            if (tiebaApplication.N()) {
                DatabaseService.x();
                tiebaApplication.b(0);
            }
            DatabaseService.t();
            DatabaseService.w();
            this.f1003a.a(this.f1003a.getCacheDir());
        } catch (Exception e) {
        }
        handler = this.f1003a.k;
        handler2 = this.f1003a.k;
        handler.sendMessage(handler2.obtainMessage());
    }
}
