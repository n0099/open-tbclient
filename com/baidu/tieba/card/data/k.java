package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import tbclient.SmartApp;
/* loaded from: classes21.dex */
public class k extends b {
    public static String imU = "";
    public static String imV = "";
    public static String imW = "";
    public static String imX = "";
    public static String imY = "";
    public static String imZ = "";
    public static String ina = "";
    public static String inb = "";
    public static String inc = "";
    public static String ind = "";
    public static String ine = "";
    public static String inf = "";
    public static String ing = "";
    public static String inh = "";
    public static String ini = "";
    public static String inj = "";
    public static String ink = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId inl = BdUniqueId.gen();
    public static final BdUniqueId eJo = BdUniqueId.gen();
    public static final BdUniqueId eJv = BdUniqueId.gen();
    public static final BdUniqueId eJw = BdUniqueId.gen();
    public static final BdUniqueId eJx = BdUniqueId.gen();
    public static final BdUniqueId eJy = BdUniqueId.gen();
    public static final BdUniqueId eJC = BdUniqueId.gen();
    public static final BdUniqueId eJD = BdUniqueId.gen();
    public static final BdUniqueId inm = BdUniqueId.gen();
    public static final BdUniqueId inn = BdUniqueId.gen();
    public static final BdUniqueId eIX = BdUniqueId.gen();
    public static final BdUniqueId ino = BdUniqueId.gen();
    public static final BdUniqueId inp = BdUniqueId.gen();
    public static final BdUniqueId inq = BdUniqueId.gen();
    public static final BdUniqueId inr = BdUniqueId.gen();

    /* renamed from: int  reason: not valid java name */
    public static final BdUniqueId f4int = BdUniqueId.gen();
    public static final BdUniqueId inu = BdUniqueId.gen();
    public static final BdUniqueId inv = BdUniqueId.gen();
    public static final BdUniqueId eJj = BdUniqueId.gen();
    public static final BdUniqueId eJl = BdUniqueId.gen();
    public static final BdUniqueId eJm = BdUniqueId.gen();
    public boolean inw = false;
    public boolean isLinkThread = false;
    public boolean eII = false;
    public boolean inx = false;
    public boolean iny = false;
    public boolean fvC = true;

    public static boolean ad(by byVar) {
        if (byVar == null) {
            return false;
        }
        return byVar.getType() == by.eIS || byVar.getType() == by.eJp || byVar.getType() == by.eJo || byVar.getType() == by.eJv || byVar.getType() == by.eJA;
    }

