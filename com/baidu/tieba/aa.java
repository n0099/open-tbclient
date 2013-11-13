package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class aa extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f1015a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(LogoActivity logoActivity) {
        this.f1015a = logoActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        this.f1015a.c = true;
        z = this.f1015a.b;
        if (z) {
            if (!this.f1015a.getDatabasePath("baidu_tieba.db").exists()) {
                TiebaApplication.a(DatabaseService.n(), this.f1015a.getBaseContext());
            }
            this.f1015a.a(this.f1015a.getBaseContext());
        }
        super.handleMessage(message);
    }
}
