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
    public static final BdUniqueId iBN = BdUniqueId.gen();
    public static final BdUniqueId iBO = BdUniqueId.gen();
    public static final BdUniqueId iBP = BdUniqueId.gen();
    public static final BdUniqueId iBQ = BdUniqueId.gen();
    public static final BdUniqueId iBR = BdUniqueId.gen();
    public static final BdUniqueId iBS = BdUniqueId.gen();
    public static final BdUniqueId iBT = BdUniqueId.gen();
    public static final BdUniqueId iBU = BdUniqueId.gen();
    public static final BdUniqueId iBV = BdUniqueId.gen();
    public static final BdUniqueId iBW = BdUniqueId.gen();
    public static final ArrayList<BdUniqueId> iBX = new ArrayList<>();
    public static final ArrayList<BdUniqueId> iBY = new ArrayList<>();
    public static BdUniqueId[][] iBZ;
    public cb eLr;
    private String iCa;
    private int iCb;
    private String iCc;
    private String iCd;
    public int iCf;
    private String mExtra;
    private String mSource;
    public String tid;
    public int objType = 1;
    private Integer iCe = 0;
    public int eRK = 0;
    public int eRL = 0;
    public boolean eRs = false;
    public boolean eRJ = false;
    public boolean eRx = false;
    public boolean iCg = false;
    public boolean eRw = false;
    public boolean eRt = false;
    public boolean iCh = false;
    public boolean eRF = false;
    public boolean eRH = false;
    public boolean eRI = false;
    public boolean iCi = false;
    public boolean eRz = false;
    public boolean eRy = false;
    public boolean iCj = false;

    static {
        iBX.add(iBN);
        iBX.add(iBO);
        iBY.add(iBS);
        iBY.add(iBP);
        iBY.add(iBR);
        iBY.add(iBQ);
        iBZ = (BdUniqueId[][]) Array.newInstance(BdUniqueId.class, iBX.size(), iBY.size());
        for (int i = 0; i < iBX.size(); i++) {
            for (int i2 = 0; i2 < iBY.size(); i2++) {
                iBZ[i][i2] = BdUniqueId.gen();
            }
        }
    }

    public void setWeight(String str) {
        this.iCa = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void xe(int i) {
        this.iCb = i;
    }

    public void IZ(String str) {
        this.iCc = str;
    }

    public int csU() {
        return this.iCb;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String bls() {
        return this.mSource + "#" + this.iCb + "#" + this.iCc;
    }

    public String getWeight() {
        return this.iCa;
    }

    public String getSource() {
        return this.mSource;
    }

    public String csV() {
        return this.iCc;
    }

    public String csW() {
        return this.iCd;
    }

    public void Ja(String str) {
        this.iCd = str;
    }

    @Override // com.baidu.tbadk.core.data.a
    public cb blp() {
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

    public Integer csX() {
        return this.iCe;
    }

    public void p(Integer num) {
        this.iCe = num;
    }

    public ar Jb(String str) {
        return az(str, false);
    }

    public ar az(String str, boolean z) {
        cb blp = blp();
        if (blp == null || str.length() == 0) {
            return null;
        }
        ar dR = new ar(str).dR("fid", String.valueOf(blp.getFid())).dR("tid", String.valueOf(blp.getTid())).dR(IntentConfig.NID, blp.bmq()).dR("obj_id", getExtra()).dR("obj_param1", getWeight()).aq(TiebaInitialize.Params.OBJ_PARAM2, 1).dR("obj_source", getSource()).aq("obj_locate", csU()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.csx()).dR("ab_tag", csV());
        if (!z) {
            dR.aq("obj_type", csY());
        } else {
            if (blp.eUB > 0) {
                dR.aq("midpageflag", 1);
            } else {
                dR.aq("midpageflag", 0);
            }
            dR.aq("is_vertical", csX().intValue());
        }
        if (blp.bpx() != null && blp.bpx().dNQ() != null && blp.bpx().dNQ().bHD() != null && blp.bpx().dNQ().bHD().size() > 0) {
            dR.aq(TiebaInitialize.Params.OBJ_TO, blp.bpx().nzJ ? 2 : 1);
        }
        return dR;
    }

    public ar aW(String str, int i) {
        cb blp = blp();
        if (blp == null) {
            return null;
        }
        ar dR = new ar(str).dR("fid", String.valueOf(blp.getFid())).dR("tid", String.valueOf(blp.getTid())).aq(TiebaInitialize.Params.OBJ_PARAM2, 1).dR("obj_param1", getWeight()).dR("obj_source", getSource()).aq("obj_locate", csU()).dR("obj_name", csV()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.csx());
        if (i == 0) {
            dR.aq("obj_type", csY());
        } else {
            dR.aq("obj_type", i);
        }
        dR.dR("obj_id", getExtra());
        return dR;
    }

    private int csY() {
        int i;
        int i2 = 0;
        cb blp = blp();
        if (blp == null) {
            return 0;
        }
        ArrayList<MediaData> bob = blp.bob();
        if (bob == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = bob.iterator();
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
        cb blp = blp();
        if (blp != null) {
            return blp.getImages();
        }
        return null;
    }

    public void xf(int i) {
        this.iCf = i;
    }

    public boolean csZ() {
        return this.iCf == 1;
    }

    @Override // com.baidu.tbadk.core.data.a
    public av blr() {
        if (blp() == null || this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        av avVar = new av();
        avVar.setTid(blp().getTid());
        avVar.setFid(blp().getFid());
        avVar.setNid(blp().bmq());
        avVar.setFeedBackReasonMap(this.feedBackReasonMap);
        avVar.weight = this.iCa;
        avVar.source = this.mSource;
        avVar.extra = this.mExtra;
        avVar.threadType = blp().threadType;
        return avVar;
    }

    public ar cta() {
        return null;
    }

    public ar ctb() {
        return null;
    }

    public ar ctc() {
        return null;
    }

    public ar ctd() {
        return null;
    }

    public ar Jc(String str) {
        return null;
    }

    public boolean bmx() {
        return false;
    }
}
