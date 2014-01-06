package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.ah;
import com.baidu.tieba.im.message.cc;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public cc a(com.baidu.tieba.im.message.o oVar) {
        if (oVar != null && (oVar instanceof ah)) {
            com.baidu.tieba.im.db.d.a().b(((ah) oVar).a());
        }
        return null;
    }
}
