package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.da;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public da a(com.baidu.tieba.im.message.s sVar) {
        if (sVar == null || !(sVar instanceof com.baidu.tieba.im.message.d)) {
            com.baidu.adp.lib.util.f.b("message error");
        } else {
            String a = ((com.baidu.tieba.im.message.d) sVar).a();
            String str = "";
            if (TiebaApplication.E() != null) {
                str = TiebaApplication.E().getID();
            }
            com.baidu.tieba.c.a.a().q().a("group_info" + str + a, null);
        }
        return null;
    }
}
