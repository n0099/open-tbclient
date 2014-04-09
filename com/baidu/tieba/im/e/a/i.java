package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.ResponseGroupInfoLocalMessage;
import com.baidu.tieba.im.message.aj;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.framework.task.a<Object> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<Object> aVar) {
        if (aVar == null || !(aVar instanceof aj)) {
            return a();
        }
        aj ajVar = (aj) aVar;
        String str = "";
        if (TbadkApplication.N() != null) {
            str = TbadkApplication.N().getID();
        }
        byte[] a = com.baidu.tbadk.core.c.b.a().q().a("group_info" + str + ajVar.b());
        if (a != null) {
            ResponseGroupInfoLocalMessage responseGroupInfoLocalMessage = new ResponseGroupInfoLocalMessage();
            try {
                responseGroupInfoLocalMessage.a(a);
                return responseGroupInfoLocalMessage;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return a();
    }

    private static CustomResponsedMessage<?> a() {
        ResponseGroupInfoLocalMessage responseGroupInfoLocalMessage = new ResponseGroupInfoLocalMessage();
        responseGroupInfoLocalMessage.a(-18);
        return responseGroupInfoLocalMessage;
    }
}
