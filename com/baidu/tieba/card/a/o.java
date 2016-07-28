package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
public class o extends c {
    public be aWa;
    public static final BdUniqueId aWx = BdUniqueId.gen();
    public static final BdUniqueId aWy = BdUniqueId.gen();
    public static String aWz = "";
    public static String aWA = "";
    public static String aWB = "";
    public static String aWC = "";
    public static String aWD = "";
    public boolean aWs = false;
    public boolean aWE = true;

    public o(be beVar) {
        this.aWa = beVar;
    }

    public static boolean c(be beVar) {
        return (beVar == null || beVar.qM() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.aWa == null) {
            return aWx;
        }
        if (this.aWa.qy() || this.aWa.qz()) {
            return aWy;
        }
        return aWx;
    }

    @Override // com.baidu.tieba.card.a.c
    public be Iw() {
        return this.aWa;
    }

    public ay Lu() {
        return hh(aWC);
    }

    public ay Lv() {
        return hh(aWD);
    }

    public ay Lw() {
        return hh(aWA);
    }

    public ay Lx() {
        return hh(aWz);
    }

    public ay LF() {
        return v(aWB, true);
    }
}
