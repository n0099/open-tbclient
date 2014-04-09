package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ct implements com.baidu.adp.framework.task.a<com.baidu.tbadk.core.b.ah> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<com.baidu.tbadk.core.b.ah> a(com.baidu.adp.framework.message.a<com.baidu.tbadk.core.b.ah> aVar) {
        UserData b;
        if (aVar != null && aVar.a() != null && (b = aVar.a().b()) != null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(String.valueOf(b.getUserId()));
            com.baidu.tieba.im.r.a(new cu(this, linkedList), new cv(this, aVar));
        }
        return null;
    }
}
