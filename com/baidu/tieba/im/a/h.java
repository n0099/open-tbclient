package com.baidu.tieba.im.a;

import com.baidu.tieba.im.b.q;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseQueryGroupCountMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h implements com.baidu.tieba.im.b.n<com.baidu.tieba.im.b.a.d> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.b.q, int] */
    @Override // com.baidu.tieba.im.b.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.b.a.d dVar, q qVar, int i) {
        a2((LinkedList<Message>) linkedList, dVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.b.a.d dVar, q qVar, int i) {
        ResponseQueryGroupCountMessage responseQueryGroupCountMessage = new ResponseQueryGroupCountMessage(103011);
        responseQueryGroupCountMessage.setErrorInfo(qVar);
        responseQueryGroupCountMessage.setCmd(i);
        linkedList.add(responseQueryGroupCountMessage);
        if (dVar != null && !responseQueryGroupCountMessage.hasError()) {
            responseQueryGroupCountMessage.setUserGroupCount(dVar.b("userGroupCount"));
            responseQueryGroupCountMessage.setLocalGroupCount(dVar.b("localGroupCount"));
        }
    }
}
