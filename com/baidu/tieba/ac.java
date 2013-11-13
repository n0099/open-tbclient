package com.baidu.tieba;

import android.os.Handler;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class ac extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f1017a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(LogoActivity logoActivity) {
        this.f1017a = logoActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            TiebaApplication tiebaApplication = (TiebaApplication) this.f1017a.getApplication();
            tiebaApplication.a(tiebaApplication.G() + 1);
            if (tiebaApplication.L()) {
                DatabaseService.x();
                tiebaApplication.a(0);
            }
            DatabaseService.t();
            DatabaseService.w();
            this.f1017a.a(this.f1017a.getCacheDir());
        } catch (Exception e) {
        }
        handler = this.f1017a.i;
        handler2 = this.f1017a.i;
        handler.sendMessage(handler2.obtainMessage());
    }
}
