package com.baidu.tieba.im.chat;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class ay extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsglistActivity f1556a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(MsglistActivity msglistActivity) {
        this.f1556a = msglistActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        bm bmVar;
        MsglistModel msglistModel;
        String str;
        bm bmVar2;
        MsglistModel msglistModel2;
        String str2;
        Context context;
        String str3;
        bm bmVar3;
        String str4;
        String str5;
        bm bmVar4;
        MsglistModel msglistModel3;
        String str6;
        bm bmVar5;
        MsglistModel msglistModel4;
        String str7;
        bm bmVar6;
        MsglistModel msglistModel5;
        String str8;
        bm bmVar7;
        MsglistModel msglistModel6;
        String str9;
        bm bmVar8;
        MsglistModel msglistModel7;
        String str10;
        bm bmVar9;
        MsglistModel msglistModel8;
        String str11;
        bm bmVar10;
        MsglistModel msglistModel9;
        String str12;
        bm bmVar11;
        bm bmVar12;
        MsglistModel msglistModel10;
        bm bmVar13;
        if (UtilHelper.g(this.f1556a) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            bmVar13 = this.f1556a.f;
            bmVar13.o();
        } else {
            bmVar = this.f1556a.f;
            bmVar.p();
        }
        msglistModel = this.f1556a.g;
        switch (msglistModel.getLoadDataMode()) {
            case 1:
                str12 = MsglistActivity.e;
                com.baidu.adp.lib.h.e.e(str12, "callback", "MODE_TYPE_GET_MSGS");
                bmVar11 = this.f1556a.f;
                bmVar11.n();
                bmVar12 = this.f1556a.f;
                msglistModel10 = this.f1556a.g;
                bmVar12.b(msglistModel10.b());
                return;
            case 2:
                str8 = MsglistActivity.e;
                com.baidu.adp.lib.h.e.e(str8, "callback", "MODE_TYPE_PRE");
                bmVar7 = this.f1556a.f;
                msglistModel6 = this.f1556a.g;
                bmVar7.c(msglistModel6.b());
                return;
            case 3:
                str11 = MsglistActivity.e;
                com.baidu.adp.lib.h.e.e(str11, "callback", "MODE_TYPE_PUSH");
                bmVar10 = this.f1556a.f;
                msglistModel9 = this.f1556a.g;
                bmVar10.d(msglistModel9.b());
                return;
            case 4:
                str10 = MsglistActivity.e;
                com.baidu.adp.lib.h.e.e(str10, "callback", "MODE_TYPE_SENDING");
                bmVar9 = this.f1556a.f;
                msglistModel8 = this.f1556a.g;
                bmVar9.b(msglistModel8.b());
                return;
            case 5:
                str9 = MsglistActivity.e;
                com.baidu.adp.lib.h.e.e(str9, "callback", "MODE_TYPE_SEND");
                bmVar8 = this.f1556a.f;
                msglistModel7 = this.f1556a.g;
                bmVar8.a(msglistModel7.b());
                return;
            case 6:
                str7 = MsglistActivity.e;
                com.baidu.adp.lib.h.e.e(str7, "callback", "MODE_TYPE_RESEND");
                bmVar6 = this.f1556a.f;
                msglistModel5 = this.f1556a.g;
                bmVar6.a(msglistModel5.b());
                return;
            case 7:
                str6 = MsglistActivity.e;
                com.baidu.adp.lib.h.e.e(str6, "callback", "MODE_TYPE_DELETE_MSG");
                bmVar5 = this.f1556a.f;
                msglistModel4 = this.f1556a.g;
                bmVar5.a(msglistModel4.b());
                return;
            case 8:
                str5 = MsglistActivity.e;
                com.baidu.adp.lib.h.e.e(str5, "callback", "MODE_TYPE_LOAD_DRAFT");
                if (obj != null && (obj instanceof String)) {
                    String str13 = (String) obj;
                    bmVar4 = this.f1556a.f;
                    bmVar4.c(str13);
                    msglistModel3 = this.f1556a.g;
                    msglistModel3.a(str13);
                    return;
                }
                return;
            case 9:
                str4 = MsglistActivity.e;
                com.baidu.adp.lib.h.e.e(str4, "callback", "MODE_TYPE_QUIT_GROUP");
                this.f1556a.z();
                return;
            case 10:
                str3 = MsglistActivity.e;
                com.baidu.adp.lib.h.e.e(str3, "callback", "MODE_TYPE_NAME_UPDATE");
                if (obj != null && (obj instanceof String)) {
                    bmVar3 = this.f1556a.f;
                    bmVar3.a((String) obj, true);
                    return;
                }
                return;
            case 11:
                str2 = MsglistActivity.e;
                com.baidu.adp.lib.h.e.e(str2, "callback", "MODE_TYPE_UNLOGIN");
                context = this.f1556a.l;
                LoginActivity.a(context, TiebaApplication.G());
                this.f1556a.finish();
                return;
            case 12:
                str = MsglistActivity.e;
                com.baidu.adp.lib.h.e.e(str, "callback", "MODE_TYPE_CLEAR_HISTORY");
                bmVar2 = this.f1556a.f;
                msglistModel2 = this.f1556a.g;
                bmVar2.b(msglistModel2.b());
                return;
            default:
                return;
        }
    }
}
