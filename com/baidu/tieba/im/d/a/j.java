package com.baidu.tieba.im.d.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.message.RequestFrsGroupsLocalMessage;
import com.baidu.tieba.im.message.ResponseFrsGroupsLocalMessage;
/* loaded from: classes.dex */
public class j implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestFrsGroupsLocalMessage)) {
            return null;
        }
        RequestFrsGroupsLocalMessage requestFrsGroupsLocalMessage = (RequestFrsGroupsLocalMessage) customMessage;
        byte[] a = com.baidu.tbadk.core.a.b.a().h().a("pb_" + requestFrsGroupsLocalMessage.getType() + "_" + requestFrsGroupsLocalMessage.getForumId());
        ResponseFrsGroupsLocalMessage responseFrsGroupsLocalMessage = new ResponseFrsGroupsLocalMessage();
        try {
            responseFrsGroupsLocalMessage.decodeInBackGround(2001201, a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseFrsGroupsLocalMessage;
    }
}
