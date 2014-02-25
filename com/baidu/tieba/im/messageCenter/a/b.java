package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.chat.personaltalk.PersonalSettingItemData;
import com.baidu.tieba.im.groupInfo.GroupSettingItemData;
import com.baidu.tieba.im.message.da;
import com.baidu.tieba.im.message.db;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public da a(com.baidu.tieba.im.message.s sVar) {
        if (sVar == null || !(sVar instanceof db)) {
            com.baidu.adp.lib.util.f.b("message error");
        } else {
            db dbVar = (db) sVar;
            String str = "";
            if (TiebaApplication.E() != null) {
                str = TiebaApplication.E().getID();
            }
            if (dbVar.c() == 0) {
                GroupSettingItemData a = com.baidu.tieba.im.groupInfo.v.a(str, dbVar.a());
                if (a != null) {
                    a.setDraft(dbVar.b());
                    com.baidu.tieba.im.groupInfo.v.a(a);
                }
            } else {
                PersonalSettingItemData a2 = com.baidu.tieba.im.chat.personaltalk.a.a(str, dbVar.a());
                if (a2 != null) {
                    a2.setDraft(dbVar.b());
                    com.baidu.tieba.im.chat.personaltalk.a.a(a2);
                }
            }
        }
        return null;
    }
}
