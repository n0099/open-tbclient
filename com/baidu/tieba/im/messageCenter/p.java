package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.exception.IMException;
import com.baidu.tieba.im.message.AckedMessage;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponsedMessage;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends SingleRunnable<q> {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f1652a;

    public p(byte[] bArr) {
        this.f1652a = null;
        this.f1652a = bArr;
    }

    private List<Message> c() {
        LinkedList linkedList = new LinkedList();
        AckedMessage ackedMessage = new AckedMessage();
        ackedMessage.setCmd(1003);
        ackedMessage.setAck(true);
        AckedMessage.MessageTag messageTag = new AckedMessage.MessageTag();
        messageTag.setSequence(1);
        ackedMessage.setMsgTag(messageTag);
        linkedList.add(ackedMessage);
        linkedList.addLast(new ResponsedMessage(1003));
        return linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public q b() {
        IMException iMException;
        com.baidu.tieba.im.codec.p pVar;
        com.baidu.tieba.im.codec.p pVar2;
        List<Message> list;
        List<Message> linkedList;
        if (this.f1652a == null) {
            return null;
        }
        try {
            com.baidu.tieba.im.codec.p a2 = com.baidu.tieba.im.codec.c.b().a(this.f1652a);
            try {
                if (a2.f1484a.d() == 1003) {
                    linkedList = c();
                } else if (a2.d > 0) {
                    linkedList = com.baidu.tieba.im.codec.c.b().a(a2.f1484a.b(), true, a2.b, a2.c, a2.d);
                } else {
                    com.baidu.adp.lib.h.d.b("[server error] receive messages without body! cmd:" + a2.f1484a.d());
                    linkedList = new LinkedList<>();
                }
                list = linkedList;
                pVar2 = a2;
            } catch (IMException e) {
                iMException = e;
                pVar = a2;
                com.baidu.tieba.util.o.a(0, 0, "cont unpack", "unpack error", null, iMException.getErrorCode(), null);
                com.baidu.adp.lib.h.d.a("IMException code = " + iMException.getErrorCode());
                pVar2 = pVar;
                list = null;
                return new q(this, list, pVar2);
            }
        } catch (IMException e2) {
            iMException = e2;
            pVar = null;
        }
        return new q(this, list, pVar2);
    }
}
