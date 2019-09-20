package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes3.dex */
public class l extends c implements com.baidu.tbadk.core.util.g.a {
    public static final BdUniqueId bKa = BdUniqueId.gen();
    public static final BdUniqueId eHX = BdUniqueId.gen();
    public static final BdUniqueId eHY = BdUniqueId.gen();
    public static String eHG = "";
    public static String eHH = "";
    public static String eHZ = "";
    public static String eHF = "";
    public static String eIa = "";
    public static String eIb = "";
    public static String eIc = "";
    public boolean eHW = false;
    public boolean eId = true;
    public boolean bJz = false;
    public boolean eIe = false;
    public boolean bJE = false;
    public boolean bJF = false;
    public boolean eHV = false;
    public int sourceType = 0;

    public l(bh bhVar) {
        this.threadData = bhVar;
    }

    public static boolean X(bh bhVar) {
        return (bhVar == null || bhVar.aeT() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return k.TYPE;
        }
        if (this.bJz) {
            return k.eHK;
        }
        if (this.eIe) {
            return bKa;
        }
        if (this.bJE) {
            return k.eHR;
        }
        if (this.bJF) {
            return k.eHQ;
        }
        if (this.eHV) {
            return k.eHP;
        }
        return bKa;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bh acC() {
        if (this.threadData == null) {
            return null;
        }
        if (this.threadData.aeq() != 5) {
            this.threadData.hi(1);
        }
        return this.threadData;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String acD() {
        if (this.threadData == null) {
            return null;
        }
        return this.threadData.bLX;
    }

    public an wd(String str) {
        an anVar = new an(str);
        if (this.threadData != null) {
            anVar.n("fid", this.threadData.getFid());
            anVar.bT("tid", this.threadData.getTid());
            anVar.P("obj_type", 2);
            anVar.P("obj_param1", baJ() ? 2 : 1);
            if (this.threadData.aeC() != null) {
                anVar.bT(VideoPlayActivityConfig.OBJ_ID, this.threadData.aeC().getUserId());
            }
        }
        return anVar;
    }

    public an baP() {
        an W = W(eHZ, true);
        if (W != null && acC() != null) {
            bh acC = acC();
            W.P("obj_name", acC.aga() != null && (acC.aga().cqB() != null || acC.aga().azi() != null) ? 1 : 0);
            if (acC.aeC() != null) {
                W.P("ab_type", acC.aeC().hadConcerned() ? 1 : 0);
            }
        }
        return W;
    }

    public an b(bh bhVar, int i) {
        if (bhVar.afM() != null && bhVar.afM().channelId > 0) {
            return W(eIa, true);
        }
        an W = W(eHF, true);
        if (W != null && i != -1) {
            W.P("click_locate", i);
            return W;
        }
        return W;
    }

    public an Z(bh bhVar) {
        return b(bhVar, -1);
    }

    public an baW() {
        return W(eIc, true);
    }

    public an baR() {
        return W(eHH, true);
    }

    public an aa(bh bhVar) {
        return (bhVar.afM() == null || bhVar.afM().channelId <= 0) ? W(eHG, true) : W(eIb, true);
    }

    @Override // com.baidu.tbadk.core.util.g.a
    public String getVideoUrl() {
        if (this.threadData == null || this.threadData.aeT() == null || this.threadData.aeT().video_url == null) {
            return null;
        }
        return this.threadData.aeT().video_url;
    }
}
