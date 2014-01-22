package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.br;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public com.baidu.tieba.im.message.q a(com.baidu.tieba.im.message.q qVar, com.baidu.tieba.im.coder.d dVar) {
        if (qVar != null && (qVar instanceof br)) {
            br brVar = (br) qVar;
            if (brVar.a() != null && !brVar.k()) {
                String str = "";
                if (TiebaApplication.E() != null) {
                    str = TiebaApplication.E().getID();
                }
                l.a(com.baidu.tieba.b.a.a().q(), "group_info" + str + brVar.a().getGroupId(), dVar);
            }
        }
        return null;
    }
}
