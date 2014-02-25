package com.baidu.tieba;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
class ar implements Handler.Callback {
    final /* synthetic */ TiebaApplication a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(TiebaApplication tiebaApplication) {
        this.a = tiebaApplication;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        long j;
        switch (message.what) {
            case 1:
                com.baidu.adp.lib.util.f.b("TiebaApplication", "handleMessage", "Do Aoto Login" + String.valueOf(message.what));
                TiebaApplication.a((AccountData) null, this.a.c());
                Intent intent = new Intent(TiebaApplication.g().b(), LoginActivity.class);
                String string = message.getData().getString("account");
                if (string == null) {
                    string = "";
                }
                intent.putExtra("account", string);
                intent.putExtra("has_exit_dialog", false);
                intent.setFlags(268435456);
                TiebaApplication.g().b().startActivity(intent);
                break;
            case 2:
                com.baidu.tieba.mention.v.a().j();
                break;
            case 3:
                com.baidu.tieba.mention.v.a().l();
                break;
            case 4:
                long nanoTime = System.nanoTime();
                j = this.a.q;
                long j2 = (((nanoTime - j) / 1000000) - 60000) / 1000;
                if (j2 > 0) {
                    new com.baidu.tieba.account.ax("use", String.valueOf(j2)).start();
                }
                this.a.q = 0L;
                break;
            case 5:
                if (Boolean.TRUE.equals(message.obj)) {
                    this.a.aA();
                    break;
                } else {
                    this.a.aB();
                    break;
                }
        }
        return false;
    }
}
