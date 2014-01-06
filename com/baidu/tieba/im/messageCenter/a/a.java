package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.personaltalk.PersonalSettingItemData;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import com.baidu.tieba.im.message.cc;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public cc a(com.baidu.tieba.im.message.o oVar) {
        String draft;
        com.baidu.tieba.im.message.l lVar = new com.baidu.tieba.im.message.l();
        if (oVar == null || !(oVar instanceof com.baidu.tieba.im.message.k)) {
            com.baidu.adp.lib.h.e.a("message error");
            return a(-103);
        }
        com.baidu.tieba.im.message.k kVar = (com.baidu.tieba.im.message.k) oVar;
        String str = "";
        if (TiebaApplication.F() != null) {
            str = TiebaApplication.F().getID();
        }
        if (kVar.b() == 0) {
            GroupSettingItemData a = com.baidu.tieba.im.groupInfo.u.a(str, kVar.a());
            if (a == null) {
                com.baidu.adp.lib.h.e.a("read DB error");
                return a(kVar.u());
            }
            draft = a.getDraft();
        } else {
            PersonalSettingItemData a2 = com.baidu.tieba.im.chat.personaltalk.a.a(str, kVar.a());
            if (a2 == null) {
                com.baidu.adp.lib.h.e.a("read DB error");
                return a(kVar.u());
            }
            draft = a2.getDraft();
        }
        lVar.a(draft);
        lVar.b(kVar.a());
        return lVar;
    }

    private com.baidu.tieba.im.message.l a(int i) {
        com.baidu.tieba.im.message.l lVar = new com.baidu.tieba.im.message.l();
        lVar.e(i);
        lVar.g(-18);
        return lVar;
    }
}
