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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaApplication f698a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(TiebaApplication tiebaApplication) {
        this.f698a = tiebaApplication;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        long j;
        int i;
        int i2;
        switch (message.what) {
            case 1:
                com.baidu.tieba.util.z.b("TiebaApplication", "handleMessage", "Do Aoto Login" + String.valueOf(message.what));
                if (TiebaApplication.n()) {
                    TiebaApplication.a((AccountData) null);
                    MainTabActivity.b(this.f698a, null, true);
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
                this.f698a.ab();
                break;
            case 3:
                this.f698a.ac();
                break;
            case 4:
                long nanoTime = System.nanoTime();
                j = this.f698a.r;
                long j2 = (((nanoTime - j) / 1000000) - 60000) / 1000;
                if (j2 > 0) {
                    new com.baidu.tieba.account.af("use", String.valueOf(j2)).start();
                }
                this.f698a.r = 0L;
                break;
            case 5:
                this.f698a.aO();
                String str = "";
                i = this.f698a.D;
                switch (i) {
                    case 1:
                        str = this.f698a.getString(R.string.loc_gps_off);
                        break;
                    case 2:
                        str = this.f698a.getString(R.string.loc_net_off);
                        break;
                    case 3:
                        str = this.f698a.getString(R.string.loc_gps_net_off);
                        break;
                    case 4:
                        str = this.f698a.getString(R.string.loc_out_of_time);
                        break;
                }
                TiebaApplication tiebaApplication = this.f698a;
                i2 = this.f698a.D;
                tiebaApplication.a(i2, str, (Address) null);
                break;
        }
        return false;
    }
}
