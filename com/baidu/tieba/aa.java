package com.baidu.tieba;

import android.os.Handler;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class aa extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f874a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(LogoActivity logoActivity) {
        this.f874a = logoActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            TiebaApplication tiebaApplication = (TiebaApplication) this.f874a.getApplication();
            tiebaApplication.b(tiebaApplication.H() + 1);
            if (tiebaApplication.M()) {
                DatabaseService.x();
                tiebaApplication.b(0);
            }
            DatabaseService.t();
            DatabaseService.w();
            this.f874a.a(this.f874a.getCacheDir());
        } catch (Exception e) {
        }
        handler = this.f874a.k;
        handler2 = this.f874a.k;
        handler.sendMessage(handler2.obtainMessage());
    }
}
