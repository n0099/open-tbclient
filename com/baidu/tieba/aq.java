package com.baidu.tieba;

import android.content.Intent;
import android.location.Address;
import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.AccountData;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class aq implements Handler.Callback {
    final /* synthetic */ TiebaApplication a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(TiebaApplication tiebaApplication) {
        this.a = tiebaApplication;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        long j;
        switch (message.what) {
            case 1:
                com.baidu.tieba.util.z.b("TiebaApplication", "handleMessage", "Do Aoto Login" + String.valueOf(message.what));
                if (TiebaApplication.n()) {
                    TiebaApplication.a((AccountData) null);
                    MainTabActivity.b(this.a, null, true);
                    break;
                } else {
                    Intent intent = new Intent(TiebaApplication.f(), LoginActivity.class);
                    String string = message.getData().getString("account");
                    if (string == null) {
                        string = "";
                    }
                    intent.putExtra("account", string);
                    intent.putExtra("has_exit_dialog", false);
                    intent.setFlags(268435456);
                    TiebaApplication.f().startActivity(intent);
                    break;
                }
            case 2:
                this.a.ab();
                break;
            case 3:
                this.a.ac();
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
                this.a.aO();
                String str = "";
                switch (this.a.D) {
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
                this.a.a(this.a.D, str, (Address) null);
                break;
        }
        return false;
    }
}
