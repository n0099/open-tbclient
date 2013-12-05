package com.baidu.tieba;

import android.os.Handler;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class ak extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f1117a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(LogoActivity logoActivity) {
        this.f1117a = logoActivity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Handler handler;
        Handler handler2;
        super.run();
        try {
            DatabaseService.t();
            DatabaseService.w();
            this.f1117a.a(this.f1117a.getCacheDir());
        } catch (Exception e) {
        }
        handler = this.f1117a.i;
        handler2 = this.f1117a.i;
        handler.sendMessage(handler2.obtainMessage());
    }
}
