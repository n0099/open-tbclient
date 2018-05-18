package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.al;
/* loaded from: classes2.dex */
public class l extends c {
    public static final BdUniqueId cti = BdUniqueId.gen();
    public static final BdUniqueId ctj = BdUniqueId.gen();
    public static String ctk = "";
    public static String ctl = "";
    public static String ctm = "";
    public static String ctn = "";
    public static String cto = "";
    public static String ctp = "";
    public static String ctq = "";
    public bd bjy;
    public boolean cth = false;
    public boolean ctr = true;
    public int sourceType = 0;

    public l(bd bdVar) {
        this.bjy = bdVar;
    }

    public static boolean N(bd bdVar) {
        return (bdVar == null || bdVar.sg() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.bjy == null) {
            return cti;
        }
        if (this.bjy.rS() || this.bjy.rT()) {
            return ctj;
        }
        return cti;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd Pb() {
        return this.bjy;
    }

    public al kF(String str) {
        al alVar = new al(str);
        if (this.bjy != null) {
            alVar.f(ImageViewerConfig.FORUM_ID, this.bjy.getFid());
            alVar.ac("tid", this.bjy.getTid());
            alVar.r("obj_type", 2);
            if (this.bjy.rP() != null) {
                alVar.ac(VideoPlayActivityConfig.OBJ_ID, this.bjy.rP().getUserId());
            }
        }
        return alVar;
    }

    public al afS() {
        al p = p(ctn, true);
        if (p != null && Pb() != null) {
            bd Pb = Pb();
            p.r("obj_name", Pb.tb() != null && (Pb.tb().brZ() != null || Pb.tb().JP() != null) ? 1 : 0);
            if (Pb.rP() != null) {
                p.r("ab_type", Pb.rP().hadConcerned() ? 1 : 0);
            }
        }
        return p;
    }

    public al O(bd bdVar) {
        return (bdVar.sP() == null || bdVar.sP().channelId <= 0) ? p(cto, true) : p(ctp, true);
    }

    public al afU() {
        return p(ctl, true);
    }

    public al P(bd bdVar) {
        return (bdVar.sP() == null || bdVar.sP().channelId <= 0) ? p(ctk, true) : p(ctq, true);
    }
}
