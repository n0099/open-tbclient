package com.baidu.tieba;

import android.os.Handler;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class ai extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f904a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(LogoActivity logoActivity) {
        this.f904a = logoActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            TiebaApplication tiebaApplication = (TiebaApplication) this.f904a.getApplication();
            tiebaApplication.b(tiebaApplication.J() + 1);
            if (tiebaApplication.O()) {
                DatabaseService.z();
                tiebaApplication.b(0);
            }
            DatabaseService.v();
            DatabaseService.y();
            this.f904a.a(this.f904a.getCacheDir());
        } catch (Exception e) {
        }
        handler = this.f904a.k;
        handler2 = this.f904a.k;
        handler.sendMessage(handler2.obtainMessage());
    }
}
