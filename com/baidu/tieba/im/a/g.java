package com.baidu.tieba.im.a;

import com.baidu.tieba.im.codec.n;
import com.baidu.tieba.im.codec.q;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseReportGroupMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class g implements n<com.baidu.tieba.im.codec.a.c> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.codec.q, int] */
    @Override // com.baidu.tieba.im.codec.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.codec.a.c cVar, q qVar, int i) {
        a2((LinkedList<Message>) linkedList, cVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.codec.a.c cVar, q qVar, int i) {
        ResponseReportGroupMessage responseReportGroupMessage = new ResponseReportGroupMessage(103103);
        responseReportGroupMessage.setErrorInfo(qVar);
        responseReportGroupMessage.setCmd(i);
        linkedList.add(responseReportGroupMessage);
        if (cVar == null || responseReportGroupMessage.hasError()) {
        }
    }
}
