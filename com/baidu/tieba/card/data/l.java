package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.al;
/* loaded from: classes2.dex */
public class l extends c {
    public static final BdUniqueId csc = BdUniqueId.gen();
    public static final BdUniqueId csd = BdUniqueId.gen();
    public static String cse = "";
    public static String csf = "";
    public static String csg = "";
    public static String csh = "";
    public static String csi = "";
    public static String csj = "";
    public static String csk = "";
    public bd bji;
    public boolean csb = false;
    public boolean csl = true;
    public int sourceType = 0;

    public l(bd bdVar) {
        this.bji = bdVar;
    }

    public static boolean N(bd bdVar) {
        return (bdVar == null || bdVar.sh() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.bji == null) {
            return csc;
        }
        if (this.bji.rT() || this.bji.rU()) {
            return csd;
        }
        return csc;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd Pe() {
        return this.bji;
    }

    public al kC(String str) {
        al alVar = new al(str);
        if (this.bji != null) {
            alVar.f(ImageViewerConfig.FORUM_ID, this.bji.getFid());
            alVar.ac("tid", this.bji.getTid());
            alVar.r("obj_type", 2);
            if (this.bji.rQ() != null) {
                alVar.ac(VideoPlayActivityConfig.OBJ_ID, this.bji.rQ().getUserId());
            }
        }
        return alVar;
    }

    public al afS() {
        al p = p(csh, true);
        if (p != null && Pe() != null) {
            bd Pe = Pe();
            p.r("obj_name", Pe.tc() != null && (Pe.tc().bsb() != null || Pe.tc().JR() != null) ? 1 : 0);
            if (Pe.rQ() != null) {
                p.r("ab_type", Pe.rQ().hadConcerned() ? 1 : 0);
            }
        }
        return p;
    }

    public al O(bd bdVar) {
        return (bdVar.sQ() == null || bdVar.sQ().channelId <= 0) ? p(csi, true) : p(csj, true);
    }

    public al afU() {
        return p(csf, true);
    }

    public al P(bd bdVar) {
        return (bdVar.sQ() == null || bdVar.sQ().channelId <= 0) ? p(cse, true) : p(csk, true);
    }
}
