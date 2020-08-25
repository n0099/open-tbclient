package com.baidu.tieba.card.data;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.aq;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes15.dex */
public abstract class c extends AbsThreadDataSupport implements ah {
    public bw dUS;
    private String hmA;
    public int hmC;
    private String hmx;
    private int hmy;
    private String hmz;
    private String mExtra;
    private String mSource;
    public String tid;
    public int objType = 1;
    private Integer hmB = 0;
    public int eaP = 0;
    public int eaQ = 0;

    public void setWeight(String str) {
        this.hmx = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void vy(int i) {
        this.hmy = i;
    }

    public void Ha(String str) {
        this.hmz = str;
    }

    public int ccj() {
        return this.hmy;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String bch() {
        return this.mSource + "#" + this.hmy + "#" + this.hmz;
    }

    public String getWeight() {
        return this.hmx;
    }

    public String getSource() {
        return this.mSource;
    }

    public String cck() {
        return this.hmz;
    }

    public String ccl() {
        return this.hmA;
    }

    public void Hb(String str) {
        this.hmA = str;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bce() {
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

    public Integer ccm() {
        return this.hmB;
    }

    public void l(Integer num) {
        this.hmB = num;
    }

    public aq Hc(String str) {
        return aC(str, false);
    }

    public aq aC(String str, boolean z) {
        bw bce = bce();
        if (bce == null || str.length() == 0) {
            return null;
        }
        aq dD = new aq(str).dD("fid", String.valueOf(bce.getFid())).dD("tid", String.valueOf(bce.getTid())).dD("nid", bce.getNid()).dD("obj_id", getExtra()).dD("obj_param1", getWeight()).ai(TiebaInitialize.Params.OBJ_PARAM2, 1).dD("obj_source", getSource()).ai("obj_locate", ccj()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.cbO()).dD("ab_tag", cck());
        if (!z) {
            dD.ai("obj_type", ccn());
        } else {
            if (bce.edC > 0) {
                dD.ai("midpageflag", 1);
            } else {
                dD.ai("midpageflag", 0);
            }
            dD.ai("is_vertical", ccm().intValue());
        }
        if (bce.bgh() != null && bce.bgh().dwH() != null && bce.bgh().dwH().bxw() != null && bce.bgh().dwH().bxw().size() > 0) {
            dD.ai(TiebaInitialize.Params.OBJ_TO, bce.bgh().mft ? 2 : 1);
        }
        return dD;
    }

    public aq aJ(String str, int i) {
        bw bce = bce();
        if (bce == null) {
            return null;
        }
        aq dD = new aq(str).dD("fid", String.valueOf(bce.getFid())).dD("tid", String.valueOf(bce.getTid())).ai(TiebaInitialize.Params.OBJ_PARAM2, 1).dD("obj_param1", getWeight()).dD("obj_source", getSource()).ai("obj_locate", ccj()).dD("obj_name", cck()).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.cbO());
        if (i == 0) {
            dD.ai("obj_type", ccn());
        } else {
            dD.ai("obj_type", i);
        }
        dD.dD("obj_id", getExtra());
        return dD;
    }

    private int ccn() {
        int i;
        int i2 = 0;
        bw bce = bce();
        if (bce == null) {
            return 0;
        }
        ArrayList<MediaData> beN = bce.beN();
        if (beN == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = beN.iterator();
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
        bw bce = bce();
        if (bce != null) {
            return bce.getImages();
        }
        return null;
    }

    public void vz(int i) {
        this.hmC = i;
    }

    public boolean cco() {
        return this.hmC == 1;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bcg() {
        if (bce() == null || this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        ar arVar = new ar();
        arVar.setTid(bce().getTid());
        arVar.setFid(bce().getFid());
        arVar.setNid(bce().getNid());
        arVar.setFeedBackReasonMap(this.feedBackReasonMap);
        arVar.weight = this.hmx;
        arVar.source = this.mSource;
        arVar.extra = this.mExtra;
        arVar.threadType = bce().threadType;
        return arVar;
    }

    public void ccp() {
        if (this.dUS == null) {
        }
    }
}
