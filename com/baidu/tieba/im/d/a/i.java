package com.baidu.tieba.im.d.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.RequestGroupInfoLocalMessage;
import com.baidu.tieba.im.message.ResponseGroupInfoLocalMessage;
/* loaded from: classes.dex */
public class i implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestGroupInfoLocalMessage)) {
            return a();
        }
        RequestGroupInfoLocalMessage requestGroupInfoLocalMessage = (RequestGroupInfoLocalMessage) customMessage;
        String str = "";
        if (TbadkApplication.getCurrentAccountObj() != null) {
            str = TbadkApplication.getCurrentAccountObj().getID();
        }
        byte[] a = com.baidu.tbadk.core.a.b.a().t().a("group_info" + str + requestGroupInfoLocalMessage.getGroupId());
        if (a != null) {
            ResponseGroupInfoLocalMessage responseGroupInfoLocalMessage = new ResponseGroupInfoLocalMessage();
            try {
                responseGroupInfoLocalMessage.decodeInBackGround(2001102, a);
                return responseGroupInfoLocalMessage;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return a();
    }

    private CustomResponsedMessage<?> a() {
        ResponseGroupInfoLocalMessage responseGroupInfoLocalMessage = new ResponseGroupInfoLocalMessage();
        responseGroupInfoLocalMessage.setError(-18);
        return responseGroupInfoLocalMessage;
    }
}
