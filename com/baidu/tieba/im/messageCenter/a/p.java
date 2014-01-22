package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.bt;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public com.baidu.tieba.im.message.q a(com.baidu.tieba.im.message.q qVar, com.baidu.tieba.im.coder.d dVar) {
        if (qVar != null && (qVar instanceof bt) && !((bt) qVar).k()) {
            String str = "";
            if (TiebaApplication.E() != null) {
                str = TiebaApplication.E().getID();
            }
            l.a(com.baidu.tieba.b.a.a().r(), "p_group_info" + str, dVar);
        }
        return null;
    }
}
