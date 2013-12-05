package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.ChatResponsedMessage;
import com.baidu.tieba.im.message.Message;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.im.b.n<com.baidu.tieba.im.b.a.d> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.b.q, int] */
    @Override // com.baidu.tieba.im.b.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.b.a.d dVar, com.baidu.tieba.im.b.q qVar, int i) {
        a2((LinkedList<Message>) linkedList, dVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.b.a.d dVar, com.baidu.tieba.im.b.q qVar, int i) {
        ChatResponsedMessage chatResponsedMessage = new ChatResponsedMessage();
        chatResponsedMessage.setErrorInfo(qVar);
        linkedList.add(chatResponsedMessage);
        if (dVar != null && !chatResponsedMessage.hasError()) {
            chatResponsedMessage.setMsgId(ac.b(dVar.c("msgId")));
            chatResponsedMessage.setRecordId(dVar.c("recordId"));
            chatResponsedMessage.setGroupId(dVar.a("groupId"));
        }
    }
}
