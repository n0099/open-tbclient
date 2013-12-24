package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.bg;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public com.baidu.tieba.im.message.n a(com.baidu.tieba.im.message.n nVar, com.baidu.tieba.im.coder.d dVar) {
        if (nVar != null && (nVar instanceof bg) && !((bg) nVar).i()) {
            String str = "";
            if (TiebaApplication.F() != null) {
                str = TiebaApplication.F().getID();
            }
            l.a(com.baidu.tieba.b.a.a().r(), "p_group_info" + str, dVar);
        }
        return null;
    }
}
