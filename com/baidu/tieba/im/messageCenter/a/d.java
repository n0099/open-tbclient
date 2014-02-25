package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.ar;
import com.baidu.tieba.im.message.da;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public da a(com.baidu.tieba.im.message.s sVar) {
        if (sVar != null && (sVar instanceof ar)) {
            com.baidu.tieba.im.db.b.a().b(((ar) sVar).a());
        }
        return null;
    }
}
