package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes8.dex */
public class l extends c implements com.baidu.tbadk.core.util.f.a {
    public static final BdUniqueId dqZ = BdUniqueId.gen();
    public static final BdUniqueId gsW = BdUniqueId.gen();
    public static final BdUniqueId gsX = BdUniqueId.gen();
    public static String gsA = "";
    public static String gsB = "";
    public static String gsY = "";
    public static String gsz = "";
    public static String gsZ = "";
    public static String gta = "";
    public static String gtb = "";
    public boolean gsV = false;
    public boolean gtc = true;
    public boolean dqs = false;
    public boolean gtd = false;
    public boolean dqy = false;
    public boolean dqz = false;
    public boolean gsT = false;
    public boolean gsU = false;
    public int sourceType = 0;

    public l(bj bjVar) {
        this.dqE = bjVar;
    }

    public static boolean ab(bj bjVar) {
        return (bjVar == null || bjVar.aKT() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (this.dqE == null) {
            return k.TYPE;
        }
        if (this.dqs) {
            return k.gsG;
        }
        if (this.gtd) {
            return dqZ;
        }
        if (this.dqy) {
            return k.gsP;
        }
        if (this.dqz) {
            return k.gsO;
        }
        if (this.gsT) {
            return k.gsM;
        }
        if (this.gsU) {
            return k.gsN;
        }
        return dqZ;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.a
    public bj aIu() {
        if (this.dqE == null) {
            return null;
        }
        if (this.dqE.aKq() != 5) {
            this.dqE.jP(1);
        }
        return this.dqE;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String aIv() {
        if (this.dqE == null) {
            return null;
        }
        return this.dqE.dsY;
    }

    public an BK(String str) {
        an anVar = new an(str);
        if (this.dqE != null) {
            anVar.t("fid", this.dqE.getFid());
            anVar.cI("tid", this.dqE.getTid());
            if (this.dqE.aJs()) {
                anVar.af("obj_type", 8);
            } else if (this.dqE.aMx()) {
                anVar.af("obj_type", 9);
            } else if (this.dqE.aJp()) {
                anVar.af("obj_type", 2);
            }
            anVar.af("obj_param1", bFl() ? 2 : 1);
            if (this.dqE.aKC() != null) {
                anVar.cI("obj_id", this.dqE.aKC().getUserId());
            }
        }
        return anVar;
    }

    public an bFr() {
        an al = al(gsY, true);
        if (al != null && aIu() != null) {
            bj aIu = aIu();
            al.af("obj_name", aIu.aMc() != null && (aIu.aMc().cWr() != null || aIu.aMc().bcn() != null) ? 1 : 0);
            if (aIu.aKC() != null) {
                al.af(TiebaInitialize.Params.AB_TYPE, aIu.aKC().hadConcerned() ? 1 : 0);
            }
            if (aIu.getBaijiahaoData() != null) {
                al.cI("obj_param4", aIu.getBaijiahaoData().oriUgcNid);
                al.cI("obj_param6", aIu.getBaijiahaoData().oriUgcVid);
            }
            al.af("obj_param5", af(aIu));
        }
        return al;
    }

    public an b(bj bjVar, int i) {
        an al = al(gsz, true);
        if (al != null) {
            if (i != -1) {
                al.af("click_locate", i);
            }
            if (aIu() != null) {
                bj aIu = aIu();
                if (aIu.getBaijiahaoData() != null) {
                    al.cI("obj_param4", aIu.getBaijiahaoData().oriUgcNid);
                    al.cI("obj_param6", aIu.getBaijiahaoData().oriUgcVid);
                }
                al.af("obj_param5", af(aIu));
            }
        }
        return al;
    }

    public an ag(bj bjVar) {
        return b(bjVar, -1);
    }

    public an bFy() {
        an al = al(gtb, true);
        if (al != null && aIu() != null) {
            bj aIu = aIu();
            if (aIu.getBaijiahaoData() != null) {
                al.cI("obj_param4", aIu.getBaijiahaoData().oriUgcNid);
                al.cI("obj_param6", aIu.getBaijiahaoData().oriUgcVid);
            }
            al.af("obj_param5", af(aIu));
        }
        return al;
    }

    public an bFt() {
        an al = al(gsB, true);
        if (al != null && aIu() != null) {
            bj aIu = aIu();
            if (aIu.getBaijiahaoData() != null) {
                al.cI("obj_param4", aIu.getBaijiahaoData().oriUgcNid);
                al.cI("obj_param6", aIu.getBaijiahaoData().oriUgcVid);
            }
            al.af("obj_param5", af(aIu));
        }
        return al;
    }

    public an ah(bj bjVar) {
        an al = al(gsA, true);
        if (al != null && aIu() != null) {
            bj aIu = aIu();
            if (aIu.getBaijiahaoData() != null) {
                al.cI("obj_param4", aIu.getBaijiahaoData().oriUgcNid);
                al.cI("obj_param6", aIu.getBaijiahaoData().oriUgcVid);
            }
            al.af("obj_param5", af(aIu));
        }
        return al;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public String getVideoUrl() {
        if (this.dqE == null || this.dqE.aKT() == null || this.dqE.aKT().video_url == null) {
            return null;
        }
        return this.dqE.aKT().video_url;
    }

    public int af(bj bjVar) {
        if (bjVar == null) {
            return 1;
        }
        if (bjVar.aMx() || bjVar.aMw()) {
            return 2;
        }
        return (bjVar.aJr() || bjVar.aJs()) ? 3 : 1;
    }
}
