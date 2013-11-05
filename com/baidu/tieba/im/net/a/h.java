package com.baidu.tieba.im.net.a;

import com.baidu.tieba.im.codec.m;
import com.baidu.tieba.im.codec.p;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.RequestFrsGroupsMessage;
import com.baidu.tieba.im.message.ResponseFrsGroupsMessage;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public Message a(Message message, p pVar) {
        if (message == null || !(message instanceof ResponseFrsGroupsMessage)) {
            return null;
        }
        ResponseFrsGroupsMessage responseFrsGroupsMessage = (ResponseFrsGroupsMessage) message;
        Message orginalMessage = responseFrsGroupsMessage.getOrginalMessage();
        if (orginalMessage != null && (orginalMessage instanceof RequestFrsGroupsMessage) && !responseFrsGroupsMessage.hasError()) {
            RequestFrsGroupsMessage requestFrsGroupsMessage = (RequestFrsGroupsMessage) orginalMessage;
            m.a(com.baidu.tieba.b.a.a().d(), requestFrsGroupsMessage.getType() + "_" + requestFrsGroupsMessage.getForumId(), pVar);
            return message;
        }
        return message;
    }
}
