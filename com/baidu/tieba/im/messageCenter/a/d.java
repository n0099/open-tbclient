package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.al;
import com.baidu.tieba.im.message.cr;
/* loaded from: classes.dex */
public class d extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public cr a(com.baidu.tieba.im.message.q qVar) {
        if (qVar != null && (qVar instanceof al)) {
            com.baidu.tieba.im.db.d.a().b(((al) qVar).a());
        }
        return null;
    }
}
