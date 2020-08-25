package com.baidu.tieba.im.c.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.GroupsByUidLocalMessage;
import com.baidu.tieba.im.message.ResponseGroupsByUidLocalMessage;
/* loaded from: classes20.dex */
public class p implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof GroupsByUidLocalMessage)) {
            return null;
        }
        String str = "";
        if (TbadkApplication.getCurrentAccountObj() != null) {
            str = TbadkApplication.getCurrentAccountObj().getID();
        }
        byte[] bArr = com.baidu.tbadk.core.c.a.bhb().zw("tb.im_entergroup").get("p_group_info" + str);
        ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = new ResponseGroupsByUidLocalMessage();
        if (bArr != null) {
            try {
                responseGroupsByUidLocalMessage.decodeInBackGround(CmdConfigCustom.CMD_REQUEST_GROUP_BY_UID_LOCAL, bArr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseGroupsByUidLocalMessage;
    }
}
