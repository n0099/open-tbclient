package com.baidu.tieba.card.data;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public abstract class c extends AbsThreadDataSupport implements ae {
    public bk dEA;
    private String gGP;
    private int gGQ;
    private String gGR;
    private String gGS;
    public int gGU;
    private String mExtra;
    private String mSource;
    public String tid;
    public int objType = 1;
    private Integer gGT = 0;
    public int dEB = 0;
    public int dEC = 0;

    public void setWeight(String str) {
        this.gGP = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void sr(int i) {
        this.gGQ = i;
    }

    public void Dp(String str) {
        this.gGR = str;
    }

    public int bLz() {
        return this.gGQ;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String aOl() {
        return this.mSource + "#" + this.gGQ + "#" + this.gGR;
    }

    public String getWeight() {
        return this.gGP;
    }

    public String getSource() {
        return this.mSource;
    }

    public String bLA() {
        return this.gGR;
    }

    public String bLB() {
        return this.gGS;
    }

    public void Dq(String str) {
        this.gGS = str;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bk aOi() {
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

    public Integer bLC() {
        return this.gGT;
    }

    public void k(Integer num) {
        this.gGT = num;
    }

    public an Dr(String str) {
        return ay(str, false);
    }

    public an ay(String str, boolean z) {
        bk aOi = aOi();
        if (aOi == null || str.length() == 0) {
            return null;
        }
        an dh = new an(str).dh("fid", String.valueOf(aOi.getFid())).dh("tid", String.valueOf(aOi.getTid())).dh("nid", aOi.getNid()).dh("obj_id", getExtra()).dh("obj_param1", getWeight()).ag(TiebaInitialize.Params.OBJ_PARAM2, 1).dh("obj_source", getSource()).ag("obj_locate", bLz()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.bLh());
        if (!z) {
            dh.ag("obj_type", bLD());
        } else {
            if (aOi.dHk > 0) {
                dh.ag("midpageflag", 1);
            } else {
                dh.ag("midpageflag", 0);
            }
            dh.dh("ab_tag", bLA());
            dh.ag("is_vertical", bLC().intValue());
        }
        if (aOi.aSb() != null && aOi.aSb().ddw() != null && aOi.aSb().ddw().biq() != null && aOi.aSb().ddw().biq().size() > 0) {
            dh.ag(TiebaInitialize.Params.OBJ_TO, aOi.aSb().llr ? 2 : 1);
        }
        return dh;
    }

    public an aI(String str, int i) {
        bk aOi = aOi();
        if (aOi == null) {
            return null;
        }
        an dh = new an(str).dh("fid", String.valueOf(aOi.getFid())).dh("tid", String.valueOf(aOi.getTid())).ag(TiebaInitialize.Params.OBJ_PARAM2, 1).dh("obj_param1", getWeight()).dh("obj_source", getSource()).ag("obj_locate", bLz()).dh("obj_name", bLA()).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.bLh());
        if (i == 0) {
            dh.ag("obj_type", bLD());
        } else {
            dh.ag("obj_type", i);
        }
        dh.dh("obj_id", getExtra());
        return dh;
    }

    private int bLD() {
        int i;
        int i2 = 0;
        bk aOi = aOi();
        if (aOi == null) {
            return 0;
        }
        ArrayList<MediaData> aQH = aOi.aQH();
        if (aQH == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = aQH.iterator();
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

    @Override // com.baidu.tbadk.core.util.ae
    public ArrayList<PreLoadImageInfo> getImages() {
        bk aOi = aOi();
        if (aOi != null) {
            return aOi.getImages();
        }
        return null;
    }

    public void ss(int i) {
        this.gGU = i;
    }

    public boolean bLE() {
        return this.gGU == 1;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ak aOk() {
        if (aOi() == null || this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        ak akVar = new ak();
        akVar.setTid(aOi().getTid());
        akVar.setFid(aOi().getFid());
        akVar.setNid(aOi().getNid());
        akVar.setFeedBackReasonMap(this.feedBackReasonMap);
        akVar.weight = this.gGP;
        akVar.source = this.mSource;
        akVar.extra = this.mExtra;
        akVar.threadType = aOi().threadType;
        return akVar;
    }

    public void bLF() {
        if (this.dEA == null) {
        }
    }
}
