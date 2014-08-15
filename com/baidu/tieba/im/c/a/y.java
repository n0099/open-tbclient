package com.baidu.tieba.im.c.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.message.RequestSearchGroupsLocalMessage;
import com.baidu.tieba.im.message.ResponseSearchGroupLocalMessage;
import java.util.List;
/* loaded from: classes.dex */
public class y implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestSearchGroupsLocalMessage)) {
            return null;
        }
        List<com.baidu.adp.lib.cache.v<String>> a = com.baidu.adp.lib.util.o.a(com.baidu.tbadk.core.a.a.a().b("tb.im_group_search_history"));
        ResponseSearchGroupLocalMessage responseSearchGroupLocalMessage = new ResponseSearchGroupLocalMessage();
        responseSearchGroupLocalMessage.setCacheList(a);
        return responseSearchGroupLocalMessage;
    }
}
