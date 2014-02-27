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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i implements com.baidu.tieba.im.net.a {
    private static /* synthetic */ int[] i;
    private com.baidu.tieba.im.a<l> a;
    private d e;
    private LinkedList<p> b = new LinkedList<>();
    private LinkedList<p> c = new LinkedList<>();
    private LinkedList<p> d = new LinkedList<>();
    private com.baidu.tieba.im.net.a f = null;
    private boolean g = true;
    private boolean h = false;

    private static /* synthetic */ int[] b() {
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

    public final void a(boolean z) {
        this.h = z;
    }

    public i(d dVar) {
        this.a = null;
        this.e = null;
        this.e = dVar;
        TiebaSocketLinkService.a(this);
        this.a = new j(this);
    }

    public final boolean a(s sVar) {
        if (sVar != null && (sVar instanceof b)) {
            b bVar = (b) sVar;
            if (h.a(this.c, bVar, sVar.w()) || h.a(this.b, bVar, sVar.w()) || h.a(this.d, bVar, sVar.w())) {
                return true;
            }
        }
        return false;
    }

    public final boolean a(int i2) {
        return h.a(this.c, i2) || h.a(this.b, i2) || h.a(this.d, i2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(s sVar, boolean z, int i2, boolean z2, int i3, boolean z3) {
        boolean z4;
        BdUtilHelper.b();
        if (sVar != null) {
            if (sVar != null && (sVar instanceof IDuplicateProcess)) {
                int w = sVar.w();
                IDuplicateProcess iDuplicateProcess = (IDuplicateProcess) sVar;
                switch (b()[iDuplicateProcess.c().ordinal()]) {
                    case 2:
                        if (h.a(this.c, iDuplicateProcess, w) || h.a(this.b, iDuplicateProcess, w) || h.a(this.d, iDuplicateProcess, w)) {
                            z4 = true;
                            break;
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
                if (!z4) {
                    cb.a("sandMessage", sVar.w(), sVar.v(), "duplicate remove", 0);
                    cb.a(sVar.w(), sVar.v(), "duplicate remove", "MessageQueue: Message throwed", null, 0, null);
                    return;
                }
                p pVar = new p(sVar, true, i2, false, this, i3, z3);
                if (this.h) {
                    cb.a("sandMessage", sVar.w(), sVar.v(), "MessageQueueManager.sendMessage:isOfflineBlock", 0);
                    cb.a(sVar.w(), sVar.v(), "can't send Message, beacuse of online error", "call onSendError", null, 0, null);
                    pVar.a(1);
                    return;
                }
                cb.a(TiebaApplication.g().b().getApplicationContext(), "send_msg_time", "send", 1, new Object[0]);
                cb.a(sVar.w(), sVar.v(), null, "MessageQueue: send Message", null, 0, null, 0L, 0, null);
                h.a(pVar, this.c);
                a();
                return;
            }
            z4 = false;
            if (!z4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(i iVar, l lVar) {
        if (lVar != null) {
            List<s> list = lVar.a;
            if (lVar.b != null) {
                iVar.a(lVar.b, com.baidu.tieba.im.g.s, TiebaApplication.g().b().getString(R.string.send_error));
            } else if (list == null || list.size() <= 0) {
            } else {
                s sVar = list.get(0);
                int w = sVar != null ? sVar.w() : 0;
                com.baidu.adp.lib.util.e.e("onReceiveCmd:" + w);
                cb.a(w, 0, "unpack succ", "MessageQueue: dispatchMessage", null, 0, null);
                if (iVar.e != null && list != null) {
                    iVar.e.a(list);
                }
                if ((sVar instanceof da) && ((da) sVar).m() == 110004) {
                    TiebaSocketLinkService.a(true, "be server kicked off");
                }
            }
        }
    }

    public final void a(p pVar) {
        String string = TiebaApplication.g().b().getString(R.string.timeout);
        if (pVar != null && pVar.m() && pVar.p() < 3) {
            h.a(this.b, this.d, pVar);
            m.a().a(true, "timeout seq = " + pVar.l());
            return;
        }
        c(pVar);
        a(pVar, com.baidu.tieba.im.g.m, string);
        a();
    }

    public final void a(int i2, p pVar) {
        int i3;
        String string;
        int i4;
        if (i2 == 2) {
            if (pVar.e() != null) {
                i4 = pVar.e().getErrorCode();
            } else {
                i4 = com.baidu.tieba.im.g.l;
            }
            i3 = i4;
            string = com.baidu.tieba.im.g.a(i4);
        } else {
            i3 = com.baidu.tieba.im.g.r;
            string = TiebaApplication.g().b().getString(R.string.send_error);
        }
        c(pVar);
        a(pVar, i3, string);
    }

    public final void b(p pVar) {
        if (pVar != null) {
            if (pVar.f()) {
                pVar.q();
                h.a(this.c, this.b, pVar);
                return;
            }
            h.b(pVar, this.c);
        }
    }

    private void a(p pVar, int i2, String str) {
        if (pVar != null && pVar.i() != null) {
            cb.a(pVar.i().w(), pVar.l(), "message send  error", "MessageQueue: onMessageSendFail", null, i2, str);
            s i3 = pVar.i();
            if (this.e == null || i3 == null) {
                return;
            }
            this.e.a(i3, i2, str);
        }
    }

    private void a() {
        LinkedList<p> linkedList = this.c;
        p peek = (linkedList == null || linkedList.size() <= 0) ? null : linkedList.peek();
        if (peek != null) {
            if (TiebaSocketLinkService.b()) {
                TiebaSocketLinkService.a(false, "send message");
            } else if (!this.g || peek.h() <= -3) {
                TiebaSocketLinkService.a(peek);
            }
        }
    }

    private void c(p pVar) {
        if (pVar != null) {
            pVar.d();
            h.b(pVar, this.b);
            h.b(pVar, this.c);
            h.b(pVar, this.d);
        }
    }

    private void a(LinkedList<p> linkedList) {
        while (true) {
            p poll = (linkedList == null || linkedList.size() <= 0) ? null : linkedList.poll();
            if (poll != null) {
                poll.d();
                a(poll, com.baidu.tieba.im.g.s, TiebaApplication.g().b().getString(R.string.send_error));
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.tieba.im.net.a
    public final boolean a(int i2, String str) {
        p pVar;
        if (this.f != null) {
            this.f.a(i2, str);
        }
        cb.a(0, 0, null, "MessageQueue: message Queue onClose", null, i2, str);
        m.a().b();
        if (!UtilHelper.b() || h.a(this.d) || h.a(this.c) || h.a(this.b) || this.h) {
            a(this.b);
            a(this.c);
            a(this.d);
            return false;
        }
        LinkedList<p> linkedList = this.b;
        if (linkedList != null) {
            Iterator<p> it = linkedList.iterator();
            while (it.hasNext()) {
                p next = it.next();
                if (next != null) {
                    next.a();
                }
            }
        }
        h.a(this.c, this.d);
        h.a(this.c, this.b);
        while (true) {
            LinkedList<p> linkedList2 = this.c;
            if (linkedList2 != null) {
                Iterator<p> it2 = linkedList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        pVar = null;
                        break;
                    }
                    pVar = it2.next();
                    if (pVar != null && !pVar.m()) {
                        it2.remove();
                        break;
                    }
                }
            } else {
                pVar = null;
            }
            if (pVar == null) {
                break;
            }
            pVar.d();
            a(pVar, com.baidu.tieba.im.g.s, TiebaApplication.g().b().getString(R.string.send_error));
        }
        LinkedList<p> linkedList3 = this.c;
        if ((linkedList3 == null ? 0 : linkedList3.size()) > 0) {
            cb.a("have retry message", "MessageQueue:reconnect", (String) null, 0, (String) null);
            TiebaSocketLinkService.a(false, "have retry message");
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.im.net.a
    public final void a(Map<String, String> map) {
        cb.a(0, 0, null, "MessageQueue: message Queue onConnected", null, 0, null);
        r.a().a(map);
        m.a().c();
        b(true);
        if (this.f != null) {
            this.f.a(map);
        }
    }

    @Override // com.baidu.tieba.im.net.a
    public final void a(byte[] bArr) {
        p pVar;
        p pVar2;
        if (bArr != null) {
            try {
                com.baidu.tieba.im.coder.c.a();
                com.baidu.tieba.im.coder.d a = com.baidu.tieba.im.coder.c.a(bArr);
                int c = a.a.c();
                int e = a.a.e();
                cb.a(c, e, "socket", "MessageQueue: onBinaryMesssage", "succ", 0, null, 0L, bArr.length, null);
                if (e != 0) {
                    p a2 = h.a(e, this.b);
                    if (a2 == null && (a2 = h.a(e, this.d)) == null) {
                        pVar2 = h.a(e, this.c);
                        if (pVar2 == null) {
                            cb.a(c, e, "original message removed", "MessageQueue: not dispatchMessage", null, 0, null);
                            pVar = pVar2;
                        }
                    } else {
                        pVar2 = a2;
                    }
                    cb.a(c, e, null, "MessageQueue: receive ack message", null, 0, null);
                    pVar = pVar2;
                } else {
                    pVar = null;
                }
                if (a.a.c() == 1003 && h.a(this.c, this.d)) {
                    cb.a(a.a.c(), a.a.e(), "ping succ", "MessageQueue: retry send", null, 0, null);
                    a();
                }
                m.a().c();
                if (e == 0 || (pVar != null && pVar.j() == c)) {
                    com.baidu.tieba.im.i.a(new k(a, pVar), this.a);
                } else if (pVar != null) {
                    a(pVar, com.baidu.tieba.im.g.u, TiebaApplication.g().b().getString(R.string.send_error));
                }
                if (this.f != null) {
                    this.f.a(bArr);
                }
            } catch (CoderException e2) {
                cb.a(0, 0, "socket", "MessageQueue: onBinaryMesssage decodeHeader error", "fail", e2.getErrorCode(), null, 0L, bArr.length, null);
            }
        }
    }

    @Override // com.baidu.tieba.im.net.a
    public final void a(com.baidu.adp.lib.webSocket.d dVar) {
        a();
        if (this.f != null) {
            this.f.a(dVar);
        }
    }

    @Override // com.baidu.tieba.im.net.a
    public final void a(String str) {
        if (this.f != null) {
            this.f.a(str);
        }
    }

    public final void a(com.baidu.tieba.im.net.a aVar) {
        this.f = aVar;
    }

    public final void b(s sVar) {
        LinkedList<p> linkedList = this.c;
        if (sVar != null && linkedList != null) {
            Iterator<p> it = linkedList.iterator();
            while (it.hasNext()) {
                p next = it.next();
                if (next != null && next.i() == sVar) {
                    linkedList.remove(next);
                    return;
                }
            }
        }
    }

    public final void b(boolean z) {
        boolean z2 = this.g;
        this.g = z;
        if (!this.g && z2) {
            a();
        }
    }
}
