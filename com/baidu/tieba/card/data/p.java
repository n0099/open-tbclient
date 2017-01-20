package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class p extends c {
    public bh aVi;
    public static final BdUniqueId boz = BdUniqueId.gen();
    public static final BdUniqueId boA = BdUniqueId.gen();
    public static String boB = "";
    public static String boC = "";
    public static String boD = "";
    public static String boE = "";
    public static String boF = "";
    public static String boG = "";
    public static String boH = "";
    public boolean bou = false;
    public boolean boI = true;
    public int sourceType = 0;

    public p(bh bhVar) {
        this.aVi = bhVar;
    }

    public static boolean n(bh bhVar) {
        return (bhVar == null || bhVar.rN() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.aVi == null) {
            return boz;
        }
        if (this.aVi.rz() || this.aVi.rA()) {
            return boA;
        }
        return boz;
    }

    @Override // com.baidu.tieba.card.data.c
    public bh Ji() {
        return this.aVi;
    }

    public ar RP() {
        return ik(boE);
    }

    public ar o(bh bhVar) {
        return (bhVar.sz() == null || bhVar.sz().channelId <= 0) ? ik(boF) : ik(boG);
    }

    public ar RR() {
        return ik(boC);
    }

    public ar p(bh bhVar) {
        return (bhVar.sz() == null || bhVar.sz().channelId <= 0) ? ik(boB) : ik(boH);
    }
}
