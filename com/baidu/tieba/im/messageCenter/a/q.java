package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseQueryGroupCountMessage;
/* loaded from: classes.dex */
public class q extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public Message a(Message message, com.baidu.tieba.im.b.p pVar) {
        if (message != null && (message instanceof ResponseQueryGroupCountMessage) && !((ResponseQueryGroupCountMessage) message).hasError()) {
            String str = "";
            if (TiebaApplication.F() != null) {
                str = TiebaApplication.F().getID();
            }
            com.baidu.tieba.im.b.m.a(com.baidu.tieba.b.a.a().s(), "enter_forum_group_info_" + str, pVar);
        }
        return null;
    }
}
