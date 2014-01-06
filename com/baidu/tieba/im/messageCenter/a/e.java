package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.cc;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public cc a(com.baidu.tieba.im.message.o oVar) {
        if (oVar == null || !(oVar instanceof com.baidu.tieba.im.message.c)) {
            com.baidu.adp.lib.h.e.a("message error");
        } else {
            String a = ((com.baidu.tieba.im.message.c) oVar).a();
            String str = "";
            if (TiebaApplication.F() != null) {
                str = TiebaApplication.F().getID();
            }
            com.baidu.tieba.b.a.a().q().a("group_info" + str + a, null);
        }
        return null;
    }
}
