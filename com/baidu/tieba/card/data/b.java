package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.aq;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class b extends com.baidu.tbadk.core.data.a implements ag {
    public static final BdUniqueId iug = BdUniqueId.gen();
    public static final BdUniqueId iuh = BdUniqueId.gen();
    public static final BdUniqueId iui = BdUniqueId.gen();
    public static final BdUniqueId iuj = BdUniqueId.gen();
    public static final BdUniqueId iuk = BdUniqueId.gen();
    public static final BdUniqueId iul = BdUniqueId.gen();
    public static final BdUniqueId ium = BdUniqueId.gen();
    public static final BdUniqueId iun = BdUniqueId.gen();
    public static final BdUniqueId iuo = BdUniqueId.gen();
    public static final BdUniqueId iup = BdUniqueId.gen();
    public static final ArrayList<BdUniqueId> iuq = new ArrayList<>();
    public static final ArrayList<BdUniqueId> iur = new ArrayList<>();
    public static BdUniqueId[][] ius;
    public bz eHK;
    private String iut;
    private int iuu;
    private String iuv;
    private String iuw;
    public int iuy;
    private String mExtra;
    private String mSource;
    public String tid;
    public int objType = 1;
    private Integer iux = 0;
    public int eNX = 0;
    public int eNY = 0;
    public boolean eNF = false;
    public boolean eNW = false;
    public boolean eNK = false;
    public boolean iuz = false;
    public boolean eNJ = false;
    public boolean eNG = false;
    public boolean iuA = false;
    public boolean eNS = false;
    public boolean eNU = false;
    public boolean eNV = false;
    public boolean iuB = false;
    public boolean eNM = false;
    public boolean eNL = false;
    public boolean iuC = false;

    static {
        iuq.add(iug);
        iuq.add(iuh);
        iur.add(iul);
        iur.add(iui);
        iur.add(iuk);
        iur.add(iuj);
        ius = (BdUniqueId[][]) Array.newInstance(BdUniqueId.class, iuq.size(), iur.size());
        for (int i = 0; i < iuq.size(); i++) {
            for (int i2 = 0; i2 < iur.size(); i2++) {
                ius[i][i2] = BdUniqueId.gen();
            }
        }
    }

    public void setWeight(String str) {
        this.iut = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void wT(int i) {
        this.iuu = i;
    }

    public void Ie(String str) {
        this.iuv = str;
    }

    public int crv() {
        return this.iuu;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String bkY() {
        return this.mSource + "#" + this.iuu + "#" + this.iuv;
    }

    public String getWeight() {
        return this.iut;
    }

    public String getSource() {
        return this.mSource;
    }

    public String crw() {
        return this.iuv;
    }

    public String crx() {
        return this.iuw;
    }

    public void If(String str) {
        this.iuw = str;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bz bkV() {
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

    public Integer cry() {
        return this.iux;
    }

    public void p(Integer num) {
        this.iux = num;
    }

    public aq Ig(String str) {
        return aA(str, false);
    }

    public aq aA(String str, boolean z) {
        bz bkV = bkV();
        if (bkV == null || str.length() == 0) {
            return null;
        }
        aq dW = new aq(str).dW("fid", String.valueOf(bkV.getFid())).dW("tid", String.valueOf(bkV.getTid())).dW(IntentConfig.NID, bkV.blV()).dW("obj_id", getExtra()).dW("obj_param1", getWeight()).an(TiebaInitialize.Params.OBJ_PARAM2, 1).dW("obj_source", getSource()).an("obj_locate", crv()).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.cra()).dW("ab_tag", crw());
        if (!z) {
            dW.an("obj_type", crz());
        } else {
            if (bkV.eQO > 0) {
                dW.an("midpageflag", 1);
            } else {
                dW.an("midpageflag", 0);
            }
            dW.an("is_vertical", cry().intValue());
        }
        if (bkV.bpd() != null && bkV.bpd().dLo() != null && bkV.bpd().dLo().bHf() != null && bkV.bpd().dLo().bHf().size() > 0) {
            dW.an(TiebaInitialize.Params.OBJ_TO, bkV.bpd().nnu ? 2 : 1);
        }
        return dW;
    }

    public aq aV(String str, int i) {
        bz bkV = bkV();
        if (bkV == null) {
            return null;
        }
        aq dW = new aq(str).dW("fid", String.valueOf(bkV.getFid())).dW("tid", String.valueOf(bkV.getTid())).an(TiebaInitialize.Params.OBJ_PARAM2, 1).dW("obj_param1", getWeight()).dW("obj_source", getSource()).an("obj_locate", crv()).dW("obj_name", crw()).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.cra());
        if (i == 0) {
            dW.an("obj_type", crz());
        } else {
            dW.an("obj_type", i);
        }
        dW.dW("obj_id", getExtra());
        return dW;
    }

    private int crz() {
        int i;
        int i2 = 0;
        bz bkV = bkV();
        if (bkV == null) {
            return 0;
        }
        ArrayList<MediaData> bnG = bkV.bnG();
        if (bnG == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = bnG.iterator();
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

    @Override // com.baidu.tbadk.core.util.ag
    public ArrayList<PreLoadImageInfo> getImages() {
        bz bkV = bkV();
        if (bkV != null) {
            return bkV.getImages();
        }
        return null;
    }

    public void wU(int i) {
        this.iuy = i;
    }

    public boolean crA() {
        return this.iuy == 1;
    }

    @Override // com.baidu.tbadk.core.data.a
    public at bkX() {
        if (bkV() == null || this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        at atVar = new at();
        atVar.setTid(bkV().getTid());
        atVar.setFid(bkV().getFid());
        atVar.setNid(bkV().blV());
        atVar.setFeedBackReasonMap(this.feedBackReasonMap);
        atVar.weight = this.iut;
        atVar.source = this.mSource;
        atVar.extra = this.mExtra;
        atVar.threadType = bkV().threadType;
        return atVar;
    }

    public aq crB() {
        return null;
    }

    public aq crC() {
        return null;
    }

    public aq crD() {
        return null;
    }

    public aq crE() {
        return null;
    }

    public aq Ih(String str) {
        return null;
    }

    public boolean bmc() {
        return false;
    }
}
