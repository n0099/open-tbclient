package com.baidu.tieba.im.messageCenter;

import android.os.Handler;
import com.baidu.tieba.im.exception.IMCodecException;
import com.baidu.tieba.im.exception.IMException;
import com.baidu.tieba.im.message.Message;
import java.security.InvalidParameterException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.lib.webSocket.d {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f1804a = new Handler();
    private int b;
    private IMException c;
    private boolean d;
    private Message e;
    private int g;
    private int h;
    private i j;
    private boolean n;
    private volatile int f = 0;
    private Runnable i = null;
    private boolean k = true;
    private int l = 0;
    private int m = 0;

    public p(Message message, boolean z, int i, int i2, i iVar, int i3, boolean z2) {
        this.b = 0;
        this.d = false;
        this.e = null;
        this.g = 0;
        this.h = 1;
        this.j = null;
        this.n = true;
        if (message == null) {
            throw new InvalidParameterException("SenderData msg null");
        }
        this.e = message;
        this.g = i;
        this.h = i2;
        this.d = z;
        this.b = i3;
        this.j = iVar;
        this.n = z2;
    }

    private void b(int i) {
        if (this.j != null && this.k) {
            this.j.a(i, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.j != null && this.k) {
            this.j.a(this);
        }
    }

    private void r() {
        if (this.j != null && this.k) {
            this.j.b(this);
        }
    }

    private void s() {
        if (this.j != null && this.k) {
            this.j.c(this);
        }
    }

    private Runnable t() {
        if (this.i == null) {
            this.i = new q(this);
        }
        return this.i;
    }

    public void e() {
        f1804a.removeCallbacks(t());
    }

    public void f() {
        e();
        this.k = false;
    }

    @Override // com.baidu.adp.lib.webSocket.aq
    public void c() {
        com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(this.e.getCmd(), this.f, "socket", "SenderData: start send", null, 0, null, 0L, b() != null ? b().length : 0, null));
        f1804a.removeCallbacks(t());
        if (this.b > 0) {
            f1804a.postDelayed(t(), this.b);
        } else {
            f1804a.postDelayed(t(), com.baidu.tieba.im.net.f.a().d());
        }
        s();
    }

    @Override // com.baidu.adp.lib.webSocket.aq
    public void a(int i) {
        f1804a.removeCallbacks(t());
        b(i);
    }

    @Override // com.baidu.adp.lib.webSocket.aq
    public void d() {
        com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(this.e.getCmd(), this.f, "socket", "SenderData: finish send", null, 0, null, 0L, b() != null ? b().length : 0, null));
        if (!this.d) {
            f1804a.removeCallbacks(t());
        }
        r();
    }

    public IMException g() {
        return this.c;
    }

    public boolean h() {
        return this.d;
    }

    public int i() {
        return this.g;
    }

    public Message j() {
        return this.e;
    }

    @Override // com.baidu.adp.lib.webSocket.d
    protected byte[] a() {
        this.c = null;
        com.baidu.tieba.im.b.c b = com.baidu.tieba.im.b.c.b();
        this.f = r.a().b();
        try {
            return b.a(this.e, this.f, this.h, b.a());
        } catch (IMCodecException e) {
            this.c = e;
            return null;
        }
    }

    public int k() {
        return this.f;
    }

    public boolean l() {
        return this.n;
    }

    public int m() {
        return this.m;
    }

    public int n() {
        int i = this.m + 1;
        this.m = i;
        return i;
    }

    public int o() {
        return this.l;
    }

    public int p() {
        int i = this.l + 1;
        this.l = i;
        return i;
    }
}
