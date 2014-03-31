package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.ResponseHotGroupsLocalMessage;
import com.baidu.tieba.im.message.am;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.framework.task.a<Object> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<Object> aVar) {
        if (aVar == null || !(aVar instanceof am)) {
            return a();
        }
        ((am) aVar).e();
        String str = "";
        if (TbadkApplication.N() != null) {
            str = TbadkApplication.N().getID();
        }
        byte[] a = com.baidu.tbadk.core.c.b.a().f().a("p_hot_groups_info" + str);
        ResponseHotGroupsLocalMessage responseHotGroupsLocalMessage = new ResponseHotGroupsLocalMessage();
        if (a != null) {
            try {
                responseHotGroupsLocalMessage.a(a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return a();
    }

    private static ResponseHotGroupsLocalMessage a() {
        ResponseHotGroupsLocalMessage responseHotGroupsLocalMessage = new ResponseHotGroupsLocalMessage();
        responseHotGroupsLocalMessage.a(-18);
        return responseHotGroupsLocalMessage;
    }
}
