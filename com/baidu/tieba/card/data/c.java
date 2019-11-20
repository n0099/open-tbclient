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
    public bh caz;
    private String dhw;
    private String eOV;
    private int eOW;
    private String eOX;
    private String eOY;
    public int ePa;
    private String mSource;
    public String tid;
    public int objType = 1;
    public SparseArray<String> feedBackReasonMap = null;
    private Integer eOZ = 0;
    public int caA = 0;
    public int caB = 0;

    public void setWeight(String str) {
        this.eOV = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void oO(int i) {
        this.eOW = i;
    }

    public void uB(String str) {
        this.eOX = str;
    }

    public int baE() {
        return this.eOW;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String agJ() {
        return this.mSource + "#" + this.eOW + "#" + this.eOX;
    }

    public String getWeight() {
        return this.eOV;
    }

    public String getSource() {
        return this.mSource;
    }

    public String baF() {
        return this.eOX;
    }

    public String baG() {
        return this.eOY;
    }

    public void uC(String str) {
        this.eOY = str;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bh agG() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void setExtra(String str) {
        this.dhw = str;
    }

    public String getExtra() {
        return this.dhw;
    }

    public Integer baH() {
        return this.eOZ;
    }

    public void d(Integer num) {
        this.eOZ = num;
    }

    public an uD(String str) {
        return ab(str, false);
    }

    public an ab(String str, boolean z) {
        bh agG = agG();
        if (agG == null || str.length() == 0) {
            return null;
        }
        an bS = new an(str).bS("fid", String.valueOf(agG.getFid())).bS("tid", String.valueOf(agG.getTid())).bS("obj_id", getExtra()).bS("obj_param1", getWeight()).O(TiebaInitialize.Params.OBJ_PARAM2, 1).bS("obj_source", getSource()).O("obj_locate", baE()).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.n.bal());
        if (!z) {
            bS.O("obj_type", baI());
        } else {
            if (agG.cdj > 0) {
                bS.O("midpageflag", 1);
            } else {
                bS.O("midpageflag", 0);
            }
            bS.bS(TiebaInitialize.Params.AB_TAG, baF());
            bS.O("is_vertical", baH().intValue());
        }
        if (agG.akb() != null && agG.akb().cop() != null && agG.akb().cop().azf() != null && agG.akb().cop().azf().size() > 0) {
            bS.O(TiebaInitialize.Params.OBJ_TO, agG.akb().jie ? 2 : 1);
        }
        return bS;
    }

    public an ap(String str, int i) {
        bh agG = agG();
        if (agG == null) {
            return null;
        }
        an bS = new an(str).bS("fid", String.valueOf(agG.getFid())).bS("tid", String.valueOf(agG.getTid())).O("obj_id", U(agG)).O(TiebaInitialize.Params.OBJ_PARAM2, 1).bS("obj_param1", getWeight()).bS("obj_source", getSource()).O("obj_locate", baE()).bS("obj_name", baF()).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.n.bal());
        if (i == 0) {
            bS.O("obj_type", baI());
        } else {
            bS.O("obj_type", i);
        }
        bS.bS("obj_id", getExtra());
        return bS;
    }

    private int baI() {
        int i;
        int i2 = 0;
        bh agG = agG();
        if (agG == null) {
            return 0;
        }
        ArrayList<MediaData> aiO = agG.aiO();
        if (aiO == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = aiO.iterator();
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
        bh agG = agG();
        if (agG != null) {
            return agG.getImages();
        }
        return null;
    }

    private int U(bh bhVar) {
        if (bhVar.ajN() == null || bhVar.ajN().channelId <= 0) {
            return 0;
        }
        return (int) bhVar.ajN().channelId;
    }

    public void oP(int i) {
        this.ePa = i;
    }

    public boolean baJ() {
        return this.ePa == 1;
    }

    @Override // com.baidu.tbadk.core.data.a
    public aj agI() {
        if (agG() == null || this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.setTid(agG().getTid());
        ajVar.setFid(agG().getFid());
        ajVar.setFeedBackReasonMap(this.feedBackReasonMap);
        ajVar.weight = this.eOV;
        ajVar.source = this.mSource;
        ajVar.extra = this.dhw;
        ajVar.threadType = agG().threadType;
        return ajVar;
    }
}
