package com.baidu.tieba.im.messageCenter;

import android.os.Handler;
import com.baidu.adp.lib.webSocket.am;
import com.baidu.adp.lib.webSocket.an;
import com.baidu.tieba.im.codec.NetworkMessage;
import com.baidu.tieba.im.exception.IMCodecException;
import com.baidu.tieba.im.exception.IMException;
import com.baidu.tieba.im.message.AckedMessage;
import com.baidu.tieba.im.message.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements an {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f1654a = new Handler();
    private int b;
    private am c;
    private IMException d;
    private NetworkMessage e;
    private boolean f;
    private int g;
    private int h;
    private k j;
    private Runnable i = null;
    private boolean k = true;

    public s(Message message, boolean z, int i, int i2, int i3, k kVar, int i4) {
        this.b = 0;
        this.f = false;
        this.g = 0;
        this.h = 1;
        this.j = null;
        this.e = new NetworkMessage(message);
        this.g = i;
        this.h = i3;
        this.f = z;
        if (this.f) {
            AckedMessage.MessageTag messageTag = new AckedMessage.MessageTag();
            messageTag.setSequence(i2);
            this.e.setMsgTag(messageTag);
        }
        if (i4 > 0) {
            this.b = i4;
        } else {
            this.b = 45000;
        }
        this.j = kVar;
    }

    private void i() {
        if (this.j != null && this.k) {
            this.j.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.j != null && this.k) {
            this.j.a(this);
        }
    }

    private void k() {
        if (this.j != null && this.k) {
            this.j.c(this);
        }
    }

    private void l() {
        if (this.j != null && this.k) {
            this.j.d(this);
        }
    }

    private Runnable m() {
        if (this.i == null) {
            this.i = new t(this);
        }
        return this.i;
    }

    public am a() {
        if (this.c != null) {
            return this.c;
        }
        this.d = null;
        com.baidu.tieba.im.codec.c b = com.baidu.tieba.im.codec.c.b();
        try {
            this.c = new am(b.a(c(), this.h, b.a()), this);
        } catch (IMCodecException e) {
            this.d = e;
        }
        return this.c;
    }

    private void n() {
        f1654a.removeCallbacks(m());
    }

    public void b() {
        n();
        this.k = false;
    }

    @Override // com.baidu.adp.lib.webSocket.an
    public void a(am amVar) {
        com.baidu.tieba.util.o.a(g() != null ? g().getCmd() : 0, (this.e == null || this.e.getMsgTag() == null) ? 0 : this.e.getMsgTag().getSequence(), "socket", "SenderData: start send", null, 0, null, 0L, (this.c == null || this.c.c() == null) ? 0 : this.c.c().length, null);
        f1654a.removeCallbacks(m());
        f1654a.postDelayed(m(), this.b);
        l();
    }

    @Override // com.baidu.adp.lib.webSocket.an
    public void b(am amVar) {
        f1654a.removeCallbacks(m());
        i();
    }

    @Override // com.baidu.adp.lib.webSocket.an
    public void c(am amVar) {
        com.baidu.tieba.util.o.a(g() != null ? g().getCmd() : 0, (this.e == null || this.e.getMsgTag() == null) ? 0 : this.e.getMsgTag().getSequence(), "socket", "SenderData: finish send", null, 0, null, 0L, (this.c == null || this.c.c() == null) ? 0 : this.c.c().length, null);
        if (!this.f) {
            f1654a.removeCallbacks(m());
        }
        k();
    }

    public NetworkMessage c() {
        return this.e;
    }

    public am d() {
        return this.c;
    }

    public IMException e() {
        return this.d;
    }

    public boolean f() {
        return this.f;
    }

    public Message g() {
        if (this.e == null) {
            return null;
        }
        return this.e.getData();
    }

    public int h() {
        return this.g;
    }
}
