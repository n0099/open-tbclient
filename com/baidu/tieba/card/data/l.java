package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import tbclient.SmartApp;
/* loaded from: classes21.dex */
public class l extends c {
    public static String hIL = "";
    public static String hIM = "";
    public static String hIN = "";
    public static String hIO = "";
    public static String hIP = "";
    public static String hIQ = "";
    public static String hIR = "";
    public static String hIS = "";
    public static String hIT = "";
    public static String hIU = "";
    public static String hIV = "";
    public static String hIW = "";
    public static String hIX = "";
    public static String hIY = "";
    public static String hIZ = "";
    public static String hJa = "";
    public static String hJb = "";
    public static String hJc = "";
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public static final BdUniqueId hJd = BdUniqueId.gen();
    public static final BdUniqueId epF = BdUniqueId.gen();
    public static final BdUniqueId epL = BdUniqueId.gen();
    public static final BdUniqueId epM = BdUniqueId.gen();
    public static final BdUniqueId epN = BdUniqueId.gen();
    public static final BdUniqueId epO = BdUniqueId.gen();
    public static final BdUniqueId epS = BdUniqueId.gen();
    public static final BdUniqueId epT = BdUniqueId.gen();
    public static final BdUniqueId hJe = BdUniqueId.gen();
    public static final BdUniqueId hJf = BdUniqueId.gen();
    public static final BdUniqueId epp = BdUniqueId.gen();
    public static final BdUniqueId hJg = BdUniqueId.gen();
    public static final BdUniqueId hJh = BdUniqueId.gen();
    public static final BdUniqueId hJi = BdUniqueId.gen();
    public static final BdUniqueId hJj = BdUniqueId.gen();
    public static final BdUniqueId hJk = BdUniqueId.gen();
    public static final BdUniqueId hJl = BdUniqueId.gen();
    public static final BdUniqueId hJm = BdUniqueId.gen();
    public static final BdUniqueId epB = BdUniqueId.gen();
    public static final BdUniqueId epD = BdUniqueId.gen();
    public static final BdUniqueId epE = BdUniqueId.gen();
    public boolean hJn = false;
    public boolean isLinkThread = false;
    public boolean epb = false;
    public boolean hJo = false;
    public boolean eoR = false;
    public boolean eph = false;
    public boolean epd = false;
    public boolean eoX = false;
    public boolean eoS = false;
    public boolean hJp = false;
    public boolean eoV = false;
    public boolean eoW = false;
    public boolean eoY = false;
    public boolean hJq = false;
    public boolean epf = false;
    public boolean epg = false;
    public boolean hJr = false;
    public boolean faA = true;

    public static boolean ab(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        return bwVar.getType() == bw.epl || bwVar.getType() == bw.epG || bwVar.getType() == bw.epF || bwVar.getType() == bw.epL || bwVar.getType() == bw.epQ;
    }

    public static boolean ad(bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        return bwVar.getType() == bw.epS || bwVar.getType() == bw.epT;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.eji == null) {
            return TYPE;
        }
        if (this.eji.threadType == 63) {
            return epS;
        }
        if (this.eji.threadType == 64) {
            return epT;
        }
        if (this.eji.isShareThread && this.eji.erY != null) {
            if (this.eji.erY.enA) {
                OriginalThreadInfo originalThreadInfo = this.eji.erY;
                if (originalThreadInfo.videoInfo != null) {
                    return epO;
                }
                if (originalThreadInfo.bgP()) {
                    return epN;
                }
                return epM;
            }
            return epL;
        } else if (this.eoR) {
            return hJf;
        } else {
            if (this.eoS) {
                return hJg;
            }
            if (this.hJp) {
                return hJh;
            }
            if (this.eoV) {
                return hJi;
            }
            if (this.eoW) {
                return hJj;
            }
            if (this.eoX) {
                return hJk;
            }
            if (this.eoY) {
                return hJm;
            }
            if (this.hJq) {
                return hJl;
            }
            if (this.eph) {
                return epp;
            }
            if (this.epd) {
                return epB;
            }
            if (this.epf) {
                return epD;
            }
            if (this.epg) {
                return epE;
            }
            return TYPE;
        }
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bfG() {
        if (this.eji == null) {
            return null;
        }
        if (this.eji.bhV() == 5) {
            return this.eji;
        }
        this.eji.nN(1);
        return this.eji;
    }

    public boolean cjf() {
        return (this.eji == null || y.getCount(this.eji.biu()) == 0) ? false : true;
    }

    public boolean cjg() {
        return this.eji == null || this.eji.bjk();
    }

    public boolean bgN() {
        return this.eji != null && this.eji.bgN();
    }

