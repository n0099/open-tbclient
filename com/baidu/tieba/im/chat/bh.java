package com.baidu.tieba.im.chat;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh extends com.baidu.adp.a.g {
    final /* synthetic */ bc a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bc bcVar) {
        this.a = bcVar;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        bu buVar;
        MsglistModel msglistModel;
        String str;
        bu buVar2;
        MsglistModel msglistModel2;
        String str2;
        Context context;
        String str3;
        bu buVar3;
        String str4;
        String str5;
        bu buVar4;
        MsglistModel msglistModel3;
        String str6;
        bu buVar5;
        MsglistModel msglistModel4;
        String str7;
        bu buVar6;
        MsglistModel msglistModel5;
        String str8;
        bu buVar7;
        MsglistModel msglistModel6;
        String str9;
        bu buVar8;
        MsglistModel msglistModel7;
        String str10;
        bu buVar9;
        MsglistModel msglistModel8;
        String str11;
        bu buVar10;
        MsglistModel msglistModel9;
        String str12;
        bu buVar11;
        bu buVar12;
        MsglistModel msglistModel10;
        bu buVar13;
        if (UtilHelper.g(this.a) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            buVar13 = this.a.g;
            buVar13.p();
        } else {
            buVar = this.a.g;
            buVar.q();
        }
        msglistModel = this.a.h;
        switch (msglistModel.getLoadDataMode()) {
            case 1:
                str12 = bc.a;
                com.baidu.adp.lib.h.e.e(str12, "callback", "MODE_TYPE_GET_MSGS");
                buVar11 = this.a.g;
                buVar11.o();
                buVar12 = this.a.g;
                msglistModel10 = this.a.h;
                buVar12.b(msglistModel10.c());
                return;
            case 2:
                str8 = bc.a;
                com.baidu.adp.lib.h.e.e(str8, "callback", "MODE_TYPE_PRE");
                buVar7 = this.a.g;
                msglistModel6 = this.a.h;
                buVar7.c(msglistModel6.c());
                return;
            case 3:
                str11 = bc.a;
                com.baidu.adp.lib.h.e.e(str11, "callback", "MODE_TYPE_PUSH");
                buVar10 = this.a.g;
                msglistModel9 = this.a.h;
                buVar10.d(msglistModel9.c());
                return;
            case 4:
                str10 = bc.a;
                com.baidu.adp.lib.h.e.e(str10, "callback", "MODE_TYPE_SENDING");
                buVar9 = this.a.g;
                msglistModel8 = this.a.h;
                buVar9.b(msglistModel8.c());
                return;
            case 5:
                str9 = bc.a;
                com.baidu.adp.lib.h.e.e(str9, "callback", "MODE_TYPE_SEND");
                buVar8 = this.a.g;
                msglistModel7 = this.a.h;
                buVar8.a(msglistModel7.c());
                return;
            case 6:
                str7 = bc.a;
                com.baidu.adp.lib.h.e.e(str7, "callback", "MODE_TYPE_RESEND");
                buVar6 = this.a.g;
                msglistModel5 = this.a.h;
                buVar6.a(msglistModel5.c());
                return;
            case 7:
                str6 = bc.a;
                com.baidu.adp.lib.h.e.e(str6, "callback", "MODE_TYPE_DELETE_MSG");
                buVar5 = this.a.g;
                msglistModel4 = this.a.h;
                buVar5.a(msglistModel4.c());
                return;
            case 8:
                str5 = bc.a;
                com.baidu.adp.lib.h.e.e(str5, "callback", "MODE_TYPE_LOAD_DRAFT");
                if (obj != null && (obj instanceof String)) {
                    String str13 = (String) obj;
                    buVar4 = this.a.g;
                    buVar4.c(str13);
                    msglistModel3 = this.a.h;
                    msglistModel3.a(str13);
                    return;
                }
                return;
            case 9:
                str4 = bc.a;
                com.baidu.adp.lib.h.e.e(str4, "callback", "MODE_TYPE_QUIT_GROUP");
                this.a.z();
                return;
            case 10:
                str3 = bc.a;
                com.baidu.adp.lib.h.e.e(str3, "callback", "MODE_TYPE_NAME_UPDATE");
                if (obj != null && (obj instanceof String)) {
                    buVar3 = this.a.g;
                    buVar3.a((String) obj, true);
                    return;
                }
                return;
            case 11:
                str2 = bc.a;
                com.baidu.adp.lib.h.e.e(str2, "callback", "MODE_TYPE_UNLOGIN");
                context = this.a.m;
                LoginActivity.a(context, TiebaApplication.G());
                this.a.finish();
                return;
            case 12:
                str = bc.a;
                com.baidu.adp.lib.h.e.e(str, "callback", "MODE_TYPE_CLEAR_HISTORY");
                buVar2 = this.a.g;
                msglistModel2 = this.a.h;
                buVar2.b(msglistModel2.c());
                return;
            default:
                return;
        }
    }
}
