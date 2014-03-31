package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.ResponseGroupsByUidLocalMessage;
/* loaded from: classes.dex */
public class u implements com.baidu.adp.framework.task.a<Object> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<Object> aVar) {
        if (aVar == null || !(aVar instanceof com.baidu.tieba.im.message.e)) {
            return null;
        }
        String str = "";
        if (TbadkApplication.N() != null) {
            str = TbadkApplication.N().getID();
        }
        byte[] a = com.baidu.tbadk.core.c.b.a().s().a("p_group_info" + str);
        ResponseGroupsByUidLocalMessage responseGroupsByUidLocalMessage = new ResponseGroupsByUidLocalMessage();
        if (a != null) {
            try {
                responseGroupsByUidLocalMessage.a(a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseGroupsByUidLocalMessage;
    }
}
