package com.baidu.tieba.im.chat;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf extends com.baidu.adp.a.g {
    final /* synthetic */ ba a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(ba baVar) {
        this.a = baVar;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        bs bsVar;
        MsglistModel msglistModel;
        String str;
        bs bsVar2;
        MsglistModel msglistModel2;
        String str2;
        Context context;
        String str3;
        bs bsVar3;
        String str4;
        String str5;
        bs bsVar4;
        MsglistModel msglistModel3;
        String str6;
        bs bsVar5;
        MsglistModel msglistModel4;
        String str7;
        bs bsVar6;
        MsglistModel msglistModel5;
        String str8;
        bs bsVar7;
        MsglistModel msglistModel6;
        String str9;
        bs bsVar8;
        MsglistModel msglistModel7;
        String str10;
        bs bsVar9;
        MsglistModel msglistModel8;
        String str11;
        bs bsVar10;
        MsglistModel msglistModel9;
        String str12;
        bs bsVar11;
        bs bsVar12;
        MsglistModel msglistModel10;
        bs bsVar13;
        if (UtilHelper.g(this.a) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            bsVar13 = this.a.g;
            bsVar13.p();
        } else {
            bsVar = this.a.g;
            bsVar.q();
        }
        msglistModel = this.a.h;
        switch (msglistModel.getLoadDataMode()) {
            case 1:
                str12 = ba.a;
                com.baidu.adp.lib.h.e.e(str12, "callback", "MODE_TYPE_GET_MSGS");
                bsVar11 = this.a.g;
                bsVar11.o();
                bsVar12 = this.a.g;
                msglistModel10 = this.a.h;
                bsVar12.b(msglistModel10.c());
                return;
            case 2:
                str8 = ba.a;
                com.baidu.adp.lib.h.e.e(str8, "callback", "MODE_TYPE_PRE");
                bsVar7 = this.a.g;
                msglistModel6 = this.a.h;
                bsVar7.c(msglistModel6.c());
                return;
            case 3:
                str11 = ba.a;
                com.baidu.adp.lib.h.e.e(str11, "callback", "MODE_TYPE_PUSH");
                bsVar10 = this.a.g;
                msglistModel9 = this.a.h;
                bsVar10.d(msglistModel9.c());
                return;
            case 4:
                str10 = ba.a;
                com.baidu.adp.lib.h.e.e(str10, "callback", "MODE_TYPE_SENDING");
                bsVar9 = this.a.g;
                msglistModel8 = this.a.h;
                bsVar9.b(msglistModel8.c());
                return;
            case 5:
                str9 = ba.a;
                com.baidu.adp.lib.h.e.e(str9, "callback", "MODE_TYPE_SEND");
                bsVar8 = this.a.g;
                msglistModel7 = this.a.h;
                bsVar8.a(msglistModel7.c());
                return;
            case 6:
                str7 = ba.a;
                com.baidu.adp.lib.h.e.e(str7, "callback", "MODE_TYPE_RESEND");
                bsVar6 = this.a.g;
                msglistModel5 = this.a.h;
                bsVar6.a(msglistModel5.c());
                return;
            case 7:
                str6 = ba.a;
                com.baidu.adp.lib.h.e.e(str6, "callback", "MODE_TYPE_DELETE_MSG");
                bsVar5 = this.a.g;
                msglistModel4 = this.a.h;
                bsVar5.a(msglistModel4.c());
                return;
            case 8:
                str5 = ba.a;
                com.baidu.adp.lib.h.e.e(str5, "callback", "MODE_TYPE_LOAD_DRAFT");
                if (obj != null && (obj instanceof String)) {
                    String str13 = (String) obj;
                    bsVar4 = this.a.g;
                    bsVar4.c(str13);
                    msglistModel3 = this.a.h;
                    msglistModel3.a(str13);
                    return;
                }
                return;
            case 9:
                str4 = ba.a;
                com.baidu.adp.lib.h.e.e(str4, "callback", "MODE_TYPE_QUIT_GROUP");
                this.a.A();
                return;
            case 10:
                str3 = ba.a;
                com.baidu.adp.lib.h.e.e(str3, "callback", "MODE_TYPE_NAME_UPDATE");
                if (obj != null && (obj instanceof String)) {
                    bsVar3 = this.a.g;
                    bsVar3.a((String) obj, true);
                    return;
                }
                return;
            case 11:
                str2 = ba.a;
                com.baidu.adp.lib.h.e.e(str2, "callback", "MODE_TYPE_UNLOGIN");
                context = this.a.m;
                LoginActivity.a(context, TiebaApplication.G());
                this.a.finish();
                return;
            case 12:
                str = ba.a;
                com.baidu.adp.lib.h.e.e(str, "callback", "MODE_TYPE_CLEAR_HISTORY");
                bsVar2 = this.a.g;
                msglistModel2 = this.a.h;
                bsVar2.b(msglistModel2.c());
                return;
            default:
                return;
        }
    }
}
