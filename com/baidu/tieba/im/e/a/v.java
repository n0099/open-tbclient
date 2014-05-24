package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.message.GroupsByLocationLocalMessage;
import com.baidu.tieba.im.message.ResponseNearbyGroupsLocalMessage;
/* loaded from: classes.dex */
public class v implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof GroupsByLocationLocalMessage)) {
            return null;
        }
        String str = "";
        if (TbadkApplication.getCurrentAccountObj() != null) {
            str = TbadkApplication.getCurrentAccountObj().getID();
        }
        byte[] a = com.baidu.tbadk.core.a.b.a().v().a("p_nearby_group_info" + str);
        ResponseNearbyGroupsLocalMessage responseNearbyGroupsLocalMessage = new ResponseNearbyGroupsLocalMessage();
        if (a != null) {
            try {
                responseNearbyGroupsLocalMessage.decodeInBackGround(MessageTypes.CMD_REQUEST_GROUP_BY_LOCATION_LOCAL, a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseNearbyGroupsLocalMessage;
    }
}
