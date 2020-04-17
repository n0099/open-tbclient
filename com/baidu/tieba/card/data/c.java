package com.baidu.tieba.card.data;

import android.util.SparseArray;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public abstract class c extends com.baidu.tbadk.core.data.a implements ae {
    public bj dqA;
    private String grU;
    private int grV;
    private String grW;
    private String grX;
    public int grZ;
    private String mExtra;
    private String mSource;
    public String tid;
    public int objType = 1;
    public SparseArray<String> feedBackReasonMap = null;
    private Integer grY = 0;
    public int dqB = 0;
    public int dqC = 0;

    public void setWeight(String str) {
        this.grU = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void rN(int i) {
        this.grV = i;
    }

    public void BD(String str) {
        this.grW = str;
    }

    public int bFh() {
        return this.grV;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String aIz() {
        return this.mSource + "#" + this.grV + "#" + this.grW;
    }

    public String getWeight() {
        return this.grU;
    }

    public String getSource() {
        return this.mSource;
    }

    public String bFi() {
        return this.grW;
    }

    public String bFj() {
        return this.grX;
    }

    public void BE(String str) {
        this.grX = str;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj aIw() {
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

    public Integer bFk() {
        return this.grY;
    }

    public void j(Integer num) {
        this.grY = num;
    }

    public an BF(String str) {
        return al(str, false);
    }

    public an al(String str, boolean z) {
        bj aIw = aIw();
        if (aIw == null || str.length() == 0) {
            return null;
        }
        an cI = new an(str).cI("fid", String.valueOf(aIw.getFid())).cI("tid", String.valueOf(aIw.getTid())).cI("obj_id", getExtra()).cI("obj_param1", getWeight()).af(TiebaInitialize.Params.OBJ_PARAM2, 1).cI("obj_source", getSource()).af("obj_locate", bFh()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.l.bEP());
        if (!z) {
            cI.af("obj_type", bFl());
        } else {
            if (aIw.dtm > 0) {
                cI.af("midpageflag", 1);
            } else {
                cI.af("midpageflag", 0);
            }
            cI.cI(TiebaInitialize.Params.AB_TAG, bFi());
            cI.af("is_vertical", bFk().intValue());
        }
        if (aIw.aMe() != null && aIw.aMe().cWt() != null && aIw.aMe().cWt().bch() != null && aIw.aMe().cWt().bch().size() > 0) {
            cI.af(TiebaInitialize.Params.OBJ_TO, aIw.aMe().kSW ? 2 : 1);
        }
        return cI;
    }

    public an aH(String str, int i) {
        bj aIw = aIw();
        if (aIw == null) {
            return null;
        }
        an cI = new an(str).cI("fid", String.valueOf(aIw.getFid())).cI("tid", String.valueOf(aIw.getTid())).af(TiebaInitialize.Params.OBJ_PARAM2, 1).cI("obj_param1", getWeight()).cI("obj_source", getSource()).af("obj_locate", bFh()).cI("obj_name", bFi()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.l.bEP());
        if (i == 0) {
            cI.af("obj_type", bFl());
        } else {
            cI.af("obj_type", i);
        }
        cI.cI("obj_id", getExtra());
        return cI;
    }

    private int bFl() {
        int i;
        int i2 = 0;
        bj aIw = aIw();
        if (aIw == null) {
            return 0;
        }
        ArrayList<MediaData> aKO = aIw.aKO();
        if (aKO == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = aKO.iterator();
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
        bj aIw = aIw();
        if (aIw != null) {
            return aIw.getImages();
        }
        return null;
    }

    public void rO(int i) {
        this.grZ = i;
    }

    public boolean bFm() {
        return this.grZ == 1;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al aIy() {
        if (aIw() == null || this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        al alVar = new al();
        alVar.setTid(aIw().getTid());
        alVar.setFid(aIw().getFid());
        alVar.setFeedBackReasonMap(this.feedBackReasonMap);
        alVar.weight = this.grU;
        alVar.source = this.mSource;
        alVar.extra = this.mExtra;
        alVar.threadType = aIw().threadType;
        return alVar;
    }
}
