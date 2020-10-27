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
/* loaded from: classes21.dex */
public abstract class c extends AbsThreadDataSupport implements ah {
    public bw erH;
    private String hUV;
    private int hUW;
    private String hUX;
    private String hUY;
    public int hVa;
    private String mExtra;
    private String mSource;
    public String tid;
    public int objType = 1;
    private Integer hUZ = 0;
    public int exG = 0;
    public int exH = 0;

    public void setWeight(String str) {
        this.hUV = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void wW(int i) {
        this.hUW = i;
    }

    public void IK(String str) {
        this.hUX = str;
    }

    public int cmc() {
        return this.hUW;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String bhC() {
        return this.mSource + "#" + this.hUW + "#" + this.hUX;
    }

    public String getWeight() {
        return this.hUV;
    }

    public String getSource() {
        return this.mSource;
    }

    public String cmd() {
        return this.hUX;
    }

    public String cme() {
        return this.hUY;
    }

    public void IL(String str) {
        this.hUY = str;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bhz() {
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

    public Integer cmf() {
        return this.hUZ;
    }

    public void n(Integer num) {
        this.hUZ = num;
    }

    public aq IM(String str) {
        return aI(str, false);
    }

    public aq aI(String str, boolean z) {
        bw bhz = bhz();
        if (bhz == null || str.length() == 0) {
            return null;
        }
        aq dR = new aq(str).dR("fid", String.valueOf(bhz.getFid())).dR("tid", String.valueOf(bhz.getTid())).dR("nid", bhz.getNid()).dR("obj_id", getExtra()).dR("obj_param1", getWeight()).aj(TiebaInitialize.Params.OBJ_PARAM2, 1).dR("obj_source", getSource()).aj("obj_locate", cmc()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.n.clH()).dR("ab_tag", cmd());
        if (!z) {
            dR.aj("obj_type", cmg());
        } else {
            if (bhz.eAw > 0) {
                dR.aj("midpageflag", 1);
            } else {
                dR.aj("midpageflag", 0);
            }
            dR.aj("is_vertical", cmf().intValue());
        }
        if (bhz.blD() != null && bhz.blD().dHz() != null && bhz.blD().dHz().bDj() != null && bhz.blD().dHz().bDj().size() > 0) {
            dR.aj(TiebaInitialize.Params.OBJ_TO, bhz.blD().mRu ? 2 : 1);
        }
        return dR;
    }

    public aq aL(String str, int i) {
        bw bhz = bhz();
        if (bhz == null) {
            return null;
        }
        aq dR = new aq(str).dR("fid", String.valueOf(bhz.getFid())).dR("tid", String.valueOf(bhz.getTid())).aj(TiebaInitialize.Params.OBJ_PARAM2, 1).dR("obj_param1", getWeight()).dR("obj_source", getSource()).aj("obj_locate", cmc()).dR("obj_name", cmd()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.n.clH());
        if (i == 0) {
            dR.aj("obj_type", cmg());
        } else {
            dR.aj("obj_type", i);
        }
        dR.dR("obj_id", getExtra());
        return dR;
    }

    private int cmg() {
        int i;
        int i2 = 0;
        bw bhz = bhz();
        if (bhz == null) {
            return 0;
        }
        ArrayList<MediaData> bkj = bhz.bkj();
        if (bkj == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = bkj.iterator();
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
        bw bhz = bhz();
        if (bhz != null) {
            return bhz.getImages();
        }
        return null;
    }

    public void wX(int i) {
        this.hVa = i;
    }

    public boolean cmh() {
        return this.hVa == 1;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bhB() {
        if (bhz() == null || this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        ar arVar = new ar();
        arVar.setTid(bhz().getTid());
        arVar.setFid(bhz().getFid());
        arVar.setNid(bhz().getNid());
        arVar.setFeedBackReasonMap(this.feedBackReasonMap);
        arVar.weight = this.hUV;
        arVar.source = this.mSource;
        arVar.extra = this.mExtra;
        arVar.threadType = bhz().threadType;
        return arVar;
    }

    public void cmi() {
        if (this.erH == null) {
        }
    }
}
