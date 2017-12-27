package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class l extends c {
    public be threadData;
    public static String cSo = "";
    public static String cSp = "";
    public static String cSq = "";
    public static String cSr = "";
    public static String cSs = "";
    public static String cSt = "";
    public static String cSu = "";
    public static String cSv = "";
    public static String cSw = "";
    public static String cSx = "";
    public static String cSy = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId cSz = BdUniqueId.gen();
    public static final BdUniqueId aNd = BdUniqueId.gen();
    public static final BdUniqueId aNj = BdUniqueId.gen();
    public boolean cSA = false;
    public boolean isLinkThread = false;
    public boolean cSB = false;
    public boolean brk = true;

    public static boolean J(be beVar) {
        if (beVar == null) {
            return false;
        }
        return beVar.getType() == be.aNc || beVar.getType() == be.aNe || beVar.getType() == be.aNd || beVar.getType() == be.aNj;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (this.threadData == null) {
            return TYPE;
        }
        if (this.cSA) {
            return cSz;
        }
        if (this.isLinkThread) {
            return aNd;
        }
        if (this.threadData.isShareThread) {
            return aNj;
        }
        return TYPE;
    }

    @Override // com.baidu.tieba.card.data.c
    public be VW() {
        return this.threadData;
    }

    public boolean ajS() {
        return (this.threadData == null || v.F(this.threadData.zm()) == 0) ? false : true;
    }

    public ak ajT() {
        be VW;
        if (this.cSA) {
            ak akVar = new ak("c11003");
            if (VW() != null && (VW = VW()) != null) {
                akVar.ab("tid", VW.getTid());
                if (VW.yX() != null) {
                    akVar.s("ab_type", VW.yX().hadConcerned() ? 1 : 0);
                }
            }
            return akVar;
        } else if (ajS()) {
            ak ka = ka(cSt);
            if (ka != null && VW() != null) {
                be VW2 = VW();
                ka.s("obj_name", VW2.Ao() != null && (VW2.Ao().bCo() != null || VW2.Ao().QV() != null) ? 1 : 0);
                if (VW2.yX() != null) {
                    ka.s("ab_type", VW2.yX().hadConcerned() ? 1 : 0);
                }
            }
            return ka;
        } else {
            ak ka2 = ka(cSo);
            if (ka2 != null) {
                ka2.ab("ab_tag", ajM()).ab("ab_action", "show");
                if (VW() != null) {
                    be VW3 = VW();
                    boolean z = (VW3.Ao() == null || (VW3.Ao().bCo() == null && VW3.Ao().QV() == null)) ? false : true;
                    ka2.s("obj_name", z ? 1 : 0);
                    if (z && VW3.Ao().bCo() != null && VW3.Ao().bCo().QN() != null && VW3.Ao().bCo().QN().size() > 0) {
                        ka2.s("obj_to", VW3.Ao().hjn ? 2 : 1);
                    }
                    if (VW3.yX() != null) {
                        ka2.s("ab_type", VW3.yX().hadConcerned() ? 1 : 0);
                    }
                }
            }
            return ka2;
        }
    }

    public ak kc(String str) {
        ak akVar = new ak(str);
        if (akVar != null && this.threadData != null) {
            akVar.f(ImageViewerConfig.FORUM_ID, this.threadData.getFid());
            akVar.ab("tid", this.threadData.getTid());
            int i = 1;
            if (this.threadData.isLinkThread()) {
                i = 4;
            } else if (this.threadData.isShareThread) {
                i = 5;
            }
            akVar.s("obj_type", i);
            akVar.ab("obj_id", this.threadData.yX().getUserId());
        }
        return akVar;
    }

    public ak kd(String str) {
        ak ka = ka(str);
        if (ka != null) {
            ka.ab("ab_tag", ajM()).ab("ab_action", "show");
            if (VW() != null) {
                be VW = VW();
                boolean z = (VW.Ao() == null || (VW.Ao().bCo() == null && VW.Ao().QV() == null)) ? false : true;
                ka.s("obj_name", z ? 1 : 0);
                if (z && VW.Ao().bCo() != null && VW.Ao().bCo().QN() != null && VW.Ao().bCo().QN().size() > 0) {
                    ka.s("obj_to", VW.Ao().hjn ? 2 : 1);
                }
            }
        }
        return ka;
    }

    public ak ke(String str) {
        ak ka = ka(str);
        if (ka != null) {
            ka.ab("ab_tag", ajM()).ab("ab_action", "click");
        }
        return ka;
    }

    public ak ajU() {
        if (ajS()) {
            return ka(cSu);
        }
        ak ka = ka(cSp);
        if (ka != null) {
            ka.ab("ab_tag", ajM()).ab("ab_action", "click");
            return ka;
        }
        return ka;
    }

    public ak ajV() {
        if (ajS()) {
            return ka(cSv);
        }
        ak U = U(cSq, 0);
        if (U != null) {
            U.ab("ab_tag", ajM()).ab("ab_action", "click");
            return U;
        }
        return U;
    }

    public ak ajW() {
        if (ajS()) {
            return ka(cSw);
        }
        ak ka = ka(cSr);
        if (ka != null) {
            ka.ab("ab_tag", ajM()).ab("ab_action", "click");
            return ka;
        }
        return ka;
    }

    public ak ajX() {
        if (ajS()) {
            return ka(cSx);
        }
        ak ka = ka(cSs);
        if (ka != null) {
            ka.ab("ab_tag", ajM()).ab("ab_action", "click");
            return ka;
        }
        return ka;
    }

    public ak ajY() {
        return ka(cSy);
    }

    public ak kf(String str) {
        return ka(str);
    }

    public ak kg(String str) {
        ak ka = ka(str);
        if (this.threadData != null && this.threadData.yX() != null) {
            ka.s("ab_type", this.threadData.yX().hadConcerned() ? 1 : 0);
        }
        return ka;
    }

    public ak kh(String str) {
        return ka(str);
    }
}
