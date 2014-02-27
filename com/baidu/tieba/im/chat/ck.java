package com.baidu.tieba.im.chat;

import com.baidu.tieba.data.UserData;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ck implements com.baidu.adp.framework.task.a<com.baidu.tieba.a.c> {
    @Override // com.baidu.adp.framework.task.a
    public final com.baidu.adp.framework.message.b<com.baidu.tieba.a.c> a(com.baidu.adp.framework.message.a<com.baidu.tieba.a.c> aVar) {
        UserData a;
        if (aVar != null && aVar.a() != null && (a = aVar.a().a()) != null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(String.valueOf(a.getUserId()));
            com.baidu.tieba.im.i.a(new cl(this, linkedList), new cm(this, aVar));
        }
        return null;
    }
}
