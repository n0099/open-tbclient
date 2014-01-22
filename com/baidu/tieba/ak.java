package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class ak extends Handler {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        this.a.c = true;
        z = this.a.b;
        if (z) {
            if (!this.a.getDatabasePath("baidu_tieba.db").exists()) {
                TiebaApplication.a(DatabaseService.n(), this.a.getBaseContext());
            }
            this.a.a(this.a.getBaseContext());
        }
        super.handleMessage(message);
    }
}
