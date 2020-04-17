package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes8.dex */
public class l extends c implements com.baidu.tbadk.core.util.f.a {
    public static final BdUniqueId dqV = BdUniqueId.gen();
    public static final BdUniqueId gsQ = BdUniqueId.gen();
    public static final BdUniqueId gsR = BdUniqueId.gen();
    public static String gsu = "";
    public static String gsv = "";
    public static String gsS = "";
    public static String gst = "";
    public static String gsT = "";
    public static String gsU = "";
    public static String gsV = "";
    public boolean gsP = false;
    public boolean gsW = true;
    public boolean dqo = false;
    public boolean gsX = false;
    public boolean dqu = false;
    public boolean dqv = false;
    public boolean gsN = false;
    public boolean gsO = false;
    public int sourceType = 0;

    public l(bj bjVar) {
        this.dqA = bjVar;
    }

    public static boolean ab(bj bjVar) {
        return (bjVar == null || bjVar.aKV() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.dqA == null) {
            return k.TYPE;
        }
        if (this.dqo) {
            return k.gsA;
        }
        if (this.gsX) {
            return dqV;
        }
        if (this.dqu) {
            return k.gsJ;
        }
        if (this.dqv) {
            return k.gsI;
        }
        if (this.gsN) {
            return k.gsG;
        }
        if (this.gsO) {
            return k.gsH;
        }
        return dqV;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj aIw() {
        if (this.dqA == null) {
            return null;
        }
        if (this.dqA.aKs() != 5) {
            this.dqA.jP(1);
        }
        return this.dqA;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String aIx() {
        if (this.dqA == null) {
            return null;
        }
        return this.dqA.dsU;
    }

    public an BH(String str) {
        an anVar = new an(str);
        if (this.dqA != null) {
            anVar.t("fid", this.dqA.getFid());
            anVar.cI("tid", this.dqA.getTid());
            if (this.dqA.aJu()) {
                anVar.af("obj_type", 8);
            } else if (this.dqA.aMz()) {
                anVar.af("obj_type", 9);
            } else if (this.dqA.aJr()) {
                anVar.af("obj_type", 2);
            }
            anVar.af("obj_param1", bFm() ? 2 : 1);
            if (this.dqA.aKE() != null) {
                anVar.cI("obj_id", this.dqA.aKE().getUserId());
            }
        }
        return anVar;
    }

    public an bFs() {
        an al = al(gsS, true);
        if (al != null && aIw() != null) {
            bj aIw = aIw();
            al.af("obj_name", aIw.aMe() != null && (aIw.aMe().cWt() != null || aIw.aMe().bcp() != null) ? 1 : 0);
            if (aIw.aKE() != null) {
                al.af(TiebaInitialize.Params.AB_TYPE, aIw.aKE().hadConcerned() ? 1 : 0);
            }
            if (aIw.getBaijiahaoData() != null) {
                al.cI("obj_param4", aIw.getBaijiahaoData().oriUgcNid);
                al.cI("obj_param6", aIw.getBaijiahaoData().oriUgcVid);
            }
            al.af("obj_param5", af(aIw));
        }
        return al;
    }

    public an b(bj bjVar, int i) {
        an al = al(gst, true);
        if (al != null) {
            if (i != -1) {
                al.af("click_locate", i);
            }
            if (aIw() != null) {
                bj aIw = aIw();
                if (aIw.getBaijiahaoData() != null) {
                    al.cI("obj_param4", aIw.getBaijiahaoData().oriUgcNid);
                    al.cI("obj_param6", aIw.getBaijiahaoData().oriUgcVid);
                }
                al.af("obj_param5", af(aIw));
            }
        }
        return al;
    }

    public an ag(bj bjVar) {
        return b(bjVar, -1);
    }

    public an bFz() {
        an al = al(gsV, true);
        if (al != null && aIw() != null) {
            bj aIw = aIw();
            if (aIw.getBaijiahaoData() != null) {
                al.cI("obj_param4", aIw.getBaijiahaoData().oriUgcNid);
                al.cI("obj_param6", aIw.getBaijiahaoData().oriUgcVid);
            }
            al.af("obj_param5", af(aIw));
        }
        return al;
    }

    public an bFu() {
        an al = al(gsv, true);
        if (al != null && aIw() != null) {
            bj aIw = aIw();
            if (aIw.getBaijiahaoData() != null) {
                al.cI("obj_param4", aIw.getBaijiahaoData().oriUgcNid);
                al.cI("obj_param6", aIw.getBaijiahaoData().oriUgcVid);
            }
            al.af("obj_param5", af(aIw));
        }
        return al;
    }

    public an ah(bj bjVar) {
        an al = al(gsu, true);
        if (al != null && aIw() != null) {
            bj aIw = aIw();
            if (aIw.getBaijiahaoData() != null) {
                al.cI("obj_param4", aIw.getBaijiahaoData().oriUgcNid);
                al.cI("obj_param6", aIw.getBaijiahaoData().oriUgcVid);
            }
            al.af("obj_param5", af(aIw));
        }
        return al;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public String getVideoUrl() {
        if (this.dqA == null || this.dqA.aKV() == null || this.dqA.aKV().video_url == null) {
            return null;
        }
        return this.dqA.aKV().video_url;
    }

    public int af(bj bjVar) {
        if (bjVar == null) {
            return 1;
        }
        if (bjVar.aMz() || bjVar.aMy()) {
            return 2;
        }
        return (bjVar.aJt() || bjVar.aJu()) ? 3 : 1;
    }
}
