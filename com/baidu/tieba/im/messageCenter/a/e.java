package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.cr;
/* loaded from: classes.dex */
public class e extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public cr a(com.baidu.tieba.im.message.q qVar) {
        if (qVar == null || !(qVar instanceof com.baidu.tieba.im.message.d)) {
            com.baidu.adp.lib.g.e.a("message error");
        } else {
            String a = ((com.baidu.tieba.im.message.d) qVar).a();
            String str = "";
            if (TiebaApplication.E() != null) {
                str = TiebaApplication.E().getID();
            }
            com.baidu.tieba.b.a.a().q().a("group_info" + str + a, null);
        }
        return null;
    }
}
