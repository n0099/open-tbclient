package com.baidu.tieba.im.net.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.codec.m;
import com.baidu.tieba.im.codec.p;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public Message a(Message message, p pVar) {
        if (message != null && (message instanceof ResponseGroupInfoMessage)) {
            ResponseGroupInfoMessage responseGroupInfoMessage = (ResponseGroupInfoMessage) message;
            if (responseGroupInfoMessage.getGroup() != null && !responseGroupInfoMessage.hasError()) {
                String str = "";
                if (TiebaApplication.E() != null) {
                    str = TiebaApplication.E().getID();
                }
                m.a(com.baidu.tieba.b.a.a().n(), "group_info" + str + responseGroupInfoMessage.getGroup().getGroupId(), pVar);
            }
        }
        return null;
    }
}
