package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.personaltalk.PersonalSettingItemData;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import com.baidu.tieba.im.message.cr;
import com.baidu.tieba.im.message.cs;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public cr a(com.baidu.tieba.im.message.q qVar) {
        if (qVar == null || !(qVar instanceof cs)) {
            com.baidu.adp.lib.g.e.a("message error");
        } else {
            cs csVar = (cs) qVar;
            String str = "";
            if (TiebaApplication.E() != null) {
                str = TiebaApplication.E().getID();
            }
            if (csVar.c() == 0) {
                GroupSettingItemData a = com.baidu.tieba.im.groupInfo.u.a(str, csVar.a());
                if (a != null) {
                    a.setDraft(csVar.b());
                    com.baidu.tieba.im.groupInfo.u.a(a);
                }
            } else {
                PersonalSettingItemData a2 = com.baidu.tieba.im.chat.personaltalk.a.a(str, csVar.a());
                if (a2 != null) {
                    a2.setDraft(csVar.b());
                    com.baidu.tieba.im.chat.personaltalk.a.a(a2);
                }
            }
        }
        return null;
    }
}
