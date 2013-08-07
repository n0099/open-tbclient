package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class ae extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f898a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(LogoActivity logoActivity) {
        this.f898a = logoActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        this.f898a.c = true;
        z = this.f898a.b;
        if (z) {
            if (!this.f898a.getDatabasePath("baidu_tieba.db").exists()) {
                TiebaApplication.a(DatabaseService.p(), this.f898a.getBaseContext());
            }
            this.f898a.a(this.f898a.getBaseContext());
        }
        super.handleMessage(message);
    }
}
