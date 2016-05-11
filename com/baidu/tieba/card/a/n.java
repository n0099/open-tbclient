package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes.dex */
public class n extends c {
    public static final BdUniqueId aSe = BdUniqueId.gen();
    public static final BdUniqueId aSf = BdUniqueId.gen();
    public static String aSg = "";
    public static String aSh = "";
    public static String aSi = "";
    public static String aSj = "";
    public static String aSk = "";
    public ax aRZ;
    public boolean aRY = false;
    public boolean aSl = true;

    public n(ax axVar) {
        this.aRZ = axVar;
    }

    public static boolean b(ax axVar) {
        return (axVar == null || axVar.ra() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.aRZ == null) {
            return aSe;
        }
        if (this.aRZ.qO()) {
            return aSf;
        }
        return aSe;
    }

    @Override // com.baidu.tieba.card.a.c
    public ax Kl() {
        return this.aRZ;
    }

    public aw Kw() {
        return hh(aSj);
    }

    public aw Kx() {
        return hh(aSk);
    }

    public aw Ky() {
        return hh(aSh);
    }

    public aw Kz() {
        return hh(aSg);
    }

    public aw KH() {
        return hh(aSi);
    }
}
