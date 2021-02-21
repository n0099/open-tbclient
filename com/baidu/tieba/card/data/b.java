package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.ar;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class b extends com.baidu.tbadk.core.data.a implements ah {
    public static final BdUniqueId iAe = BdUniqueId.gen();
    public static final BdUniqueId iAf = BdUniqueId.gen();
    public static final BdUniqueId iAg = BdUniqueId.gen();
    public static final BdUniqueId iAh = BdUniqueId.gen();
    public static final BdUniqueId iAi = BdUniqueId.gen();
    public static final BdUniqueId iAj = BdUniqueId.gen();
    public static final BdUniqueId iAk = BdUniqueId.gen();
    public static final BdUniqueId iAl = BdUniqueId.gen();
    public static final BdUniqueId iAm = BdUniqueId.gen();
    public static final BdUniqueId iAn = BdUniqueId.gen();
    public static final ArrayList<BdUniqueId> iAo = new ArrayList<>();
    public static final ArrayList<BdUniqueId> iAp = new ArrayList<>();
    public static BdUniqueId[][] iAq;
    public cb eJQ;
    private String iAr;
    private int iAs;
    private String iAt;
    private String iAu;
    public int iAw;
    private String mExtra;
    private String mSource;
    public String tid;
    public int objType = 1;
    private Integer iAv = 0;
    public int eQj = 0;
    public int eQk = 0;
    public boolean ePR = false;
    public boolean eQi = false;
    public boolean ePW = false;
    public boolean iAx = false;
    public boolean ePV = false;
    public boolean ePS = false;
    public boolean iAy = false;
    public boolean eQe = false;
    public boolean eQg = false;
    public boolean eQh = false;
    public boolean iAz = false;
    public boolean ePY = false;
    public boolean ePX = false;
    public boolean iAA = false;

    static {
        iAo.add(iAe);
        iAo.add(iAf);
        iAp.add(iAj);
        iAp.add(iAg);
        iAp.add(iAi);
        iAp.add(iAh);
        iAq = (BdUniqueId[][]) Array.newInstance(BdUniqueId.class, iAo.size(), iAp.size());
        for (int i = 0; i < iAo.size(); i++) {
            for (int i2 = 0; i2 < iAp.size(); i2++) {
                iAq[i][i2] = BdUniqueId.gen();
            }
        }
    }

    public void setWeight(String str) {
        this.iAr = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void xd(int i) {
        this.iAs = i;
    }

    public void IQ(String str) {
        this.iAt = str;
    }

    public int csO() {
        return this.iAs;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String blq() {
        return this.mSource + "#" + this.iAs + "#" + this.iAt;
    }

    public String getWeight() {
        return this.iAr;
    }

    public String getSource() {
        return this.mSource;
    }

    public String csP() {
        return this.iAt;
    }

    public String csQ() {
        return this.iAu;
    }

    public void IR(String str) {
        this.iAu = str;
    }

    @Override // com.baidu.tbadk.core.data.a
    public cb bln() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void setExtra(String str) {
        this.mExtra = str;
    }

    public String getExtra() {
        return this.mExtra;
    }

    public Integer csR() {
        return this.iAv;
    }

    public void p(Integer num) {
        this.iAv = num;
    }

    public ar IS(String str) {
        return az(str, false);
    }

    public ar az(String str, boolean z) {
        cb bln = bln();
        if (bln == null || str.length() == 0) {
            return null;
        }
        ar dR = new ar(str).dR("fid", String.valueOf(bln.getFid())).dR("tid", String.valueOf(bln.getTid())).dR(IntentConfig.NID, bln.bmo()).dR("obj_id", getExtra()).dR("obj_param1", getWeight()).ap(TiebaInitialize.Params.OBJ_PARAM2, 1).dR("obj_source", getSource()).ap("obj_locate", csO()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.csr()).dR("ab_tag", csP());
        if (!z) {
            dR.ap("obj_type", csS());
        } else {
            if (bln.eTa > 0) {
                dR.ap("midpageflag", 1);
            } else {
                dR.ap("midpageflag", 0);
            }
            dR.ap("is_vertical", csR().intValue());
        }
        if (bln.bpv() != null && bln.bpv().dNH() != null && bln.bpv().dNH().bHz() != null && bln.bpv().dNH().bHz().size() > 0) {
            dR.ap(TiebaInitialize.Params.OBJ_TO, bln.bpv().nxE ? 2 : 1);
        }
        return dR;
    }

    public ar aV(String str, int i) {
        cb bln = bln();
        if (bln == null) {
            return null;
        }
        ar dR = new ar(str).dR("fid", String.valueOf(bln.getFid())).dR("tid", String.valueOf(bln.getTid())).ap(TiebaInitialize.Params.OBJ_PARAM2, 1).dR("obj_param1", getWeight()).dR("obj_source", getSource()).ap("obj_locate", csO()).dR("obj_name", csP()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.csr());
        if (i == 0) {
            dR.ap("obj_type", csS());
        } else {
            dR.ap("obj_type", i);
        }
        dR.dR("obj_id", getExtra());
        return dR;
    }

    private int csS() {
        int i;
        int i2 = 0;
        cb bln = bln();
        if (bln == null) {
            return 0;
        }
        ArrayList<MediaData> bnZ = bln.bnZ();
        if (bnZ == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = bnZ.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                MediaData next = it.next();
                if (next != null && next.getType() == 3) {
                    i++;
                }
                i2 = i;
            }
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        cb bln = bln();
        if (bln != null) {
            return bln.getImages();
        }
        return null;
    }

    public void xe(int i) {
        this.iAw = i;
    }

    public boolean csT() {
        return this.iAw == 1;
    }

    @Override // com.baidu.tbadk.core.data.a
    public av blp() {
        if (bln() == null || this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        av avVar = new av();
        avVar.setTid(bln().getTid());
        avVar.setFid(bln().getFid());
        avVar.setNid(bln().bmo());
        avVar.setFeedBackReasonMap(this.feedBackReasonMap);
        avVar.weight = this.iAr;
        avVar.source = this.mSource;
        avVar.extra = this.mExtra;
        avVar.threadType = bln().threadType;
        return avVar;
    }

    public ar csU() {
        return null;
    }

    public ar csV() {
        return null;
    }

    public ar csW() {
        return null;
    }

    public ar csX() {
        return null;
    }

    public ar IT(String str) {
        return null;
    }

    public boolean bmv() {
        return false;
    }
}
