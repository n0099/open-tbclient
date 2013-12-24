package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.bp;
/* loaded from: classes.dex */
public class r extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public com.baidu.tieba.im.message.n a(com.baidu.tieba.im.message.n nVar, com.baidu.tieba.im.coder.d dVar) {
        if (nVar != null && (nVar instanceof bp) && !((bp) nVar).i()) {
            String str = "";
            if (TiebaApplication.F() != null) {
                str = TiebaApplication.F().getID();
            }
            l.a(com.baidu.tieba.b.a.a().s(), "p_enter_forum_group_info_" + str, dVar);
        }
        return null;
    }
}
