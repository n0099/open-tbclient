package com.baidu.tbadk.coreExtra.d;

import android.os.Build;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebSocketStateHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public final class q {
    private static q a = null;
    private int b;
    private com.baidu.adp.lib.network.websocket.c c = null;
    private int d = 0;
    private boolean e = false;
    private boolean f = false;
    private List<String> g = null;
    private boolean h = false;
    private com.baidu.tbadk.coreExtra.message.e i = null;
    private final com.baidu.adp.lib.network.websocket.c j = new r(this);

    public static synchronized q a() {
        q qVar;
        synchronized (q.class) {
            if (a == null) {
                a = new q();
            }
            qVar = a;
        }
        return qVar;
    }

    private q() {
        com.baidu.adp.framework.c.a().a(new s(this, 1001));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        f();
        com.baidu.adp.framework.e.c.a();
        com.baidu.adp.framework.e.c.a(true);
        com.baidu.adp.lib.util.f.b("【打开】了上线不成功消息拦截机制");
        NoNetworkView.a();
    }

    private static com.baidu.tbadk.coreExtra.message.e d() {
        com.baidu.tbadk.coreExtra.message.e eVar = new com.baidu.tbadk.coreExtra.message.e();
        eVar.a("_client_type", "2");
        eVar.a("_client_version", com.baidu.tbadk.core.data.n.c());
        if (TbadkApplication.j().C() != null) {
            eVar.a("_phone_imei", TbadkApplication.j().C());
        }
        String B = TbadkApplication.B();
        if (B != null) {
            eVar.a("_client_id", B);
        }
        String I = TbadkApplication.I();
        if (I != null && I.length() > 0) {
            eVar.a("from", I);
        }
        String str = new ak().a().a().a().j;
        if (str != null) {
            eVar.a("net_type", str);
        }
        String y = TbadkApplication.y();
        if (y != null) {
            eVar.a("cuid", y);
        }
        eVar.a("timestamp", Long.toString(System.currentTimeMillis()));
        eVar.a("model", Build.MODEL);
        eVar.a("_os_version", Build.VERSION.RELEASE);
        StringBuffer stringBuffer = new StringBuffer(15);
        stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.i.b(TbadkApplication.j().b())));
        stringBuffer.append(",");
        stringBuffer.append(String.valueOf(com.baidu.adp.lib.util.i.c(TbadkApplication.j().b())));
        eVar.a("_phone_screen", stringBuffer.toString());
        if (TbadkApplication.j().ai() > 0) {
            eVar.a("_msg_status", "0");
        } else {
            eVar.a("_msg_status", "1");
        }
        eVar.a("_pic_quality", String.valueOf(TbadkApplication.j().an()));
        try {
            if (TbadkApplication.F()) {
                com.baidu.tbadk.core.a.n a2 = com.baidu.tbadk.core.a.a.a(TbadkApplication.D());
                if (a2 != null) {
                    eVar.a(a2.a);
                } else {
                    eVar.a(TbadkApplication.D());
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("createUpdateClientInfoMessage getaccountdata error.");
        }
        int a3 = com.baidu.adp.lib.util.i.a(TbadkApplication.j().c(), 70.0f);
        eVar.f(com.baidu.adp.lib.util.i.a(TbadkApplication.j().c(), 70.0f));
        eVar.e(a3);
        if (com.baidu.tbadk.coreExtra.a.a.a().b()) {
            eVar.d(3);
        }
        eVar.a(com.baidu.tbadk.message.websockt.c.a().b());
        eVar.a("pversion", "1.0.3");
        return eVar;
    }

    private static String a(String str) {
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

    public final void b() {
        com.baidu.adp.framework.c.a().a(this.j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(q qVar) {
        a aVar;
        a aVar2;
        e eVar;
        com.baidu.adp.lib.util.f.b("【关闭】了上线不成功消息拦截机制，----online succ");
        WebSocketStateHelper.a(WebSocketStateHelper.WebSocketStateInfo.ONLINE);
        qVar.b = 0;
        qVar.f();
        aVar = d.a;
        aVar.a(x.a);
        aVar2 = d.a;
        aVar2.b();
        eVar = f.a;
        eVar.a(x.a);
        com.baidu.adp.framework.e.c.a();
        com.baidu.adp.framework.e.c.a(false);
        NoNetworkView.a();
        com.baidu.adp.framework.e.c.a();
        com.baidu.adp.framework.e.c.c("online succ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e() {
        com.baidu.adp.lib.util.f.d("start online");
        TiebaStatic.a(1001, 0, "on connect", "start online", null, 0, null);
        this.i = d();
        com.baidu.adp.framework.c.a().a(this.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        String str2;
        a aVar;
        a aVar2;
        a aVar3;
        if (i > 30) {
            c();
            return;
        }
        if (this.g != null && this.d >= 0 && this.d < this.g.size()) {
            aVar3 = d.a;
            str2 = aVar3.a().get(this.d);
        } else {
            str2 = null;
        }
        if (str2 == null) {
            aVar = d.a;
            if (!aVar.c()) {
                aVar2 = d.a;
                aVar2.a(new t(this, str, i));
            }
            c();
            return;
        }
        String a2 = a(str2);
        if (a2 == null) {
            c();
        } else {
            new i(a2, new u(this, str2, str, i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(q qVar, int i, int i2, String str) {
        e eVar;
        e eVar2;
        e eVar3;
        qVar.b++;
        if (qVar.b >= 5) {
            if (!qVar.h) {
                qVar.h = true;
                if (qVar.e) {
                    qVar.e = false;
                    eVar3 = f.a;
                    eVar3.b(x.a);
                }
                eVar = f.a;
                eVar.a();
                if (!UtilHelper.a()) {
                    eVar2 = f.a;
                    eVar2.a(0);
                    qVar.c();
                } else if (qVar.f) {
                    qVar.a("change ip to reconnect with DNS' failed.", 0);
                } else {
                    new i("www.baidu.com", new v(qVar));
                    qVar.f = true;
                }
            }
            WebSocketStateHelper.a(WebSocketStateHelper.WebSocketStateInfo.UNAVAIL);
        }
        com.baidu.adp.framework.e.c.a();
        com.baidu.adp.framework.e.c.a(8, "online error = " + i2);
    }

    private void f() {
        this.f = false;
        this.d = 0;
        this.h = false;
        this.e = false;
    }

    public final void a(com.baidu.adp.lib.network.websocket.c cVar) {
        this.c = cVar;
    }
}
