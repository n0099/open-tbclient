package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    private static r a = null;
    private int b;
    private int c = 0;
    private boolean d = false;
    private boolean e = false;
    private List<String> f = null;
    private boolean g = false;
    private final com.baidu.adp.lib.webSocket.l h = new s(this);

    public static synchronized r a() {
        r rVar;
        synchronized (r.class) {
            if (a == null) {
                synchronized (r.class) {
                    if (a == null) {
                        a = new r();
                    }
                }
            }
            rVar = a;
        }
        return rVar;
    }

    public void b() {
        com.baidu.adp.lib.webSocket.m.a().a(this.h);
    }

    public static String a(String str) {
        int lastIndexOf;
        if (str != null && (lastIndexOf = str.lastIndexOf(":")) >= 5) {
            try {
                return str.substring(5, lastIndexOf);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    private String c() {
        if (this.f == null || this.c <= -1 || this.c >= this.f.size()) {
            return null;
        }
        return a.a().d().get(this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        String c = c();
        if (c == null) {
            if (!a.a().f()) {
                a.a().a(new t(this, str));
            }
            com.baidu.adp.framework.client.socket.l.a(com.baidu.tbadk.h.a);
            BdSocketLinkService.setAvailable(false);
            d();
        } else if (a(c) == null) {
            d();
        } else {
            this.g = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.l.a(c);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.d = true;
            this.c++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        NoNetworkView.a();
        this.e = false;
        this.c = 0;
        this.g = false;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!this.g) {
            this.g = true;
            if (this.d) {
                this.d = false;
                f.a().a(com.baidu.tbadk.h.a);
            }
            f.a().b();
            if (!this.e) {
                new j("www.baidu.com", new u(this));
                this.e = true;
                return;
            }
            b("change ip to reconnect with DNS' failed.");
        }
    }
}
