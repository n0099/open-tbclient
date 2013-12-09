package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.exception.IMException;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponsedMessage;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends SingleRunnable<m> {

    /* renamed from: a  reason: collision with root package name */
    private LinkedList<Message> f1801a = null;
    private com.baidu.tieba.im.b.p b;
    private p c;

    public l(com.baidu.tieba.im.b.p pVar, p pVar2) {
        this.b = null;
        this.c = null;
        this.b = pVar;
        this.c = pVar2;
    }

    private List<Message> c() {
        if (this.f1801a == null) {
            synchronized (l.class) {
                if (this.f1801a == null) {
                    this.f1801a = new LinkedList<>();
                    this.f1801a.addLast(new ResponsedMessage(1003));
                }
            }
        }
        return this.f1801a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public m b() {
        IMException iMException;
        int i;
        com.baidu.tieba.im.b.p pVar;
        int i2;
        com.baidu.tieba.im.b.p pVar2;
        boolean a2;
        com.baidu.tieba.im.b.p pVar3;
        List<Message> list = null;
        if (this.b == null) {
            return null;
        }
        try {
            i = this.b.f1524a.f();
            try {
                if (this.b.f1524a.d() == 1003) {
                    list = c();
                    pVar3 = null;
                } else if (this.b.d > 0) {
                    com.baidu.tieba.im.b.p a3 = com.baidu.tieba.im.b.c.b().a(this.b);
                    try {
                        list = com.baidu.tieba.im.b.c.b().a(a3.f1524a.b(), true, a3.b, a3.c, a3.d);
                        pVar3 = a3;
                    } catch (IMException e) {
                        iMException = e;
                        pVar = a3;
                        com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(0, 0, "cont unpack", "unpack error", null, iMException.getErrorCode(), null));
                        com.baidu.adp.lib.h.e.a("IMException code = " + iMException.getErrorCode());
                        i2 = i;
                        pVar2 = pVar;
                        a2 = a(list, i2, this.c);
                        a(list, pVar2);
                        m mVar = new m(this);
                        mVar.f1802a = list;
                        if (!a2) {
                        }
                        return mVar;
                    }
                } else {
                    pVar3 = null;
                }
                pVar2 = pVar3;
                i2 = i;
            } catch (IMException e2) {
                iMException = e2;
                pVar = null;
            }
        } catch (IMException e3) {
            iMException = e3;
            i = 0;
            pVar = null;
        }
        a2 = a(list, i2, this.c);
        a(list, pVar2);
        m mVar2 = new m(this);
        mVar2.f1802a = list;
        if (!a2) {
            mVar2.b = this.c;
        }
        return mVar2;
    }

    private boolean a(List<Message> list, int i, p pVar) {
        ResponsedMessage responsedMessage;
        Message message;
        if (i != 0) {
            if (list == null || list.size() <= 0 || (message = list.get(0)) == null || !(message instanceof ResponsedMessage)) {
                responsedMessage = null;
            } else {
                responsedMessage = (ResponsedMessage) message;
                if (pVar != null) {
                    responsedMessage.setOrginalMessage(pVar.j());
                } else {
                    list.remove(0);
                }
            }
            if (responsedMessage == null && pVar != null) {
                com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(0, 0, "server error", "ack cont responsed", null, 0, null));
                return false;
            }
        }
        return true;
    }

    private void a(List<Message> list, com.baidu.tieba.im.b.p pVar) {
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Message message = list.get(i);
                a a2 = e.a().a(message.getCmd());
                if (a2 != null) {
                    a2.a(message, pVar);
                }
            }
        }
    }
}
