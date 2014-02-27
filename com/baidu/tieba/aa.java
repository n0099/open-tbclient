package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
final class aa extends Handler {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        boolean z;
        this.a.c = true;
        z = this.a.b;
        if (z) {
            if (!this.a.getDatabasePath("baidu_tieba.db").exists()) {
                TiebaApplication.a(DatabaseService.l(), this.a.getBaseContext());
            }
            LogoActivity logoActivity = this.a;
            this.a.getBaseContext();
            logoActivity.a();
        }
        super.handleMessage(message);
    }
}
