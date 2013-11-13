package com.baidu.tieba.im.net.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.codec.m;
import com.baidu.tieba.im.codec.p;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
/* loaded from: classes.dex */
public class j extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public Message a(Message message, p pVar) {
        if (message != null && (message instanceof ResponseGroupsByUidMessage) && !((ResponseGroupsByUidMessage) message).hasError()) {
            String str = "";
            if (TiebaApplication.E() != null) {
                str = TiebaApplication.E().getID();
            }
            m.a(com.baidu.tieba.b.a.a().o(), "group_info" + str, pVar);
        }
        return null;
    }
}
