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
class az implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TiebaApplication f1126a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(TiebaApplication tiebaApplication) {
        this.f1126a = tiebaApplication;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        long j;
        switch (message.what) {
            case 1:
                com.baidu.tieba.util.bd.b("TiebaApplication", "handleMessage", "Do Aoto Login" + String.valueOf(message.what));
                if (TiebaApplication.o()) {
                    TiebaApplication.a((AccountData) null, this.f1126a.getBaseContext());
                    MainTabActivity.b(this.f1126a, -1, true);
                    break;
                } else {
                    TiebaApplication.a((AccountData) null, this.f1126a.getBaseContext());
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
                com.baidu.tieba.mention.t.a().i();
                break;
            case 3:
                com.baidu.tieba.mention.t.a().k();
                break;
            case 4:
                long nanoTime = System.nanoTime();
                j = this.f1126a.r;
                long j2 = (((nanoTime - j) / 1000000) - Util.MILLSECONDS_OF_MINUTE) / 1000;
                if (j2 > 0) {
                    new com.baidu.tieba.account.ai("use", String.valueOf(j2)).start();
                }
                this.f1126a.r = 0L;
                break;
            case 5:
                this.f1126a.aP();
                String str = "";
                switch (this.f1126a.E) {
                    case 1:
                        str = this.f1126a.getString(R.string.loc_gps_off);
                        break;
                    case 2:
                        str = this.f1126a.getString(R.string.loc_net_off);
                        break;
                    case 3:
                        str = this.f1126a.getString(R.string.loc_gps_net_off);
                        break;
                    case 4:
                        str = this.f1126a.getString(R.string.loc_out_of_time);
                        break;
                }
                this.f1126a.a(this.f1126a.E, str, (Address) null);
                break;
            case 6:
                if (Boolean.TRUE.equals(message.obj)) {
                    this.f1126a.aD();
                    break;
                } else {
                    this.f1126a.aE();
                    break;
                }
        }
        return false;
    }
}
