package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.bh;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public com.baidu.tieba.im.message.o a(com.baidu.tieba.im.message.o oVar, com.baidu.tieba.im.coder.d dVar) {
        if (oVar != null && (oVar instanceof bh)) {
            bh bhVar = (bh) oVar;
            if (bhVar.a() != null && !bhVar.i()) {
                String str = "";
                if (TiebaApplication.F() != null) {
                    str = TiebaApplication.F().getID();
                }
                l.a(com.baidu.tieba.b.a.a().q(), "group_info" + str + bhVar.a().getGroupId(), dVar);
            }
        }
        return null;
    }
}
