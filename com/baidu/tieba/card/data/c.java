package com.baidu.tieba.card.data;

import android.util.SparseArray;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public abstract class c extends com.baidu.tbadk.core.data.a implements ae {
    public bh cbq;
    private String din;
    private String ePM;
    private int ePN;
    private String ePO;
    private String ePP;
    public int ePR;
    private String mSource;
    public String tid;
    public int objType = 1;
    public SparseArray<String> feedBackReasonMap = null;
    private Integer ePQ = 0;
    public int cbr = 0;
    public int cbs = 0;

    public void setWeight(String str) {
        this.ePM = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void oP(int i) {
        this.ePN = i;
    }

    public void uB(String str) {
        this.ePO = str;
    }

    public int baG() {
        return this.ePN;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String agL() {
        return this.mSource + "#" + this.ePN + "#" + this.ePO;
    }

    public String getWeight() {
        return this.ePM;
    }

    public String getSource() {
        return this.mSource;
    }

    public String baH() {
        return this.ePO;
    }

    public String baI() {
        return this.ePP;
    }

    public void uC(String str) {
        this.ePP = str;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bh agI() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void setExtra(String str) {
        this.din = str;
    }

    public String getExtra() {
        return this.din;
    }

    public Integer baJ() {
        return this.ePQ;
    }

    public void d(Integer num) {
        this.ePQ = num;
    }

    public an uD(String str) {
        return ab(str, false);
    }

    public an ab(String str, boolean z) {
        bh agI = agI();
        if (agI == null || str.length() == 0) {
            return null;
        }
        an bS = new an(str).bS("fid", String.valueOf(agI.getFid())).bS("tid", String.valueOf(agI.getTid())).bS("obj_id", getExtra()).bS("obj_param1", getWeight()).O(TiebaInitialize.Params.OBJ_PARAM2, 1).bS("obj_source", getSource()).O("obj_locate", baG()).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.n.ban());
        if (!z) {
            bS.O("obj_type", baK());
        } else {
            if (agI.cea > 0) {
                bS.O("midpageflag", 1);
            } else {
                bS.O("midpageflag", 0);
            }
            bS.bS(TiebaInitialize.Params.AB_TAG, baH());
            bS.O("is_vertical", baJ().intValue());
        }
        if (agI.akd() != null && agI.akd().cor() != null && agI.akd().cor().azh() != null && agI.akd().cor().azh().size() > 0) {
            bS.O(TiebaInitialize.Params.OBJ_TO, agI.akd().jiV ? 2 : 1);
        }
        return bS;
    }

    public an ap(String str, int i) {
        bh agI = agI();
        if (agI == null) {
            return null;
        }
        an bS = new an(str).bS("fid", String.valueOf(agI.getFid())).bS("tid", String.valueOf(agI.getTid())).O("obj_id", U(agI)).O(TiebaInitialize.Params.OBJ_PARAM2, 1).bS("obj_param1", getWeight()).bS("obj_source", getSource()).O("obj_locate", baG()).bS("obj_name", baH()).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.n.ban());
        if (i == 0) {
            bS.O("obj_type", baK());
        } else {
            bS.O("obj_type", i);
        }
        bS.bS("obj_id", getExtra());
        return bS;
    }

    private int baK() {
        int i;
        int i2 = 0;
        bh agI = agI();
        if (agI == null) {
            return 0;
        }
        ArrayList<MediaData> aiQ = agI.aiQ();
        if (aiQ == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = aiQ.iterator();
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
        bh agI = agI();
        if (agI != null) {
            return agI.getImages();
        }
        return null;
    }

    private int U(bh bhVar) {
        if (bhVar.ajP() == null || bhVar.ajP().channelId <= 0) {
            return 0;
        }
        return (int) bhVar.ajP().channelId;
    }

    public void oQ(int i) {
        this.ePR = i;
    }

    public boolean baL() {
        return this.ePR == 1;
    }

    @Override // com.baidu.tbadk.core.data.a
    public aj agK() {
        if (agI() == null || this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.setTid(agI().getTid());
        ajVar.setFid(agI().getFid());
        ajVar.setFeedBackReasonMap(this.feedBackReasonMap);
        ajVar.weight = this.ePM;
        ajVar.source = this.mSource;
        ajVar.extra = this.din;
        ajVar.threadType = agI().threadType;
        return ajVar;
    }
}
