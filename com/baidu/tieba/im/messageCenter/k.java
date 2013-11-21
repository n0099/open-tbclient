package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.lib.webSocket.am;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.AckedMessage;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponsedMessage;
import com.baidu.tieba.im.net.link.TiebaSocketLinkService;
import com.baidu.tieba.util.y;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.tieba.im.net.link.a {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.im.a<s> f1725a;
    private com.baidu.tieba.im.a<q> b;
    private com.baidu.tieba.im.a<List<Message>> c;
    private f h;
    private LinkedList<s> d = new LinkedList<>();
    private LinkedList<s> e = new LinkedList<>();
    private LinkedList<s> f = new LinkedList<>();
    private LinkedList<s> g = new LinkedList<>();
    private int i = 10;
    private com.baidu.tieba.im.net.link.a j = null;
    private boolean k = false;
    private boolean l = false;

    public k(f fVar) {
        this.f1725a = null;
        this.b = null;
        this.c = null;
        this.h = null;
        this.h = fVar;
        TiebaSocketLinkService.a(this);
        this.f1725a = new l(this);
        this.b = new m(this);
        this.c = new n(this);
    }

    public boolean a(Message message) {
        if (message != null && (message instanceof c)) {
            c cVar = (c) message;
            if (j.a(this.g, cVar, message.getCmd()) || j.a(this.f, cVar, message.getCmd()) || j.a(this.d, cVar, message.getCmd()) || j.a(this.e, cVar, message.getCmd())) {
                return true;
            }
        }
        return false;
    }

    public boolean a(int i) {
        return j.a(this.g, i) || j.a(this.f, i) || j.a(this.d, i) || j.a(this.e, i);
    }

    protected int b(Message message) {
        if (message.getCmd() == 1003) {
            return 1;
        }
        this.i++;
        return this.i;
    }

    public void a(Message message, boolean z, int i, int i2, int i3) {
        com.baidu.adp.lib.h.f.a();
        if (message != null) {
            int b = z ? b(message) : 0;
            s sVar = new s(message, z, i, b, i2, this, i3);
            if (d(message)) {
                y.a(message.getCmd(), b, "duplicate remove", "MessageQueue: Message throwed", null, 0, null);
                return;
            }
            if (TiebaApplication.g().s()) {
                StatService.onEvent(TiebaApplication.g().getApplicationContext(), "send_msg_time", "send", 1);
            }
            j.b(sVar, this.e);
            com.baidu.tieba.im.m.a(new i(sVar), this.f1725a);
        }
    }

    private boolean d(Message message) {
        if (message != null && (message instanceof IDuplicateProcess)) {
            int cmd = message.getCmd();
            IDuplicateProcess iDuplicateProcess = (IDuplicateProcess) message;
            switch (o.f1729a[iDuplicateProcess.getDuplicateRemoveType().ordinal()]) {
                case 1:
                    j.b(this.g, iDuplicateProcess, cmd);
                    j.b(this.d, iDuplicateProcess, cmd);
                    j.b(this.f, iDuplicateProcess, cmd);
                    j.b(this.e, iDuplicateProcess, cmd);
                    break;
                case 2:
                    j.b(this.g, iDuplicateProcess, cmd);
                    j.b(this.e, iDuplicateProcess, cmd);
                    break;
                case 3:
                    if (j.a(this.g, iDuplicateProcess, cmd) || j.a(this.d, iDuplicateProcess, cmd) || j.a(this.f, iDuplicateProcess, cmd) || j.a(this.e, iDuplicateProcess, cmd)) {
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(s sVar) {
        if (sVar != null) {
            int cmd = sVar.g() != null ? sVar.g().getCmd() : 0;
            int sequence = (sVar.c() == null || sVar.c().getMsgTag() == null) ? 0 : sVar.c().getMsgTag().getSequence();
            if (sVar.e() != null) {
                String a2 = com.baidu.tieba.im.k.a(sVar.e().getErrorCode());
                y.a(cmd, sequence, "pack error", "MessageQueue: Message throwed", null, sVar.e().getErrorCode(), a2);
                a(sVar, sVar.e().getErrorCode(), a2);
            } else if (sVar.d() != null) {
                y.a(cmd, sequence, null, "MessageQueue: send Message", null, 0, null, 0L, sVar.d().c() != null ? sVar.d().c().length : 0, null);
                j.a(sVar, this.g);
                if (this.k && sVar.g() != null && sVar.g().getCmd() != 1001 && sVar.g().getCmd() != 1003) {
                    com.baidu.adp.lib.h.d.a("offline state message active");
                    y.a(cmd, sequence, "message active to online", "MessageQueue: online", null, 0, null);
                    b(-111);
                }
                if (this.l && cmd != 1003 && cmd != 1001) {
                    y.a(cmd, sequence, "vary state", "MessageQueue: dispatchMessage need ping", null, 0, null);
                    b(-12);
                }
            } else {
                y.a(cmd, sequence, "pack error cont codec", "MessageQueue: Message throwed", null, 0, null);
                a(sVar, com.baidu.tieba.im.k.l, com.baidu.tieba.im.k.a(com.baidu.tieba.im.k.l));
            }
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(q qVar) {
        List<Message> a2;
        int i;
        int i2;
        AckedMessage ackedMessage;
        ResponsedMessage responsedMessage;
        s a3;
        if (qVar != null && (a2 = qVar.a()) != null && a2.size() > 0) {
            Message message = a2.get(0);
            if (message != null) {
                int cmd = message.getCmd();
                if (message instanceof AckedMessage) {
                    AckedMessage ackedMessage2 = (AckedMessage) a2.remove(0);
                    if (ackedMessage2.getMsgTag() != null) {
                        i = ackedMessage2.getMsgTag().getSequence();
                        ackedMessage = ackedMessage2;
                        i2 = cmd;
                    } else {
                        i = 0;
                        ackedMessage = ackedMessage2;
                        i2 = cmd;
                    }
                } else {
                    i = 0;
                    i2 = cmd;
                    ackedMessage = null;
                }
            } else {
                i = 0;
                i2 = 0;
                ackedMessage = null;
            }
            y.a(i2, i, "unpack succ", "MessageQueue: receive message", null, 0, null);
            if (ackedMessage != null) {
                Object obj = a2.size() > 0 ? (Message) a2.get(0) : null;
                if (obj != null && (obj instanceof ResponsedMessage)) {
                    responsedMessage = (ResponsedMessage) obj;
                    if (responsedMessage.getErrNo() == 110004) {
                        com.baidu.adp.lib.h.d.a("is offline state force online");
                        y.a(i2, i, "server kick off", "MessageQueue: on line", null, 0, null);
                        b(-112);
                    }
                    if (ackedMessage != null && ackedMessage.getMsgTag() != null) {
                        a3 = j.a(ackedMessage.getMsgTag().getSequence(), this.f);
                        y.a(i2, i, null, "MessageQueue: receive ack message", null, 0, null);
                        if (a3 == null) {
                            if (a3.c() != null && responsedMessage != null) {
                                responsedMessage.setOrginalMessage(a3.c().getData());
                            }
                            a3.b();
                            j.c(a3, this.f);
                        } else if (responsedMessage != null) {
                            y.a(i2, i, "original message removed", "MessageQueue: not dispatchMessage", null, 0, null);
                            a2.remove(responsedMessage);
                        }
                    }
                    com.baidu.tieba.im.m.a(new e(a2, qVar.b()), this.c);
                }
            }
            responsedMessage = null;
            if (ackedMessage != null) {
                a3 = j.a(ackedMessage.getMsgTag().getSequence(), this.f);
                y.a(i2, i, null, "MessageQueue: receive ack message", null, 0, null);
                if (a3 == null) {
                }
            }
            com.baidu.tieba.im.m.a(new e(a2, qVar.b()), this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<Message> list) {
        b(list);
        d();
    }

    public void a(s sVar) {
        String string = TiebaApplication.g().getString(R.string.timeout);
        f(sVar);
        a(sVar, com.baidu.tieba.im.k.m, string);
        d();
    }

    public void b(s sVar) {
        String string = TiebaApplication.g().getString(R.string.send_error);
        f(sVar);
        a(sVar, com.baidu.tieba.im.k.r, string);
        d();
    }

    public void c(s sVar) {
        if (sVar != null && sVar.f()) {
            j.a(this.d, this.f, sVar);
        }
    }

    public void d(s sVar) {
        j.a(this.g, this.d, sVar);
    }

    protected void a(s sVar, int i, String str) {
        int i2;
        int i3 = 0;
        if (sVar == null || sVar.g() == null) {
            i2 = 0;
        } else {
            i2 = sVar.g().getCmd();
            if (sVar.c() != null && sVar.c().getMsgTag() != null) {
                i3 = sVar.c().getMsgTag().getSequence();
            }
        }
        y.a(i2, i3, "message send  error", "MessageQueue: onMessageSendFail", null, i, str);
        if (sVar != null && sVar.g() != null) {
            a(sVar.g(), i, str);
        }
    }

    private void d() {
        s a2 = j.a(this.g);
        if (a2 != null) {
            if ((!this.k && !this.l) || a2.h() <= -3) {
                TiebaSocketLinkService.a(a2.d());
            }
        }
    }

    private void a(Message message, int i, String str) {
        if (TiebaApplication.g().s()) {
            StatService.onEvent(TiebaApplication.g().getApplicationContext(), "send_msg_time", "send", 1);
        }
        if (this.h != null && message != null) {
            this.h.a(message, i, str);
        }
    }

    private void b(int i) {
        Message message = new Message() { // from class: com.baidu.tieba.im.messageCenter.MessageQueueManager$4
        };
        message.setCmd(i);
        e(message);
    }

    private void b(List<Message> list) {
        if (this.h != null && list != null) {
            this.h.a(list);
        }
    }

    private void e(Message message) {
        if (this.h != null && message != null) {
            this.h.e(message);
        }
    }

    private void f(s sVar) {
        if (sVar != null) {
            sVar.b();
            j.c(sVar, this.d);
            j.c(sVar, this.f);
            j.c(sVar, this.g);
            j.c(sVar, this.e);
        }
    }

    private void a(LinkedList<s> linkedList) {
        while (true) {
            s b = j.b(linkedList);
            if (b != null) {
                b.b();
                a(b, com.baidu.tieba.im.k.s, TiebaApplication.g().getString(R.string.send_error));
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        a(this.d);
        a(this.f);
        a(this.g);
        a(this.e);
    }

    void b() {
        a(this.d);
        a(this.f);
    }

    @Override // com.baidu.tieba.im.net.link.a
    public void a(int i, String str) {
        y.a(0, 0, null, "MessageQueue: message Queue onClose", null, i, str);
        if (i == 7) {
            b();
        } else {
            a();
        }
        if (this.j != null) {
            this.j.a(i, str);
        }
    }

    @Override // com.baidu.tieba.im.net.link.a
    public void c() {
        y.a(0, 0, null, "MessageQueue: message Queue onConnected", null, 0, null);
        if (this.j != null) {
            this.j.c();
        }
    }

    @Override // com.baidu.tieba.im.net.link.a
    public void a(byte[] bArr) {
        if (bArr != null) {
            y.a(0, 0, "socket", "MessageQueue: onBinaryMesssage", null, 0, null, 0L, bArr.length, null);
        }
        com.baidu.tieba.im.m.a(new p(bArr), this.b);
        if (this.j != null) {
            this.j.a(bArr);
        }
    }

    @Override // com.baidu.tieba.im.net.link.a
    public void a(am amVar) {
        d();
        if (this.j != null) {
            this.j.a(amVar);
        }
    }

    @Override // com.baidu.tieba.im.net.link.a
    public void a(String str) {
        if (this.j != null) {
            this.j.a(str);
        }
    }

    public void a(com.baidu.tieba.im.net.link.a aVar) {
        this.j = aVar;
    }

    public void c(Message message) {
        j.a(message, this.g);
        j.a(message, this.e);
    }

    public void a(boolean z) {
        boolean z2 = this.k;
        this.k = z;
        if (!this.k && !this.l && z2) {
            d();
        }
    }

    public void b(boolean z) {
        boolean z2 = this.l;
        this.l = z;
        if (!this.k && !this.l && z2) {
            d();
        }
    }
}
