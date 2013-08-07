package com.baidu.tieba;

import android.content.Intent;
import android.location.Address;
import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.AccountData;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
/* loaded from: classes.dex */
class as implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaApplication f911a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(TiebaApplication tiebaApplication) {
        this.f911a = tiebaApplication;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        long j;
        switch (message.what) {
            case 1:
                com.baidu.tieba.util.aj.b("TiebaApplication", "handleMessage", "Do Aoto Login" + String.valueOf(message.what));
                if (TiebaApplication.n()) {
                    TiebaApplication.a((AccountData) null, this.f911a.getBaseContext());
                    MainTabActivity.b(this.f911a, null, true);
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
                this.f911a.ac();
                break;
            case 3:
                this.f911a.ad();
                break;
            case 4:
                long nanoTime = System.nanoTime();
                j = this.f911a.r;
                long j2 = (((nanoTime - j) / 1000000) - Util.MILLSECONDS_OF_MINUTE) / 1000;
                if (j2 > 0) {
                    new com.baidu.tieba.account.ag("use", String.valueOf(j2)).start();
                }
                this.f911a.r = 0L;
                break;
            case 5:
                this.f911a.aS();
                String str = "";
                switch (this.f911a.D) {
                    case 1:
                        str = this.f911a.getString(R.string.loc_gps_off);
                        break;
                    case 2:
                        str = this.f911a.getString(R.string.loc_net_off);
                        break;
                    case 3:
                        str = this.f911a.getString(R.string.loc_gps_net_off);
                        break;
                    case 4:
                        str = this.f911a.getString(R.string.loc_out_of_time);
                        break;
                }
                this.f911a.a(this.f911a.D, str, (Address) null);
                break;
        }
        return false;
    }
}
