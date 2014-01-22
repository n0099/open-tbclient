package com.baidu.tieba.im.messageCenter.a;

import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.personaltalk.PersonalSettingItemData;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import com.baidu.tieba.im.message.cr;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public cr a(com.baidu.tieba.im.message.q qVar) {
        String draft;
        com.baidu.tieba.im.message.n nVar = new com.baidu.tieba.im.message.n();
        if (qVar == null || !(qVar instanceof com.baidu.tieba.im.message.m)) {
            com.baidu.adp.lib.g.e.a("message error");
            return a(SapiErrorCode.INVALID_ARG);
        }
        com.baidu.tieba.im.message.m mVar = (com.baidu.tieba.im.message.m) qVar;
        String str = "";
        if (TiebaApplication.E() != null) {
            str = TiebaApplication.E().getID();
        }
        if (mVar.b() == 0) {
            GroupSettingItemData a = com.baidu.tieba.im.groupInfo.u.a(str, mVar.a());
            if (a == null) {
                com.baidu.adp.lib.g.e.a("read DB error");
                return a(mVar.w());
            }
            draft = a.getDraft();
        } else {
            PersonalSettingItemData a2 = com.baidu.tieba.im.chat.personaltalk.a.a(str, mVar.a());
            if (a2 == null) {
                com.baidu.adp.lib.g.e.a("read DB error");
                return a(mVar.w());
            }
            draft = a2.getDraft();
        }
        nVar.a(draft);
        nVar.b(mVar.a());
        return nVar;
    }

    private com.baidu.tieba.im.message.n a(int i) {
        com.baidu.tieba.im.message.n nVar = new com.baidu.tieba.im.message.n();
        nVar.e(i);
        nVar.g(-18);
        return nVar;
    }
}
