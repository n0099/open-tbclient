package com.baidu.tieba.im.a;

import com.baidu.tieba.im.b.q;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseRequestGroupLocMessage;
import java.util.LinkedList;
import org.msgpack.type.ArrayValue;
import org.msgpack.type.ValueType;
import org.msgpack.type.r;
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.im.b.n<com.baidu.tieba.im.b.a.d> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.b.q, int] */
    @Override // com.baidu.tieba.im.b.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.b.a.d dVar, q qVar, int i) {
        a2((LinkedList<Message>) linkedList, dVar, qVar, i);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.b.a.d dVar, q qVar, int i) {
        ArrayValue b;
        ResponseRequestGroupLocMessage responseRequestGroupLocMessage = new ResponseRequestGroupLocMessage(103010);
        responseRequestGroupLocMessage.setErrorInfo(qVar);
        responseRequestGroupLocMessage.setCmd(i);
        linkedList.add(responseRequestGroupLocMessage);
        if (dVar != null && !responseRequestGroupLocMessage.hasError()) {
            responseRequestGroupLocMessage.setPosition(dVar.a("position"));
            com.baidu.tieba.im.b.a.a e = dVar.e("business");
            if (e != null && (b = e.b()) != null && (r2 = b.iterator()) != null) {
                for (r rVar : b) {
                    if (rVar.getType() == ValueType.RAW) {
                        responseRequestGroupLocMessage.addBusinessArea(rVar.asRawValue().c());
                    }
                }
            }
        }
    }
}
