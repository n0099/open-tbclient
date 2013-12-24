package com.baidu.tieba;

import android.os.Handler;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class aj extends Thread {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            DatabaseService.t();
            DatabaseService.w();
            this.a.a(this.a.getCacheDir());
        } catch (Exception e) {
        }
        handler = this.a.i;
        handler2 = this.a.i;
        handler.sendMessage(handler2.obtainMessage());
    }
}
