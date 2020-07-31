package com.baidu.tieba.card.data;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes15.dex */
public abstract class c extends AbsThreadDataSupport implements ag {
    public bv dLK;
    private String gZE;
    private int gZF;
    private String gZG;
    private String gZH;
    public int gZJ;
    private String mExtra;
    private String mSource;
    public String tid;
    public int objType = 1;
    private Integer gZI = 0;
    public int dRu = 0;
    public int dRv = 0;

    public void setWeight(String str) {
        this.gZE = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void tj(int i) {
        this.gZF = i;
    }

    public void EB(String str) {
        this.gZG = str;
    }

    public int bRX() {
        return this.gZF;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String aTQ() {
        return this.mSource + "#" + this.gZF + "#" + this.gZG;
    }

    public String getWeight() {
        return this.gZE;
    }

    public String getSource() {
        return this.mSource;
    }

    public String bRY() {
        return this.gZG;
    }

    public String bRZ() {
        return this.gZH;
    }

    public void EC(String str) {
        this.gZH = str;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bv aTN() {
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

    public Integer bSa() {
        return this.gZI;
    }

    public void k(Integer num) {
        this.gZI = num;
    }

    public ap ED(String str) {
        return ay(str, false);
    }

    public ap ay(String str, boolean z) {
        bv aTN = aTN();
        if (aTN == null || str.length() == 0) {
            return null;
        }
        ap dn = new ap(str).dn("fid", String.valueOf(aTN.getFid())).dn("tid", String.valueOf(aTN.getTid())).dn("nid", aTN.getNid()).dn("obj_id", getExtra()).dn("obj_param1", getWeight()).ah(TiebaInitialize.Params.OBJ_PARAM2, 1).dn("obj_source", getSource()).ah("obj_locate", bRX()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.bRC()).dn("ab_tag", bRY());
        if (!z) {
            dn.ah("obj_type", bSb());
        } else {
            if (aTN.dUg > 0) {
                dn.ah("midpageflag", 1);
            } else {
                dn.ah("midpageflag", 0);
            }
            dn.ah("is_vertical", bSa().intValue());
        }
        if (aTN.aXO() != null && aTN.aXO().dlj() != null && aTN.aXO().dlj().boJ() != null && aTN.aXO().dlj().boJ().size() > 0) {
            dn.ah(TiebaInitialize.Params.OBJ_TO, aTN.aXO().lNH ? 2 : 1);
        }
        return dn;
    }

    public ap aG(String str, int i) {
        bv aTN = aTN();
        if (aTN == null) {
            return null;
        }
        ap dn = new ap(str).dn("fid", String.valueOf(aTN.getFid())).dn("tid", String.valueOf(aTN.getTid())).ah(TiebaInitialize.Params.OBJ_PARAM2, 1).dn("obj_param1", getWeight()).dn("obj_source", getSource()).ah("obj_locate", bRX()).dn("obj_name", bRY()).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.bRC());
        if (i == 0) {
            dn.ah("obj_type", bSb());
        } else {
            dn.ah("obj_type", i);
        }
        dn.dn("obj_id", getExtra());
        return dn;
    }

    private int bSb() {
        int i;
        int i2 = 0;
        bv aTN = aTN();
        if (aTN == null) {
            return 0;
        }
        ArrayList<MediaData> aWu = aTN.aWu();
        if (aWu == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = aWu.iterator();
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
        bv aTN = aTN();
        if (aTN != null) {
            return aTN.getImages();
        }
        return null;
    }

    public void tk(int i) {
        this.gZJ = i;
    }

    public boolean bSc() {
        return this.gZJ == 1;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public aq aTP() {
        if (aTN() == null || this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        aq aqVar = new aq();
        aqVar.setTid(aTN().getTid());
        aqVar.setFid(aTN().getFid());
        aqVar.setNid(aTN().getNid());
        aqVar.setFeedBackReasonMap(this.feedBackReasonMap);
        aqVar.weight = this.gZE;
        aqVar.source = this.mSource;
        aqVar.extra = this.mExtra;
        aqVar.threadType = aTN().threadType;
        return aqVar;
    }

    public void bSd() {
        if (this.dLK == null) {
        }
    }
}
