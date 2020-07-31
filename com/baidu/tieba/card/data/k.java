package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import tbclient.SmartApp;
/* loaded from: classes15.dex */
public class k extends c {
    public static String gZQ = "";
    public static String gZR = "";
    public static String gZS = "";
    public static String gZT = "";
    public static String gZU = "";
    public static String gZV = "";
    public static String gZW = "";
    public static String gZX = "";
    public static String gZY = "";
    public static String gZZ = "";
    public static String haa = "";
    public static String hab = "";
    public static String hac = "";
    public static String had = "";
    public static String hae = "";
    public static String haf = "";
    public static String hag = "";
    public static String hah = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId hai = BdUniqueId.gen();
    public static final BdUniqueId dRQ = BdUniqueId.gen();
    public static final BdUniqueId dRW = BdUniqueId.gen();
    public static final BdUniqueId dRX = BdUniqueId.gen();
    public static final BdUniqueId dRY = BdUniqueId.gen();
    public static final BdUniqueId dRZ = BdUniqueId.gen();
    public static final BdUniqueId dSd = BdUniqueId.gen();
    public static final BdUniqueId dSe = BdUniqueId.gen();
    public static final BdUniqueId haj = BdUniqueId.gen();
    public static final BdUniqueId hak = BdUniqueId.gen();
    public static final BdUniqueId hal = BdUniqueId.gen();
    public static final BdUniqueId ham = BdUniqueId.gen();
    public static final BdUniqueId han = BdUniqueId.gen();
    public static final BdUniqueId hao = BdUniqueId.gen();
    public static final BdUniqueId hap = BdUniqueId.gen();
    public static final BdUniqueId haq = BdUniqueId.gen();
    public static final BdUniqueId har = BdUniqueId.gen();
    public static final BdUniqueId dRM = BdUniqueId.gen();
    public static final BdUniqueId dRO = BdUniqueId.gen();
    public static final BdUniqueId dRP = BdUniqueId.gen();
    public boolean has = false;
    public boolean isLinkThread = false;
    public boolean dRo = false;
    public boolean hat = false;
    public boolean dRe = false;
    public boolean hau = false;
    public boolean dRq = false;
    public boolean dRk = false;
    public boolean dRf = false;
    public boolean hav = false;
    public boolean dRi = false;
    public boolean dRj = false;
    public boolean dRl = false;
    public boolean haw = false;
    public boolean dRs = false;
    public boolean dRt = false;
    public boolean hax = false;
    public boolean eBy = true;

    public static boolean aa(bv bvVar) {
        if (bvVar == null) {
            return false;
        }
        return bvVar.getType() == bv.dRx || bvVar.getType() == bv.dRR || bvVar.getType() == bv.dRQ || bvVar.getType() == bv.dRW || bvVar.getType() == bv.dSb;
    }

    public static boolean ac(bv bvVar) {
        if (bvVar == null) {
            return false;
        }
        return bvVar.getType() == bv.dSd || bvVar.getType() == bv.dSe;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.dLK == null) {
            return TYPE;
        }
        if (this.dLK.threadType == 63) {
            return dSd;
        }
        if (this.dLK.threadType == 64) {
            return dSe;
        }
        if (this.dLK.isShareThread && this.dLK.dUi != null) {
            if (this.dLK.dUi.dPP) {
                OriginalThreadInfo originalThreadInfo = this.dLK.dUi;
                if (originalThreadInfo.videoInfo != null) {
                    return dRZ;
                }
                if (originalThreadInfo.aUT()) {
                    return dRY;
                }
                return dRX;
            }
            return dRW;
        } else if (this.dRe) {
            return haj;
        } else {
            if (this.dRf) {
                return hal;
            }
            if (this.hav) {
                return ham;
            }
            if (this.dRi) {
                return han;
            }
            if (this.dRj) {
                return hao;
            }
            if (this.dRk) {
                return hap;
            }
            if (this.dRl) {
                return har;
            }
            if (this.haw) {
                return haq;
            }
            if (this.hau) {
                return hak;
            }
            if (this.dRq) {
                return dRM;
            }
            if (this.dRs) {
                return dRO;
            }
            if (this.dRt) {
                return dRP;
            }
            return TYPE;
        }
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bv aTN() {
        if (this.dLK == null) {
            return null;
        }
        if (this.dLK.aVZ() == 5) {
            return this.dLK;
        }
        this.dLK.kZ(1);
        return this.dLK;
    }

    public boolean bSh() {
        return (this.dLK == null || x.getCount(this.dLK.aWy()) == 0) ? false : true;
    }

    public boolean bSi() {
        return this.dLK == null || this.dLK.aXo();
    }

    public boolean aUR() {
        return this.dLK != null && this.dLK.aUR();
    }

