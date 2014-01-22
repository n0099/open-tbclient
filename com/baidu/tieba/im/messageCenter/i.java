package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.coder.CoderException;
import com.baidu.tieba.im.message.cr;
import com.baidu.tieba.im.net.TiebaSocketLinkService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.by;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.im.net.a {
    private com.baidu.tieba.im.a<m> a;
    private e e;
    private LinkedList<p> b = new LinkedList<>();
    private LinkedList<p> c = new LinkedList<>();
    private LinkedList<p> d = new LinkedList<>();
    private com.baidu.tieba.im.net.a f = null;
    private boolean g = true;
    private boolean h = false;

    public void a(boolean z) {
        this.h = z;
    }

    public i(e eVar) {
        this.a = null;
        this.e = null;
        this.e = eVar;
        TiebaSocketLinkService.a(this);
        this.a = new j(this);
    }

    public boolean a(com.baidu.tieba.im.message.q qVar) {
        if (qVar != null && (qVar instanceof c)) {
            c cVar = (c) qVar;
            if (h.a(this.c, cVar, qVar.w()) || h.a(this.b, cVar, qVar.w()) || h.a(this.d, cVar, qVar.w())) {
                return true;
            }
        }
        return false;
    }

    public boolean a(int i) {
        return h.a(this.c, i) || h.a(this.b, i) || h.a(this.d, i);
    }

    public void a(com.baidu.tieba.im.message.q qVar, boolean z, int i, boolean z2, int i2, boolean z3) {
        com.baidu.adp.lib.g.g.a();
        if (qVar != null) {
            if (c(qVar)) {
                by.a("sandMessage", qVar.w(), qVar.v(), "duplicate remove", 0);
                by.a(qVar.w(), qVar.v(), "duplicate remove", "MessageQueue: Message throwed", null, 0, null);
                return;
            }
            p pVar = new p(qVar, z, i, z2, this, i2, z3);
            if (this.h) {
                by.a("sandMessage", qVar.w(), qVar.v(), "MessageQueueManager.sendMessage:isOfflineBlock", 0);
                by.a(qVar.w(), qVar.v(), "can't send Message, beacuse of online error", "call onSendError", null, 0, null);
                pVar.a(1);
                return;
            }
            by.a(TiebaApplication.h().getApplicationContext(), "send_msg_time", "send", 1, new Object[0]);
            by.a(qVar.w(), qVar.v(), null, "MessageQueue: send Message", null, 0, null, 0L, 0, null);
            h.a(pVar, this.c);
            b();
        }
    }

    private boolean c(com.baidu.tieba.im.message.q qVar) {
        if (qVar != null && (qVar instanceof IDuplicateProcess)) {
            int w = qVar.w();
            IDuplicateProcess iDuplicateProcess = (IDuplicateProcess) qVar;
            switch (k.a[iDuplicateProcess.h().ordinal()]) {
                case 1:
                    h.b(this.c, iDuplicateProcess, w);
                    h.b(this.b, iDuplicateProcess, w);
                    h.b(this.d, iDuplicateProcess, w);
                    break;
                case 2:
                    h.b(this.c, iDuplicateProcess, w);
                    break;
                case 3:
                    if (h.a(this.c, iDuplicateProcess, w) || h.a(this.b, iDuplicateProcess, w) || h.a(this.d, iDuplicateProcess, w)) {
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
            List<com.baidu.tieba.im.message.q> list = mVar.a;
            if (mVar.b != null) {
                a(mVar.b, com.baidu.tieba.im.k.s, TiebaApplication.h().getString(R.string.send_error));
            } else if (list != null && list.size() >= 1) {
                com.baidu.tieba.im.message.q qVar = list.get(0);
                int w = qVar != null ? qVar.w() : 0;
                com.baidu.adp.lib.g.e.d("onReceiveCmd:" + w);
                by.a(w, 0, "unpack succ", "MessageQueue: dispatchMessage", null, 0, null);
                a(list);
                if ((qVar instanceof cr) && ((cr) qVar).l() == 110004) {
                    TiebaSocketLinkService.a(true, "be server kicked off");
                }
            }
        }
    }

    public void a(p pVar) {
        String string = TiebaApplication.h().getString(R.string.timeout);
        if (pVar != null && pVar.m() && pVar.p() < 3) {
            h.a(this.b, this.d, pVar);
            PingManager.a().a(true, "timeout seq = " + pVar.l());
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
                pVar.q();
                h.a(this.c, this.b, pVar);
                return;
            }
            h.b(pVar, this.c);
        }
    }

    protected void a(p pVar, int i, String str) {
        if (pVar != null && pVar.j() != null) {
            by.a(pVar.j().w(), pVar.l(), "message send  error", "MessageQueue: onMessageSendFail", null, i, str);
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

    private void a(com.baidu.tieba.im.message.q qVar, int i, String str) {
        if (this.e != null && qVar != null) {
            this.e.a(qVar, i, str);
        }
    }

    private void a(List<com.baidu.tieba.im.message.q> list) {
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
        if (this.f != null) {
            this.f.a(i, str);
        }
        by.a(0, 0, null, "MessageQueue: message Queue onClose", null, i, str);
        PingManager.a().b();
        if (!UtilHelper.b() || h.e(this.d) || h.e(this.c) || h.e(this.b) || this.h) {
            a();
            return false;
        }
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
            by.a("have retry message", "MessageQueue:reconnect", (String) null, 0, (String) null);
            TiebaSocketLinkService.a(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.im.net.a
    public void a(Map<String, String> map) {
        by.a(0, 0, null, "MessageQueue: message Queue onConnected", null, 0, null);
        r.a().a(map);
        PingManager.a().c();
        b(true);
        if (this.f != null) {
            this.f.a(map);
        }
    }

    @Override // com.baidu.tieba.im.net.a
    public void a(byte[] bArr) {
        if (bArr != null) {
            try {
                com.baidu.tieba.im.coder.d a = com.baidu.tieba.im.coder.c.a().a(bArr);
                int c = a.a.c();
                int e = a.a.e();
                by.a(c, e, "socket", "MessageQueue: onBinaryMesssage", "succ", 0, null, 0L, bArr.length, null);
                p a2 = a(c, e);
                if (a.a.c() == 1003 && h.a(this.c, this.d)) {
                    by.a(a.a.c(), a.a.e(), "ping succ", "MessageQueue: retry send", null, 0, null);
                    b();
                }
                PingManager.a().c();
                if (e == 0 || (a2 != null && a2.k() == c)) {
                    com.baidu.tieba.im.m.a(new l(a, a2), this.a);
                } else if (a2 != null) {
                    a(a2, com.baidu.tieba.im.k.u, TiebaApplication.h().getString(R.string.send_error));
                }
                if (this.f != null) {
                    this.f.a(bArr);
                }
            } catch (CoderException e2) {
                by.a(0, 0, "socket", "MessageQueue: onBinaryMesssage decodeHeader error", "fail", e2.getErrorCode(), null, 0L, bArr.length, null);
            }
        }
    }

    private p a(int i, int i2) {
        if (i2 != 0) {
            p a = h.a(i2, this.b);
            if (a != null || (a = h.a(i2, this.d)) != null || (a = h.a(i2, this.c)) != null) {
                p pVar = a;
                by.a(i, i2, null, "MessageQueue: receive ack message", null, 0, null);
                return pVar;
            }
            by.a(i, i2, "original message removed", "MessageQueue: not dispatchMessage", null, 0, null);
            return a;
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

    public void b(com.baidu.tieba.im.message.q qVar) {
        h.a(qVar, this.c);
    }

    public void b(boolean z) {
        boolean z2 = this.g;
        this.g = z;
        if (!this.g && z2) {
            b();
        }
    }
}
