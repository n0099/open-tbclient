package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.ca;
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public com.baidu.tieba.im.message.s a(com.baidu.tieba.im.message.s sVar, com.baidu.tieba.im.coder.d dVar) {
        if (sVar != null && (sVar instanceof ca)) {
            ca caVar = (ca) sVar;
            if (caVar.b() != null && !caVar.l()) {
                String str = "";
                if (TiebaApplication.E() != null) {
                    str = TiebaApplication.E().getID();
                }
                n.a(com.baidu.tieba.c.a.a().q(), "group_info" + str + caVar.b().getGroupId(), dVar);
            }
        }
        return null;
    }
}
