package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.personaltalk.PersonalSettingItemData;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import com.baidu.tieba.im.message.bz;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public bz a(com.baidu.tieba.im.message.n nVar) {
        String draft;
        com.baidu.tieba.im.message.k kVar = new com.baidu.tieba.im.message.k();
        if (nVar == null || !(nVar instanceof com.baidu.tieba.im.message.j)) {
            com.baidu.adp.lib.h.e.a("message error");
            return a(-103);
        }
        com.baidu.tieba.im.message.j jVar = (com.baidu.tieba.im.message.j) nVar;
        String str = "";
        if (TiebaApplication.F() != null) {
            str = TiebaApplication.F().getID();
        }
        if (jVar.b() == 0) {
            GroupSettingItemData a = com.baidu.tieba.im.groupInfo.u.a(str, jVar.a());
            if (a == null) {
                com.baidu.adp.lib.h.e.a("read DB error");
                return a(jVar.t());
            }
            draft = a.getDraft();
        } else {
            PersonalSettingItemData a2 = com.baidu.tieba.im.chat.personaltalk.a.a(str, jVar.a());
            if (a2 == null) {
                com.baidu.adp.lib.h.e.a("read DB error");
                return a(jVar.t());
            }
            draft = a2.getDraft();
        }
        kVar.a(draft);
        kVar.b(jVar.a());
        return kVar;
    }

    private com.baidu.tieba.im.message.k a(int i) {
        com.baidu.tieba.im.message.k kVar = new com.baidu.tieba.im.message.k();
        kVar.e(i);
        kVar.c(-18);
        return kVar;
    }
}
