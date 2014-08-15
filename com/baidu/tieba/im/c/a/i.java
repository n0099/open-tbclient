package com.baidu.tieba.im.c.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.message.RequestFrsGroupsLocalMessage;
import com.baidu.tieba.im.message.ResponseFrsGroupsLocalMessage;
/* loaded from: classes.dex */
public class i implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestFrsGroupsLocalMessage)) {
            return null;
        }
        RequestFrsGroupsLocalMessage requestFrsGroupsLocalMessage = (RequestFrsGroupsLocalMessage) customMessage;
        byte[] a = com.baidu.tbadk.core.a.a.a().a("tb.im_frsgroup").a("pb_" + requestFrsGroupsLocalMessage.getType() + "_" + requestFrsGroupsLocalMessage.getForumId());
        ResponseFrsGroupsLocalMessage responseFrsGroupsLocalMessage = new ResponseFrsGroupsLocalMessage();
        try {
            responseFrsGroupsLocalMessage.decodeInBackGround(2001210, a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseFrsGroupsLocalMessage;
    }
}
