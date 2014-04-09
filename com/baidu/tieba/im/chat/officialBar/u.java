package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u implements com.baidu.adp.framework.task.a<com.baidu.tbadk.core.b.ae> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<com.baidu.tbadk.core.b.ae> a(com.baidu.adp.framework.message.a<com.baidu.tbadk.core.b.ae> aVar) {
        UserData b;
        if (aVar != null && aVar.a() != null && (b = aVar.a().b()) != null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(String.valueOf(b.getUserId()));
            com.baidu.tieba.im.r.a(new v(this, linkedList), new w(this, aVar));
        }
        return null;
    }
}
