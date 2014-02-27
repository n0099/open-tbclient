package com.baidu.tieba;

import android.os.Handler;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
final class ae extends Thread {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            DatabaseService.t();
            this.a.a(this.a.getCacheDir());
        } catch (Exception e) {
        }
        handler = this.a.j;
        handler2 = this.a.j;
        handler.sendMessage(handler2.obtainMessage());
    }
}
