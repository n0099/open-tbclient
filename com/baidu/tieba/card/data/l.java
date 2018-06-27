package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes2.dex */
public class l extends c {
    public static final BdUniqueId czH = BdUniqueId.gen();
    public static final BdUniqueId czI = BdUniqueId.gen();
    public static String czJ = "";
    public static String czK = "";
    public static String czL = "";
    public static String czM = "";
    public static String czN = "";
    public static String czO = "";
    public static String czP = "";
    public bc btc;
    public boolean czG = false;
    public boolean czQ = true;
    public int sourceType = 0;

    public l(bc bcVar) {
        this.btc = bcVar;
    }

    public static boolean P(bc bcVar) {
        return (bcVar == null || bcVar.vN() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.btc == null) {
            return czH;
        }
        if (this.btc.vz() || this.btc.vA()) {
            return czI;
        }
        return czH;
    }

    @Override // com.baidu.tieba.card.data.c
    public bc SV() {
        if (this.btc == null) {
            return this.btc;
        }
        if (this.btc.vl() == 5) {
            return this.btc;
        }
        this.btc.setResource(1);
        return this.btc;
    }

    public an lf(String str) {
        an anVar = new an(str);
        if (this.btc != null) {
            anVar.f(ImageViewerConfig.FORUM_ID, this.btc.getFid());
            anVar.ah("tid", this.btc.getTid());
            anVar.r("obj_type", 2);
            anVar.r("obj_param1", aiP() ? 2 : 1);
            if (this.btc.vw() != null) {
                anVar.ah(VideoPlayActivityConfig.OBJ_ID, this.btc.vw().getUserId());
            }
        }
        return anVar;
    }

    public an aiU() {
        an p = p(czM, true);
        if (p != null && SV() != null) {
            bc SV = SV();
            p.r("obj_name", SV.wI() != null && (SV.wI().bxE() != null || SV.wI().NH() != null) ? 1 : 0);
            if (SV.vw() != null) {
                p.r("ab_type", SV.vw().hadConcerned() ? 1 : 0);
            }
        }
        return p;
    }

    public an Q(bc bcVar) {
        return (bcVar.ww() == null || bcVar.ww().channelId <= 0) ? p(czN, true) : p(czO, true);
    }

    public an aiW() {
        return p(czK, true);
    }

    public an R(bc bcVar) {
        return (bcVar.ww() == null || bcVar.ww().channelId <= 0) ? p(czJ, true) : p(czP, true);
    }
}
