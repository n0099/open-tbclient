package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.im.message.ab;
import com.baidu.tieba.im.message.cl;
import com.baidu.tieba.im.message.da;
/* loaded from: classes.dex */
public class s extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public da a(com.baidu.tieba.im.message.s sVar) {
        cl clVar;
        if (sVar == null || !(sVar instanceof ab)) {
            return null;
        }
        byte[] a = com.baidu.tieba.c.a.a().s().a("p_enter_forum_group_info");
        cl clVar2 = new cl();
        if (a != null) {
            try {
                clVar = (cl) n.a(103011, a);
            } catch (Exception e) {
                e.printStackTrace();
            }
            clVar.e(-114);
            return clVar;
        }
        clVar = clVar2;
        clVar.e(-114);
        return clVar;
    }
}