    public static boolean af(by byVar) {
        if (byVar == null) {
            return false;
        }
        return byVar.getType() == by.eJC || byVar.getType() == by.eJD;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        int indexOf;
        int indexOf2;
        if (this.eCR == null) {
            return TYPE;
        }
        if (this.imM && b.imC.length > 1) {
            BdUniqueId type = this.eCR.getType();
            if (type == by.eIS || type == by.eJo || type == by.eJA || type == by.eJp) {
                if (this.eIO) {
                    indexOf = b.imA.indexOf(b.ims);
                } else {
                    indexOf = b.imA.indexOf(b.imr);
                }
                if (this.eID) {
                    indexOf2 = b.imB.indexOf(b.imt);
                } else if (this.eIC) {
                    indexOf2 = b.imB.indexOf(b.imv);
                } else if (this.imJ) {
                    indexOf2 = b.imB.indexOf(b.imu);
                } else {
                    indexOf2 = b.imB.indexOf(b.imw);
                }
                if (indexOf >= 0 && indexOf < b.imC.length && indexOf2 >= 0 && indexOf2 < b.imC[0].length) {
                    return b.imC[indexOf][indexOf2];
                }
            }
            return type;
        } else if (this.eCR.threadType == 63) {
            return eJC;
        } else {
            if (this.eCR.threadType == 64) {
                return eJD;
            }
            if (this.eCR.isShareThread && this.eCR.eLH != null) {
                if (this.eCR.eLH.eHh) {
                    OriginalThreadInfo originalThreadInfo = this.eCR.eLH;
                    if (originalThreadInfo.videoInfo != null) {
                        return eJy;
                    }
                    if (originalThreadInfo.bnx()) {
                        return eJx;
                    }
                    return eJw;
                }
                return eJv;
            } else if (this.eIy) {
                return inn;
            } else {
                if (this.eIz) {
                    return ino;
                }
                if (this.imJ) {
                    return inp;
                }
                if (this.eIC) {
                    return inq;
                }
                if (this.eID) {
                    return inr;
                }
                if (this.eIE) {
                    return f4int;
                }
                if (this.eIF) {
                    return inv;
                }
                if (this.imL) {
                    return inu;
                }
                if (this.eIO) {
                    return eIX;
                }
                if (this.eIK) {
                    return eJj;
                }
                if (this.eIM) {
                    return eJl;
                }
                if (this.eIN) {
                    return eJm;
                }
                return TYPE;
            }
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.tbadk.core.data.a
    public by bmn() {
        if (this.eCR == null) {
            return null;
        }
        if (this.eCR.boD() == 5) {
            return this.eCR;
        }
        this.eCR.oC(1);
        return this.eCR;
    }

    public boolean csF() {
        return (this.eCR == null || y.getCount(this.eCR.bpc()) == 0) ? false : true;
    }

    public boolean csG() {
        return this.eCR == null || this.eCR.bpU();
    }

    @Override // com.baidu.tieba.card.data.b
    public boolean bnv() {
        return this.eCR != null && this.eCR.bnv();
    }

    @Override // com.baidu.tieba.card.data.b
    public ar csB() {
        SmartApp bpE;
        if (csF()) {
            ar Ju = Ju(imZ);
            if (Ju != null) {
                Ju.setPosition(this.position);
                if (bmn() != null) {
                    by bmn = bmn();
                    Ju.al("obj_name", bmn.bqu() != null && (bmn.bqu().dPi() != null || bmn.bqu().bIK() != null) ? 1 : 0);
                    if (bmn.boP() != null) {
                        Ju.al(TiebaInitialize.Params.AB_TYPE, bmn.boP().hadConcerned() ? 1 : 0);
                    }
                    Ju.al("is_full", bmn.bqH() ? 1 : 0);
                }
            }
            return Ju;
        } else if (csG()) {
            ar Ju2 = Ju(inf);
            if (Ju2 != null) {
                Ju2.setPosition(this.position);
                if (bmn() != null && (bpE = bmn().bpE()) != null) {
                    TiebaStatic.deleteParamByKey(Ju2, "obj_type");
                    Ju2.dY("obj_type", bpE.id);
                    Ju2.dY("obj_name", bpE.name);
                    return Ju2;
                }
                return Ju2;
            }
            return Ju2;
        } else if (bnv()) {
            return null;
        } else {
            ar Ju3 = Ju(imU);
            if (Ju3 != null) {
                Ju3.setPosition(this.position);
                Ju3.dY(TiebaInitialize.Params.AB_ACTION, "show");
                if (bmn() != null) {
                    by bmn2 = bmn();
                    boolean z = (bmn2.bqu() == null || (bmn2.bqu().dPi() == null && bmn2.bqu().bIK() == null)) ? false : true;
                    Ju3.al("obj_name", z ? 1 : 0);
                    if (z && bmn2.bqu().dPi() != null && bmn2.bqu().dPi().bIC() != null && bmn2.bqu().dPi().bIC().size() > 0) {
                        Ju3.al(TiebaInitialize.Params.OBJ_TO, bmn2.bqu().nmn ? 2 : 1);
                    }
                    if (bmn2.boP() != null) {
                        Ju3.al(TiebaInitialize.Params.AB_TYPE, bmn2.boP().hadConcerned() ? 1 : 0);
                    }
                    Ju3.al("is_full", bmn2.bqH() ? 1 : 0);
                    if (bmn2.getBaijiahaoData() != null) {
                        Ju3.dY("obj_param4", bmn2.getBaijiahaoData().oriUgcNid);
                    }
                    Ju3.al("obj_param5", ah(bmn2));
                    if (bmn2.bqU()) {
                        Ju3.al("obj_param6", 2);
                    } else {
                        Ju3.al("obj_param6", 1);
                    }
                    if (bmn2.bra()) {
                        Ju3.al("gua_type", 1);
                    } else if (bmn2.bqV() != null) {
                        Ju3.al("gua_type", 2);
                    } else {
                        Ju3.al("gua_type", 0);
                    }
                }
            }
            return Ju3;
        }
    }

    @Override // com.baidu.tieba.card.data.b
    public ar Jv(String str) {
        int i;
        ar arVar = new ar(str);
        if (this.eCR != null) {
            if (this.eCR.getBaijiahaoData() == null) {
                arVar.w("fid", this.eCR.getFid());
                arVar.dY("tid", this.eCR.getTid());
            } else {
                arVar.dY("tid", this.eCR.getBaijiahaoData().oriUgcNid);
            }
            if (this.eCR.bnv()) {
                i = 2;
            } else if (this.eCR.isLinkThread()) {
                i = 4;
            } else if (this.eCR.isShareThread) {
                i = 5;
            } else if (this.eCR.bnx()) {
                i = 6;
            } else if (this.eCR.bqM()) {
                i = 7;
            } else if (this.eCR.bny()) {
                i = 8;
            } else {
                i = this.eCR.bqN() ? 9 : 1;
            }
            arVar.al("obj_type", i);
            arVar.dY("obj_id", this.eCR.boP().getUserId());
            arVar.al("obj_param1", csx() ? 2 : 1);
        }
        return arVar;
    }

    public ar Jx(String str) {
        ar Ju = Ju(str);
        if (Ju != null) {
            Ju.dY("ab_tag", cst()).dY(TiebaInitialize.Params.AB_ACTION, "show");
            if (bmn() != null) {
                by bmn = bmn();
                boolean z = (bmn.bqu() == null || (bmn.bqu().dPi() == null && bmn.bqu().bIK() == null)) ? false : true;
                Ju.al("obj_name", z ? 1 : 0);
                if (z && bmn.bqu().dPi() != null && bmn.bqu().dPi().bIC() != null && bmn.bqu().dPi().bIC().size() > 0) {
                    Ju.al(TiebaInitialize.Params.OBJ_TO, bmn.bqu().nmn ? 2 : 1);
                }
            }
        }
        return Ju;
    }

    @Override // com.baidu.tieba.card.data.b
    public ar csz() {
        ar Ju;
        SmartApp bpE;
        if (csF()) {
            Ju = Ju(ina);
        } else if (csG()) {
            ar Ju2 = Ju(ing);
            if (Ju2 != null && bmn() != null && (bpE = bmn().bpE()) != null) {
                TiebaStatic.deleteParamByKey(Ju2, "obj_type");
                Ju2.dY("obj_type", bpE.id);
                Ju2.dY("obj_name", bpE.name);
                return Ju2;
            }
            return Ju2;
        } else {
            Ju = Ju(imV);
            if (Ju != null) {
                Ju.dY(TiebaInitialize.Params.AB_ACTION, "click");
                if (bmn() != null) {
                    by bmn = bmn();
                    if (bmn.getBaijiahaoData() != null) {
                        Ju.dY("obj_param4", bmn.getBaijiahaoData().oriUgcNid);
                    }
                    Ju.al("obj_param5", ah(bmn));
                }
            }
        }
        if (Ju != null && bmn() != null) {
            Ju.al("is_full", bmn().bqH() ? 1 : 0);
        }
        return Ju;
    }

    @Override // com.baidu.tieba.card.data.b
    public ar csy() {
        if (csF()) {
            return Ju(inb);
        }
        if (l.ad(this.eCR)) {
            ar aJ = aJ(inj, true);
            if (aJ != null && bmn() != null) {
                by bmn = bmn();
                if (bmn.getBaijiahaoData() != null) {
                    aJ.dY("obj_param4", bmn.getBaijiahaoData().oriUgcNid);
                    aJ.dY("obj_param6", bmn.getBaijiahaoData().oriUgcVid);
                }
                aJ.al("obj_param5", ah(bmn));
                return aJ;
            }
            return aJ;
        }
        ar aN = aN(imW, 0);
        if (aN != null) {
            aN.dY("ab_tag", cst()).dY(TiebaInitialize.Params.AB_ACTION, "click");
            if (bmn() != null) {
                by bmn2 = bmn();
                if (bmn2.getBaijiahaoData() != null) {
                    aN.dY("obj_param4", bmn2.getBaijiahaoData().oriUgcNid);
                }
                aN.al("obj_param5", ah(bmn2));
                aN.dY("nid", bmn2.getNid());
                return aN;
            }
            return aN;
        }
        return aN;
    }

    public ar csH() {
        if (l.ad(this.eCR)) {
            ar aJ = aJ(ini, true);
            if (aJ != null && bmn() != null) {
                by bmn = bmn();
                if (bmn.getBaijiahaoData() != null) {
                    aJ.dY("obj_param4", bmn.getBaijiahaoData().oriUgcNid);
                    aJ.dY("obj_param6", bmn.getBaijiahaoData().oriUgcVid);
                }
                aJ.al("obj_param5", ah(bmn));
                if (bmn.bqU()) {
                    aJ.al(TiebaInitialize.Params.OBJ_PARAM2, 2);
                    return aJ;
                }
                aJ.al(TiebaInitialize.Params.OBJ_PARAM2, 1);
                return aJ;
            }
            return aJ;
        } else if (csF()) {
            return Ju(inc);
        } else {
            ar Ju = Ju(imX);
            if (Ju != null) {
                Ju.dY("ab_tag", cst()).dY(TiebaInitialize.Params.AB_ACTION, "click");
                if (bmn() != null) {
                    by bmn2 = bmn();
                    if (bmn2.getBaijiahaoData() != null) {
                        Ju.dY("obj_param4", bmn2.getBaijiahaoData().oriUgcNid);
                    }
                    Ju.al("obj_param5", ah(bmn2));
                    Ju.dY("nid", bmn2.getNid());
                    if (bmn2.bqU()) {
                        Ju.al(TiebaInitialize.Params.OBJ_PARAM2, 2);
                        return Ju;
                    }
                    Ju.al(TiebaInitialize.Params.OBJ_PARAM2, 1);
                    return Ju;
                }
                return Ju;
            }
            return Ju;
        }
    }

    public ar csI() {
        if (csF()) {
            return Ju(ind);
        }
        ar Ju = Ju(imY);
        if (Ju != null) {
            Ju.dY(TiebaInitialize.Params.AB_ACTION, "click");
            if (bmn() != null) {
                by bmn = bmn();
                if (bmn.getBaijiahaoData() != null) {
                    Ju.dY("obj_param4", bmn.getBaijiahaoData().oriUgcNid);
                }
                Ju.al("obj_param5", ah(bmn));
                return Ju;
            }
            return Ju;
        }
        return Ju;
    }

    public ar csJ() {
        return Ju(ine);
    }

    @Override // com.baidu.tieba.card.data.b
    public ar csA() {
        ar aJ = aJ(inh, true);
        if (bmn() != null) {
            by bmn = bmn();
            if (bmn.getBaijiahaoData() != null) {
                aJ.dY("obj_param4", bmn.getBaijiahaoData().oriUgcNid);
                aJ.dY("obj_param6", bmn.getBaijiahaoData().oriUgcVid);
            }
            aJ.al("obj_param5", ah(bmn));
        }
        return aJ;
    }

    public ar Jy(String str) {
        ar Ju = Ju(str);
        if (this.eCR != null && this.eCR.boP() != null) {
            Ju.al(TiebaInitialize.Params.AB_TYPE, this.eCR.boP().hadConcerned() ? 1 : 0);
        }
        return Ju;
    }

    public ar Jz(String str) {
        return Ju(str);
    }

    public int ag(by byVar) {
        if (byVar == null) {
            return 0;
        }
        if (byVar.bnx()) {
            return 1;
        }
        if (byVar.bnv()) {
            return 2;
        }
        if (byVar.bqM()) {
            return 3;
        }
        return byVar.bqN() ? 4 : 0;
    }

    public int ah(by byVar) {
        if (byVar == null) {
            return 1;
        }
        if (byVar.bqN() || byVar.bqM()) {
            return 2;
        }
        return (byVar.bnx() || byVar.bny()) ? 3 : 1;
    }
}
