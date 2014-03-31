package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
final class e extends Handler {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        boolean z;
        this.a.b = true;
        z = this.a.a;
        if (z) {
            if (!this.a.getDatabasePath("baidu_tieba.db").exists()) {
                TbadkApplication.a(com.baidu.tbadk.core.a.o.c(), this.a.getBaseContext());
            }
            LogoActivity logoActivity = this.a;
            this.a.getBaseContext();
            logoActivity.a();
        }
        super.handleMessage(message);
    }
}
