package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cz extends com.baidu.adp.a.g {
    final /* synthetic */ cy a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(cy cyVar) {
        this.a = cyVar;
    }

    @Override // com.baidu.adp.a.g
    public final void a(Object obj) {
        long j;
        if (UtilHelper.h(this.a) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            if (this.a.d != null) {
                this.a.d.p();
            }
        } else if (this.a.d != null) {
            this.a.d.q();
        }
        switch (this.a.e.getLoadDataMode()) {
            case 1:
                com.baidu.adp.lib.util.e.e("MODE_TYPE_GET_MSGS");
                j = this.a.l;
                if (j > -1) {
                    this.a.l = -1L;
                }
                this.a.d.o();
                this.a.d.b(this.a.e.c());
                return;
            case 2:
                com.baidu.adp.lib.util.e.e("MODE_TYPE_PRE");
                this.a.d.c(this.a.e.c());
                return;
            case 3:
                com.baidu.adp.lib.util.e.e("MODE_TYPE_PUSH");
                this.a.d.d(this.a.e.c());
                return;
            case 4:
                com.baidu.adp.lib.util.e.e("MODE_TYPE_SENDING");
                this.a.d.b(this.a.e.c());
                return;
            case 5:
                com.baidu.adp.lib.util.e.e("MODE_TYPE_SEND");
                this.a.d.a(this.a.e.c());
                return;
            case 6:
                com.baidu.adp.lib.util.e.e("MODE_TYPE_RESEND");
                this.a.d.a(this.a.e.c());
                return;
            case 7:
                com.baidu.adp.lib.util.e.e("MODE_TYPE_DELETE_MSG");
                this.a.d.a(this.a.e.c());
                return;
            case 8:
                com.baidu.adp.lib.util.e.e("MODE_TYPE_LOAD_DRAFT");
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.a.d.c(str);
                    this.a.e.a(str);
                    return;
                }
                return;
            case 9:
                com.baidu.adp.lib.util.e.e("MODE_TYPE_QUIT_GROUP");
                this.a.finish();
                return;
            case 10:
                com.baidu.adp.lib.util.e.e("MODE_TYPE_NAME_UPDATE");
                if (obj != null && (obj instanceof String)) {
                    this.a.d.a((String) obj);
                    return;
                }
                return;
            case 11:
                com.baidu.adp.lib.util.e.e("MODE_TYPE_UNLOGIN");
                LoginActivity.a(this.a, TiebaApplication.z());
                this.a.finish();
                return;
            case 12:
                com.baidu.adp.lib.util.e.e("MODE_TYPE_CLEAR_HISTORY");
                this.a.d.b(this.a.e.c());
                return;
            case 13:
                com.baidu.adp.lib.util.e.e("MODE_TYPE_CHAT_ROOM_RULE");
                this.a.d.a(this.a.e.c());
                return;
            default:
                return;
        }
    }
}
