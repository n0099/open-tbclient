package com.baidu.tieba.card.data;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public abstract class c extends AbsThreadDataSupport implements af {
    public bu dLi;
    private String gUa;
    private int gUb;
    private String gUc;
    private String gUd;
    public int gUf;
    private String mExtra;
    private String mSource;
    public String tid;
    public int objType = 1;
    private Integer gUe = 0;
    public int dLj = 0;
    public int dLk = 0;

    public void setWeight(String str) {
        this.gUa = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void sR(int i) {
        this.gUb = i;
    }

    public void DQ(String str) {
        this.gUc = str;
    }

    public int bOM() {
        return this.gUb;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String aPV() {
        return this.mSource + "#" + this.gUb + "#" + this.gUc;
    }

    public String getWeight() {
        return this.gUa;
    }

    public String getSource() {
        return this.mSource;
    }

    public String bON() {
        return this.gUc;
    }

    public String bOO() {
        return this.gUd;
    }

    public void DR(String str) {
        this.gUd = str;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bu aPS() {
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

    public Integer bOP() {
        return this.gUe;
    }

    public void k(Integer num) {
        this.gUe = num;
    }

    public ao DS(String str) {
        return aA(str, false);
    }

    public ao aA(String str, boolean z) {
        bu aPS = aPS();
        if (aPS == null || str.length() == 0) {
            return null;
        }
        ao dk = new ao(str).dk("fid", String.valueOf(aPS.getFid())).dk("tid", String.valueOf(aPS.getTid())).dk("nid", aPS.getNid()).dk("obj_id", getExtra()).dk("obj_param1", getWeight()).ag(TiebaInitialize.Params.OBJ_PARAM2, 1).dk("obj_source", getSource()).ag("obj_locate", bOM()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.bOs()).dk("ab_tag", bON());
        if (!z) {
            dk.ag("obj_type", bOQ());
        } else {
            if (aPS.dNV > 0) {
                dk.ag("midpageflag", 1);
            } else {
                dk.ag("midpageflag", 0);
            }
            dk.ag("is_vertical", bOP().intValue());
        }
        if (aPS.aTS() != null && aPS.aTS().dib() != null && aPS.aTS().dib().bkP() != null && aPS.aTS().dib().bkP().size() > 0) {
            dk.ag(TiebaInitialize.Params.OBJ_TO, aPS.aTS().lGt ? 2 : 1);
        }
        return dk;
    }

    public ao aH(String str, int i) {
        bu aPS = aPS();
        if (aPS == null) {
            return null;
        }
        ao dk = new ao(str).dk("fid", String.valueOf(aPS.getFid())).dk("tid", String.valueOf(aPS.getTid())).ag(TiebaInitialize.Params.OBJ_PARAM2, 1).dk("obj_param1", getWeight()).dk("obj_source", getSource()).ag("obj_locate", bOM()).dk("obj_name", bON()).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.bOs());
        if (i == 0) {
            dk.ag("obj_type", bOQ());
        } else {
            dk.ag("obj_type", i);
        }
        dk.dk("obj_id", getExtra());
        return dk;
    }

    private int bOQ() {
        int i;
        int i2 = 0;
        bu aPS = aPS();
        if (aPS == null) {
            return 0;
        }
        ArrayList<MediaData> aSy = aPS.aSy();
        if (aSy == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = aSy.iterator();
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

    @Override // com.baidu.tbadk.core.util.af
    public ArrayList<PreLoadImageInfo> getImages() {
        bu aPS = aPS();
        if (aPS != null) {
            return aPS.getImages();
        }
        return null;
    }

    public void sS(int i) {
        this.gUf = i;
    }

    public boolean bOR() {
        return this.gUf == 1;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ap aPU() {
        if (aPS() == null || this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        ap apVar = new ap();
        apVar.setTid(aPS().getTid());
        apVar.setFid(aPS().getFid());
        apVar.setNid(aPS().getNid());
        apVar.setFeedBackReasonMap(this.feedBackReasonMap);
        apVar.weight = this.gUa;
        apVar.source = this.mSource;
        apVar.extra = this.mExtra;
        apVar.threadType = aPS().threadType;
        return apVar;
    }

    public void bOS() {
        if (this.dLi == null) {
        }
    }
}
