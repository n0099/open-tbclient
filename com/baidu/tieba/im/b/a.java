package com.baidu.tieba.im.b;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.util.BdUtilHelper;
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
import com.baidu.tieba.util.UtilHelper;
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
public final class a {
    private static a a = null;
    private int o;
    private boolean x;
    private long y;
    private long z;
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
    private boolean r = false;
    private int s = 0;
    private List<String> t = null;
    private final Handler u = new l((byte) 0);
    private final i v = new i(this, (byte) 0);
    private final com.baidu.tieba.im.net.a w = new b(this);
    private final com.baidu.tieba.im.a<com.baidu.tieba.im.db.d> A = new c(this);

    public final boolean a() {
        return this.o >= 5;
    }

    public final void b() {
        this.o++;
        if (!a() || this.p) {
            return;
        }
        this.p = true;
        if (this.q) {
            this.q = false;
            com.baidu.tieba.im.net.f.a().b(com.baidu.tieba.im.f.a);
        }
        com.baidu.tieba.im.net.f.a().b();
        if (UtilHelper.b()) {
            if (!this.r) {
                new com.baidu.tieba.im.net.h("www.baidu.com", new e(this));
                this.r = true;
                return;
            }
            a("change ip to reconnect with DNS' failed.", 0);
            return;
        }
        com.baidu.tieba.im.net.f.a().a(0);
        j();
    }