    public aq cjh() {
        SmartApp biW;
        if (cjf()) {
            aq In = In(hIQ);
            if (In != null) {
                In.setPosition(this.position);
                if (bfG() != null) {
                    bw bfG = bfG();
                    In.aj("obj_name", bfG.bjK() != null && (bfG.bjK().dEr() != null || bfG.bjK().bBy() != null) ? 1 : 0);
                    if (bfG.bih() != null) {
                        In.aj(TiebaInitialize.Params.AB_TYPE, bfG.bih().hadConcerned() ? 1 : 0);
                    }
                    In.aj("is_full", bfG.bjX() ? 1 : 0);
                }
            }
            return In;
        } else if (cjg()) {
            aq In2 = In(hIW);
            if (In2 != null) {
                In2.setPosition(this.position);
                if (bfG() != null && (biW = bfG().biW()) != null) {
                    In2.dK("obj_type", biW.id);
                    In2.dK("obj_name", biW.name);
                    return In2;
                }
                return In2;
            }
            return In2;
        } else if (bgN()) {
            return null;
        } else {
            aq In3 = In(hIL);
            if (In3 != null) {
                In3.setPosition(this.position);
                In3.dK("ab_tag", ciW()).dK(TiebaInitialize.Params.AB_ACTION, "show");
                if (bfG() != null) {
                    bw bfG2 = bfG();
                    boolean z = (bfG2.bjK() == null || (bfG2.bjK().dEr() == null && bfG2.bjK().bBy() == null)) ? false : true;
                    In3.aj("obj_name", z ? 1 : 0);
                    if (z && bfG2.bjK().dEr() != null && bfG2.bjK().dEr().bBq() != null && bfG2.bjK().dEr().bBq().size() > 0) {
                        In3.aj(TiebaInitialize.Params.OBJ_TO, bfG2.bjK().mEN ? 2 : 1);
                    }
                    if (bfG2.bih() != null) {
                        In3.aj(TiebaInitialize.Params.AB_TYPE, bfG2.bih().hadConcerned() ? 1 : 0);
                    }
                    In3.aj("is_full", bfG2.bjX() ? 1 : 0);
                    if (bfG2.getBaijiahaoData() != null) {
                        In3.dK("obj_param4", bfG2.getBaijiahaoData().oriUgcNid);
                    }
                    In3.aj("obj_param5", af(bfG2));
                    In3.dK("nid", bfG2.getNid());
                    if (bfG2.bkj()) {
                        In3.aj("obj_param6", 2);
                    } else {
                        In3.aj("obj_param6", 1);
                    }
                }
            }
            return In3;
        }
    }

    public aq Ip(String str) {
        int i;
        aq aqVar = new aq(str);
        if (this.eji != null) {
            if (this.eji.getBaijiahaoData() == null) {
                aqVar.u("fid", this.eji.getFid());
                aqVar.dK("tid", this.eji.getTid());
            } else {
                aqVar.dK("tid", this.eji.getBaijiahaoData().oriUgcNid);
            }
            if (this.eji.bgN()) {
                i = 2;
            } else if (this.eji.isLinkThread()) {
                i = 4;
            } else if (this.eji.isShareThread) {
                i = 5;
            } else if (this.eji.bgP()) {
                i = 6;
            } else if (this.eji.bkc()) {
                i = 7;
            } else if (this.eji.bgQ()) {
                i = 8;
            } else {
                i = this.eji.bkd() ? 9 : 1;
            }
            aqVar.aj("obj_type", i);
            aqVar.dK("obj_id", this.eji.bih().getUserId());
            aqVar.aj("obj_param1", cja() ? 2 : 1);
        }
        return aqVar;
    }

    public aq Iq(String str) {
        aq In = In(str);
        if (In != null) {
            In.dK("ab_tag", ciW()).dK(TiebaInitialize.Params.AB_ACTION, "show");
            if (bfG() != null) {
                bw bfG = bfG();
                boolean z = (bfG.bjK() == null || (bfG.bjK().dEr() == null && bfG.bjK().bBy() == null)) ? false : true;
                In.aj("obj_name", z ? 1 : 0);
                if (z && bfG.bjK().dEr() != null && bfG.bjK().dEr().bBq() != null && bfG.bjK().dEr().bBq().size() > 0) {
                    In.aj(TiebaInitialize.Params.OBJ_TO, bfG.bjK().mEN ? 2 : 1);
                }
            }
        }
        return In;
    }

    public aq cji() {
        aq In;
        SmartApp biW;
        if (cjf()) {
            In = In(hIR);
        } else if (cjg()) {
            aq In2 = In(hIX);
            if (In2 != null && bfG() != null && (biW = bfG().biW()) != null) {
                In2.dK("obj_type", biW.id);
                In2.dK("obj_name", biW.name);
                return In2;
            }
            return In2;
        } else {
            In = In(hIM);
            if (In != null) {
                In.dK("ab_tag", ciW()).dK(TiebaInitialize.Params.AB_ACTION, "click");
                if (bfG() != null) {
                    bw bfG = bfG();
                    if (bfG.getBaijiahaoData() != null) {
                        In.dK("obj_param4", bfG.getBaijiahaoData().oriUgcNid);
                    }
                    In.aj("obj_param5", af(bfG));
                    In.dK("nid", bfG.getNid());
                }
            }
        }
        if (In != null && bfG() != null) {
            In.aj("is_full", bfG().bjX() ? 1 : 0);
        }
        return In;
    }

