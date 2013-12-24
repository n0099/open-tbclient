package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.ae;
import com.baidu.tieba.im.message.bz;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public bz a(com.baidu.tieba.im.message.n nVar) {
        if (nVar != null && (nVar instanceof ae)) {
            com.baidu.tieba.im.db.d.a().b(((ae) nVar).a());
        }
        return null;
    }
}
