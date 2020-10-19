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
    public bw eji;
    private String hIA;
    private String hIB;
    public int hID;
    private String hIy;
    private int hIz;
    private String mExtra;
    private String mSource;
    public String tid;
    public int objType = 1;
    private Integer hIC = 0;
    public int epi = 0;
    public int epj = 0;

    public void setWeight(String str) {
        this.hIy = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void wD(int i) {
        this.hIz = i;
    }

    public void Il(String str) {
        this.hIA = str;
    }

    public int ciV() {
        return this.hIz;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public String bfJ() {
        return this.mSource + "#" + this.hIz + "#" + this.hIA;
    }

    public String getWeight() {
        return this.hIy;
    }

    public String getSource() {
        return this.mSource;
    }

    public String ciW() {
        return this.hIA;
    }

    public String ciX() {
        return this.hIB;
    }

    public void Im(String str) {
        this.hIB = str;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bfG() {
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

    public Integer ciY() {
        return this.hIC;
    }

    public void n(Integer num) {
        this.hIC = num;
    }

    public aq In(String str) {
        return aG(str, false);
    }

    public aq aG(String str, boolean z) {
        bw bfG = bfG();
        if (bfG == null || str.length() == 0) {
            return null;
        }
        aq dK = new aq(str).dK("fid", String.valueOf(bfG.getFid())).dK("tid", String.valueOf(bfG.getTid())).dK("nid", bfG.getNid()).dK("obj_id", getExtra()).dK("obj_param1", getWeight()).aj(TiebaInitialize.Params.OBJ_PARAM2, 1).dK("obj_source", getSource()).aj("obj_locate", ciV()).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.ciA()).dK("ab_tag", ciW());
        if (!z) {
            dK.aj("obj_type", ciZ());
        } else {
            if (bfG.erW > 0) {
                dK.aj("midpageflag", 1);
            } else {
                dK.aj("midpageflag", 0);
            }
            dK.aj("is_vertical", ciY().intValue());
        }
        if (bfG.bjK() != null && bfG.bjK().dEr() != null && bfG.bjK().dEr().bBq() != null && bfG.bjK().dEr().bBq().size() > 0) {
            dK.aj(TiebaInitialize.Params.OBJ_TO, bfG.bjK().mEN ? 2 : 1);
        }
        return dK;
    }

    public aq aK(String str, int i) {
        bw bfG = bfG();
        if (bfG == null) {
            return null;
        }
        aq dK = new aq(str).dK("fid", String.valueOf(bfG.getFid())).dK("tid", String.valueOf(bfG.getTid())).aj(TiebaInitialize.Params.OBJ_PARAM2, 1).dK("obj_param1", getWeight()).dK("obj_source", getSource()).aj("obj_locate", ciV()).dK("obj_name", ciW()).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.ciA());
        if (i == 0) {
            dK.aj("obj_type", ciZ());
        } else {
            dK.aj("obj_type", i);
        }
        dK.dK("obj_id", getExtra());
        return dK;
    }

    private int ciZ() {
        int i;
        int i2 = 0;
        bw bfG = bfG();
        if (bfG == null) {
            return 0;
        }
        ArrayList<MediaData> biq = bfG.biq();
        if (biq == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = biq.iterator();
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
        bw bfG = bfG();
        if (bfG != null) {
            return bfG.getImages();
        }
        return null;
    }

    public void wE(int i) {
        this.hID = i;
    }

    public boolean cja() {
        return this.hID == 1;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bfI() {
        if (bfG() == null || this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        ar arVar = new ar();
        arVar.setTid(bfG().getTid());
        arVar.setFid(bfG().getFid());
        arVar.setNid(bfG().getNid());
        arVar.setFeedBackReasonMap(this.feedBackReasonMap);
        arVar.weight = this.hIy;
        arVar.source = this.mSource;
        arVar.extra = this.mExtra;
        arVar.threadType = bfG().threadType;
        return arVar;
    }

    public void cjb() {
        if (this.eji == null) {
        }
    }
}
