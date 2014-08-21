package com.baidu.tieba.b;

import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.stats.q;
import com.baidu.adp.lib.util.BdNetUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
/* loaded from: classes.dex */
public class a {
    private q c;
    private final int d = 10;
    private final int e = 3000;
    public String a = null;
    public boolean b = false;

    public a(String str) {
        a(str, false);
    }

    public void a(String str, boolean z) {
        this.a = str;
        this.b = z;
        this.c = new q("dbg");
        b.a(str, d(), z);
    }

    public void a() {
        this.c.a();
    }

    public void a(boolean z, boolean z2, int i, String str, long j) {
        long b = this.c.b();
        long j2 = 0;
        long j3 = 0;
        if (z) {
            j2 = b;
        } else {
            j3 = b;
        }
        a(z, z2, i, str, j, j2, j3);
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e c;
        if (this.c != null && (c = c()) != null) {
            if (z) {
                if (c.d != null) {
                    c.d.b++;
                    if (z2) {
                        c.d.a += j2;
                        c.d.d += j;
                    } else {
                        c.d.c++;
                    }
                } else {
                    return;
                }
            } else if (c.e != null) {
                c.e.b++;
                if (z2) {
                    c.e.a += j3;
                    c.e.d += j;
                    j2 = j3;
                } else {
                    c.e.c++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.c = null;
            if (z2) {
                b.a(c, 10);
            }
            if (this.a == "frsStat") {
                if (!z2 || j2 > 3000) {
                    q qVar = new q("dbg");
                    qVar.a("act", "frs");
                    qVar.a("result", z2 ? "0" : TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
                    qVar.a("isHttp", z ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
                    qVar.a("timeCost", String.valueOf(j2));
                    qVar.a("errCode", String.valueOf(i));
                    qVar.a("errMsg", str);
                    qVar.a("down", String.valueOf(j));
                    f.c().a("frs", qVar);
                }
            }
        }
    }

    public void b() {
        e c;
        if (this.c != null && (c = c()) != null && c.f != null) {
            long b = this.c.b();
            if (b > 3000) {
                d dVar = c.f;
                dVar.a = b + dVar.a;
                c.f.b++;
                b.a(c, 10);
            }
        }
    }

    private e c() {
        return b.b(this.a, d(), this.b);
    }

    private String d() {
        BdNetUtil.NetworkStateInfo statusInfo = BdNetUtil.getStatusInfo();
        if (statusInfo == BdNetUtil.NetworkStateInfo.UNAVAIL) {
            return "N";
        }
        if (statusInfo == BdNetUtil.NetworkStateInfo.WIFI) {
            return NetworkChangeReceiver.WIFI_STRING;
        }
        if (statusInfo == BdNetUtil.NetworkStateInfo.ThreeG) {
            return "3G";
        }
        if (statusInfo != BdNetUtil.NetworkStateInfo.TwoG) {
            return "N";
        }
        return "2G";
    }
}
