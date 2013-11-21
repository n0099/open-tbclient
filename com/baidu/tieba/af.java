package com.baidu.tieba;

import android.os.Handler;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class af extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f1102a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(LogoActivity logoActivity) {
        this.f1102a = logoActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            TiebaApplication tiebaApplication = (TiebaApplication) this.f1102a.getApplication();
            tiebaApplication.a(tiebaApplication.G() + 1);
            if (tiebaApplication.L()) {
                DatabaseService.x();
                tiebaApplication.a(0);
            }
            DatabaseService.t();
            DatabaseService.w();
            this.f1102a.a(this.f1102a.getCacheDir());
        } catch (Exception e) {
        }
        handler = this.f1102a.i;
        handler2 = this.f1102a.i;
        handler.sendMessage(handler2.obtainMessage());
    }
}
