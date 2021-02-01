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
    public static BdUniqueId[][] iAc;
    public cb eJQ;
    private String iAd;
    private int iAe;
    private String iAf;
    private String iAg;
    public int iAi;
    private String mExtra;
    private String mSource;
    public String tid;
    public static final BdUniqueId izQ = BdUniqueId.gen();
    public static final BdUniqueId izR = BdUniqueId.gen();
    public static final BdUniqueId izS = BdUniqueId.gen();
    public static final BdUniqueId izT = BdUniqueId.gen();
    public static final BdUniqueId izU = BdUniqueId.gen();
    public static final BdUniqueId izV = BdUniqueId.gen();
    public static final BdUniqueId izW = BdUniqueId.gen();
    public static final BdUniqueId izX = BdUniqueId.gen();
    public static final BdUniqueId izY = BdUniqueId.gen();
    public static final BdUniqueId izZ = BdUniqueId.gen();
    public static final ArrayList<BdUniqueId> iAa = new ArrayList<>();
    public static final ArrayList<BdUniqueId> iAb = new ArrayList<>();
    public int objType = 1;
    private Integer iAh = 0;
    public int eQj = 0;
    public int eQk = 0;
    public boolean ePR = false;
    public boolean eQi = false;
    public boolean ePW = false;
    public boolean iAj = false;
    public boolean ePV = false;
    public boolean ePS = false;
    public boolean iAk = false;
    public boolean eQe = false;
    public boolean eQg = false;
    public boolean eQh = false;
    public boolean iAl = false;
    public boolean ePY = false;
    public boolean ePX = false;
    public boolean iAm = false;

    static {
        iAa.add(izQ);
        iAa.add(izR);
        iAb.add(izV);
        iAb.add(izS);
        iAb.add(izU);
        iAb.add(izT);
        iAc = (BdUniqueId[][]) Array.newInstance(BdUniqueId.class, iAa.size(), iAb.size());
        for (int i = 0; i < iAa.size(); i++) {
            for (int i2 = 0; i2 < iAb.size(); i2++) {
                iAc[i][i2] = BdUniqueId.gen();
            }
        }
    }

    public void setWeight(String str) {
        this.iAd = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void xd(int i) {
        this.iAe = i;
    }

    public void IP(String str) {
        this.iAf = str;
    }

    public int csH() {
        return this.iAe;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String blq() {
        return this.mSource + "#" + this.iAe + "#" + this.iAf;
    }

    public String getWeight() {
        return this.iAd;
    }

    public String getSource() {
        return this.mSource;
    }

    public String csI() {
        return this.iAf;
    }

    public String csJ() {
        return this.iAg;
    }

    public void IQ(String str) {
        this.iAg = str;
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

    public Integer csK() {
        return this.iAh;
    }

    public void p(Integer num) {
        this.iAh = num;
    }

    public ar IR(String str) {
        return az(str, false);
    }

    public ar az(String str, boolean z) {
        cb bln = bln();
        if (bln == null || str.length() == 0) {
            return null;
        }
        ar dR = new ar(str).dR("fid", String.valueOf(bln.getFid())).dR("tid", String.valueOf(bln.getTid())).dR(IntentConfig.NID, bln.bmo()).dR("obj_id", getExtra()).dR("obj_param1", getWeight()).ap(TiebaInitialize.Params.OBJ_PARAM2, 1).dR("obj_source", getSource()).ap("obj_locate", csH()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.csk()).dR("ab_tag", csI());
        if (!z) {
            dR.ap("obj_type", csL());
        } else {
            if (bln.eTa > 0) {
                dR.ap("midpageflag", 1);
            } else {
                dR.ap("midpageflag", 0);
            }
            dR.ap("is_vertical", csK().intValue());
        }
        if (bln.bpv() != null && bln.bpv().dNz() != null && bln.bpv().dNz().bHz() != null && bln.bpv().dNz().bHz().size() > 0) {
            dR.ap(TiebaInitialize.Params.OBJ_TO, bln.bpv().nxe ? 2 : 1);
        }
        return dR;
    }

    public ar aV(String str, int i) {
        cb bln = bln();
        if (bln == null) {
            return null;
        }
        ar dR = new ar(str).dR("fid", String.valueOf(bln.getFid())).dR("tid", String.valueOf(bln.getTid())).ap(TiebaInitialize.Params.OBJ_PARAM2, 1).dR("obj_param1", getWeight()).dR("obj_source", getSource()).ap("obj_locate", csH()).dR("obj_name", csI()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.csk());
        if (i == 0) {
            dR.ap("obj_type", csL());
        } else {
            dR.ap("obj_type", i);
        }
        dR.dR("obj_id", getExtra());
        return dR;
    }

    private int csL() {
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
        this.iAi = i;
    }

    public boolean csM() {
        return this.iAi == 1;
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
        avVar.weight = this.iAd;
        avVar.source = this.mSource;
        avVar.extra = this.mExtra;
        avVar.threadType = bln().threadType;
        return avVar;
    }

    public ar csN() {
        return null;
    }

    public ar csO() {
        return null;
    }

    public ar csP() {
        return null;
    }

    public ar csQ() {
        return null;
    }

    public ar IS(String str) {
        return null;
    }

    public boolean bmv() {
        return false;
    }
}
