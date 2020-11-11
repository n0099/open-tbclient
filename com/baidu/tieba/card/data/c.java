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
    public bw exA;
    private String iaS;
    private int iaT;
    private String iaU;
    private String iaV;
    public int iaX;
    private String mExtra;
    private String mSource;
    public String tid;
    public int objType = 1;
    private Integer iaW = 0;
    public int eDx = 0;
    public int eDy = 0;

    public void setWeight(String str) {
        this.iaS = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void xj(int i) {
        this.iaT = i;
    }

    public void Jb(String str) {
        this.iaU = str;
    }

    public int coD() {
        return this.iaT;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String bkc() {
        return this.mSource + "#" + this.iaT + "#" + this.iaU;
    }

    public String getWeight() {
        return this.iaS;
    }

    public String getSource() {
        return this.mSource;
    }

    public String coE() {
        return this.iaU;
    }

    public String coF() {
        return this.iaV;
    }

    public void Jc(String str) {
        this.iaV = str;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bjZ() {
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

    public Integer coG() {
        return this.iaW;
    }

    public void n(Integer num) {
        this.iaW = num;
    }

    public aq Jd(String str) {
        return aI(str, false);
    }

    public aq aI(String str, boolean z) {
        bw bjZ = bjZ();
        if (bjZ == null || str.length() == 0) {
            return null;
        }
        aq dR = new aq(str).dR("fid", String.valueOf(bjZ.getFid())).dR("tid", String.valueOf(bjZ.getTid())).dR("nid", bjZ.getNid()).dR("obj_id", getExtra()).dR("obj_param1", getWeight()).al(TiebaInitialize.Params.OBJ_PARAM2, 1).dR("obj_source", getSource()).al("obj_locate", coD()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.n.coi()).dR("ab_tag", coE());
        if (!z) {
            dR.al("obj_type", coH());
        } else {
            if (bjZ.eGl > 0) {
                dR.al("midpageflag", 1);
            } else {
                dR.al("midpageflag", 0);
            }
            dR.al("is_vertical", coG().intValue());
        }
        if (bjZ.bod() != null && bjZ.bod().dKb() != null && bjZ.bod().dKb().bFI() != null && bjZ.bod().dKb().bFI().size() > 0) {
            dR.al(TiebaInitialize.Params.OBJ_TO, bjZ.bod().mXx ? 2 : 1);
        }
        return dR;
    }

    public aq aN(String str, int i) {
        bw bjZ = bjZ();
        if (bjZ == null) {
            return null;
        }
        aq dR = new aq(str).dR("fid", String.valueOf(bjZ.getFid())).dR("tid", String.valueOf(bjZ.getTid())).al(TiebaInitialize.Params.OBJ_PARAM2, 1).dR("obj_param1", getWeight()).dR("obj_source", getSource()).al("obj_locate", coD()).dR("obj_name", coE()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.n.coi());
        if (i == 0) {
            dR.al("obj_type", coH());
        } else {
            dR.al("obj_type", i);
        }
        dR.dR("obj_id", getExtra());
        return dR;
    }

    private int coH() {
        int i;
        int i2 = 0;
        bw bjZ = bjZ();
        if (bjZ == null) {
            return 0;
        }
        ArrayList<MediaData> bmJ = bjZ.bmJ();
        if (bmJ == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = bmJ.iterator();
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
        bw bjZ = bjZ();
        if (bjZ != null) {
            return bjZ.getImages();
        }
        return null;
    }

    public void xk(int i) {
        this.iaX = i;
    }

    public boolean coI() {
        return this.iaX == 1;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bkb() {
        if (bjZ() == null || this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        ar arVar = new ar();
        arVar.setTid(bjZ().getTid());
        arVar.setFid(bjZ().getFid());
        arVar.setNid(bjZ().getNid());
        arVar.setFeedBackReasonMap(this.feedBackReasonMap);
        arVar.weight = this.iaS;
        arVar.source = this.mSource;
        arVar.extra = this.mExtra;
        arVar.threadType = bjZ().threadType;
        return arVar;
    }

    public void coJ() {
        if (this.exA == null) {
        }
    }
}
