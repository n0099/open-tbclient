package com.baidu.tieba;

import android.content.Intent;
import android.location.Address;
import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.bg;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
/* loaded from: classes.dex */
class as implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaApplication f1106a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(TiebaApplication tiebaApplication) {
        this.f1106a = tiebaApplication;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        long j;
        switch (message.what) {
            case 1:
                bg.b("TiebaApplication", "handleMessage", "Do Aoto Login" + String.valueOf(message.what));
                if (TiebaApplication.n()) {
                    TiebaApplication.a((AccountData) null, this.f1106a.getBaseContext());
                    MainTabActivity.b(this.f1106a, -1, true);
                    break;
                } else {
                    TiebaApplication.a((AccountData) null, this.f1106a.getBaseContext());
                    Intent intent = new Intent(TiebaApplication.g(), LoginActivity.class);
                    String string = message.getData().getString("account");
                    if (string == null) {
                        string = "";
                    }
                    intent.putExtra("account", string);
                    intent.putExtra("has_exit_dialog", false);
                    intent.setFlags(268435456);
                    TiebaApplication.g().startActivity(intent);
                    break;
                }
            case 2:
                com.baidu.tieba.mention.t.a().i();
                break;
            case 3:
                com.baidu.tieba.mention.t.a().k();
                break;
            case 4:
                long nanoTime = System.nanoTime();
                j = this.f1106a.q;
                long j2 = (((nanoTime - j) / 1000000) - Util.MILLSECONDS_OF_MINUTE) / 1000;
                if (j2 > 0) {
                    new com.baidu.tieba.account.ag("use", String.valueOf(j2)).start();
                }
                this.f1106a.q = 0L;
                break;
            case 5:
                this.f1106a.aM();
                String str = "";
                switch (this.f1106a.B) {
                    case 1:
                        str = this.f1106a.getString(R.string.loc_gps_off);
                        break;
                    case 2:
                        str = this.f1106a.getString(R.string.loc_net_off);
                        break;
                    case 3:
                        str = this.f1106a.getString(R.string.loc_gps_net_off);
                        break;
                    case 4:
                        str = this.f1106a.getString(R.string.loc_out_of_time);
                        break;
                }
                this.f1106a.a(this.f1106a.B, str, (Address) null);
                break;
            case 6:
                if (Boolean.TRUE.equals(message.obj)) {
                    this.f1106a.aC();
                    break;
                } else {
                    this.f1106a.aD();
                    break;
                }
        }
        return false;
    }
}
