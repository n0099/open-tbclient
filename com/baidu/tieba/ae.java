package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class ae extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f900a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(LogoActivity logoActivity) {
        this.f900a = logoActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        this.f900a.c = true;
        z = this.f900a.b;
        if (z) {
            if (!this.f900a.getDatabasePath("baidu_tieba.db").exists()) {
                TiebaApplication.a(DatabaseService.p(), this.f900a.getBaseContext());
            }
            this.f900a.a(this.f900a.getBaseContext());
        }
        super.handleMessage(message);
    }
}
