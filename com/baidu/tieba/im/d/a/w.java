package com.baidu.tieba.im.d.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.GroupsByUidLocalMessage;
import com.baidu.tieba.im.message.ResponseGroupsByUidLocalMessage;
/* loaded from: classes.dex */
public class w implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof GroupsByUidLocalMessage)) {
            return null;
        }
        String str = "";
        if (TbadkApplication.getCurrentAccountObj() != null) {
            str = TbadkApplication.getCurrentAccountObj().getID();
        }
        byte[] a = com.baidu.tbadk.core.a.b.a().v().a("p_group_info" + str);
        ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = new ResponseGroupsByUidLocalMessage();
        if (a != null) {
            try {
                responseGroupsByUidLocalMessage.decodeInBackGround(2001106, a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseGroupsByUidLocalMessage;
    }
}
