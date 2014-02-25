package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.coder.CoderException;
import com.baidu.tieba.im.message.da;
import com.baidu.tieba.im.message.s;
import com.baidu.tieba.im.messageCenter.IDuplicateProcess;
import com.baidu.tieba.im.net.TiebaSocketLinkService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.cb;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.im.net.a {
    private static /* synthetic */ int[] i;
    private com.baidu.tieba.im.a<l> a;
    private e e;
    private LinkedList<p> b = new LinkedList<>();
    private LinkedList<p> c = new LinkedList<>();
    private LinkedList<p> d = new LinkedList<>();
    private com.baidu.tieba.im.net.a f = null;
    private boolean g = true;
    private boolean h = false;

    static /* synthetic */ int[] b() {
        int[] iArr = i;
        if (iArr == null) {
            iArr = new int[IDuplicateProcess.RemoveState.valuesCustom().length];
            try {
                iArr[IDuplicateProcess.RemoveState.NOT_REMOVE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[IDuplicateProcess.RemoveState.REMOVE_ALL.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[IDuplicateProcess.RemoveState.REMOVE_ME.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[IDuplicateProcess.RemoveState.REMOVE_WAITINGS.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            i = iArr;
        }
        return iArr;
    }

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

    public boolean a(s sVar) {
        if (sVar != null && (sVar instanceof c)) {
            c cVar = (c) sVar;
            if (h.a(this.c, cVar, sVar.w()) || h.a(this.b, cVar, sVar.w()) || h.a(this.d, cVar, sVar.w())) {
                return true;
            }
        }
        return false;
    }

    public boolean a(int i2) {
        return h.a(this.c, i2) || h.a(this.b, i2) || h.a(this.d, i2);
    }

    public void a(s sVar, boolean z, int i2, boolean z2, int i3, boolean z3) {
        BdUtilHelper.b();
        if (sVar != null) {
            if (c(sVar)) {
                cb.a("sandMessage", sVar.w(), sVar.v(), "duplicate remove", 0);
                cb.a(sVar.w(), sVar.v(), "duplicate remove", "MessageQueue: Message throwed", null, 0, null);
                return;
            }
            p pVar = new p(sVar, z, i2, z2, this, i3, z3);
            if (this.h) {
                cb.a("sandMessage", sVar.w(), sVar.v(), "MessageQueueManager.sendMessage:isOfflineBlock", 0);
                cb.a(sVar.w(), sVar.v(), "can't send Message, beacuse of online error", "call onSendError", null, 0, null);
                pVar.a(1);
                return;
            }
            cb.a(TiebaApplication.g().b().getApplicationContext(), "send_msg_time", "send", 1, new Object[0]);
            cb.a(sVar.w(), sVar.v(), null, "MessageQueue: send Message", null, 0, null, 0L, 0, null);
            h.a(pVar, this.c);
            c();
        }
    }

    private boolean c(s sVar) {
        if (sVar != null && (sVar instanceof IDuplicateProcess)) {
            int w = sVar.w();
            IDuplicateProcess iDuplicateProcess = (IDuplicateProcess) sVar;
            switch (b()[iDuplicateProcess.h().ordinal()]) {
                case 2:
                    if (h.a(this.c, iDuplicateProcess, w) || h.a(this.b, iDuplicateProcess, w) || h.a(this.d, iDuplicateProcess, w)) {
                        return true;
                    }
                    break;
                case 3:
                    h.b(this.c, iDuplicateProcess, w);
                    break;
                case 4:
                    h.b(this.c, iDuplicateProcess, w);
                    h.b(this.b, iDuplicateProcess, w);
                    h.b(this.d, iDuplicateProcess, w);
                    break;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar) {
        if (lVar != null) {
            List<s> list = lVar.a;
            if (lVar.b != null) {
                a(lVar.b, com.baidu.tieba.im.h.s, TiebaApplication.g().b().getString(R.string.send_error));
            } else if (list != null && list.size() >= 1) {
                s sVar = list.get(0);
                int w = sVar != null ? sVar.w() : 0;
                com.baidu.adp.lib.util.f.e("onReceiveCmd:" + w);
                cb.a(w, 0, "unpack succ", "MessageQueue: dispatchMessage", null, 0, null);
                a(list);
                if ((sVar instanceof da) && ((da) sVar).m() == 110004) {
                    TiebaSocketLinkService.a(true, "be server kicked off");
                }
            }
        }
    }

    public void a(p pVar) {
        String string = TiebaApplication.g().b().getString(R.string.timeout);
        if (pVar != null && pVar.m() && pVar.p() < 3) {
            h.a(this.b, this.d, pVar);
            m.a().a(true, "timeout seq = " + pVar.k());
            return;
        }
        d(pVar);
        a(pVar, com.baidu.tieba.im.h.m, string);
        c();
    }

    public void a(int i2, p pVar) {
        int i3;
        String string;
        int i4;
        if (i2 == 2) {
            if (pVar.e() != null) {
                i4 = pVar.e().getErrorCode();
            } else {
                i4 = com.baidu.tieba.im.h.l;
            }
            i3 = i4;
            string = com.baidu.tieba.im.h.a(i4);
        } else {
            i3 = com.baidu.tieba.im.h.r;
            string = TiebaApplication.g().b().getString(R.string.send_error);
        }
        d(pVar);
        a(pVar, i3, string);
    }

    public void b(p pVar) {
    }

    public void c(p pVar) {
        if (pVar != null) {
            if (pVar.f()) {
                pVar.q();
                h.a(this.c, this.b, pVar);
                return;
            }
            h.b(pVar, this.c);
        }
    }

    protected void a(p pVar, int i2, String str) {
        if (pVar != null && pVar.i() != null) {
            cb.a(pVar.i().w(), pVar.k(), "message send  error", "MessageQueue: onMessageSendFail", null, i2, str);
            a(pVar.i(), i2, str);
        }
    }

    private void c() {
        p c = h.c(this.c);
        if (c != null) {
            if (TiebaSocketLinkService.b()) {
                TiebaSocketLinkService.a(false, "send message");
            } else if (!this.g || c.g() <= -3) {
                TiebaSocketLinkService.a(c);
            }
        }
    }

    private void a(s sVar, int i2, String str) {
        if (this.e != null && sVar != null) {
            this.e.a(sVar, i2, str);
        }
    }

    private void a(List<s> list) {
        if (this.e != null && list != null) {
            this.e.a(list);
        }
    }

    private void d(p pVar) {
        if (pVar != null) {
            pVar.b();
            h.b(pVar, this.b);
            h.b(pVar, this.c);
            h.b(pVar, this.d);
        }
    }

    private void a(LinkedList<p> linkedList) {
        while (true) {
            p d = h.d(linkedList);
            if (d != null) {
                d.b();
                a(d, com.baidu.tieba.im.h.s, TiebaApplication.g().b().getString(R.string.send_error));
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
    public boolean a(int i2, String str) {
        if (this.f != null) {
            this.f.a(i2, str);
        }
        cb.a(0, 0, null, "MessageQueue: message Queue onClose", null, i2, str);
        m.a().b();
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
            b.b();
            a(b, com.baidu.tieba.im.h.s, TiebaApplication.g().b().getString(R.string.send_error));
        }
        if (h.a(this.c) > 0) {
            cb.a("have retry message", "MessageQueue:reconnect", (String) null, 0, (String) null);
            TiebaSocketLinkService.a(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.im.net.a
    public void a(Map<String, String> map) {
        cb.a(0, 0, null, "MessageQueue: message Queue onConnected", null, 0, null);
        r.a().a(map);
        m.a().c();
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
                cb.a(c, e, "socket", "MessageQueue: onBinaryMesssage", "succ", 0, null, 0L, bArr.length, null);
                p a2 = a(c, e);
                if (a.a.c() == 1003 && h.a(this.c, this.d)) {
                    cb.a(a.a.c(), a.a.e(), "ping succ", "MessageQueue: retry send", null, 0, null);
                    c();
                }
                m.a().c();
                if (e == 0 || (a2 != null && a2.j() == c)) {
                    com.baidu.tieba.im.j.a(new k(a, a2), this.a);
                } else if (a2 != null) {
                    a(a2, com.baidu.tieba.im.h.u, TiebaApplication.g().b().getString(R.string.send_error));
                }
                if (this.f != null) {
                    this.f.a(bArr);
                }
            } catch (CoderException e2) {
                cb.a(0, 0, "socket", "MessageQueue: onBinaryMesssage decodeHeader error", "fail", e2.getErrorCode(), null, 0L, bArr.length, null);
            }
        }
    }

    private p a(int i2, int i3) {
        if (i3 != 0) {
            p a = h.a(i3, this.b);
            if (a != null || (a = h.a(i3, this.d)) != null || (a = h.a(i3, this.c)) != null) {
                p pVar = a;
                cb.a(i2, i3, null, "MessageQueue: receive ack message", null, 0, null);
                return pVar;
            }
            cb.a(i2, i3, "original message removed", "MessageQueue: not dispatchMessage", null, 0, null);
            return a;
        }
        return null;
    }

    @Override // com.baidu.tieba.im.net.a
    public void a(com.baidu.adp.lib.webSocket.d dVar) {
        c();
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

    public void b(s sVar) {
        h.a(sVar, this.c);
    }

    public void b(boolean z) {
        boolean z2 = this.g;
        this.g = z;
        if (!this.g && z2) {
            c();
        }
    }
}
