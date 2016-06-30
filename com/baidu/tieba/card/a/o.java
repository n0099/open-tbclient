package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
public class o extends c {
    public az aVc;
    public static final BdUniqueId aVz = BdUniqueId.gen();
    public static final BdUniqueId aVA = BdUniqueId.gen();
    public static String aVB = "";
    public static String aVC = "";
    public static String aVD = "";
    public static String aVE = "";
    public static String aVF = "";
    public boolean aVu = false;
    public boolean aVG = true;

    public o(az azVar) {
        this.aVc = azVar;
    }

    public static boolean c(az azVar) {
        return (azVar == null || azVar.qW() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.aVc == null) {
            return aVz;
        }
        if (this.aVc.qJ() || this.aVc.qK()) {
            return aVA;
        }
        return aVz;
    }

    @Override // com.baidu.tieba.card.a.c
    public az Ix() {
        return this.aVc;
    }

    public ay Lv() {
        return hh(aVE);
    }

    public ay Lw() {
        return hh(aVF);
    }

    public ay Lx() {
        return hh(aVC);
    }

    public ay Ly() {
        return hh(aVB);
    }

    public ay LG() {
        return v(aVD, true);
    }
}
