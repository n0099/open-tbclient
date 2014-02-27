package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.cc;
/* loaded from: classes.dex */
public class r extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public final com.baidu.tieba.im.message.s a(com.baidu.tieba.im.message.s sVar, com.baidu.tieba.im.coder.d dVar) {
        if (sVar != null && (sVar instanceof cc) && !((cc) sVar).l()) {
            String str = "";
            if (TiebaApplication.y() != null) {
                str = TiebaApplication.y().getID();
            }
            n.a(com.baidu.tieba.c.a.a().s(), "p_group_info" + str, dVar);
        }
        return null;
    }
}
