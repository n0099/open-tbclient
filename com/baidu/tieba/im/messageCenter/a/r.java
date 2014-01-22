package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.cc;
/* loaded from: classes.dex */
public class r extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public com.baidu.tieba.im.message.q a(com.baidu.tieba.im.message.q qVar, com.baidu.tieba.im.coder.d dVar) {
        if (qVar != null && (qVar instanceof cc) && !((cc) qVar).k()) {
            l.a(com.baidu.tieba.b.a.a().s(), "p_enter_forum_group_info", dVar);
        }
        return null;
    }
}
