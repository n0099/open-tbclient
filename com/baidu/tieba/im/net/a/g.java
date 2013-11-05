package com.baidu.tieba.im.net.a;

import com.baidu.tieba.im.codec.m;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.RequestFrsGroupsMessage;
import com.baidu.tieba.im.message.ResponseFrsGroupsMessage;
import com.baidu.tieba.im.message.ResponsedMessage;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public ResponsedMessage b(Message message) {
        if (message == null || !(message instanceof RequestFrsGroupsMessage)) {
            return null;
        }
        RequestFrsGroupsMessage requestFrsGroupsMessage = (RequestFrsGroupsMessage) message;
        ResponsedMessage a2 = m.a(com.baidu.tieba.b.a.a().d().a(requestFrsGroupsMessage.getType() + "_" + requestFrsGroupsMessage.getForumId()));
        if (a2 == null) {
            a2 = new ResponseFrsGroupsMessage();
        }
        a2.setCmd(-201);
        a2.setOrginalMessage(message);
        return a2;
    }
}
