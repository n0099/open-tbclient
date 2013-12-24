package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.bz;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public bz a(com.baidu.tieba.im.message.n nVar) {
        if (nVar == null || !(nVar instanceof com.baidu.tieba.im.message.c)) {
            com.baidu.adp.lib.h.e.a("message error");
        } else {
            String a = ((com.baidu.tieba.im.message.c) nVar).a();
            String str = "";
            if (TiebaApplication.F() != null) {
                str = TiebaApplication.F().getID();
            }
            com.baidu.tieba.b.a.a().q().a("group_info" + str + a, null);
        }
        return null;
    }
}
