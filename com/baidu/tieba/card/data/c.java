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
    public bj dqE;
    private String gsa;
    private int gsb;
    private String gsc;
    private String gsd;
    public int gsf;
    private String mExtra;
    private String mSource;
    public String tid;
    public int objType = 1;
    public SparseArray<String> feedBackReasonMap = null;
    private Integer gse = 0;
    public int dqF = 0;
    public int dqG = 0;

    public void setWeight(String str) {
        this.gsa = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void rN(int i) {
        this.gsb = i;
    }

    public void BG(String str) {
        this.gsc = str;
    }

    public int bFg() {
        return this.gsb;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String aIx() {
        return this.mSource + "#" + this.gsb + "#" + this.gsc;
    }

    public String getWeight() {
        return this.gsa;
    }

    public String getSource() {
        return this.mSource;
    }

    public String bFh() {
        return this.gsc;
    }

    public String bFi() {
        return this.gsd;
    }

    public void BH(String str) {
        this.gsd = str;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj aIu() {
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

    public Integer bFj() {
        return this.gse;
    }

    public void j(Integer num) {
        this.gse = num;
    }

    public an BI(String str) {
        return al(str, false);
    }

    public an al(String str, boolean z) {
        bj aIu = aIu();
        if (aIu == null || str.length() == 0) {
            return null;
        }
        an cI = new an(str).cI("fid", String.valueOf(aIu.getFid())).cI("tid", String.valueOf(aIu.getTid())).cI("obj_id", getExtra()).cI("obj_param1", getWeight()).af(TiebaInitialize.Params.OBJ_PARAM2, 1).cI("obj_source", getSource()).af("obj_locate", bFg()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.l.bEO());
        if (!z) {
            cI.af("obj_type", bFk());
        } else {
            if (aIu.dtq > 0) {
                cI.af("midpageflag", 1);
            } else {
                cI.af("midpageflag", 0);
            }
            cI.cI(TiebaInitialize.Params.AB_TAG, bFh());
            cI.af("is_vertical", bFj().intValue());
        }
        if (aIu.aMc() != null && aIu.aMc().cWr() != null && aIu.aMc().cWr().bcf() != null && aIu.aMc().cWr().bcf().size() > 0) {
            cI.af(TiebaInitialize.Params.OBJ_TO, aIu.aMc().kTa ? 2 : 1);
        }
        return cI;
    }

    public an aH(String str, int i) {
        bj aIu = aIu();
        if (aIu == null) {
            return null;
        }
        an cI = new an(str).cI("fid", String.valueOf(aIu.getFid())).cI("tid", String.valueOf(aIu.getTid())).af(TiebaInitialize.Params.OBJ_PARAM2, 1).cI("obj_param1", getWeight()).cI("obj_source", getSource()).af("obj_locate", bFg()).cI("obj_name", bFh()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.l.bEO());
        if (i == 0) {
            cI.af("obj_type", bFk());
        } else {
            cI.af("obj_type", i);
        }
        cI.cI("obj_id", getExtra());
        return cI;
    }

    private int bFk() {
        int i;
        int i2 = 0;
        bj aIu = aIu();
        if (aIu == null) {
            return 0;
        }
        ArrayList<MediaData> aKM = aIu.aKM();
        if (aKM == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = aKM.iterator();
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
        bj aIu = aIu();
        if (aIu != null) {
            return aIu.getImages();
        }
        return null;
    }

    public void rO(int i) {
        this.gsf = i;
    }

    public boolean bFl() {
        return this.gsf == 1;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al aIw() {
        if (aIu() == null || this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        al alVar = new al();
        alVar.setTid(aIu().getTid());
        alVar.setFid(aIu().getFid());
        alVar.setFeedBackReasonMap(this.feedBackReasonMap);
        alVar.weight = this.gsa;
        alVar.source = this.mSource;
        alVar.extra = this.mExtra;
        alVar.threadType = aIu().threadType;
        return alVar;
    }
}
