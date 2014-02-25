package com.baidu.tieba.im.b;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.webSocket.m;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.o;
import com.baidu.tieba.im.chat.LocalViewSize;
import com.baidu.tieba.im.data.GroupMidData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.cj;
import com.baidu.tieba.im.message.df;
import com.baidu.tieba.im.message.s;
import com.baidu.tieba.im.message.t;
import com.baidu.tieba.im.message.z;
import com.baidu.tieba.im.net.TiebaSocketLinkService;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.util.cb;
import com.baidu.tieba.view.NoNetworkView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private static a a = null;
    private int o;
    private boolean w;
    private long x;
    private long y;
    private int b = 900000;
    private int c = 360000;
    private df d = null;
    private int e = this.c;
    private boolean f = false;
    private long g = 0;
    private LinkedList<GroupMidData> h = new LinkedList<>();
    private String i = "";
    private long j = 0;
    private int k = 0;
    private long l = 0;
    private int m = 0;
    private long n = 0;
    private boolean p = false;
    private boolean q = false;
    private int r = 0;
    private List<String> s = null;
    private final Handler t = new l(null);
    private final i u = new i(this, null);
    private final com.baidu.tieba.im.net.a v = new b(this);
    private final com.baidu.tieba.im.a<com.baidu.tieba.im.db.d> z = new c(this);

    public boolean a() {
        return this.o >= 5;
    }

    public void b() {
        this.o++;
        if (a()) {
            j();
        }
    }

    private void j() {
        if (!this.p) {
            this.p = true;
            com.baidu.tieba.im.net.f.a().a("conn:fail to : " + com.baidu.tieba.im.g.a + " time: " + System.currentTimeMillis());
            if (!this.q) {
                new com.baidu.tieba.im.net.h("www.baidu.com", new e(this));
                this.q = true;
                return;
            }
            if (this.r > -1) {
                com.baidu.tieba.im.net.f.a().c();
            }
            a("change ip to reconnect with DNS' failed.", 0);
        }
    }

    public void a(String str, int i) {
        if (i > 30) {
            l();
            return;
        }
        int i2 = i + 1;
        String k = k();
        if (k == null) {
            if (!com.baidu.tieba.im.net.b.a().f()) {
                com.baidu.tieba.im.net.b.a().a(new g(this, str, i));
            }
            l();
            return;
        }
        String a2 = a(k);
        if (a2 == null) {
            l();
        } else {
            new com.baidu.tieba.im.net.h(a2, new h(this, k, str, i));
        }
    }

    private String k() {
        if (this.s == null || this.r <= -1 || this.r >= this.s.size()) {
            return null;
        }
        return com.baidu.tieba.im.net.b.a().d().get(this.r);
    }

    private String a(String str) {
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

    public void l() {
        com.baidu.tieba.im.net.f.a().b();
        this.q = false;
        this.r = 0;
        this.p = false;
        com.baidu.tieba.im.messageCenter.e.a().a(true);
        com.baidu.adp.lib.util.f.b("【打开】了上线不成功消息拦截机制");
        NoNetworkView.a();
    }

    public void m() {
        com.baidu.adp.lib.util.f.b("【关闭】了上线不成功消息拦截机制");
        this.o = 0;
        this.q = false;
        this.r = 0;
        this.p = false;
        com.baidu.tieba.im.net.b.a().a(com.baidu.tieba.im.g.a);
        com.baidu.tieba.im.net.b.a().e();
        com.baidu.tieba.im.net.f.a().a("conn:succ to : " + com.baidu.tieba.im.g.a + " time: " + System.currentTimeMillis());
        com.baidu.tieba.im.messageCenter.e.a().a(false);
        NoNetworkView.a();
        TiebaSocketLinkService.c("online succ");
    }

    public Map<Long, Long> a(s sVar) {
        boolean z;
        List<com.baidu.tieba.im.message.b> a2;
        if (sVar instanceof cj) {
            cj cjVar = (cj) sVar;
            StringBuilder sb = new StringBuilder(200);
            if (cjVar.l()) {
                Iterator<GroupMidData> it = this.h.iterator();
                while (it.hasNext()) {
                    GroupMidData next = it.next();
                    sb.append(next.getGroupId());
                    sb.append("-");
                    sb.append(next.getLastMsgId());
                    sb.append("|");
                }
                cb.a(202003, 0, this.i, "MessageSync-receive-pullmsg", "fail", cjVar.m(), cjVar.n(), System.currentTimeMillis() - this.g, 0, sb.toString());
                return null;
            } else if (cjVar.a() == null || cjVar.a().size() == 0) {
                cb.a(202003, 0, this.i, "MessageSync-receive-pullmsg", "succ-empty", cjVar.m(), cjVar.n(), System.currentTimeMillis() - this.g, 0, "");
                return null;
            } else {
                HashMap hashMap = new HashMap();
                for (com.baidu.tieba.im.data.c cVar : cjVar.a()) {
                    if (cVar != null) {
                        long groupId = cVar.a() != null ? cVar.a().getGroupId() : 0L;
                        long l = (cVar.b() == null || (a2 = cVar.b().a()) == null || a2.size() <= 0) ? 0L : a2.get(a2.size() - 1).l();
                        if (groupId > 0 && l > 0) {
                            hashMap.put(Long.valueOf(groupId), Long.valueOf(l));
                        }
                    }
                }
                Iterator<GroupMidData> it2 = this.h.iterator();
                while (it2.hasNext()) {
                    GroupMidData next2 = it2.next();
                    sb.append(next2.getGroupId());
                    sb.append("-");
                    sb.append(next2.getLastMsgId());
                    sb.append("-");
                    Iterator<com.baidu.tieba.im.data.c> it3 = cjVar.a().iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            z = false;
                            break;
                        }
                        com.baidu.tieba.im.data.c next3 = it3.next();
                        if (next3 != null && next3.a() != null && next3.a().getGroupId() == next2.getGroupId() && next3.b() != null && next3.b().a() != null) {
                            sb.append(next3.b().a().size());
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        sb.append(0);
                    }
                    sb.append("|");
                }
                cb.a(202003, 0, this.i, "MessageSync-receive-pullmsg", "succ", cjVar.m(), cjVar.n(), System.currentTimeMillis() - this.g, 0, sb.toString());
                return hashMap;
            }
        }
        return null;
    }

    public void n() {
        if (this.f) {
            i();
            this.f = false;
        }
    }

    public void a(Map<Long, Long> map) {
        ImMessageCenterPojo a2;
        com.baidu.tieba.im.db.d d = com.baidu.tieba.im.db.h.a().d();
        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null && (a2 = d.a(String.valueOf(entry.getKey().longValue()))) != null) {
                a2.setPulled_msgId(entry.getValue().longValue());
            }
        }
        n();
    }

    private void o() {
        this.t.removeMessages(3);
        this.t.removeMessages(2);
    }

    public void a(int i, int i2, String str) {
        b();
        TiebaSocketLinkService.a(8, "online error = " + i2);
    }

    public static synchronized a c() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public void a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        com.baidu.tieba.im.messageCenter.e.a().a(-11, this.u);
        com.baidu.tieba.im.messageCenter.e.a().a(this.v);
        com.baidu.tieba.im.messageCenter.e.a().a(1003, this.u);
        com.baidu.tieba.im.messageCenter.e.a().a(1001, this.u);
        com.baidu.tieba.im.messageCenter.e.a().a(202003, this.u);
        com.baidu.tieba.im.messageCenter.e.a().a(202101, this.u);
        d();
    }

    public void d() {
        int[] aW = TiebaApplication.g().aW();
        if (aW.length == 2) {
            a(aW[0] * LocationClientOption.MIN_SCAN_SPAN);
            b(aW[1] * LocationClientOption.MIN_SCAN_SPAN);
        }
    }

    public void e() {
        this.f = false;
        r();
    }

    public void f() {
        this.f = false;
        com.baidu.adp.lib.util.f.d("----msg sync stop");
        o();
    }

    public void g() {
        com.baidu.adp.lib.util.f.d("----switchToForeground");
        this.e = this.c;
        if (this.k > 0) {
            i();
        }
    }

    public void h() {
        com.baidu.adp.lib.util.f.d("----switchToBackground");
        this.l = System.currentTimeMillis();
        c().e = c().b;
    }

    public void a(int i) {
        if (i > 0) {
            this.c = i;
        }
    }

    public void b(int i) {
        if (i > 0) {
            this.b = i;
        }
    }

    public synchronized void p() {
        if (System.currentTimeMillis() - this.n >= 180000) {
            z zVar = new z();
            zVar.b(this.m);
            zVar.a(m.a().g());
            zVar.b(m.a().i());
            zVar.a(TiebaApplication.g().aC());
            com.baidu.tieba.im.messageCenter.e.a().a(zVar);
            this.n = System.currentTimeMillis();
            this.m = 0;
            m.a().h();
            m.a().f();
            TiebaApplication.g().aD();
        }
    }

    public t q() {
        t tVar = new t();
        tVar.a(new ArrayList());
        LocalViewSize.ImageSize d = LocalViewSize.a().d();
        if (d != null) {
            tVar.a(d.width);
            tVar.b(d.height);
        }
        LocalViewSize.ImageSize c = LocalViewSize.a().c();
        if (c != null) {
            tVar.d(c.height);
            tVar.c(c.width);
        }
        return tVar;
    }

    public synchronized void a(long j, long j2, long j3) {
        this.m++;
        a(j, j2, j3, false);
    }

    public synchronized void i() {
        a(0L, 0L, 0L, true);
    }

    private synchronized void a(long j, long j2, long j3, boolean z) {
        if (TiebaApplication.B()) {
            this.w = z;
            this.x = j;
            this.y = j2;
            if (!z) {
                this.t.removeMessages(3);
                c().t.sendMessageDelayed(c().t.obtainMessage(3), c().e);
            }
            com.baidu.adp.lib.util.f.d("----begin pullMessageForNewRemind");
            this.z.a(com.baidu.tieba.im.db.h.a().d());
        }
    }

    private synchronized void r() {
        com.baidu.adp.lib.util.f.d("start online");
        cb.a(1001, 0, "on connect", "start online", null, 0, null);
        this.d = s();
        com.baidu.tieba.im.messageCenter.e.a().a(this.d, -3, 0, false);
    }

    private df s() {
        df dfVar = new df();
        dfVar.a("_client_type", "2");
        dfVar.a("_client_version", com.baidu.tieba.data.i.u());
        if (TiebaApplication.g().p() != null) {
            dfVar.a("_phone_imei", TiebaApplication.g().p());
        }
        String K = TiebaApplication.K();
        if (K != null) {
            dfVar.a("_client_id", K);
        }
        String y = TiebaApplication.y();
        if (y != null && y.length() > 0) {
            dfVar.a("from", y);
        }
        String i = new ba().i();
        if (i != null) {
            dfVar.a("net_type", i);
        }
        String a2 = com.baidu.tieba.im.f.a();
        if (a2 != null) {
            dfVar.a(SocialConstants.PARAM_CUID, a2);
        }
        dfVar.a("timestamp", Long.toString(System.currentTimeMillis()));
        dfVar.a("model", Build.MODEL);
        dfVar.a("_os_version", Build.VERSION.RELEASE);
        StringBuffer stringBuffer = new StringBuffer(15);
        stringBuffer.append(String.valueOf(BdUtilHelper.b(TiebaApplication.g().b())));
        stringBuffer.append(",");
        stringBuffer.append(String.valueOf(BdUtilHelper.c(TiebaApplication.g().b())));
        dfVar.a("_phone_screen", stringBuffer.toString());
        if (TiebaApplication.g().M() > 0) {
            dfVar.a("_msg_status", SocialConstants.FALSE);
        } else {
            dfVar.a("_msg_status", SocialConstants.TRUE);
        }
        dfVar.a("_pic_quality", String.valueOf(TiebaApplication.g().af()));
        try {
            if (TiebaApplication.B()) {
                o a3 = com.baidu.tieba.account.a.a(TiebaApplication.D());
                if (a3 != null) {
                    dfVar.a(a3.a);
                } else {
                    dfVar.a(TiebaApplication.D());
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("createUpdateClientInfoMessage getaccountdata error.");
        }
        int a4 = BdUtilHelper.a(TiebaApplication.g().c(), 70.0f);
        dfVar.b(BdUtilHelper.a(TiebaApplication.g().c(), 70.0f));
        dfVar.a(a4);
        dfVar.a(com.baidu.tieba.im.coder.e.a().b());
        dfVar.a("pversion", "1.0.2");
        return dfVar;
    }
}