    public ap bSj() {
        SmartApp aXa;
        if (bSh()) {
            ap ED = ED(gZV);
            if (ED != null) {
                ED.setPosition(this.position);
                if (aTN() != null) {
                    bv aTN = aTN();
                    ED.ah("obj_name", aTN.aXO() != null && (aTN.aXO().dlj() != null || aTN.aXO().boR() != null) ? 1 : 0);
                    if (aTN.aWl() != null) {
                        ED.ah(TiebaInitialize.Params.AB_TYPE, aTN.aWl().hadConcerned() ? 1 : 0);
                    }
                    ED.ah("is_full", aTN.aYb() ? 1 : 0);
                }
            }
            return ED;
        } else if (bSi()) {
            ap ED2 = ED(hab);
            if (ED2 != null) {
                ED2.setPosition(this.position);
                if (aTN() != null && (aXa = aTN().aXa()) != null) {
                    ED2.dn("obj_type", aXa.id);
                    ED2.dn("obj_name", aXa.name);
                    return ED2;
                }
                return ED2;
            }
            return ED2;
        } else if (aUR()) {
            return null;
        } else {
            ap ED3 = ED(gZQ);
            if (ED3 != null) {
                ED3.setPosition(this.position);
                ED3.dn("ab_tag", bRY()).dn(TiebaInitialize.Params.AB_ACTION, "show");
                if (aTN() != null) {
                    bv aTN2 = aTN();
                    boolean z = (aTN2.aXO() == null || (aTN2.aXO().dlj() == null && aTN2.aXO().boR() == null)) ? false : true;
                    ED3.ah("obj_name", z ? 1 : 0);
                    if (z && aTN2.aXO().dlj() != null && aTN2.aXO().dlj().boJ() != null && aTN2.aXO().dlj().boJ().size() > 0) {
                        ED3.ah(TiebaInitialize.Params.OBJ_TO, aTN2.aXO().lNH ? 2 : 1);
                    }
                    if (aTN2.aWl() != null) {
                        ED3.ah(TiebaInitialize.Params.AB_TYPE, aTN2.aWl().hadConcerned() ? 1 : 0);
                    }
                    ED3.ah("is_full", aTN2.aYb() ? 1 : 0);
                    if (aTN2.getBaijiahaoData() != null) {
                        ED3.dn("obj_param4", aTN2.getBaijiahaoData().oriUgcNid);
                    }
                    ED3.ah("obj_param5", ae(aTN2));
                    ED3.dn("nid", aTN2.getNid());
                    if (aTN2.aYn()) {
                        ED3.ah("obj_param6", 2);
                    } else {
                        ED3.ah("obj_param6", 1);
                    }
                }
            }
            return ED3;
        }
    }

    public ap EF(String str) {
        int i;
        ap apVar = new ap(str);
        if (this.dLK != null) {
            if (this.dLK.getBaijiahaoData() == null) {
                apVar.t("fid", this.dLK.getFid());
                apVar.dn("tid", this.dLK.getTid());
            } else {
                apVar.dn("tid", this.dLK.getBaijiahaoData().oriUgcNid);
            }
            if (this.dLK.aUR()) {
                i = 2;
            } else if (this.dLK.isLinkThread()) {
                i = 4;
            } else if (this.dLK.isShareThread) {
                i = 5;
            } else if (this.dLK.aUT()) {
                i = 6;
            } else if (this.dLK.aYg()) {
                i = 7;
            } else if (this.dLK.aUU()) {
                i = 8;
            } else {
                i = this.dLK.aYh() ? 9 : 1;
            }
            apVar.ah("obj_type", i);
            apVar.dn("obj_id", this.dLK.aWl().getUserId());
            apVar.ah("obj_param1", bSc() ? 2 : 1);
        }
        return apVar;
    }

    public ap EG(String str) {
        ap ED = ED(str);
        if (ED != null) {
            ED.dn("ab_tag", bRY()).dn(TiebaInitialize.Params.AB_ACTION, "show");
            if (aTN() != null) {
                bv aTN = aTN();
                boolean z = (aTN.aXO() == null || (aTN.aXO().dlj() == null && aTN.aXO().boR() == null)) ? false : true;
                ED.ah("obj_name", z ? 1 : 0);
                if (z && aTN.aXO().dlj() != null && aTN.aXO().dlj().boJ() != null && aTN.aXO().dlj().boJ().size() > 0) {
                    ED.ah(TiebaInitialize.Params.OBJ_TO, aTN.aXO().lNH ? 2 : 1);
                }
            }
        }
        return ED;
    }

