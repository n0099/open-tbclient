package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes3.dex */
public class l extends c implements com.baidu.tbadk.core.util.g.a {
    public static final BdUniqueId caR = BdUniqueId.gen();
    public static final BdUniqueId ePL = BdUniqueId.gen();
    public static final BdUniqueId ePM = BdUniqueId.gen();
    public static String ePu = "";
    public static String ePv = "";
    public static String ePN = "";
    public static String ePt = "";
    public static String ePO = "";
    public static String ePP = "";
    public static String ePQ = "";
    public boolean ePK = false;
    public boolean ePR = true;
    public boolean cap = false;
    public boolean ePS = false;
    public boolean cau = false;
    public boolean cav = false;
    public boolean ePJ = false;
    public int sourceType = 0;

    public l(bh bhVar) {
        this.caz = bhVar;
    }

    public static boolean V(bh bhVar) {
        return (bhVar == null || bhVar.aiV() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.caz == null) {
            return k.TYPE;
        }
        if (this.cap) {
            return k.ePy;
        }
        if (this.ePS) {
            return caR;
        }
        if (this.cau) {
            return k.ePF;
        }
        if (this.cav) {
            return k.ePE;
        }
        if (this.ePJ) {
            return k.ePD;
        }
        return caR;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bh agG() {
        if (this.caz == null) {
            return null;
        }
        if (this.caz.ais() != 5) {
            this.caz.hG(1);
        }
        return this.caz;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String agH() {
        if (this.caz == null) {
            return null;
        }
        return this.caz.ccP;
    }

    public an uF(String str) {
        an anVar = new an(str);
        if (this.caz != null) {
            anVar.p("fid", this.caz.getFid());
            anVar.bS("tid", this.caz.getTid());
            anVar.O("obj_type", 2);
            anVar.O("obj_param1", baJ() ? 2 : 1);
            if (this.caz.aiE() != null) {
                anVar.bS("obj_id", this.caz.aiE().getUserId());
            }
        }
        return anVar;
    }

    public an baP() {
        an ab = ab(ePN, true);
        if (ab != null && agG() != null) {
            bh agG = agG();
            ab.O("obj_name", agG.akb() != null && (agG.akb().cop() != null || agG.akb().azp() != null) ? 1 : 0);
            if (agG.aiE() != null) {
                ab.O(TiebaInitialize.Params.AB_TYPE, agG.aiE().hadConcerned() ? 1 : 0);
            }
        }
        return ab;
    }

    public an b(bh bhVar, int i) {
        if (bhVar.ajN() != null && bhVar.ajN().channelId > 0) {
            return ab(ePO, true);
        }
        an ab = ab(ePt, true);
        if (ab != null && i != -1) {
            ab.O("click_locate", i);
            return ab;
        }
        return ab;
    }

    public an X(bh bhVar) {
        return b(bhVar, -1);
    }

    public an baW() {
        return ab(ePQ, true);
    }

    public an baR() {
        return ab(ePv, true);
    }

    public an Y(bh bhVar) {
        return (bhVar.ajN() == null || bhVar.ajN().channelId <= 0) ? ab(ePu, true) : ab(ePP, true);
    }

    @Override // com.baidu.tbadk.core.util.g.a
    public String getVideoUrl() {
        if (this.caz == null || this.caz.aiV() == null || this.caz.aiV().video_url == null) {
            return null;
        }
        return this.caz.aiV().video_url;
    }
}
