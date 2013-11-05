package com.baidu.tieba.im.pushNotify;

import com.baidu.browser.core.util.BdLog;
import com.baidu.tieba.im.message.Message;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class s implements com.baidu.tieba.im.codec.n<com.baidu.tieba.im.codec.a.c> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.codec.q, int] */
    @Override // com.baidu.tieba.im.codec.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.codec.a.c cVar, com.baidu.tieba.im.codec.q qVar, int i) {
        a2((LinkedList<Message>) linkedList, cVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.codec.a.c cVar, com.baidu.tieba.im.codec.q qVar, int i) {
        BdLog.d("begin");
        if (cVar != null && linkedList != null) {
            PushNotifyMessage pushNotifyMessage = new PushNotifyMessage();
            pushNotifyMessage.setCmd(i);
            pushNotifyMessage.setGroupId(cVar.c("groupId"));
            pushNotifyMessage.setNewestMsgId(cVar.c("msgId"));
            pushNotifyMessage.setPushTime(cVar.c("pushTime"));
            linkedList.add(pushNotifyMessage);
            BdLog.d("end");
        }
    }
}
