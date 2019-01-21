package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes6.dex */
public class l extends c implements com.baidu.tbadk.core.util.e.a {
    public static final BdUniqueId dbL = BdUniqueId.gen();
    public static final BdUniqueId dbM = BdUniqueId.gen();
    public static String dbN = "";
    public static String dbO = "";
    public static String dbP = "";
    public static String dbQ = "";
    public static String dbR = "";
    public static String dbS = "";
    public static String dbT = "";
    public bb bNA;
    public boolean dbK = false;
    public boolean dbU = true;
    public int sourceType = 0;

    public l(bb bbVar) {
        this.bNA = bbVar;
    }

    public static boolean S(bb bbVar) {
        return (bbVar == null || bbVar.Al() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.bNA == null) {
            return dbL;
        }
        if (this.bNA.zW() || this.bNA.zX()) {
            return dbM;
        }
        return dbL;
    }

    @Override // com.baidu.tieba.card.data.c
    public bb aaq() {
        if (this.bNA == null) {
            return this.bNA;
        }
        if (this.bNA.zI() == 5) {
            return this.bNA;
        }
        this.bNA.setResource(1);
        return this.bNA;
    }

    public am nd(String str) {
        am amVar = new am(str);
        if (this.bNA != null) {
            amVar.i(ImageViewerConfig.FORUM_ID, this.bNA.getFid());
            amVar.aB("tid", this.bNA.getTid());
            amVar.y("obj_type", 2);
            amVar.y("obj_param1", arf() ? 2 : 1);
            if (this.bNA.zT() != null) {
                amVar.aB(VideoPlayActivityConfig.OBJ_ID, this.bNA.zT().getUserId());
            }
        }
        return amVar;
    }

    public am ark() {
        am y = y(dbP, true);
        if (y != null && aaq() != null) {
            bb aaq = aaq();
            y.y("obj_name", aaq.Bk() != null && (aaq.Bk().bEU() != null || aaq.Bk().SF() != null) ? 1 : 0);
            if (aaq.zT() != null) {
                y.y("ab_type", aaq.zT().hadConcerned() ? 1 : 0);
            }
        }
        return y;
    }

    public am a(bb bbVar, int i) {
        if (bbVar.AW() != null && bbVar.AW().channelId > 0) {
            return y(dbR, true);
        }
        am y = y(dbQ, true);
        if (y != null && i != -1) {
            y.y("click_locate", i);
            return y;
        }
        return y;
    }

    public am T(bb bbVar) {
        return a(bbVar, -1);
    }

    public am arq() {
        return y(dbT, true);
    }

    public am arm() {
        return y(dbO, true);
    }

    public am U(bb bbVar) {
        return (bbVar.AW() == null || bbVar.AW().channelId <= 0) ? y(dbN, true) : y(dbS, true);
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public String getVideoUrl() {
        if (this.bNA == null || this.bNA.Al() == null || this.bNA.Al().video_url == null) {
            return null;
        }
        return this.bNA.Al().video_url;
    }
}
