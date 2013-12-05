package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
/* loaded from: classes.dex */
public class o extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public Message a(Message message, com.baidu.tieba.im.b.p pVar) {
        if (message != null && (message instanceof ResponseGroupsByUidMessage) && !((ResponseGroupsByUidMessage) message).hasError()) {
            String str = "";
            if (TiebaApplication.F() != null) {
                str = TiebaApplication.F().getID();
            }
            com.baidu.tieba.im.b.m.a(com.baidu.tieba.b.a.a().r(), "group_info" + str, pVar);
        }
        return null;
    }
}
