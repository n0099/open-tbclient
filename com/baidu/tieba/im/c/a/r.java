package com.baidu.tieba.im.c.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.message.RequestSearchGroupsLocalMessage;
import com.baidu.tieba.im.message.ResponseSearchGroupLocalMessage;
/* loaded from: classes3.dex */
public class r implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestSearchGroupsLocalMessage)) {
            return null;
        }
        long groupId = ((RequestSearchGroupsLocalMessage) customMessage).getGroupId();
        ResponseSearchGroupLocalMessage responseSearchGroupLocalMessage = new ResponseSearchGroupLocalMessage(2001207);
        responseSearchGroupLocalMessage.setOrginalMessage(customMessage);
        responseSearchGroupLocalMessage.setError(0);
        responseSearchGroupLocalMessage.setGid(groupId);
        String str = groupId + "";
        com.baidu.adp.lib.cache.l<String> ey = com.baidu.tbadk.core.c.a.BB().ey("tb.im_group_search_history");
        ey.e(str, ey.get(str));
        return responseSearchGroupLocalMessage;
    }
}
