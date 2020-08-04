package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes15.dex */
public class l extends c implements com.baidu.tbadk.core.util.f.a {
    public static final BdUniqueId dRS = BdUniqueId.gen();
    public static String hae = "";
    public static String haf = "";
    public static String hay = "";
    public static String had = "";
    public static String haz = "";
    public static String haA = "";
    public static String haB = "";
    public boolean hax = false;
    public boolean haC = true;
    public boolean dRe = false;
    public boolean haD = false;
    public boolean dRk = false;
    public boolean dRl = false;
    public boolean haw = false;
    public boolean hau = false;
    public boolean dRq = false;
    public boolean dRs = false;
    public boolean dRt = false;
    public int sourceType = 0;

    public l(bv bvVar) {
        this.dLK = bvVar;
    }

    public static boolean aa(bv bvVar) {
        return (bvVar == null || bvVar.aWD() == null) ? false : true;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.dLK == null) {
            return k.TYPE;
        }
        if (this.dRe) {
            return k.haj;
        }
        if (this.haD) {
            return dRS;
        }
        if (this.dRk) {
            return k.hap;
        }
        if (this.dRl) {
            return k.har;
        }
        if (this.haw) {
            return k.haq;
        }
        if (this.hau) {
            return k.hak;
        }
        if (this.dRq) {
            return k.dRM;
        }
        if (this.dRs) {
            return k.dRO;
        }
        if (this.dRt) {
            return k.dRP;
        }
        return dRS;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bv aTN() {
        if (this.dLK == null) {
            return null;
        }
        if (this.dLK.aVZ() != 5) {
            this.dLK.kZ(1);
        }
        return this.dLK;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String aTO() {
        if (this.dLK == null) {
            return null;
        }
        return this.dLK.dTO;
    }

    public ap EF(String str) {
        ap apVar = new ap(str);
        if (this.dLK != null) {
            apVar.t("fid", this.dLK.getFid());
            apVar.dn("tid", this.dLK.getTid());
            if (this.dLK.aUU()) {
                apVar.ah("obj_type", 8);
            } else if (this.dLK.aYh()) {
                apVar.ah("obj_type", 9);
            } else if (this.dLK.aUR()) {
                apVar.ah("obj_type", 2);
            }
            apVar.ah("obj_param1", bSc() ? 2 : 1);
            if (this.dLK.aWl() != null) {
                apVar.dn("obj_id", this.dLK.aWl().getUserId());
            }
        }
        return apVar;
    }

    public ap bSj() {
        ap ay = ay(hay, true);
        if (ay != null && aTN() != null) {
            bv aTN = aTN();
            ay.ah("obj_name", aTN.aXO() != null && (aTN.aXO().dlk() != null || aTN.aXO().boR() != null) ? 1 : 0);
            if (aTN.aWl() != null) {
                ay.ah(TiebaInitialize.Params.AB_TYPE, aTN.aWl().hadConcerned() ? 1 : 0);
            }
            if (aTN.getBaijiahaoData() != null) {
                ay.dn("obj_param4", aTN.getBaijiahaoData().oriUgcNid);
                ay.dn("obj_param6", aTN.getBaijiahaoData().oriUgcVid);
            }
            ay.ah("obj_param5", ae(aTN));
            if (aTN.aYn()) {
                ay.ah(TiebaInitialize.Params.OBJ_TO, 2);
            } else {
                ay.ah(TiebaInitialize.Params.OBJ_TO, 1);
            }
        }
        return ay;
    }

    public ap b(bv bvVar, int i) {
        ap ay = ay(had, true);
        if (ay != null) {
            if (i != -1) {
                ay.ah("click_locate", i);
            }
            if (aTN() != null) {
                bv aTN = aTN();
                if (aTN.getBaijiahaoData() != null) {
                    ay.dn("obj_param4", aTN.getBaijiahaoData().oriUgcNid);
                    ay.dn("obj_param6", aTN.getBaijiahaoData().oriUgcVid);
                }
                ay.ah("obj_param5", ae(aTN));
            }
        }
        return ay;
    }

    public ap af(bv bvVar) {
        return b(bvVar, -1);
    }

    public ap bSq() {
        ap ay = ay(haB, true);
        if (ay != null && aTN() != null) {
            bv aTN = aTN();
            if (aTN.getBaijiahaoData() != null) {
                ay.dn("obj_param4", aTN.getBaijiahaoData().oriUgcNid);
                ay.dn("obj_param6", aTN.getBaijiahaoData().oriUgcVid);
            }
            ay.ah("obj_param5", ae(aTN));
            ay.dn("nid", aTN.getNid());
        }
        return ay;
    }

    public ap ag(bv bvVar) {
        ap ay = ay(hae, true);
        if (ay != null && aTN() != null) {
            bv aTN = aTN();
            if (aTN.getBaijiahaoData() != null) {
                ay.dn("obj_param4", aTN.getBaijiahaoData().oriUgcNid);
                ay.dn("obj_param6", aTN.getBaijiahaoData().oriUgcVid);
                if (aTN.aYn()) {
                    ay.ah(TiebaInitialize.Params.OBJ_PARAM2, 2);
                } else {
                    ay.ah(TiebaInitialize.Params.OBJ_PARAM2, 1);
                }
            }
            ay.ah("obj_param5", ae(aTN));
        }
        return ay;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public String getVideoUrl() {
        if (this.dLK == null || this.dLK.aWD() == null || this.dLK.aWD().video_url == null) {
            return null;
        }
        return this.dLK.aWD().video_url;
    }

    public int ae(bv bvVar) {
        if (bvVar == null) {
            return 1;
        }
        if (bvVar.aYh() || bvVar.aYg()) {
            return 2;
        }
        return (bvVar.aUT() || bvVar.aUU()) ? 3 : 1;
    }
}
