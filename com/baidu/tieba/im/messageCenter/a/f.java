package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.by;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public final com.baidu.tieba.im.message.s a(com.baidu.tieba.im.message.s sVar, com.baidu.tieba.im.coder.d dVar) {
        if (sVar != null && (sVar instanceof by)) {
            by byVar = (by) sVar;
            if (byVar.a() != null && !byVar.l()) {
                String str = "";
                if (TiebaApplication.y() != null) {
                    str = TiebaApplication.y().getID();
                }
                n.a(com.baidu.tieba.c.a.a().r(), "group_activity" + str + byVar.a().getActivityId(), dVar);
            }
        }
        return null;
    }
}
