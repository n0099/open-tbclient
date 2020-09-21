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
/* loaded from: classes20.dex */
public abstract class c extends AbsThreadDataSupport implements ah {
    public bw dXg;
    private String htE;
    private int htF;
    private String htG;
    private String htH;
    public int htJ;
    private String mExtra;
    private String mSource;
    public String tid;
    public int objType = 1;
    private Integer htI = 0;
    public int edd = 0;
    public int ede = 0;

    public void setWeight(String str) {
        this.htE = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void vX(int i) {
        this.htF = i;
    }

    public void Hy(String str) {
        this.htG = str;
    }

    public int cfz() {
        return this.htF;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String bdb() {
        return this.mSource + "#" + this.htF + "#" + this.htG;
    }

    public String getWeight() {
        return this.htE;
    }

    public String getSource() {
        return this.mSource;
    }

    public String cfA() {
        return this.htG;
    }

    public String cfB() {
        return this.htH;
    }

    public void Hz(String str) {
        this.htH = str;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bcY() {
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

    public Integer cfC() {
        return this.htI;
    }

    public void l(Integer num) {
        this.htI = num;
    }

    public aq HA(String str) {
        return aC(str, false);
    }

    public aq aC(String str, boolean z) {
        bw bcY = bcY();
        if (bcY == null || str.length() == 0) {
            return null;
        }
        aq dF = new aq(str).dF("fid", String.valueOf(bcY.getFid())).dF("tid", String.valueOf(bcY.getTid())).dF("nid", bcY.getNid()).dF("obj_id", getExtra()).dF("obj_param1", getWeight()).ai(TiebaInitialize.Params.OBJ_PARAM2, 1).dF("obj_source", getSource()).ai("obj_locate", cfz()).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.cfe()).dF("ab_tag", cfA());
        if (!z) {
            dF.ai("obj_type", cfD());
        } else {
            if (bcY.efQ > 0) {
                dF.ai("midpageflag", 1);
            } else {
                dF.ai("midpageflag", 0);
            }
            dF.ai("is_vertical", cfC().intValue());
        }
        if (bcY.bhb() != null && bcY.bhb().dAF() != null && bcY.bhb().dAF().byG() != null && bcY.bhb().dAF().byG().size() > 0) {
            dF.ai(TiebaInitialize.Params.OBJ_TO, bcY.bhb().mph ? 2 : 1);
        }
        return dF;
    }

    public aq aJ(String str, int i) {
        bw bcY = bcY();
        if (bcY == null) {
            return null;
        }
        aq dF = new aq(str).dF("fid", String.valueOf(bcY.getFid())).dF("tid", String.valueOf(bcY.getTid())).ai(TiebaInitialize.Params.OBJ_PARAM2, 1).dF("obj_param1", getWeight()).dF("obj_source", getSource()).ai("obj_locate", cfz()).dF("obj_name", cfA()).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.cfe());
        if (i == 0) {
            dF.ai("obj_type", cfD());
        } else {
            dF.ai("obj_type", i);
        }
        dF.dF("obj_id", getExtra());
        return dF;
    }

    private int cfD() {
        int i;
        int i2 = 0;
        bw bcY = bcY();
        if (bcY == null) {
            return 0;
        }
        ArrayList<MediaData> bfH = bcY.bfH();
        if (bfH == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = bfH.iterator();
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
        bw bcY = bcY();
        if (bcY != null) {
            return bcY.getImages();
        }
        return null;
    }

    public void vY(int i) {
        this.htJ = i;
    }

    public boolean cfE() {
        return this.htJ == 1;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bda() {
        if (bcY() == null || this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        ar arVar = new ar();
        arVar.setTid(bcY().getTid());
        arVar.setFid(bcY().getFid());
        arVar.setNid(bcY().getNid());
        arVar.setFeedBackReasonMap(this.feedBackReasonMap);
        arVar.weight = this.htE;
        arVar.source = this.mSource;
        arVar.extra = this.mExtra;
        arVar.threadType = bcY().threadType;
        return arVar;
    }

    public void cfF() {
        if (this.dXg == null) {
        }
    }
}
