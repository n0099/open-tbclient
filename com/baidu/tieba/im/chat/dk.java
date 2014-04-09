package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class dk extends com.baidu.adp.a.h {
    final /* synthetic */ dj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(dj djVar) {
        this.a = djVar;
    }

    @Override // com.baidu.adp.a.h
    public final void a(Object obj) {
        long j;
        if (UtilHelper.d(this.a) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            if (this.a.d != null) {
                this.a.d.s();
            }
        } else if (this.a.d != null) {
            this.a.d.t();
        }
        switch (this.a.e.getLoadDataMode()) {
            case 1:
                com.baidu.adp.lib.util.f.e("MODE_TYPE_GET_MSGS");
                j = this.a.b;
                if (j > -1) {
                    this.a.b = -1L;
                }
                this.a.d.r();
                this.a.d.b(this.a.e.g());
                return;
            case 2:
                com.baidu.adp.lib.util.f.e("MODE_TYPE_PRE");
                this.a.d.c(this.a.e.g());
                return;
            case 3:
                com.baidu.adp.lib.util.f.e("MODE_TYPE_PUSH");
                this.a.d.d(this.a.e.g());
                return;
            case 4:
                com.baidu.adp.lib.util.f.e("MODE_TYPE_SENDING");
                this.a.d.b(this.a.e.g());
                return;
            case 5:
                com.baidu.adp.lib.util.f.e("MODE_TYPE_SEND");
                this.a.d.a(this.a.e.g());
                return;
            case 6:
                com.baidu.adp.lib.util.f.e("MODE_TYPE_RESEND");
                this.a.d.a(this.a.e.g());
                return;
            case 7:
                com.baidu.adp.lib.util.f.e("MODE_TYPE_DELETE_MSG");
                this.a.d.a(this.a.e.g());
                return;
            case 8:
                com.baidu.adp.lib.util.f.e("MODE_TYPE_LOAD_DRAFT");
                if (obj != null && (obj instanceof String)) {
                    String str = (String) obj;
                    this.a.d.c(str);
                    this.a.e.b(str);
                    return;
                }
                return;
            case 9:
                com.baidu.adp.lib.util.f.e("MODE_TYPE_QUIT_GROUP");
                this.a.finish();
                return;
            case 10:
                com.baidu.adp.lib.util.f.e("MODE_TYPE_NAME_UPDATE");
                if (obj != null && (obj instanceof String)) {
                    this.a.d.a((String) obj);
                    return;
                }
                return;
            case 11:
                com.baidu.adp.lib.util.f.e("MODE_TYPE_UNLOGIN");
                LoginActivity.a(this.a, TbadkApplication.O());
                this.a.finish();
                return;
            case 12:
                com.baidu.adp.lib.util.f.e("MODE_TYPE_CLEAR_HISTORY");
                this.a.d.b(this.a.e.g());
                return;
            case 13:
                com.baidu.adp.lib.util.f.e("MODE_TYPE_CHAT_ROOM_RULE");
                this.a.d.a(this.a.e.g());
                return;
            default:
                return;
        }
    }
}
