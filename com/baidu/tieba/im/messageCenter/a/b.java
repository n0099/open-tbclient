package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.personaltalk.PersonalSettingItemData;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import com.baidu.tieba.im.message.bz;
import com.baidu.tieba.im.message.ca;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public bz a(com.baidu.tieba.im.message.n nVar) {
        if (nVar == null || !(nVar instanceof ca)) {
            com.baidu.adp.lib.h.e.a("message error");
        } else {
            ca caVar = (ca) nVar;
            String str = "";
            if (TiebaApplication.F() != null) {
                str = TiebaApplication.F().getID();
            }
            if (caVar.c() == 0) {
                GroupSettingItemData a = com.baidu.tieba.im.groupInfo.u.a(str, caVar.a());
                if (a != null) {
                    a.setDraft(caVar.b());
                    com.baidu.tieba.im.groupInfo.u.a(a);
                }
            } else {
                PersonalSettingItemData a2 = com.baidu.tieba.im.chat.personaltalk.a.a(str, caVar.a());
                if (a2 != null) {
                    a2.setDraft(caVar.b());
                    com.baidu.tieba.im.chat.personaltalk.a.a(a2);
                }
            }
        }
        return null;
    }
}