    public aq cjj() {
        if (cjf()) {
            return In(hIS);
        }
        if (m.ab(this.eji)) {
            aq aG = aG(hJa, true);
            if (aG != null && bfG() != null) {
                bw bfG = bfG();
                if (bfG.getBaijiahaoData() != null) {
                    aG.dK("obj_param4", bfG.getBaijiahaoData().oriUgcNid);
                    aG.dK("obj_param6", bfG.getBaijiahaoData().oriUgcVid);
                }
                aG.aj("obj_param5", af(bfG));
                aG.dK("nid", bfG.getNid());
                return aG;
            }
            return aG;
        }
        aq aK = aK(hIN, 0);
        if (aK != null) {
            aK.dK("ab_tag", ciW()).dK(TiebaInitialize.Params.AB_ACTION, "click");
            if (bfG() != null) {
                bw bfG2 = bfG();
                if (bfG2.getBaijiahaoData() != null) {
                    aK.dK("obj_param4", bfG2.getBaijiahaoData().oriUgcNid);
                }
                aK.aj("obj_param5", af(bfG2));
                aK.dK("nid", bfG2.getNid());
                return aK;
            }
            return aK;
        }
        return aK;
    }

    public aq cjk() {
        if (m.ab(this.eji)) {
            aq aG = aG(hIZ, true);
            if (aG != null && bfG() != null) {
                bw bfG = bfG();
                if (bfG.getBaijiahaoData() != null) {
                    aG.dK("obj_param4", bfG.getBaijiahaoData().oriUgcNid);
                    aG.dK("obj_param6", bfG.getBaijiahaoData().oriUgcVid);
                }
                aG.aj("obj_param5", af(bfG));
                if (bfG.bkj()) {
                    aG.aj(TiebaInitialize.Params.OBJ_PARAM2, 2);
                    return aG;
                }
                aG.aj(TiebaInitialize.Params.OBJ_PARAM2, 1);
                return aG;
            }
            return aG;
        } else if (cjf()) {
            return In(hIT);
        } else {
            aq In = In(hIO);
            if (In != null) {
                In.dK("ab_tag", ciW()).dK(TiebaInitialize.Params.AB_ACTION, "click");
                if (bfG() != null) {
                    bw bfG2 = bfG();
                    if (bfG2.getBaijiahaoData() != null) {
                        In.dK("obj_param4", bfG2.getBaijiahaoData().oriUgcNid);
                    }
                    In.aj("obj_param5", af(bfG2));
                    In.dK("nid", bfG2.getNid());
                    if (bfG2.bkj()) {
                        In.aj(TiebaInitialize.Params.OBJ_PARAM2, 2);
                        return In;
                    }
                    In.aj(TiebaInitialize.Params.OBJ_PARAM2, 1);
                    return In;
                }
                return In;
            }
            return In;
        }
    }

    public aq cjl() {
        if (cjf()) {
            return In(hIU);
        }
        aq In = In(hIP);
        if (In != null) {
            In.dK("ab_tag", ciW()).dK(TiebaInitialize.Params.AB_ACTION, "click");
            if (bfG() != null) {
                bw bfG = bfG();
                if (bfG.getBaijiahaoData() != null) {
                    In.dK("obj_param4", bfG.getBaijiahaoData().oriUgcNid);
                }
                In.aj("obj_param5", af(bfG));
                In.dK("nid", bfG.getNid());
                return In;
            }
            return In;
        }
        return In;
    }

    public aq cjm() {
        return In(hIV);
    }

    public aq cjn() {
        aq aG = aG(hIY, true);
        if (bfG() != null) {
            bw bfG = bfG();
            if (bfG.getBaijiahaoData() != null) {
                aG.dK("obj_param4", bfG.getBaijiahaoData().oriUgcNid);
                aG.dK("obj_param6", bfG.getBaijiahaoData().oriUgcVid);
            }
            aG.aj("obj_param5", af(bfG));
            aG.dK("nid", bfG.getNid());
        }
        return aG;
    }

    public aq Ir(String str) {
        aq In = In(str);
        if (this.eji != null && this.eji.bih() != null) {
            In.aj(TiebaInitialize.Params.AB_TYPE, this.eji.bih().hadConcerned() ? 1 : 0);
        }
        return In;
    }

    public aq Is(String str) {
        return In(str);
    }

    public int ae(bw bwVar) {
        if (bwVar == null) {
            return 0;
        }
        if (bwVar.bgP()) {
            return 1;
        }
        if (bwVar.bgN()) {
            return 2;
        }
        if (bwVar.bkc()) {
            return 3;
        }
        return bwVar.bkd() ? 4 : 0;
    }

    public int af(bw bwVar) {
        if (bwVar == null) {
            return 1;
        }
        if (bwVar.bkd() || bwVar.bkc()) {
            return 2;
        }
        return (bwVar.bgP() || bwVar.bgQ()) ? 3 : 1;
    }
}
