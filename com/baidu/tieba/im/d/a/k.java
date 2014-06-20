package com.baidu.tieba.im.d.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.RequestHotGroupsByLocalMessage;
import com.baidu.tieba.im.message.ResponseHotGroupsLocalMessage;
/* loaded from: classes.dex */
public class k implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof RequestHotGroupsByLocalMessage)) {
            return a();
        }
        int cmd = ((RequestHotGroupsByLocalMessage) customMessage).getCmd();
        String str = "";
        if (TbadkApplication.getCurrentAccountObj() != null) {
            str = TbadkApplication.getCurrentAccountObj().getID();
        }
        byte[] a = com.baidu.tbadk.core.a.b.a().i().a("p_hot_groups_info" + str);
        ResponseHotGroupsLocalMessage responseHotGroupsLocalMessage = new ResponseHotGroupsLocalMessage();
        if (a != null) {
            try {
                responseHotGroupsLocalMessage.decodeInBackGround(cmd, a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return a();
    }

    private ResponseHotGroupsLocalMessage a() {
        ResponseHotGroupsLocalMessage responseHotGroupsLocalMessage = new ResponseHotGroupsLocalMessage();
        responseHotGroupsLocalMessage.setError(-18);
        return responseHotGroupsLocalMessage;
    }
}