    public void a(String str, int i) {
        if (i > 30) {
            j();
            return;
        }
        String str2 = (this.t == null || this.s < 0 || this.s >= this.t.size()) ? null : com.baidu.tieba.im.net.b.a().c().get(this.s);
        if (str2 == null) {
            if (!com.baidu.tieba.im.net.b.a().e()) {
                com.baidu.tieba.im.net.b.a().a(new g(this, str, i));
            }
            j();
            return;
        }
        String a2 = a(str2);
        if (a2 == null) {
            j();
        } else {
            new com.baidu.tieba.im.net.h(a2, new h(this, str2, str, i));
        }
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

    public void j() {
        k();
        com.baidu.tieba.im.messageCenter.d.a().a(true);
        com.baidu.adp.lib.util.e.b("【打开】了上线不成功消息拦截机制");
        NoNetworkView.a();
    }

    private void k() {
        this.r = false;
        this.s = 0;
        this.p = false;
        this.q = false;
    }

    public static /* synthetic */ void p(a aVar) {
        com.baidu.adp.lib.util.e.b("【关闭】了上线不成功消息拦截机制");
        aVar.o = 0;
        aVar.k();
        com.baidu.tieba.im.net.b.a().a(com.baidu.tieba.im.f.a);
        com.baidu.tieba.im.net.b.a().d();
        com.baidu.tieba.im.net.f.a().a(com.baidu.tieba.im.f.a);
        com.baidu.tieba.im.messageCenter.d.a().a(false);
        NoNetworkView.a();
        TiebaSocketLinkService.c("online succ");
    }

    public static /* synthetic */ Map a(a aVar, s sVar) {
        boolean z;
        List<com.baidu.tieba.im.message.b> a2;
        if (sVar instanceof cj) {
            cj cjVar = (cj) sVar;
            StringBuilder sb = new StringBuilder(200);
            if (cjVar.l()) {
                Iterator<GroupMidData> it = aVar.h.iterator();
                while (it.hasNext()) {
                    GroupMidData next = it.next();
                    sb.append(next.getGroupId());
                    sb.append("-");
                    sb.append(next.getLastMsgId());
                    sb.append("|");
                }
                cb.a(202003, 0, aVar.i, "MessageSync-receive-pullmsg", "fail", cjVar.m(), cjVar.n(), System.currentTimeMillis() - aVar.g, 0, sb.toString());
                return null;
            } else if (cjVar.a() == null || cjVar.a().size() == 0) {
                cb.a(202003, 0, aVar.i, "MessageSync-receive-pullmsg", "succ-empty", cjVar.m(), cjVar.n(), System.currentTimeMillis() - aVar.g, 0, "");
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
                Iterator<GroupMidData> it2 = aVar.h.iterator();
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
                cb.a(202003, 0, aVar.i, "MessageSync-receive-pullmsg", "succ", cjVar.m(), cjVar.n(), System.currentTimeMillis() - aVar.g, 0, sb.toString());
                return hashMap;
            }
        }
        return null;
    }

    public void l() {
        if (this.f) {
            i();
            this.f = false;
        }
    }

    public static /* synthetic */ void a(a aVar, Map map) {
        ImMessageCenterPojo a2;
        com.baidu.tieba.im.db.d d = com.baidu.tieba.im.db.h.a().d();
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null && (a2 = d.a(String.valueOf(((Long) entry.getKey()).longValue()))) != null) {
                a2.setPulled_msgId(((Long) entry.getValue()).longValue());
            }
        }
        aVar.l();
    }

    public static /* synthetic */ void a(a aVar, int i, int i2, String str) {
        aVar.b();
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

    public final void a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("MessageSync init param illegal");
        }
        com.baidu.tieba.im.messageCenter.d.a().a(-11, this.v);
        com.baidu.tieba.im.messageCenter.d.a().a(this.w);
        com.baidu.tieba.im.messageCenter.d.a().a(1003, this.v);
        com.baidu.tieba.im.messageCenter.d.a().a(1001, this.v);
        com.baidu.tieba.im.messageCenter.d.a().a(202003, this.v);
        com.baidu.tieba.im.messageCenter.d.a().a(202101, this.v);
        d();
    }

    public final void d() {
        int[] aO = TiebaApplication.g().aO();
        if (aO.length == 2) {
            int i = aO[0] * LocationClientOption.MIN_SCAN_SPAN;
            if (i > 0) {
                this.c = i;
            }
            int i2 = aO[1] * LocationClientOption.MIN_SCAN_SPAN;
            if (i2 > 0) {
                this.b = i2;
            }
        }
    }

    public final void e() {
        this.f = false;
        n();
    }

    public final void f() {
        this.f = false;
        com.baidu.adp.lib.util.e.d("----msg sync stop");
        this.u.removeMessages(3);
        this.u.removeMessages(2);
    }

    public final void g() {
        com.baidu.adp.lib.util.e.d("----switchToForeground");
        this.e = this.c;
        if (this.k > 0) {
            i();
        }
    }

    public final void h() {
        com.baidu.adp.lib.util.e.d("----switchToBackground");
        this.l = System.currentTimeMillis();
        c().e = c().b;
    }

    public synchronized void m() {
        if (System.currentTimeMillis() - this.n >= 180000) {
            z zVar = new z();
            zVar.b(this.m);
            zVar.a(com.baidu.adp.lib.webSocket.l.a().g());
            zVar.b(com.baidu.adp.lib.webSocket.l.a().i());
            zVar.a(TiebaApplication.g().av());
            com.baidu.tieba.im.messageCenter.d.a().a(zVar);
            this.n = System.currentTimeMillis();
            this.m = 0;
            com.baidu.adp.lib.webSocket.l.a().h();
            com.baidu.adp.lib.webSocket.l.a().f();
            TiebaApplication.g().aw();
        }
    }

    public static /* synthetic */ t j(a aVar) {
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

    public final synchronized void a(long j, long j2, long j3) {
        this.m++;
        a(j, j2, false);
    }

    public final synchronized void i() {
        a(0L, 0L, true);
    }

    private synchronized void a(long j, long j2, boolean z) {
        if (TiebaApplication.w()) {
            this.x = z;
            this.y = j;
            this.z = j2;
            if (!z) {
                this.u.removeMessages(3);
                c().u.sendMessageDelayed(c().u.obtainMessage(3), c().e);
            }
            com.baidu.adp.lib.util.e.d("----begin pullMessageForNewRemind");
            this.A.a(com.baidu.tieba.im.db.h.a().d());
        }
    }

    private synchronized void n() {
        com.baidu.adp.lib.util.e.d("start online");
        cb.a(1001, 0, "on connect", "start online", null, 0, null);
        this.d = o();
        com.baidu.tieba.im.messageCenter.d.a().a(this.d, -3, 0, false);
    }

    private static df o() {
        df dfVar = new df();
        dfVar.a("_client_type", "2");
        dfVar.a("_client_version", com.baidu.tieba.data.i.u());
        if (TiebaApplication.g().k() != null) {
            dfVar.a("_phone_imei", TiebaApplication.g().k());
        }
        String E = TiebaApplication.E();
        if (E != null) {
            dfVar.a("_client_id", E);
        }
        String t = TiebaApplication.t();
        if (t != null && t.length() > 0) {
            dfVar.a("from", t);
        }
        String h = new ba().h();
        if (h != null) {
            dfVar.a("net_type", h);
        }
        String b = com.baidu.tieba.im.e.b();
        if (b != null) {
            dfVar.a(SocialConstants.PARAM_CUID, b);
        }
        dfVar.a("timestamp", Long.toString(System.currentTimeMillis()));
        dfVar.a("model", Build.MODEL);
        dfVar.a("_os_version", Build.VERSION.RELEASE);
        StringBuffer stringBuffer = new StringBuffer(15);
        stringBuffer.append(String.valueOf(BdUtilHelper.b(TiebaApplication.g().b())));
        stringBuffer.append(",");
        stringBuffer.append(String.valueOf(BdUtilHelper.c(TiebaApplication.g().b())));
        dfVar.a("_phone_screen", stringBuffer.toString());
        if (TiebaApplication.g().G() > 0) {
            dfVar.a("_msg_status", SocialConstants.FALSE);
        } else {
            dfVar.a("_msg_status", SocialConstants.TRUE);
        }
        dfVar.a("_pic_quality", String.valueOf(TiebaApplication.g().Y()));
        try {
            if (TiebaApplication.w()) {
                o a2 = com.baidu.tieba.account.a.a(TiebaApplication.x());
                if (a2 != null) {
                    dfVar.a(a2.a);
                } else {
                    dfVar.a(TiebaApplication.x());
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("createUpdateClientInfoMessage getaccountdata error.");
        }
        int a3 = BdUtilHelper.a(TiebaApplication.g().c(), 70.0f);
        dfVar.b(BdUtilHelper.a(TiebaApplication.g().c(), 70.0f));
        dfVar.a(a3);
        dfVar.a(com.baidu.tieba.im.coder.e.a().b());
        dfVar.a("pversion", "1.0.2");
        return dfVar;
    }
}
