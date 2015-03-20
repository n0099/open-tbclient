package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.cache.v;
import com.baidu.adp.lib.util.z;
import com.baidu.tieba.im.message.RequestSearchGroupsLocalMessage;
import com.baidu.tieba.im.message.ResponseSearchGroupLocalMessage;
import java.util.List;
/* loaded from: classes.dex */
public class q implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestSearchGroupsLocalMessage)) {
            return null;
        }
        List<v<String>> b = z.b(com.baidu.tbadk.core.b.a.rc().bX("tb.im_group_search_history"));
        ResponseSearchGroupLocalMessage responseSearchGroupLocalMessage = new ResponseSearchGroupLocalMessage();
        responseSearchGroupLocalMessage.setCacheList(b);
        return responseSearchGroupLocalMessage;
    }
}
