package com.baidu.tieba.im.pushNotify;

import com.baidu.browser.core.util.BdLog;
import com.baidu.tieba.im.message.Message;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class q implements com.baidu.tieba.im.b.n<com.baidu.tieba.im.b.a.d> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.b.q, int] */
    @Override // com.baidu.tieba.im.b.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.b.a.d dVar, com.baidu.tieba.im.b.q qVar, int i) {
        a2((LinkedList<Message>) linkedList, dVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.b.a.d dVar, com.baidu.tieba.im.b.q qVar, int i) {
        BdLog.d("begin");
        if (dVar != null && linkedList != null) {
            PushNotifyMessage pushNotifyMessage = new PushNotifyMessage();
            pushNotifyMessage.setCmd(i);
            pushNotifyMessage.setGroupId(dVar.c("groupId"));
            pushNotifyMessage.setNewestMsgId(dVar.c("msgId"));
            pushNotifyMessage.setPushTime(dVar.c("pushTime"));
            linkedList.add(pushNotifyMessage);
            BdLog.d("end");
        }
    }
}
