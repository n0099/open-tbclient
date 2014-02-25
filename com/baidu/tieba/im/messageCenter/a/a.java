package com.baidu.tieba.im.messageCenter.a;

import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.personaltalk.PersonalSettingItemData;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import com.baidu.tieba.im.message.da;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public da a(com.baidu.tieba.im.message.s sVar) {
        String draft;
        com.baidu.tieba.im.message.p pVar = new com.baidu.tieba.im.message.p();
        if (sVar == null || !(sVar instanceof com.baidu.tieba.im.message.o)) {
            com.baidu.adp.lib.util.f.b("message error");
            return a(SapiErrorCode.INVALID_ARG);
        }
        com.baidu.tieba.im.message.o oVar = (com.baidu.tieba.im.message.o) sVar;
        String str = "";
        if (TiebaApplication.E() != null) {
            str = TiebaApplication.E().getID();
        }
        if (oVar.b() == 0) {
            GroupSettingItemData a = com.baidu.tieba.im.groupInfo.v.a(str, oVar.a());
            if (a == null) {
                com.baidu.adp.lib.util.f.b("read DB error");
                return a(oVar.w());
            }
            draft = a.getDraft();
        } else {
            PersonalSettingItemData a2 = com.baidu.tieba.im.chat.personaltalk.a.a(str, oVar.a());
            if (a2 == null) {
                com.baidu.adp.lib.util.f.b("read DB error");
                return a(oVar.w());
            }
            draft = a2.getDraft();
        }
        pVar.a(draft);
        pVar.b(oVar.a());
        return pVar;
    }

    private com.baidu.tieba.im.message.p a(int i) {
        com.baidu.tieba.im.message.p pVar = new com.baidu.tieba.im.message.p();
        pVar.e(i);
        pVar.g(-18);
        return pVar;
    }
}
