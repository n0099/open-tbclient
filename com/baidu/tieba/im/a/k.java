package com.baidu.tieba.im.a;

import com.baidu.tieba.im.b.q;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseReportGroupMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class k implements com.baidu.tieba.im.b.n<com.baidu.tieba.im.b.a.d> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.b.q, int] */
    @Override // com.baidu.tieba.im.b.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.b.a.d dVar, q qVar, int i) {
        a2((LinkedList<Message>) linkedList, dVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.b.a.d dVar, q qVar, int i) {
        ResponseReportGroupMessage responseReportGroupMessage = new ResponseReportGroupMessage(103103);
        responseReportGroupMessage.setErrorInfo(qVar);
        responseReportGroupMessage.setCmd(i);
        linkedList.add(responseReportGroupMessage);
        if (dVar == null || responseReportGroupMessage.hasError()) {
        }
    }
}
