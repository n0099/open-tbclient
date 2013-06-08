package com.baidu.tieba;

import android.content.Intent;
import android.location.Address;
import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.account.LoginActivity;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class aj implements Handler.Callback {
    final /* synthetic */ TiebaApplication a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(TiebaApplication tiebaApplication) {
        this.a = tiebaApplication;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        long j;
        int i;
        int i2;
        switch (message.what) {
            case 1:
                com.baidu.tieba.d.ae.b("TiebaApplication", "handleMessage", "Do Aoto Login" + String.valueOf(message.what));
                if (TiebaApplication.i()) {
                    TiebaApplication.a((com.baidu.tieba.a.a) null);
                    MainTabActivity.b(this.a, null, true);
                    break;
                } else {
                    Intent intent = new Intent(TiebaApplication.d(), LoginActivity.class);
                    String string = message.getData().getString("account");
                    if (string == null) {
                        string = "";
                    }
                    intent.putExtra("account", string);
                    intent.putExtra("has_exit_dialog", false);
                    intent.setFlags(268435456);
                    TiebaApplication.d().startActivity(intent);
                    break;
                }
            case 2:
                this.a.Z();
                break;
            case 3:
                this.a.aa();
                break;
            case 4:
                long nanoTime = System.nanoTime();
                j = this.a.r;
                long j2 = (((nanoTime - j) / 1000000) - 60000) / 1000;
                if (j2 > 0) {
                    new com.baidu.tieba.account.af("use", String.valueOf(j2)).start();
                }
                this.a.r = 0L;
                break;
            case 5:
                this.a.aK();
                String str = "";
                i = this.a.D;
                switch (i) {
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
                TiebaApplication tiebaApplication = this.a;
                i2 = this.a.D;
                tiebaApplication.a(i2, str, (Address) null);
                break;
        }
        return false;
    }
}
