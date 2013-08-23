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
class ai implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaApplication f921a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(TiebaApplication tiebaApplication) {
        this.f921a = tiebaApplication;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        long j;
        switch (message.what) {
            case 1:
                com.baidu.tieba.util.aq.b("TiebaApplication", "handleMessage", "Do Aoto Login" + String.valueOf(message.what));
                if (TiebaApplication.p()) {
                    TiebaApplication.a((AccountData) null, this.f921a.getBaseContext());
                    MainTabActivity.b(this.f921a, -1, true);
                    break;
                } else {
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
                com.baidu.tieba.mention.r.a().e();
                break;
            case 3:
                com.baidu.tieba.mention.r.a().f();
                break;
            case 4:
                long nanoTime = System.nanoTime();
                j = this.f921a.q;
                long j2 = (((nanoTime - j) / 1000000) - Util.MILLSECONDS_OF_MINUTE) / 1000;
                if (j2 > 0) {
                    new com.baidu.tieba.account.ag("use", String.valueOf(j2)).start();
                }
                this.f921a.q = 0L;
                break;
            case 5:
                this.f921a.aJ();
                String str = "";
                switch (this.f921a.D) {
                    case 1:
                        str = this.f921a.getString(R.string.loc_gps_off);
                        break;
                    case 2:
                        str = this.f921a.getString(R.string.loc_net_off);
                        break;
                    case 3:
                        str = this.f921a.getString(R.string.loc_gps_net_off);
                        break;
                    case 4:
                        str = this.f921a.getString(R.string.loc_out_of_time);
                        break;
                }
                this.f921a.a(this.f921a.D, str, (Address) null);
                break;
        }
        return false;
    }
}
