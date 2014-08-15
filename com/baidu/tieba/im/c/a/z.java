package com.baidu.tieba.im.c.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.message.RequestSearchGroupsLocalMessage;
import com.baidu.tieba.im.message.ResponseSearchGroupLocalMessage;
/* loaded from: classes.dex */
public class z implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestSearchGroupsLocalMessage)) {
            return null;
        }
        long groupId = ((RequestSearchGroupsLocalMessage) customMessage).getGroupId();
        ResponseSearchGroupLocalMessage responseSearchGroupLocalMessage = new ResponseSearchGroupLocalMessage(2001213);
        responseSearchGroupLocalMessage.setOrginalMessage(customMessage);
        responseSearchGroupLocalMessage.setError(0);
        responseSearchGroupLocalMessage.setGid(groupId);
        String sb = new StringBuilder(String.valueOf(groupId)).toString();
        com.baidu.adp.lib.cache.t<String> b = com.baidu.tbadk.core.a.a.a().b("tb.im_group_search_history");
        b.a(sb, b.a(sb));
        return responseSearchGroupLocalMessage;
    }
}
