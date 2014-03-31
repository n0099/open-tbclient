package com.baidu.tieba.im.e.a;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
public class n implements com.baidu.adp.framework.task.a<String> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<String> a(com.baidu.adp.framework.message.a<String> aVar) {
        int a = com.baidu.adp.lib.f.b.a(aVar.a(), 0);
        if (!com.baidu.tieba.im.db.m.d().e(String.valueOf(a))) {
            return null;
        }
        ImMessageCenterPojo a2 = com.baidu.tieba.im.b.j.a().a(String.valueOf(a));
        if (a2 != null) {
            a2.setLast_content(" ");
        }
        return new CustomResponsedMessage<>(2001155, String.valueOf(a));
    }
}
