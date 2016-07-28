package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
/* loaded from: classes.dex */
public class m extends c {
    public boolean aWr = false;
    public boolean aWs = false;
    public boolean asx = true;
    public be threadData;
    public static String aWf = "";
    public static String aWg = "";
    public static String aWh = "";
    public static String aWi = "";
    public static String aWj = "";
    public static String aWk = "";
    public static String aWl = "";
    public static String aWm = "";
    public static String aWn = "";
    public static String aWo = "";
    public static String aWp = "";
    public static final BdUniqueId OB = BdUniqueId.gen();
    public static final BdUniqueId aWq = BdUniqueId.gen();

    public static boolean c(be beVar) {
        if (beVar == null) {
            return false;
        }
        return beVar.getType() == be.TYPE_NORMAL || beVar.getType() == be.QB;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return OB;
        }
        if (this.aWr) {
            return aWq;
        }
        return OB;
    }

    @Override // com.baidu.tieba.card.a.c
    public be Iw() {
        return this.threadData;
    }

    public boolean Lt() {
        return (this.threadData == null || y.s(this.threadData.qJ()) == 0) ? false : true;
    }

    public ay Lu() {
        if (Lt()) {
            return hh(aWk);
        }
        ay hh = hh(aWf);
        if (hh != null) {
            hh.ab("ab_tag", Li()).ab("ab_action", "show");
            return hh;
        }
        return hh;
    }

    public ay Lv() {
        if (Lt()) {
            return hh(aWl);
        }
        ay hh = hh(aWg);
        if (hh != null) {
            hh.ab("ab_tag", Li()).ab("ab_action", "click");
            return hh;
        }
        return hh;
    }

    public ay Lw() {
        if (Lt()) {
            return hh(aWm);
        }
        ay hh = hh(aWh);
        if (hh != null) {
            hh.ab("ab_tag", Li()).ab("ab_action", "click");
            return hh;
        }
        return hh;
    }

    public ay Lx() {
        if (Lt()) {
            return hh(aWn);
        }
        ay hh = hh(aWi);
        if (hh != null) {
            hh.ab("ab_tag", Li()).ab("ab_action", "click");
            return hh;
        }
        return hh;
    }

    public ay Ly() {
        if (Lt()) {
            return hh(aWo);
        }
        ay hh = hh(aWj);
        if (hh != null) {
            hh.ab("ab_tag", Li()).ab("ab_action", "click");
            return hh;
        }
        return hh;
    }

    public ay Lz() {
        return hh(aWp);
    }
}
