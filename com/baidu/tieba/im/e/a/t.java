package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.ResponseNearbyGroupsLocalMessage;
/* loaded from: classes.dex */
public class t implements com.baidu.adp.framework.task.a<Object> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<Object> aVar) {
        if (aVar == null || !(aVar instanceof com.baidu.tieba.im.message.d)) {
            return null;
        }
        String str = "";
        if (TbadkApplication.N() != null) {
            str = TbadkApplication.N().getID();
        }
        byte[] a = com.baidu.tbadk.core.c.b.a().s().a("p_nearby_group_info" + str);
        ResponseNearbyGroupsLocalMessage responseNearbyGroupsLocalMessage = new ResponseNearbyGroupsLocalMessage();
        if (a != null) {
            try {
                responseNearbyGroupsLocalMessage.a(a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseNearbyGroupsLocalMessage;
    }
}
