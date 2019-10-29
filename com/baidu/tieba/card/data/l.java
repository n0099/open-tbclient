package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes3.dex */
public class l extends c implements com.baidu.tbadk.core.util.g.a {
    public static final BdUniqueId cbI = BdUniqueId.gen();
    public static final BdUniqueId eQC = BdUniqueId.gen();
    public static final BdUniqueId eQD = BdUniqueId.gen();
    public static String eQl = "";
    public static String eQm = "";
    public static String eQE = "";
    public static String eQk = "";
    public static String eQF = "";
    public static String eQG = "";
    public static String eQH = "";
    public boolean eQB = false;
    public boolean eQI = true;
    public boolean cbg = false;
    public boolean eQJ = false;
    public boolean cbl = false;
    public boolean cbm = false;
    public boolean eQA = false;
    public int sourceType = 0;

    public l(bh bhVar) {
        this.cbq = bhVar;
    }

    public static boolean V(bh bhVar) {
        return (bhVar == null || bhVar.aiX() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.cbq == null) {
            return k.TYPE;
        }
        if (this.cbg) {
            return k.eQp;
        }
        if (this.eQJ) {
            return cbI;
        }
        if (this.cbl) {
            return k.eQw;
        }
        if (this.cbm) {
            return k.eQv;
        }
        if (this.eQA) {
            return k.eQu;
        }
        return cbI;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bh agI() {
        if (this.cbq == null) {
            return null;
        }
        if (this.cbq.aiu() != 5) {
            this.cbq.hH(1);
        }
        return this.cbq;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String agJ() {
        if (this.cbq == null) {
            return null;
        }
        return this.cbq.cdG;
    }

    public an uF(String str) {
        an anVar = new an(str);
        if (this.cbq != null) {
            anVar.p("fid", this.cbq.getFid());
            anVar.bS("tid", this.cbq.getTid());
            anVar.O("obj_type", 2);
            anVar.O("obj_param1", baL() ? 2 : 1);
            if (this.cbq.aiG() != null) {
                anVar.bS("obj_id", this.cbq.aiG().getUserId());
            }
        }
        return anVar;
    }

    public an baR() {
        an ab = ab(eQE, true);
        if (ab != null && agI() != null) {
            bh agI = agI();
            ab.O("obj_name", agI.akd() != null && (agI.akd().cor() != null || agI.akd().azr() != null) ? 1 : 0);
            if (agI.aiG() != null) {
                ab.O(TiebaInitialize.Params.AB_TYPE, agI.aiG().hadConcerned() ? 1 : 0);
            }
        }
        return ab;
    }

    public an b(bh bhVar, int i) {
        if (bhVar.ajP() != null && bhVar.ajP().channelId > 0) {
            return ab(eQF, true);
        }
        an ab = ab(eQk, true);
        if (ab != null && i != -1) {
            ab.O("click_locate", i);
            return ab;
        }
        return ab;
    }

    public an X(bh bhVar) {
        return b(bhVar, -1);
    }

    public an baY() {
        return ab(eQH, true);
    }

    public an baT() {
        return ab(eQm, true);
    }

    public an Y(bh bhVar) {
        return (bhVar.ajP() == null || bhVar.ajP().channelId <= 0) ? ab(eQl, true) : ab(eQG, true);
    }

    @Override // com.baidu.tbadk.core.util.g.a
    public String getVideoUrl() {
        if (this.cbq == null || this.cbq.aiX() == null || this.cbq.aiX().video_url == null) {
            return null;
        }
        return this.cbq.aiX().video_url;
    }
}
