package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.RequestSearchGroupsMessage;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
import com.baidu.tieba.im.message.ResponsedMessage;
/* loaded from: classes.dex */
public class t extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public ResponsedMessage a(Message message) {
        if (message == null || !(message instanceof RequestSearchGroupsMessage)) {
            return null;
        }
        long groupId = ((RequestSearchGroupsMessage) message).getGroupId();
        ResponseSearchGroupMessage responseSearchGroupMessage = new ResponseSearchGroupMessage();
        responseSearchGroupMessage.setCmd(-204);
        responseSearchGroupMessage.setOrginalMessage(message);
        responseSearchGroupMessage.setErrNo(0);
        responseSearchGroupMessage.setGid(groupId);
        String str = groupId + "";
        com.baidu.adp.lib.cache.s<String> h = com.baidu.tieba.b.a.a().h();
        h.a(str, h.a(str));
        return responseSearchGroupMessage;
    }
}
