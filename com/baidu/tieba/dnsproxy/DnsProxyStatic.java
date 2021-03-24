package com.baidu.tieba.dnsproxy;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.switchs.DnsProxySwitch;
import d.b.b.e.j.a.d;
import d.b.b.e.p.j;
import d.b.i0.e0.e;
import d.b.i0.e0.f;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
/* loaded from: classes4.dex */
public class DnsProxyStatic {

    /* renamed from: a  reason: collision with root package name */
    public static int f15307a;

    /* renamed from: b  reason: collision with root package name */
    public static int f15308b;

    /* loaded from: classes4.dex */
    public static class a extends d.b.b.e.j.a.a {
        @Override // d.b.b.e.j.a.a
        public String a(String str) {
            if (f.a().c(str)) {
                try {
                    return e.i().h(new URL(str).getHost(), f.a().b(str));
                } catch (MalformedURLException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }

        @Override // d.b.b.e.j.a.a
        public void c(d.b.b.e.j.a.e eVar) {
            if (eVar != null && j.z()) {
                d dVar = null;
                List<d> d2 = eVar.d();
                if (d2 != null && d2.size() > 0) {
                    dVar = d2.get(0);
                }
                if (dVar != null) {
                    if (!TextUtils.isEmpty(dVar.l)) {
                        DnsProxyStatic.e(eVar, dVar);
                    } else {
                        DnsProxyStatic.d(eVar, dVar);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SwitchManager.getInstance().findType(DnsProxySwitch.DNSPROXY_KEY) == 1) {
                    DnsProxyStatic.f();
                } else {
                    DnsProxyStatic.c();
                }
            }
        }

        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.b.b.e.m.e.a().postDelayed(new a(this), 1000L);
        }
    }

    static {
        MessageManager.getInstance().registerListener(new b(2007015));
    }

    public static final void c() {
        d.b.b.e.j.a.a.d(null);
        e.i().f();
    }

    public static final void d(d.b.b.e.j.a.e eVar, d dVar) {
        if (eVar == null || dVar == null) {
            return;
        }
        boolean z = eVar.c().f41797b >= 400;
        if (eVar.c().f41797b < 200) {
            z = true;
        }
        byte[] bArr = eVar.c().f41803h;
        if (bArr == null) {
            z = true;
        }
        if (bArr != null && bArr.length == 0) {
            z = true;
        }
        if (z) {
            try {
                URL url = new URL(eVar.b().i());
                d.b.b.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.b("workflow", "dnsproxy_unuse");
                statsItem.c("sucnum", Integer.valueOf(f15308b));
                statsItem.c("failnum", 1);
                statsItem.b("host", url.getHost());
                statsItem.b("reason", dVar.f41784h);
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                f15308b = 0;
                return;
            } catch (Throwable th) {
                BdLog.detailException(th);
                return;
            }
        }
        int i = f15308b + 1;
        f15308b = i;
        if (i >= 100) {
            g();
        }
    }

    public static final void e(d.b.b.e.j.a.e eVar, d dVar) {
        if (eVar == null || dVar == null) {
            return;
        }
        boolean z = eVar.c().f41797b >= 400;
        if (eVar.c().f41797b < 200) {
            z = true;
        }
        byte[] bArr = eVar.c().f41803h;
        if (bArr == null) {
            z = true;
        }
        if (bArr != null && bArr.length == 0) {
            z = true;
        }
        d.b.i0.e0.i.d.m().p(dVar.l, !z);
        if (z) {
            try {
                URL url = new URL(eVar.b().i());
                d.b.b.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.b("workflow", "dnsproxy_use");
                statsItem.c("sucnum", Integer.valueOf(f15307a));
                statsItem.c("failnum", 1);
                statsItem.b("host", url.getHost());
                statsItem.b("ip", dVar.l);
                statsItem.b("reason", dVar.f41784h);
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                f15307a = 0;
                return;
            } catch (Throwable th) {
                BdLog.detailException(th);
                return;
            }
        }
        int i = f15307a + 1;
        f15307a = i;
        if (i >= 100) {
            h();
        }
    }

    public static final void f() {
        d.b.b.e.j.a.a.d(new a());
        e.i().n();
    }

    public static final void g() {
        if (f15308b <= 0) {
            return;
        }
        try {
            d.b.b.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.b("workflow", "dnsproxy_unuse");
            statsItem.c("sucnum", Integer.valueOf(f15308b));
            BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
            f15308b = 0;
        } catch (Throwable th) {
            BdLog.detailException(th);
        }
    }

    public static final void h() {
        if (f15307a <= 0) {
            return;
        }
        try {
            d.b.b.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem.b("workflow", "dnsproxy_use");
            statsItem.c("sucnum", Integer.valueOf(f15307a));
            BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
            f15307a = 0;
        } catch (Throwable th) {
            BdLog.detailException(th);
        }
    }
}
