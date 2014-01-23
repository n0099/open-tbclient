package com.baidu.tieba;

import android.content.Intent;
import android.location.Address;
import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.AccountData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ay implements Handler.Callback {
    final /* synthetic */ TiebaApplication a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(TiebaApplication tiebaApplication) {
        this.a = tiebaApplication;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        long j;
        switch (message.what) {
            case 1:
                com.baidu.adp.lib.g.e.b("TiebaApplication", "handleMessage", "Do Aoto Login" + String.valueOf(message.what));
                if (TiebaApplication.n()) {
                    TiebaApplication.a((AccountData) null, this.a.getBaseContext());
                    MainTabActivity.b(this.a, -1, true);
                    break;
                } else {
                    TiebaApplication.a((AccountData) null, this.a.getBaseContext());
                    Intent intent = new Intent(TiebaApplication.h(), LoginActivity.class);
                    String string = message.getData().getString("account");
                    if (string == null) {
                        string = "";
                    }
                    intent.putExtra("account", string);
                    intent.putExtra("has_exit_dialog", false);
                    intent.setFlags(268435456);
                    TiebaApplication.h().startActivity(intent);
                    break;
                }
            case 2:
                com.baidu.tieba.mention.s.a().j();
                break;
            case 3:
                com.baidu.tieba.mention.s.a().l();
                break;
            case 4:
                long nanoTime = System.nanoTime();
                j = this.a.q;
                long j2 = (((nanoTime - j) / 1000000) - 60000) / 1000;
                if (j2 > 0) {
                    new com.baidu.tieba.account.av("use", String.valueOf(j2)).start();
                }
                this.a.q = 0L;
                break;
            case 5:
                this.a.aN();
                String str = "";
                switch (this.a.C) {
                    case 1:
                        str = this.a.getString(R.string.loc_gps_off);
                        break;
                    case 2:
                        str = this.a.getString(R.string.loc_net_off);
                        break;
                    case 3:
                        str = this.a.getString(R.string.loc_gps_net_off);
                        break;
                    case 4:
                        str = this.a.getString(R.string.loc_out_of_time);
                        break;
                }
                this.a.a(this.a.C, str, (Address) null);
                break;
            case 6:
                if (Boolean.TRUE.equals(message.obj)) {
                    this.a.aB();
                    break;
                } else {
                    this.a.aC();
                    break;
                }
        }
        return false;
    }
}
