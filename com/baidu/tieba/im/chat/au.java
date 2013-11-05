package com.baidu.tieba.im.chat;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class au extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsglistActivity f1421a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(MsglistActivity msglistActivity) {
        this.f1421a = msglistActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        bh bhVar;
        MsglistModel msglistModel;
        String str;
        Context context;
        String str2;
        bh bhVar2;
        String str3;
        bh bhVar3;
        String str4;
        bh bhVar4;
        MsglistModel msglistModel2;
        String str5;
        bh bhVar5;
        MsglistModel msglistModel3;
        String str6;
        bh bhVar6;
        MsglistModel msglistModel4;
        String str7;
        bh bhVar7;
        MsglistModel msglistModel5;
        String str8;
        bh bhVar8;
        MsglistModel msglistModel6;
        String str9;
        bh bhVar9;
        MsglistModel msglistModel7;
        String str10;
        bh bhVar10;
        MsglistModel msglistModel8;
        String str11;
        bh bhVar11;
        bh bhVar12;
        MsglistModel msglistModel9;
        bh bhVar13;
        if (UtilHelper.i(this.f1421a) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            bhVar13 = this.f1421a.f;
            bhVar13.o();
        } else {
            bhVar = this.f1421a.f;
            bhVar.p();
        }
        msglistModel = this.f1421a.g;
        switch (msglistModel.getLoadDataMode()) {
            case 1:
                str11 = MsglistActivity.e;
                com.baidu.adp.lib.h.d.e(str11, "callback", "MODE_TYPE_GET_MSGS");
                bhVar11 = this.f1421a.f;
                bhVar11.n();
                bhVar12 = this.f1421a.f;
                msglistModel9 = this.f1421a.g;
                bhVar12.b(msglistModel9.b());
                return;
            case 2:
                str7 = MsglistActivity.e;
                com.baidu.adp.lib.h.d.e(str7, "callback", "MODE_TYPE_PRE");
                bhVar7 = this.f1421a.f;
                msglistModel5 = this.f1421a.g;
                bhVar7.c(msglistModel5.b());
                return;
            case 3:
                str10 = MsglistActivity.e;
                com.baidu.adp.lib.h.d.e(str10, "callback", "MODE_TYPE_PUSH");
                bhVar10 = this.f1421a.f;
                msglistModel8 = this.f1421a.g;
                bhVar10.d(msglistModel8.b());
                return;
            case 4:
                str9 = MsglistActivity.e;
                com.baidu.adp.lib.h.d.e(str9, "callback", "MODE_TYPE_SENDING");
                bhVar9 = this.f1421a.f;
                msglistModel7 = this.f1421a.g;
                bhVar9.b(msglistModel7.b());
                return;
            case 5:
                str8 = MsglistActivity.e;
                com.baidu.adp.lib.h.d.e(str8, "callback", "MODE_TYPE_SEND");
                bhVar8 = this.f1421a.f;
                msglistModel6 = this.f1421a.g;
                bhVar8.a(msglistModel6.b());
                return;
            case 6:
                str6 = MsglistActivity.e;
                com.baidu.adp.lib.h.d.e(str6, "callback", "MODE_TYPE_RESEND");
                bhVar6 = this.f1421a.f;
                msglistModel4 = this.f1421a.g;
                bhVar6.a(msglistModel4.b());
                return;
            case 7:
                str5 = MsglistActivity.e;
                com.baidu.adp.lib.h.d.e(str5, "callback", "MODE_TYPE_DELETE_MSG");
                bhVar5 = this.f1421a.f;
                msglistModel3 = this.f1421a.g;
                bhVar5.a(msglistModel3.b());
                return;
            case 8:
                str4 = MsglistActivity.e;
                com.baidu.adp.lib.h.d.e(str4, "callback", "MODE_TYPE_LOAD_DRAFT");
                if (obj != null && (obj instanceof String)) {
                    String str12 = (String) obj;
                    bhVar4 = this.f1421a.f;
                    bhVar4.c(str12);
                    msglistModel2 = this.f1421a.g;
                    msglistModel2.a(str12);
                    return;
                }
                return;
            case 9:
                str3 = MsglistActivity.e;
                com.baidu.adp.lib.h.d.e(str3, "callback", "MODE_TYPE_QUIT_GROUP");
                bhVar3 = this.f1421a.f;
                bhVar3.D();
                return;
            case 10:
                str2 = MsglistActivity.e;
                com.baidu.adp.lib.h.d.e(str2, "callback", "MODE_TYPE_NAME_UPDATE");
                if (obj != null && (obj instanceof String)) {
                    bhVar2 = this.f1421a.f;
                    bhVar2.a((String) obj, true);
                    return;
                }
                return;
            case 11:
                str = MsglistActivity.e;
                com.baidu.adp.lib.h.d.e(str, "callback", "MODE_TYPE_UNLOGIN");
                context = this.f1421a.n;
                LoginActivity.a(context, TiebaApplication.H());
                this.f1421a.finish();
                return;
            default:
                return;
        }
    }
}
