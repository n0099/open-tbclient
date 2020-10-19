package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes21.dex */
public class m extends c implements com.baidu.tbadk.core.util.f.a {
    public static final BdUniqueId epH = BdUniqueId.gen();
    public static String hIZ = "";
    public static String hJa = "";
    public static String hJs = "";
    public static String hIY = "";
    public static String hJt = "";
    public static String hJu = "";
    public static String hJv = "";
    public boolean hJr = false;
    public boolean hJw = true;
    public boolean eoR = false;
    public boolean hJx = false;
    public boolean eoX = false;
    public boolean eoY = false;
    public boolean hJq = false;
    public boolean eph = false;
    public boolean epd = false;
    public boolean epf = false;
    public boolean epg = false;
    public int sourceType = 0;

    public m(bw bwVar) {
        this.eji = bwVar;
    }

    public static boolean ab(bw bwVar) {
        return (bwVar == null || bwVar.biz() == null) ? false : true;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (this.eji == null) {
            return l.TYPE;
        }
        if (this.eoR) {
            return l.hJf;
        }
        if (this.hJx) {
            return epH;
        }
        if (this.eoX) {
            return l.hJk;
        }
        if (this.eoY) {
            return l.hJm;
        }
        if (this.hJq) {
            return l.hJl;
        }
        if (this.eph) {
            return l.epp;
        }
        if (this.epd) {
            return l.epB;
        }
        if (this.epf) {
            return l.epD;
        }
        if (this.epg) {
            return l.epE;
        }
        return epH;
    }

    @Override // com.baidu.tieba.card.data.c, com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bfG() {
        if (this.eji == null) {
            return null;
        }
        if (this.eji.bhV() != 5) {
            this.eji.nN(1);
        }
        return this.eji;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String bfH() {
        if (this.eji == null) {
            return null;
        }
        return this.eji.erE;
    }

    public aq Ip(String str) {
        aq aqVar = new aq(str);
        if (this.eji != null) {
            aqVar.u("fid", this.eji.getFid());
            aqVar.dK("tid", this.eji.getTid());
            if (this.eji.bgQ()) {
                aqVar.aj("obj_type", 8);
            } else if (this.eji.bkd()) {
                aqVar.aj("obj_type", 9);
            } else if (this.eji.bgN()) {
                aqVar.aj("obj_type", 2);
            }
            aqVar.aj("obj_param1", cja() ? 2 : 1);
            if (this.eji.bih() != null) {
                aqVar.dK("obj_id", this.eji.bih().getUserId());
            }
        }
        return aqVar;
    }

    public aq cjh() {
        aq aG = aG(hJs, true);
        if (aG != null && bfG() != null) {
            bw bfG = bfG();
            aG.aj("obj_name", bfG.bjK() != null && (bfG.bjK().dEr() != null || bfG.bjK().bBy() != null) ? 1 : 0);
            if (bfG.bih() != null) {
                aG.aj(TiebaInitialize.Params.AB_TYPE, bfG.bih().hadConcerned() ? 1 : 0);
            }
            if (bfG.getBaijiahaoData() != null) {
                aG.dK("obj_param4", bfG.getBaijiahaoData().oriUgcNid);
                aG.dK("obj_param6", bfG.getBaijiahaoData().oriUgcVid);
            }
            aG.aj("obj_param5", af(bfG));
            if (bfG.bkj()) {
                aG.aj(TiebaInitialize.Params.OBJ_TO, 2);
            } else {
                aG.aj(TiebaInitialize.Params.OBJ_TO, 1);
            }
        }
        return aG;
    }

    public aq b(bw bwVar, int i) {
        aq aG = aG(hIY, true);
        if (aG != null) {
            if (i != -1) {
                aG.aj("click_locate", i);
            }
            if (bfG() != null) {
                bw bfG = bfG();
                if (bfG.getBaijiahaoData() != null) {
                    aG.dK("obj_param4", bfG.getBaijiahaoData().oriUgcNid);
                    aG.dK("obj_param6", bfG.getBaijiahaoData().oriUgcVid);
                }
                aG.aj("obj_param5", af(bfG));
            }
        }
        return aG;
    }

    public aq ag(bw bwVar) {
        return b(bwVar, -1);
    }

    public aq cjo() {
        aq aG = aG(hJv, true);
        if (aG != null && bfG() != null) {
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

    public aq ah(bw bwVar) {
        aq aG = aG(hIZ, true);
        if (aG != null && bfG() != null) {
            bw bfG = bfG();
            if (bfG.getBaijiahaoData() != null) {
                aG.dK("obj_param4", bfG.getBaijiahaoData().oriUgcNid);
                aG.dK("obj_param6", bfG.getBaijiahaoData().oriUgcVid);
                if (bfG.bkj()) {
                    aG.aj(TiebaInitialize.Params.OBJ_PARAM2, 2);
                } else {
                    aG.aj(TiebaInitialize.Params.OBJ_PARAM2, 1);
                }
            }
            aG.aj("obj_param5", af(bfG));
        }
        return aG;
    }

    @Override // com.baidu.tbadk.core.util.f.a
    public String getVideoUrl() {
        if (this.eji == null || this.eji.biz() == null || this.eji.biz().video_url == null) {
            return null;
        }
        return this.eji.biz().video_url;
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
