package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class n extends c {
    public static final BdUniqueId cdK = BdUniqueId.gen();
    public static final BdUniqueId cdL = BdUniqueId.gen();
    public static String cdM = "";
    public static String cdN = "";
    public static String cdO = "";
    public static String cdP = "";
    public static String cdQ = "";
    public static String cdR = "";
    public static String cdS = "";
    public bd bjD;
    public boolean cdF = false;
    public boolean cdT = true;
    public int sourceType = 0;

    public n(bd bdVar) {
        this.bjD = bdVar;
    }

    public static boolean D(bd bdVar) {
        return (bdVar == null || bdVar.rP() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.bjD == null) {
            return cdK;
        }
        if (this.bjD.rB() || this.bjD.rC()) {
            return cdL;
        }
        return cdK;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd Ox() {
        return this.bjD;
    }

    public ak jY(String str) {
        ak akVar = new ak(str);
        if (this.bjD != null) {
            akVar.f(ImageViewerConfig.FORUM_ID, this.bjD.getFid());
            akVar.ac("tid", this.bjD.getTid());
            akVar.r("obj_type", 2);
            if (this.bjD.rx() != null) {
                akVar.ac("obj_id", this.bjD.rx().getUserId());
            }
        }
        return akVar;
    }

    public ak ace() {
        ak t = t(cdP, true);
        if (t != null && Ox() != null) {
            bd Ox = Ox();
            t.r("obj_name", Ox.sO() != null && (Ox.sO().bwr() != null || Ox.sO().Jy() != null) ? 1 : 0);
            if (Ox.rx() != null) {
                t.r("ab_type", Ox.rx().hadConcerned() ? 1 : 0);
            }
        }
        return t;
    }

    public ak E(bd bdVar) {
        return (bdVar.sC() == null || bdVar.sC().channelId <= 0) ? t(cdQ, true) : t(cdR, true);
    }

    public ak acg() {
        return t(cdN, true);
    }

    public ak F(bd bdVar) {
        return (bdVar.sC() == null || bdVar.sC().channelId <= 0) ? t(cdM, true) : t(cdS, true);
    }
}
