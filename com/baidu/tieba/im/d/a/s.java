package com.baidu.tieba.im.d.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.GroupsByLocationLocalMessage;
import com.baidu.tieba.im.message.ResponseNearbyGroupsLocalMessage;
/* loaded from: classes.dex */
public class s implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof GroupsByLocationLocalMessage)) {
            return null;
        }
        String str = "";
        if (TbadkApplication.getCurrentAccountObj() != null) {
            str = TbadkApplication.getCurrentAccountObj().getID();
        }
        byte[] bArr = com.baidu.tbadk.core.a.a.kS().bc("tb.im_entergroup").get("p_nearby_group_info" + str);
        ResponseNearbyGroupsLocalMessage responseNearbyGroupsLocalMessage = new ResponseNearbyGroupsLocalMessage();
        if (bArr != null) {
            try {
                responseNearbyGroupsLocalMessage.decodeInBackGround(2001115, bArr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseNearbyGroupsLocalMessage;
    }
}
