package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.ResponseGetGroupActivityLocalMessage;
import com.baidu.tieba.im.message.ah;
/* loaded from: classes.dex */
public class e implements com.baidu.adp.framework.task.a<Integer> {
    private static ResponseGetGroupActivityLocalMessage a() {
        ResponseGetGroupActivityLocalMessage responseGetGroupActivityLocalMessage = new ResponseGetGroupActivityLocalMessage();
        responseGetGroupActivityLocalMessage.a(-18);
        return responseGetGroupActivityLocalMessage;
    }

    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<Integer> aVar) {
        if (aVar == null || !(aVar instanceof ah)) {
            return a();
        }
        ah ahVar = (ah) aVar;
        String str = "";
        if (TbadkApplication.N() != null) {
            str = TbadkApplication.N().getID();
        }
        byte[] a = com.baidu.tbadk.core.c.b.a().r().a("group_activity" + str + ahVar.a());
        ResponseGetGroupActivityLocalMessage responseGetGroupActivityLocalMessage = new ResponseGetGroupActivityLocalMessage();
        if (a != null) {
            try {
                responseGetGroupActivityLocalMessage.a(2001127, a);
                return responseGetGroupActivityLocalMessage;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return a();
    }
}
