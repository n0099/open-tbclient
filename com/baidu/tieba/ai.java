package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class ai extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f1115a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(LogoActivity logoActivity) {
        this.f1115a = logoActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        this.f1115a.c = true;
        z = this.f1115a.b;
        if (z) {
            if (!this.f1115a.getDatabasePath("baidu_tieba.db").exists()) {
                TiebaApplication.a(DatabaseService.n(), this.f1115a.getBaseContext());
            }
            this.f1115a.a(this.f1115a.getBaseContext());
        }
        super.handleMessage(message);
    }
}
