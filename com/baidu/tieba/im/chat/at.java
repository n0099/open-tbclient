package com.baidu.tieba.im.chat;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class at extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsglistActivity f1513a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(MsglistActivity msglistActivity) {
        this.f1513a = msglistActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        bg bgVar;
        MsglistModel msglistModel;
        String str;
        Context context;
        String str2;
        bg bgVar2;
        String str3;
        bg bgVar3;
        String str4;
        bg bgVar4;
        MsglistModel msglistModel2;
        String str5;
        bg bgVar5;
        MsglistModel msglistModel3;
        String str6;
        bg bgVar6;
        MsglistModel msglistModel4;
        String str7;
        bg bgVar7;
        MsglistModel msglistModel5;
        String str8;
        bg bgVar8;
        MsglistModel msglistModel6;
        String str9;
        bg bgVar9;
        MsglistModel msglistModel7;
        String str10;
        bg bgVar10;
        MsglistModel msglistModel8;
        String str11;
        bg bgVar11;
        bg bgVar12;
        MsglistModel msglistModel9;
        bg bgVar13;
        if (UtilHelper.i(this.f1513a) == UtilHelper.NetworkStateInfo.UNAVAIL) {
            bgVar13 = this.f1513a.f;
            bgVar13.o();
        } else {
            bgVar = this.f1513a.f;
            bgVar.p();
        }
        msglistModel = this.f1513a.g;
        switch (msglistModel.getLoadDataMode()) {
            case 1:
                str11 = MsglistActivity.e;
                com.baidu.adp.lib.h.d.e(str11, "callback", "MODE_TYPE_GET_MSGS");
                bgVar11 = this.f1513a.f;
                bgVar11.n();
                bgVar12 = this.f1513a.f;
                msglistModel9 = this.f1513a.g;
                bgVar12.b(msglistModel9.b());
                return;
            case 2:
                str7 = MsglistActivity.e;
                com.baidu.adp.lib.h.d.e(str7, "callback", "MODE_TYPE_PRE");
                bgVar7 = this.f1513a.f;
                msglistModel5 = this.f1513a.g;
                bgVar7.c(msglistModel5.b());
                return;
            case 3:
                str10 = MsglistActivity.e;
                com.baidu.adp.lib.h.d.e(str10, "callback", "MODE_TYPE_PUSH");
                bgVar10 = this.f1513a.f;
                msglistModel8 = this.f1513a.g;
                bgVar10.d(msglistModel8.b());
                return;
            case 4:
                str9 = MsglistActivity.e;
                com.baidu.adp.lib.h.d.e(str9, "callback", "MODE_TYPE_SENDING");
                bgVar9 = this.f1513a.f;
                msglistModel7 = this.f1513a.g;
                bgVar9.b(msglistModel7.b());
                return;
            case 5:
                str8 = MsglistActivity.e;
                com.baidu.adp.lib.h.d.e(str8, "callback", "MODE_TYPE_SEND");
                bgVar8 = this.f1513a.f;
                msglistModel6 = this.f1513a.g;
                bgVar8.a(msglistModel6.b());
                return;
            case 6:
                str6 = MsglistActivity.e;
                com.baidu.adp.lib.h.d.e(str6, "callback", "MODE_TYPE_RESEND");
                bgVar6 = this.f1513a.f;
                msglistModel4 = this.f1513a.g;
                bgVar6.a(msglistModel4.b());
                return;
            case 7:
                str5 = MsglistActivity.e;
                com.baidu.adp.lib.h.d.e(str5, "callback", "MODE_TYPE_DELETE_MSG");
                bgVar5 = this.f1513a.f;
                msglistModel3 = this.f1513a.g;
                bgVar5.a(msglistModel3.b());
                return;
            case 8:
                str4 = MsglistActivity.e;
                com.baidu.adp.lib.h.d.e(str4, "callback", "MODE_TYPE_LOAD_DRAFT");
                if (obj != null && (obj instanceof String)) {
                    String str12 = (String) obj;
                    bgVar4 = this.f1513a.f;
                    bgVar4.c(str12);
                    msglistModel2 = this.f1513a.g;
                    msglistModel2.a(str12);
                    return;
                }
                return;
            case 9:
                str3 = MsglistActivity.e;
                com.baidu.adp.lib.h.d.e(str3, "callback", "MODE_TYPE_QUIT_GROUP");
                bgVar3 = this.f1513a.f;
                bgVar3.D();
                return;
            case 10:
                str2 = MsglistActivity.e;
                com.baidu.adp.lib.h.d.e(str2, "callback", "MODE_TYPE_NAME_UPDATE");
                if (obj != null && (obj instanceof String)) {
                    bgVar2 = this.f1513a.f;
                    bgVar2.a((String) obj, true);
                    return;
                }
                return;
            case 11:
                str = MsglistActivity.e;
                com.baidu.adp.lib.h.d.e(str, "callback", "MODE_TYPE_UNLOGIN");
                context = this.f1513a.l;
                LoginActivity.a(context, TiebaApplication.F());
                this.f1513a.finish();
                return;
            default:
                return;
        }
    }
}
