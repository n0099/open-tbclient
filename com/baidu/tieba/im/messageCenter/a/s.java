package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.RequestSearchGroupsMessage;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
import com.baidu.tieba.im.message.ResponsedMessage;
import java.util.List;
/* loaded from: classes.dex */
public class s extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public ResponsedMessage a(Message message) {
        if (message == null || !(message instanceof RequestSearchGroupsMessage)) {
            return null;
        }
        List<com.baidu.adp.lib.cache.t<String>> a2 = com.baidu.adp.lib.h.i.a(com.baidu.tieba.b.a.a().h());
        ResponseSearchGroupMessage responseSearchGroupMessage = new ResponseSearchGroupMessage();
        responseSearchGroupMessage.setCmd(-202);
        responseSearchGroupMessage.setOrginalMessage(message);
        responseSearchGroupMessage.setCacheList(a2);
        return responseSearchGroupMessage;
    }
}
