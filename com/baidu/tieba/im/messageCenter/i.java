package com.baidu.tieba.im.messageCenter;

import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.exception.IMException;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponsedMessage;
import com.baidu.tieba.im.net.TiebaSocketLinkService;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.im.net.a {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.im.a<m> f1797a;
    private e e;
    private LinkedList<p> b = new LinkedList<>();
    private LinkedList<p> c = new LinkedList<>();
    private LinkedList<p> d = new LinkedList<>();
    private com.baidu.tieba.im.net.a f = null;
    private boolean g = true;

    public i(e eVar) {
        this.f1797a = null;
        this.e = null;
        this.e = eVar;
        TiebaSocketLinkService.a(this);
        this.f1797a = new j(this);
    }

    public boolean a(Message message) {
        if (message != null && (message instanceof c)) {
            c cVar = (c) message;
            if (h.a(this.c, cVar, message.getCmd()) || h.a(this.b, cVar, message.getCmd()) || h.a(this.d, cVar, message.getCmd())) {
                return true;
            }
        }
        return false;
    }

    public boolean a(int i) {
        return h.a(this.c, i) || h.a(this.b, i) || h.a(this.d, i);
    }

    public void a(Message message, boolean z, int i, int i2, int i3, boolean z2) {
        com.baidu.adp.lib.h.g.a();
        if (message != null) {
            if (c(message)) {
                com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(message.getCmd(), 0, "duplicate remove", "MessageQueue: Message throwed", null, 0, null));
                return;
            }
            p pVar = new p(message, z, i, i2, this, i3, z2);
            if (TiebaApplication.h().t()) {
                StatService.onEvent(TiebaApplication.h().getApplicationContext(), "send_msg_time", "send", 1);
            }
            com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(message.getCmd(), 0, null, "MessageQueue: send Message", null, 0, null, 0L, 0, null));
            h.a(pVar, this.c);
            b();
        }
    }

    private boolean c(Message message) {
        if (message != null && (message instanceof IDuplicateProcess)) {
            int cmd = message.getCmd();
            IDuplicateProcess iDuplicateProcess = (IDuplicateProcess) message;
            switch (k.f1799a[iDuplicateProcess.getDuplicateRemoveType().ordinal()]) {
                case 1:
                    h.b(this.c, iDuplicateProcess, cmd);
                    h.b(this.b, iDuplicateProcess, cmd);
                    h.b(this.d, iDuplicateProcess, cmd);
                    break;
                case 2:
                    h.b(this.c, iDuplicateProcess, cmd);
                    break;
                case 3:
                    if (h.a(this.c, iDuplicateProcess, cmd) || h.a(this.b, iDuplicateProcess, cmd) || h.a(this.d, iDuplicateProcess, cmd)) {
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(m mVar) {
        if (mVar != null) {
            List<Message> list = mVar.f1801a;
            if (mVar.b != null) {
                a(mVar.b, com.baidu.tieba.im.k.s, TiebaApplication.h().getString(R.string.send_error));
            }
            if (list != null && list.size() > 0) {
                Message message = list.get(0);
                com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(message != null ? message.getCmd() : 0, 0, "unpack succ", "MessageQueue: dispatchMessage", null, 0, null));
                a(list);
                if ((message instanceof ResponsedMessage) && ((ResponsedMessage) message).getErrNo() == 110004) {
                    TiebaSocketLinkService.a(true, "be server kicked off");
                }
            }
        }
    }

    public void a(p pVar) {
        String string = TiebaApplication.h().getString(R.string.timeout);
        if (pVar != null && pVar.l() && pVar.o() < 3) {
            h.a(this.b, this.d, pVar);
            PingManager.a().a(true, "timeout seq = " + pVar.k());
            return;
        }
        d(pVar);
        a(pVar, com.baidu.tieba.im.k.m, string);
        b();
    }

    public void a(int i, p pVar) {
        int i2;
        String string;
        int i3;
        if (i == 2) {
            if (pVar.g() != null) {
                i3 = pVar.g().getErrorCode();
            } else {
                i3 = com.baidu.tieba.im.k.l;
            }
            i2 = i3;
            string = com.baidu.tieba.im.k.a(i3);
        } else {
            i2 = com.baidu.tieba.im.k.r;
            string = TiebaApplication.h().getString(R.string.send_error);
        }
        d(pVar);
        a(pVar, i2, string);
    }

    public void b(p pVar) {
    }

    public void c(p pVar) {
        if (pVar != null) {
            if (pVar.h()) {
                pVar.p();
                h.a(this.c, this.b, pVar);
                return;
            }
            h.b(pVar, this.c);
        }
    }

    protected void a(p pVar, int i, String str) {
        if (pVar != null && pVar.j() != null) {
            com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(pVar.j().getCmd(), pVar.k(), "message send  error", "MessageQueue: onMessageSendFail", null, i, str));
            a(pVar.j(), i, str);
        }
    }

    private void b() {
        p c = h.c(this.c);
        if (c != null) {
            if (TiebaSocketLinkService.b()) {
                TiebaSocketLinkService.a(false, "send message");
            } else if (!this.g || c.i() <= -3) {
                TiebaSocketLinkService.a(c);
            }
        }
    }

    private void a(Message message, int i, String str) {
        if (this.e != null && message != null) {
            this.e.a(message, i, str);
        }
    }

    private void a(List<Message> list) {
        if (this.e != null && list != null) {
            this.e.a(list);
        }
    }

    private void d(p pVar) {
        if (pVar != null) {
            pVar.f();
            h.b(pVar, this.b);
            h.b(pVar, this.c);
            h.b(pVar, this.d);
        }
    }

    private void a(LinkedList<p> linkedList) {
        while (true) {
            p d = h.d(linkedList);
            if (d != null) {
                d.f();
                a(d, com.baidu.tieba.im.k.s, TiebaApplication.h().getString(R.string.send_error));
            } else {
                return;
            }
        }
    }

    void a() {
        a(this.b);
        a(this.c);
        a(this.d);
    }

    @Override // com.baidu.tieba.im.net.a
    public boolean a(int i, String str) {
        boolean z = false;
        com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(0, 0, null, "MessageQueue: message Queue onClose", null, i, str));
        PingManager.a().b();
        if (!UtilHelper.b() || h.e(this.d) || h.e(this.c) || h.e(this.b)) {
            a();
        } else {
            h.f(this.b);
            h.a(this.c, this.d);
            h.a(this.c, this.b);
            while (true) {
                p b = h.b(this.c);
                if (b == null) {
                    break;
                }
                b.f();
                a(b, com.baidu.tieba.im.k.s, TiebaApplication.h().getString(R.string.send_error));
            }
            if (h.a(this.c) > 0) {
                com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a("have retry message", "MessageQueue:reconnect", null, 0, null));
                TiebaSocketLinkService.a(false, "have retry message");
                z = true;
            }
        }
        if (this.f != null) {
            this.f.a(i, str);
        }
        return z;
    }

    @Override // com.baidu.tieba.im.net.a
    public void a(Map<String, String> map) {
        com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(0, 0, null, "MessageQueue: message Queue onConnected", null, 0, null));
        r.a().a(map);
        PingManager.a().c();
        a(true);
        if (this.f != null) {
            this.f.a(map);
        }
    }

    @Override // com.baidu.tieba.im.net.a
    public void a(byte[] bArr) {
        if (bArr != null) {
            try {
                com.baidu.tieba.im.b.p a2 = com.baidu.tieba.im.b.c.b().a(bArr);
                int d = a2.f1524a.d();
                int f = a2.f1524a.f();
                com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(d, f, "socket", "MessageQueue: onBinaryMesssage", "succ", 0, null, 0L, bArr.length, null));
                p a3 = a(d, f);
                if (a2.f1524a.d() == 1003 && h.a(this.c, this.d)) {
                    com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(a2.f1524a.d(), a2.f1524a.f(), "ping succ", "MessageQueue: retry send", null, 0, null));
                    b();
                }
                PingManager.a().c();
                com.baidu.tieba.im.m.a(new l(a2, a3), this.f1797a);
                if (this.f != null) {
                    this.f.a(bArr);
                }
            } catch (IMException e) {
                com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(0, 0, "socket", "MessageQueue: onBinaryMesssage decodeHeader error", "fail", e.getErrorCode(), null, 0L, bArr.length, null));
            }
        }
    }

    private p a(int i, int i2) {
        if (i2 != 0) {
            p a2 = h.a(i2, this.b);
            if (a2 != null || (a2 = h.a(i2, this.d)) != null || (a2 = h.a(i2, this.c)) != null) {
                p pVar = a2;
                com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(i, i2, null, "MessageQueue: receive ack message", null, 0, null));
                return pVar;
            }
            com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(i, i2, "original message removed", "MessageQueue: not dispatchMessage", null, 0, null));
            return a2;
        }
        return null;
    }

    @Override // com.baidu.tieba.im.net.a
    public void a(com.baidu.adp.lib.webSocket.d dVar) {
        b();
        if (this.f != null) {
            this.f.a(dVar);
        }
    }

    @Override // com.baidu.tieba.im.net.a
    public void a(String str) {
        if (this.f != null) {
            this.f.a(str);
        }
    }

    public void a(com.baidu.tieba.im.net.a aVar) {
        this.f = aVar;
    }

    public void b(Message message) {
        h.a(message, this.c);
    }

    public void a(boolean z) {
        boolean z2 = this.g;
        this.g = z;
        if (!this.g && z2) {
            b();
        }
    }
}
