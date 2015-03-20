package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.cache.t;
import com.baidu.tieba.im.message.RequestSearchGroupsLocalMessage;
import com.baidu.tieba.im.message.ResponseSearchGroupLocalMessage;
/* loaded from: classes.dex */
public class r implements CustomMessageTask.CustomRunnable<Object> {
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
        t<String> bX = com.baidu.tbadk.core.b.a.rc().bX("tb.im_group_search_history");
        bX.f(sb, bX.get(sb));
        return responseSearchGroupLocalMessage;
    }
}
