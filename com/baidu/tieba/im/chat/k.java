package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.ChatResponsedMessage;
import com.baidu.tieba.im.message.Message;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class k implements com.baidu.tieba.im.codec.n<com.baidu.tieba.im.codec.a.c> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.codec.q, int] */
    @Override // com.baidu.tieba.im.codec.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.codec.a.c cVar, com.baidu.tieba.im.codec.q qVar, int i) {
        a2((LinkedList<Message>) linkedList, cVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.codec.a.c cVar, com.baidu.tieba.im.codec.q qVar, int i) {
        ChatResponsedMessage chatResponsedMessage = new ChatResponsedMessage();
        chatResponsedMessage.setErrorInfo(qVar);
        linkedList.add(chatResponsedMessage);
        if (cVar != null && !chatResponsedMessage.hasError()) {
            chatResponsedMessage.setMsgId(z.b(cVar.c("msgId")));
            chatResponsedMessage.setRecordId(cVar.c("recordId"));
            chatResponsedMessage.setGroupId(cVar.a("groupId"));
        }
    }
}