    public ap bSk() {
        ap ED;
        SmartApp aXa;
        if (bSh()) {
            ED = ED(gZW);
        } else if (bSi()) {
            ap ED2 = ED(hac);
            if (ED2 != null && aTN() != null && (aXa = aTN().aXa()) != null) {
                ED2.dn("obj_type", aXa.id);
                ED2.dn("obj_name", aXa.name);
                return ED2;
            }
            return ED2;
        } else {
            ED = ED(gZR);
            if (ED != null) {
                ED.dn("ab_tag", bRY()).dn(TiebaInitialize.Params.AB_ACTION, "click");
                if (aTN() != null) {
                    bv aTN = aTN();
                    if (aTN.getBaijiahaoData() != null) {
                        ED.dn("obj_param4", aTN.getBaijiahaoData().oriUgcNid);
                    }
                    ED.ah("obj_param5", ae(aTN));
                    ED.dn("nid", aTN.getNid());
                }
            }
        }
        if (ED != null && aTN() != null) {
            ED.ah("is_full", aTN().aYb() ? 1 : 0);
        }
        return ED;
    }

    public ap bSl() {
        if (bSh()) {
            return ED(gZX);
        }
        if (l.aa(this.dLK)) {
            ap ay = ay(haf, true);
            if (ay != null && aTN() != null) {
                bv aTN = aTN();
                if (aTN.getBaijiahaoData() != null) {
                    ay.dn("obj_param4", aTN.getBaijiahaoData().oriUgcNid);
                    ay.dn("obj_param6", aTN.getBaijiahaoData().oriUgcVid);
                }
                ay.ah("obj_param5", ae(aTN));
                ay.dn("nid", aTN.getNid());
                return ay;
            }
            return ay;
        }
        ap aG = aG(gZS, 0);
        if (aG != null) {
            aG.dn("ab_tag", bRY()).dn(TiebaInitialize.Params.AB_ACTION, "click");
            if (aTN() != null) {
                bv aTN2 = aTN();
                if (aTN2.getBaijiahaoData() != null) {
                    aG.dn("obj_param4", aTN2.getBaijiahaoData().oriUgcNid);
                }
                aG.ah("obj_param5", ae(aTN2));
                aG.dn("nid", aTN2.getNid());
                return aG;
            }
            return aG;
        }
        return aG;
    }

    public ap bSm() {
        if (l.aa(this.dLK)) {
            ap ay = ay(hae, true);
            if (ay != null && aTN() != null) {
                bv aTN = aTN();
                if (aTN.getBaijiahaoData() != null) {
                    ay.dn("obj_param4", aTN.getBaijiahaoData().oriUgcNid);
                    ay.dn("obj_param6", aTN.getBaijiahaoData().oriUgcVid);
                }
                ay.ah("obj_param5", ae(aTN));
                if (aTN.aYn()) {
                    ay.ah(TiebaInitialize.Params.OBJ_PARAM2, 2);
                    return ay;
                }
                ay.ah(TiebaInitialize.Params.OBJ_PARAM2, 1);
                return ay;
            }
            return ay;
        } else if (bSh()) {
            return ED(gZY);
        } else {
            ap ED = ED(gZT);
            if (ED != null) {
                ED.dn("ab_tag", bRY()).dn(TiebaInitialize.Params.AB_ACTION, "click");
                if (aTN() != null) {
                    bv aTN2 = aTN();
                    if (aTN2.getBaijiahaoData() != null) {
                        ED.dn("obj_param4", aTN2.getBaijiahaoData().oriUgcNid);
                    }
                    ED.ah("obj_param5", ae(aTN2));
                    ED.dn("nid", aTN2.getNid());
                    if (aTN2.aYn()) {
                        ED.ah(TiebaInitialize.Params.OBJ_PARAM2, 2);
                        return ED;
                    }
                    ED.ah(TiebaInitialize.Params.OBJ_PARAM2, 1);
                    return ED;
                }
                return ED;
            }
            return ED;
        }
    }

    public ap bSn() {
        if (bSh()) {
            return ED(gZZ);
        }
        ap ED = ED(gZU);
        if (ED != null) {
            ED.dn("ab_tag", bRY()).dn(TiebaInitialize.Params.AB_ACTION, "click");
            if (aTN() != null) {
                bv aTN = aTN();
                if (aTN.getBaijiahaoData() != null) {
                    ED.dn("obj_param4", aTN.getBaijiahaoData().oriUgcNid);
                }
                ED.ah("obj_param5", ae(aTN));
                ED.dn("nid", aTN.getNid());
                return ED;
            }
            return ED;
        }
        return ED;
    }

    public ap bSo() {
        return ED(haa);
    }

    public ap bSp() {
        ap ay = ay(had, true);
        if (aTN() != null) {
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

    public ap EH(String str) {
        ap ED = ED(str);
        if (this.dLK != null && this.dLK.aWl() != null) {
            ED.ah(TiebaInitialize.Params.AB_TYPE, this.dLK.aWl().hadConcerned() ? 1 : 0);
        }
        return ED;
    }

    public ap EI(String str) {
        return ED(str);
    }

    public int ad(bv bvVar) {
        if (bvVar == null) {
            return 0;
        }
        if (bvVar.aUT()) {
            return 1;
        }
        if (bvVar.aUR()) {
            return 2;
        }
        if (bvVar.aYg()) {
            return 3;
        }
        return bvVar.aYh() ? 4 : 0;
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
