package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.personaltalk.PersonalSettingItemData;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import com.baidu.tieba.im.message.cc;
import com.baidu.tieba.im.message.cd;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public cc a(com.baidu.tieba.im.message.o oVar) {
        if (oVar == null || !(oVar instanceof cd)) {
            com.baidu.adp.lib.h.e.a("message error");
        } else {
            cd cdVar = (cd) oVar;
            String str = "";
            if (TiebaApplication.F() != null) {
                str = TiebaApplication.F().getID();
            }
            if (cdVar.c() == 0) {
                GroupSettingItemData a = com.baidu.tieba.im.groupInfo.u.a(str, cdVar.a());
                if (a != null) {
                    a.setDraft(cdVar.b());
                    com.baidu.tieba.im.groupInfo.u.a(a);
                }
            } else {
                PersonalSettingItemData a2 = com.baidu.tieba.im.chat.personaltalk.a.a(str, cdVar.a());
                if (a2 != null) {
                    a2.setDraft(cdVar.b());
                    com.baidu.tieba.im.chat.personaltalk.a.a(a2);
                }
            }
        }
        return null;
    }
}
