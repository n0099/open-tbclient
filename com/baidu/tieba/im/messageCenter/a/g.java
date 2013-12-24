package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.be;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public com.baidu.tieba.im.message.n a(com.baidu.tieba.im.message.n nVar, com.baidu.tieba.im.coder.d dVar) {
        if (nVar != null && (nVar instanceof be)) {
            be beVar = (be) nVar;
            if (beVar.a() != null && !beVar.i()) {
                String str = "";
                if (TiebaApplication.F() != null) {
                    str = TiebaApplication.F().getID();
                }
                l.a(com.baidu.tieba.b.a.a().q(), "group_info" + str + beVar.a().getGroupId(), dVar);
            }
        }
        return null;
    }
}
