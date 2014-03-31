package com.baidu.tbadk;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.core.b.y;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.ax;
/* loaded from: classes.dex */
final class o implements Handler.Callback {
    final /* synthetic */ TbadkApplication a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TbadkApplication tbadkApplication) {
        this.a = tbadkApplication;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                com.baidu.adp.lib.util.f.b("TiebaApplication", "handleMessage", "Do Aoto Login" + String.valueOf(message.what));
                TbadkApplication.a((AccountData) null, this.a.c());
                String string = message.getData().getString("account");
                if (string == null) {
                    string = "";
                }
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new y((Context) this.a, string, false, true)));
                break;
            case 4:
                long nanoTime = (((System.nanoTime() - this.a.f) / 1000000) - 60000) / 1000;
                if (nanoTime > 0) {
                    new ax("use", String.valueOf(nanoTime)).start();
                }
                this.a.f = 0L;
                break;
            case 5:
                if (Boolean.TRUE.equals(message.obj)) {
                    this.a.r();
                    break;
                } else {
                    this.a.u();
                    break;
                }
        }
        return false;
    }
}
