package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes2.dex */
public class k extends c {
    public bd threadData;
    public static String csT = "";
    public static String csU = "";
    public static String csV = "";
    public static String csW = "";
    public static String csX = "";
    public static String csY = "";
    public static String csZ = "";
    public static String cta = "";
    public static String ctb = "";
    public static String ctc = "";
    public static String ctd = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId cte = BdUniqueId.gen();
    public static final BdUniqueId ZI = BdUniqueId.gen();
    public static final BdUniqueId ZO = BdUniqueId.gen();
    public static final BdUniqueId ctf = BdUniqueId.gen();
    public boolean ctg = false;
    public boolean isLinkThread = false;
    public boolean cth = false;
    public boolean aEg = true;

    public static boolean N(bd bdVar) {
        if (bdVar == null) {
            return false;
        }
        return bdVar.getType() == bd.ZH || bdVar.getType() == bd.ZJ || bdVar.getType() == bd.ZI || bdVar.getType() == bd.ZO || bdVar.getType() == bd.ZQ;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.ctg) {
            return cte;
        }
        if (this.isLinkThread) {
            return ZI;
        }
        if (this.threadData.isShareThread) {
            return ZO;
        }
        if (this.threadData.getType() == bd.ZQ) {
            return ctf;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd Pb() {
        return this.threadData;
    }

    public boolean afR() {
        return (this.threadData == null || v.v(this.threadData.sd()) == 0) ? false : true;
    }

    public al afS() {
        bd Pb;
        if (this.ctg) {
            al alVar = new al("c11003");
            if (Pb() != null && (Pb = Pb()) != null) {
                alVar.ac("tid", Pb.getTid());
                if (Pb.rP() != null) {
                    alVar.r("ab_type", Pb.rP().hadConcerned() ? 1 : 0);
                }
            }
            return alVar;
        } else if (afR()) {
            al kD = kD(csY);
            if (kD != null && Pb() != null) {
                bd Pb2 = Pb();
                kD.r("obj_name", Pb2.tb() != null && (Pb2.tb().brZ() != null || Pb2.tb().JP() != null) ? 1 : 0);
                if (Pb2.rP() != null) {
                    kD.r("ab_type", Pb2.rP().hadConcerned() ? 1 : 0);
                }
            }
            return kD;
        } else {
            al kD2 = kD(csT);
            if (kD2 != null) {
                kD2.ac("ab_tag", afK()).ac("ab_action", "show");
                if (Pb() != null) {
                    bd Pb3 = Pb();
                    boolean z = (Pb3.tb() == null || (Pb3.tb().brZ() == null && Pb3.tb().JP() == null)) ? false : true;
                    kD2.r("obj_name", z ? 1 : 0);
                    if (z && Pb3.tb().brZ() != null && Pb3.tb().brZ().JH() != null && Pb3.tb().brZ().JH().size() > 0) {
                        kD2.r("obj_to", Pb3.tb().gyb ? 2 : 1);
                    }
                    if (Pb3.rP() != null) {
                        kD2.r("ab_type", Pb3.rP().hadConcerned() ? 1 : 0);
                    }
                }
            }
            return kD2;
        }
    }

    public al kF(String str) {
        al alVar = new al(str);
        if (alVar != null && this.threadData != null) {
            alVar.f(ImageViewerConfig.FORUM_ID, this.threadData.getFid());
            alVar.ac("tid", this.threadData.getTid());
            int i = 1;
            if (this.threadData.isLinkThread()) {
                i = 4;
            } else if (this.threadData.isShareThread) {
                i = 5;
            }
            alVar.r("obj_type", i);
            alVar.ac(VideoPlayActivityConfig.OBJ_ID, this.threadData.rP().getUserId());
        }
        return alVar;
    }

    public al kG(String str) {
        al kD = kD(str);
        if (kD != null) {
            kD.ac("ab_tag", afK()).ac("ab_action", "show");
            if (Pb() != null) {
                bd Pb = Pb();
                boolean z = (Pb.tb() == null || (Pb.tb().brZ() == null && Pb.tb().JP() == null)) ? false : true;
                kD.r("obj_name", z ? 1 : 0);
                if (z && Pb.tb().brZ() != null && Pb.tb().brZ().JH() != null && Pb.tb().brZ().JH().size() > 0) {
                    kD.r("obj_to", Pb.tb().gyb ? 2 : 1);
                }
            }
        }
        return kD;
    }

    public al kH(String str) {
        al kD = kD(str);
        if (kD != null) {
            kD.ac("ab_tag", afK()).ac("ab_action", "click");
        }
        return kD;
    }

    public al afT() {
        if (afR()) {
            return kD(csZ);
        }
        al kD = kD(csU);
        if (kD != null) {
            kD.ac("ab_tag", afK()).ac("ab_action", "click");
            return kD;
        }
        return kD;
    }

    public al afU() {
        if (afR()) {
            return kD(cta);
        }
        al U = U(csV, 0);
        if (U != null) {
            U.ac("ab_tag", afK()).ac("ab_action", "click");
            return U;
        }
        return U;
    }

    public al afV() {
        if (afR()) {
            return kD(ctb);
        }
        al kD = kD(csW);
        if (kD != null) {
            kD.ac("ab_tag", afK()).ac("ab_action", "click");
            return kD;
        }
        return kD;
    }

    public al afW() {
        if (afR()) {
            return kD(ctc);
        }
        al kD = kD(csX);
        if (kD != null) {
            kD.ac("ab_tag", afK()).ac("ab_action", "click");
            return kD;
        }
        return kD;
    }

    public al afX() {
        return kD(ctd);
    }

    public al kI(String str) {
        return kD(str);
    }

    public al kJ(String str) {
        al kD = kD(str);
        if (this.threadData != null && this.threadData.rP() != null) {
            kD.r("ab_type", this.threadData.rP().hadConcerned() ? 1 : 0);
        }
        return kD;
    }

    public al kK(String str) {
        return kD(str);
    }
}
