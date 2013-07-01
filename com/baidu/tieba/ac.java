package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class ac extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f630a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(LogoActivity logoActivity) {
        this.f630a = logoActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        this.f630a.c = true;
        z = this.f630a.b;
        if (z) {
            if (!this.f630a.getDatabasePath("baidu_tieba.db").exists()) {
                TiebaApplication.a(DatabaseService.p());
            }
            this.f630a.d();
        }
        super.handleMessage(message);
    }
}
