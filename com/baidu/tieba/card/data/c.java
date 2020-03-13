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
    public bj cRg;
    private String fMF;
    private int fMG;
    private String fMH;
    private String fMI;
    public int fMK;
    private String mExtra;
    private String mSource;
    public String tid;
    public int objType = 1;
    public SparseArray<String> feedBackReasonMap = null;
    private Integer fMJ = 0;
    public int cRh = 0;
    public int cRi = 0;

    public void setWeight(String str) {
        this.fMF = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void rt(int i) {
        this.fMG = i;
    }

    public void zV(String str) {
        this.fMH = str;
    }

    public int bvr() {
        return this.fMG;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String aAj() {
        return this.mSource + "#" + this.fMG + "#" + this.fMH;
    }

    public String getWeight() {
        return this.fMF;
    }

    public String getSource() {
        return this.mSource;
    }

    public String bvs() {
        return this.fMH;
    }

    public String bvt() {
        return this.fMI;
    }

    public void zW(String str) {
        this.fMI = str;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj aAg() {
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

    public Integer bvu() {
        return this.fMJ;
    }

    public void j(Integer num) {
        this.fMJ = num;
    }

    public an zX(String str) {
        return af(str, false);
    }

    public an af(String str, boolean z) {
        bj aAg = aAg();
        if (aAg == null || str.length() == 0) {
            return null;
        }
        an cy = new an(str).cy("fid", String.valueOf(aAg.getFid())).cy("tid", String.valueOf(aAg.getTid())).cy("obj_id", getExtra()).cy("obj_param1", getWeight()).X(TiebaInitialize.Params.OBJ_PARAM2, 1).cy("obj_source", getSource()).X("obj_locate", bvr()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.l.buY());
        if (!z) {
            cy.X("obj_type", bvv());
        } else {
            if (aAg.cTP > 0) {
                cy.X("midpageflag", 1);
            } else {
                cy.X("midpageflag", 0);
            }
            cy.cy(TiebaInitialize.Params.AB_TAG, bvs());
            cy.X("is_vertical", bvu().intValue());
        }
        if (aAg.aDM() != null && aAg.aDM().cLd() != null && aAg.aDM().cLd().aTT() != null && aAg.aDM().cLd().aTT().size() > 0) {
            cy.X(TiebaInitialize.Params.OBJ_TO, aAg.aDM().khn ? 2 : 1);
        }
        return cy;
    }

    public an ax(String str, int i) {
        bj aAg = aAg();
        if (aAg == null) {
            return null;
        }
        an cy = new an(str).cy("fid", String.valueOf(aAg.getFid())).cy("tid", String.valueOf(aAg.getTid())).X(TiebaInitialize.Params.OBJ_PARAM2, 1).cy("obj_param1", getWeight()).cy("obj_source", getSource()).X("obj_locate", bvr()).cy("obj_name", bvs()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.l.buY());
        if (i == 0) {
            cy.X("obj_type", bvv());
        } else {
            cy.X("obj_type", i);
        }
        cy.cy("obj_id", getExtra());
        return cy;
    }

    private int bvv() {
        int i;
        int i2 = 0;
        bj aAg = aAg();
        if (aAg == null) {
            return 0;
        }
        ArrayList<MediaData> aCy = aAg.aCy();
        if (aCy == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = aCy.iterator();
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
        bj aAg = aAg();
        if (aAg != null) {
            return aAg.getImages();
        }
        return null;
    }

    public void ru(int i) {
        this.fMK = i;
    }

    public boolean bvw() {
        return this.fMK == 1;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al aAi() {
        if (aAg() == null || this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        al alVar = new al();
        alVar.setTid(aAg().getTid());
        alVar.setFid(aAg().getFid());
        alVar.setFeedBackReasonMap(this.feedBackReasonMap);
        alVar.weight = this.fMF;
        alVar.source = this.mSource;
        alVar.extra = this.mExtra;
        alVar.threadType = aAg().threadType;
        return alVar;
    }
}
