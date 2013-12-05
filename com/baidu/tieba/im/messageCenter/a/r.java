package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.RequestSearchGroupsMessage;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
import com.baidu.tieba.im.message.ResponsedMessage;
/* loaded from: classes.dex */
public class r extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public ResponsedMessage a(Message message) {
        if (message == null || !(message instanceof RequestSearchGroupsMessage)) {
            return null;
        }
        com.baidu.tieba.b.a.a().i();
        ResponseSearchGroupMessage responseSearchGroupMessage = new ResponseSearchGroupMessage();
        responseSearchGroupMessage.setCmd(-203);
        responseSearchGroupMessage.setOrginalMessage(message);
        responseSearchGroupMessage.setErrNo(0);
        return responseSearchGroupMessage;
    }
}
