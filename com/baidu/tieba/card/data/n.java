package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
/* loaded from: classes.dex */
public class n extends c {
    public bh threadData;
    public static String boh = "";
    public static String boi = "";
    public static String boj = "";
    public static String bok = "";
    public static String bol = "";
    public static String bom = "";
    public static String bon = "";
    public static String boo = "";
    public static String bop = "";
    public static String boq = "";
    public static String bor = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId bos = BdUniqueId.gen();
    public boolean bot = false;
    public boolean bou = false;
    public boolean auD = true;

    public static boolean n(bh bhVar) {
        if (bhVar == null) {
            return false;
        }
        return bhVar.getType() == bh.Sx || bhVar.getType() == bh.Sy;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.bot) {
            return bos;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bh Ji() {
        return this.threadData;
    }

    public boolean RO() {
        return (this.threadData == null || w.r(this.threadData.rK()) == 0) ? false : true;
    }

    public ar RP() {
        if (RO()) {
            return ik(bom);
        }
        ar ik = ik(boh);
        if (ik != null) {
            ik.ab("ab_tag", RB()).ab("ab_action", "show");
            return ik;
        }
        return ik;
    }

    public ar RQ() {
        if (RO()) {
            return ik(bon);
        }
        ar ik = ik(boi);
        if (ik != null) {
            ik.ab("ab_tag", RB()).ab("ab_action", "click");
            return ik;
        }
        return ik;
    }

    public ar RR() {
        if (RO()) {
            return ik(boo);
        }
        ar ik = ik(boj);
        if (ik != null) {
            ik.ab("ab_tag", RB()).ab("ab_action", "click");
            return ik;
        }
        return ik;
    }

    public ar RS() {
        if (RO()) {
            return ik(bop);
        }
        ar ik = ik(bok);
        if (ik != null) {
            ik.ab("ab_tag", RB()).ab("ab_action", "click");
            return ik;
        }
        return ik;
    }

    public ar RT() {
        if (RO()) {
            return ik(boq);
        }
        ar ik = ik(bol);
        if (ik != null) {
            ik.ab("ab_tag", RB()).ab("ab_action", "click");
            return ik;
        }
        return ik;
    }

    public ar RU() {
        return ik(bor);
    }
}
