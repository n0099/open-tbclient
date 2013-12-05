package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.RequestFrsGroupsMessage;
import com.baidu.tieba.im.message.ResponseFrsGroupsMessage;
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public Message a(Message message, com.baidu.tieba.im.b.p pVar) {
        if (message == null || !(message instanceof ResponseFrsGroupsMessage)) {
            return null;
        }
        ResponseFrsGroupsMessage responseFrsGroupsMessage = (ResponseFrsGroupsMessage) message;
        Message orginalMessage = responseFrsGroupsMessage.getOrginalMessage();
        if (orginalMessage != null && (orginalMessage instanceof RequestFrsGroupsMessage) && !responseFrsGroupsMessage.hasError()) {
            RequestFrsGroupsMessage requestFrsGroupsMessage = (RequestFrsGroupsMessage) orginalMessage;
            com.baidu.tieba.im.b.m.a(com.baidu.tieba.b.a.a().e(), requestFrsGroupsMessage.getType() + "_" + requestFrsGroupsMessage.getForumId(), pVar);
            return message;
        }
        return message;
    }
}
