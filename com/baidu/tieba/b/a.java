package com.baidu.tieba.b;

import com.baidu.adp.lib.stats.f;
import com.baidu.adp.lib.stats.q;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
/* loaded from: classes.dex */
public class a {
    private q amY;
    private final int amZ = 10;
    private final int ana = 3000;
    public String anb = null;
    public boolean Gn = false;

    public a(String str) {
        t(str, false);
    }

    public void t(String str, boolean z) {
        this.anb = str;
        this.Gn = z;
        this.amY = new q("dbg");
        b.c(str, getNetType(), z);
    }

    public void start() {
        this.amY.eL();
    }

    public void a(boolean z, boolean z2, int i, String str, long j) {
        long eM = this.amY.eM();
        long j2 = 0;
        long j3 = 0;
        if (z) {
            j2 = eM;
        } else {
            j3 = eM;
        }
        a(z, z2, i, str, j, j2, j3);
    }

    public void a(boolean z, boolean z2, int i, String str, long j, long j2, long j3) {
        e AI;
        if (this.amY != null && (AI = AI()) != null) {
            if (z) {
                if (AI.anh != null) {
                    AI.anh.num++;
                    if (z2) {
                        AI.anh.and += j2;
                        AI.anh.size += j;
                    } else {
                        AI.anh.ane++;
                    }
                } else {
                    return;
                }
            } else if (AI.ani != null) {
                AI.ani.num++;
                if (z2) {
                    AI.ani.and += j3;
                    AI.ani.size += j;
                    j2 = j3;
                } else {
                    AI.ani.ane++;
                    j2 = j3;
                }
            } else {
                return;
            }
            this.amY = null;
            if (z2) {
                b.a(AI, 10);
            }
            if (this.anb == "frsStat") {
                if (!z2 || j2 > 3000) {
                    q qVar = new q("dbg");
                    qVar.n("act", "frs");
                    qVar.n("result", z2 ? "0" : "1");
                    qVar.n("isHttp", z ? "1" : "0");
                    qVar.n("timeCost", String.valueOf(j2));
                    qVar.n("errCode", String.valueOf(i));
                    qVar.n("errMsg", str);
                    qVar.n("down", String.valueOf(j));
                    f.er().a("frs", qVar);
                }
            }
        }
    }

    public void ya() {
        e AI;
        if (this.amY != null && (AI = AI()) != null && AI.anj != null) {
            long eM = this.amY.eM();
            if (eM > 3000) {
                d dVar = AI.anj;
                dVar.and = eM + dVar.and;
                AI.anj.num++;
                b.a(AI, 10);
            }
        }
    }

    private e AI() {
        return b.d(this.anb, getNetType(), this.Gn);
    }

    private String getNetType() {
        int fm = j.fm();
        if (fm == 0) {
            return "N";
        }
        if (fm == 1) {
            return NetworkChangeReceiver.WIFI_STRING;
        }
        if (fm == 3) {
            return "3G";
        }
        if (fm != 2) {
            return "N";
        }
        return "2G";
    }
}
