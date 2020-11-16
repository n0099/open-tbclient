package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.ar;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes20.dex */
public abstract class b extends com.baidu.tbadk.core.data.a implements ah {
    public static BdUniqueId[][] ibF;
    public bx evQ;
    private String ibG;
    private int ibH;
    private String ibI;
    private String ibJ;
    public int ibL;
    private String mExtra;
    private String mSource;
    public String tid;
    public static final BdUniqueId ibu = BdUniqueId.gen();
    public static final BdUniqueId ibv = BdUniqueId.gen();
    public static final BdUniqueId ibw = BdUniqueId.gen();
    public static final BdUniqueId ibx = BdUniqueId.gen();
    public static final BdUniqueId iby = BdUniqueId.gen();
    public static final BdUniqueId ibz = BdUniqueId.gen();
    public static final BdUniqueId ibA = BdUniqueId.gen();
    public static final BdUniqueId ibB = BdUniqueId.gen();
    public static final BdUniqueId ibC = BdUniqueId.gen();
    public static final ArrayList<BdUniqueId> ibD = new ArrayList<>();
    public static final ArrayList<BdUniqueId> ibE = new ArrayList<>();
    public int objType = 1;
    private Integer ibK = 0;
    public int eBO = 0;
    public int eBP = 0;
    public boolean eBx = false;
    public boolean eBN = false;
    public boolean eBC = false;
    public boolean ibM = false;
    public boolean eBB = false;
    public boolean eBy = false;
    public boolean ibN = false;
    public boolean eBJ = false;
    public boolean eBL = false;
    public boolean eBM = false;
    public boolean ibO = false;
    public boolean eBE = false;
    public boolean eBD = false;
    public boolean ibP = false;

    static {
        ibD.add(ibu);
        ibD.add(ibv);
        ibE.add(ibz);
        ibE.add(ibw);
        ibE.add(iby);
        ibE.add(ibx);
        ibF = (BdUniqueId[][]) Array.newInstance(BdUniqueId.class, ibD.size(), ibE.size());
        for (int i = 0; i < ibD.size(); i++) {
            for (int i2 = 0; i2 < ibE.size(); i2++) {
                ibF[i][i2] = BdUniqueId.gen();
            }
        }
    }

    public void setWeight(String str) {
        this.ibG = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void xH(int i) {
        this.ibH = i;
    }

    public void IC(String str) {
        this.ibI = str;
    }

    public int cof() {
        return this.ibH;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String bjg() {
        return this.mSource + "#" + this.ibH + "#" + this.ibI;
    }

    public String getWeight() {
        return this.ibG;
    }

    public String getSource() {
        return this.mSource;
    }

    public String cog() {
        return this.ibI;
    }

    public String coh() {
        return this.ibJ;
    }

    public void ID(String str) {
        this.ibJ = str;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bx bjd() {
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

    public Integer coi() {
        return this.ibK;
    }

    public void n(Integer num) {
        this.ibK = num;
    }

    public ar IE(String str) {
        return aI(str, false);
    }

    public ar aI(String str, boolean z) {
        bx bjd = bjd();
        if (bjd == null || str.length() == 0) {
            return null;
        }
        ar dR = new ar(str).dR("fid", String.valueOf(bjd.getFid())).dR("tid", String.valueOf(bjd.getTid())).dR("nid", bjd.getNid()).dR("obj_id", getExtra()).dR("obj_param1", getWeight()).ak(TiebaInitialize.Params.OBJ_PARAM2, 1).dR("obj_source", getSource()).ak("obj_locate", cof()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.n.cnK()).dR("ab_tag", cog());
        if (!z) {
            dR.ak("obj_type", coj());
        } else {
            if (bjd.eED > 0) {
                dR.ak("midpageflag", 1);
            } else {
                dR.ak("midpageflag", 0);
            }
            dR.ak("is_vertical", coi().intValue());
        }
        if (bjd.bnh() != null && bjd.bnh().dJS() != null && bjd.bnh().dJS().bFb() != null && bjd.bnh().dJS().bFb().size() > 0) {
            dR.ak(TiebaInitialize.Params.OBJ_TO, bjd.bnh().mYp ? 2 : 1);
        }
        return dR;
    }

    public ar aM(String str, int i) {
        bx bjd = bjd();
        if (bjd == null) {
            return null;
        }
        ar dR = new ar(str).dR("fid", String.valueOf(bjd.getFid())).dR("tid", String.valueOf(bjd.getTid())).ak(TiebaInitialize.Params.OBJ_PARAM2, 1).dR("obj_param1", getWeight()).dR("obj_source", getSource()).ak("obj_locate", cof()).dR("obj_name", cog()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.n.cnK());
        if (i == 0) {
            dR.ak("obj_type", coj());
        } else {
            dR.ak("obj_type", i);
        }
        dR.dR("obj_id", getExtra());
        return dR;
    }

    private int coj() {
        int i;
        int i2 = 0;
        bx bjd = bjd();
        if (bjd == null) {
            return 0;
        }
        ArrayList<MediaData> blL = bjd.blL();
        if (blL == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = blL.iterator();
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
        bx bjd = bjd();
        if (bjd != null) {
            return bjd.getImages();
        }
        return null;
    }

    public void xI(int i) {
        this.ibL = i;
    }

    public boolean cok() {
        return this.ibL == 1;
    }

    @Override // com.baidu.tbadk.core.data.a
    public as bjf() {
        if (bjd() == null || this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        as asVar = new as();
        asVar.setTid(bjd().getTid());
        asVar.setFid(bjd().getFid());
        asVar.setNid(bjd().getNid());
        asVar.setFeedBackReasonMap(this.feedBackReasonMap);
        asVar.weight = this.ibG;
        asVar.source = this.mSource;
        asVar.extra = this.mExtra;
        asVar.threadType = bjd().threadType;
        return asVar;
    }

    public ar col() {
        return null;
    }

    public ar com() {
        return null;
    }

    public ar con() {
        return null;
    }

    public ar coo() {
        return null;
    }

    public ar IF(String str) {
        return null;
    }

    public boolean bki() {
        return false;
    }
}
