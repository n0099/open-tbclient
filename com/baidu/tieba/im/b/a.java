package com.baidu.tieba.im.b;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.baidu.adp.lib.webSocket.m;
import com.baidu.browser.webpool.BdWebPoolView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.location.LocationClientOption;
import com.baidu.loginshare.Token;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.h;
import com.baidu.tieba.im.chat.LocalViewSize;
import com.baidu.tieba.im.data.GroupMidData;
import com.baidu.tieba.im.db.ad;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.bn;
import com.baidu.tieba.im.message.cd;
import com.baidu.tieba.im.message.n;
import com.baidu.tieba.im.message.o;
import com.baidu.tieba.im.message.s;
import com.baidu.tieba.im.net.TiebaSocketLinkService;
import com.baidu.tieba.log.i;
import com.baidu.tieba.util.an;
import com.baidu.tieba.view.NoNetworkView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    private static a a = null;
    private int o;
    private boolean s;
    private long t;
    private long u;
    private int b = 900000;
    private int c = 360000;
    private cd d = null;
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
    private Handler p = new g(null);
    private e q = new e(this, null);
    private com.baidu.tieba.im.net.a r = new b(this);
    private com.baidu.tieba.im.a<ConcurrentHashMap<String, ImMessageCenterPojo>> v = new c(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int i(a aVar) {
        int i = aVar.k;
        aVar.k = i + 1;
        return i;
    }

    public boolean a() {
        return this.o >= 5;
    }

    private void i() {
        this.o++;
        if (a()) {
            com.baidu.tieba.im.messageCenter.e.a().a(true);
            com.baidu.adp.lib.h.e.a("【打开】了上线不成功消息拦截机制");
            NoNetworkView.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        com.baidu.adp.lib.h.e.a("【关闭】了上线不成功消息拦截机制");
        this.o = 0;
        com.baidu.tieba.im.messageCenter.e.a().a(false);
        NoNetworkView.a();
        TiebaSocketLinkService.b("online succ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<Long, Long> a(n nVar) {
        boolean z;
        List<com.baidu.tieba.im.message.b> a2;
        if (nVar instanceof bn) {
            bn bnVar = (bn) nVar;
            StringBuilder sb = new StringBuilder((int) BdWebPoolView.DELAYED_TIME);
            if (bnVar.i()) {
                Iterator<GroupMidData> it = this.h.iterator();
                while (it.hasNext()) {
                    GroupMidData next = it.next();
                    sb.append(next.getGroupId());
                    sb.append("-");
                    sb.append(next.getLastMsgId());
                    sb.append("|");
                }
                com.baidu.tieba.log.a.b(i.a(202003, 0, this.i, "MessageSync-receive-pullmsg", "fail", bnVar.j(), bnVar.k(), System.currentTimeMillis() - this.g, 0, sb.toString()));
                return null;
            } else if (bnVar.a() == null || bnVar.a().size() == 0) {
                com.baidu.tieba.log.a.b(i.a(202003, 0, this.i, "MessageSync-receive-pullmsg", "succ-empty", bnVar.j(), bnVar.k(), System.currentTimeMillis() - this.g, 0, ""));
                return null;
            } else {
                HashMap hashMap = new HashMap();
                for (com.baidu.tieba.im.data.c cVar : bnVar.a()) {
                    if (cVar != null) {
                        long groupId = cVar.a() != null ? cVar.a().getGroupId() : 0L;
                        long k = (cVar.b() == null || (a2 = cVar.b().a()) == null || a2.size() <= 0) ? 0L : a2.get(a2.size() - 1).k();
                        if (groupId > 0 && k > 0) {
                            hashMap.put(Long.valueOf(groupId), Long.valueOf(k));
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
                    Iterator<com.baidu.tieba.im.data.c> it3 = bnVar.a().iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            z = false;
                            break;
                        }
                        com.baidu.tieba.im.data.c next3 = it3.next();
                        if (next3 != null && next3.a() != null && next3.a().getGroupId() == next2.getGroupId() && next3.b() != null && next3.b().a() != null) {
                            z = true;
                            sb.append(next3.b().a().size());
                            break;
                        }
                    }
                    if (!z) {
                        sb.append(0);
                    }
                    sb.append("|");
                }
                com.baidu.tieba.log.a.b(i.a(202003, 0, this.i, "MessageSync-receive-pullmsg", "succ", bnVar.j(), bnVar.k(), System.currentTimeMillis() - this.g, 0, sb.toString()));
                return hashMap;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f) {
            h();
            this.f = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<Long, Long> map) {
        ad.a().a(new d(this, map));
    }

    private void l() {
        this.p.removeMessages(3);
        this.p.removeMessages(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, String str) {
        i();
        TiebaSocketLinkService.a(8, "online error = " + i2);
    }

    public static synchronized a b() {
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
        com.baidu.tieba.im.messageCenter.e.a().a(-11, this.q);
        com.baidu.tieba.im.messageCenter.e.a().a(this.r);
        com.baidu.tieba.im.messageCenter.e.a().a(1003, this.q);
        com.baidu.tieba.im.messageCenter.e.a().a(1001, this.q);
        com.baidu.tieba.im.messageCenter.e.a().a(202003, this.q);
        com.baidu.tieba.im.messageCenter.e.a().a(202101, this.q);
        c();
    }

    public void c() {
        int[] ba = TiebaApplication.h().ba();
        if (ba.length == 2) {
            a(ba[0] * LocationClientOption.MIN_SCAN_SPAN);
            b(ba[1] * LocationClientOption.MIN_SCAN_SPAN);
        }
    }

    public void d() {
        this.f = false;
        o();
    }

    public void e() {
        this.f = false;
        com.baidu.adp.lib.h.e.c("----msg sync stop");
        l();
    }

    public void f() {
        com.baidu.adp.lib.h.e.c("----switchToForeground");
        this.e = this.c;
        if (this.k > 0) {
            h();
        }
    }

    public void g() {
        com.baidu.adp.lib.h.e.c("----switchToBackground");
        this.l = System.currentTimeMillis();
        b().e = b().b;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (System.currentTimeMillis() - this.n >= 180000) {
            s sVar = new s();
            sVar.b(this.m);
            sVar.a(m.a().h());
            sVar.b(m.a().j());
            sVar.a(TiebaApplication.h().aF());
            com.baidu.tieba.im.messageCenter.e.a().a(sVar);
            this.n = System.currentTimeMillis();
            this.m = 0;
            m.a().i();
            m.a().g();
            TiebaApplication.h().aG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public o n() {
        o oVar = new o();
        oVar.a(new ArrayList());
        LocalViewSize.ImageSize d = LocalViewSize.a().d();
        if (d != null) {
            oVar.a(d.width);
            oVar.b(d.height);
        }
        LocalViewSize.ImageSize c = LocalViewSize.a().c();
        if (c != null) {
            oVar.d(c.height);
            oVar.c(c.width);
        }
        return oVar;
    }

    public synchronized void a(long j, long j2, long j3) {
        this.m++;
        a(j, j2, j3, false);
    }

    public synchronized void h() {
        a(0L, 0L, 0L, true);
    }

    private synchronized void a(long j, long j2, long j3, boolean z) {
        if (TiebaApplication.C()) {
            this.s = z;
            this.t = j;
            this.u = j2;
            if (!z) {
                this.p.removeMessages(3);
                b().p.sendMessageDelayed(b().p.obtainMessage(3), b().e);
            }
            com.baidu.adp.lib.h.e.c("----begin pullMessageForNewRemind");
            ad.a().a(this.v);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImMessageCenterPojo a(ConcurrentHashMap<String, ImMessageCenterPojo> concurrentHashMap, long j) {
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return null;
        }
        return concurrentHashMap.get(String.valueOf(j));
    }

    private synchronized void o() {
        com.baidu.adp.lib.h.e.c("start online");
        com.baidu.tieba.log.a.b(i.a(1001, 0, "on connect", "start online", null, 0, null));
        this.d = p();
        com.baidu.tieba.im.messageCenter.e.a().a(this.d, -3, 0, false);
    }

    private cd p() {
        cd cdVar = new cd();
        cdVar.a("_client_type", "2");
        cdVar.a("_client_version", h.j());
        if (TiebaApplication.h().q() != null) {
            cdVar.a("_phone_imei", TiebaApplication.h().q());
        }
        String L = TiebaApplication.L();
        if (L != null) {
            cdVar.a("_client_id", L);
        }
        String z = TiebaApplication.z();
        if (z != null && z.length() > 0) {
            cdVar.a("from", z);
        }
        String h = new an().h();
        if (h != null) {
            cdVar.a("net_type", h);
        }
        String p = TiebaApplication.h().p();
        if (p != null) {
            cdVar.a(SocialConstants.PARAM_CUID, p);
        }
        cdVar.a("timestamp", Long.toString(System.currentTimeMillis()));
        cdVar.a("model", Build.MODEL);
        cdVar.a("_os_version", Build.VERSION.RELEASE);
        StringBuffer stringBuffer = new StringBuffer(15);
        stringBuffer.append(String.valueOf(com.baidu.adp.lib.h.g.b(TiebaApplication.h())));
        stringBuffer.append(",");
        stringBuffer.append(String.valueOf(com.baidu.adp.lib.h.g.c(TiebaApplication.h())));
        cdVar.a("_phone_screen", stringBuffer.toString());
        if (TiebaApplication.h().N() > 0) {
            cdVar.a("_msg_status", SocialConstants.FALSE);
        } else {
            cdVar.a("_msg_status", SocialConstants.TRUE);
        }
        cdVar.a("_pic_quality", String.valueOf(TiebaApplication.h().ah()));
        if (TiebaApplication.C()) {
            Token a2 = com.baidu.tieba.account.a.a(TiebaApplication.E());
            if (a2 != null) {
                cdVar.a(a2.mBduss);
            } else {
                cdVar.a(TiebaApplication.E());
            }
        }
        int a3 = com.baidu.adp.lib.h.g.a((Context) TiebaApplication.a(), 70.0f);
        cdVar.b(com.baidu.adp.lib.h.g.a((Context) TiebaApplication.a(), 70.0f));
        cdVar.a(a3);
        cdVar.a(com.baidu.tieba.im.coder.e.a().b());
        cdVar.a("pversion", "1.0.0");
        return cdVar;
    }
}
