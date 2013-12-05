package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.data.BaseGroupData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.RequestSearchGroupsMessage;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class u extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public Message a(Message message, com.baidu.tieba.im.b.p pVar) {
        if (message == null || !(message instanceof ResponseSearchGroupMessage)) {
            return null;
        }
        ResponseSearchGroupMessage responseSearchGroupMessage = (ResponseSearchGroupMessage) message;
        Message orginalMessage = responseSearchGroupMessage.getOrginalMessage();
        if (orginalMessage != null && (orginalMessage instanceof RequestSearchGroupsMessage) && !responseSearchGroupMessage.hasError()) {
            String str = ((RequestSearchGroupsMessage) orginalMessage).getGroupId() + "";
            com.baidu.adp.lib.cache.s<String> h = com.baidu.tieba.b.a.a().h();
            List<BaseGroupData> searchResult = responseSearchGroupMessage.getSearchResult();
            if (searchResult != null) {
                Iterator<BaseGroupData> it = searchResult.iterator();
                while (it.hasNext()) {
                    h.a(str, it.next().getName() + "(" + str + ")");
                }
                return message;
            }
            return message;
        }
        return message;
    }
}
