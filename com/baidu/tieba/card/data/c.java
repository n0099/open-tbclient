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
    public bj cRf;
    private String fMs;
    private int fMt;
    private String fMu;
    private String fMv;
    public int fMx;
    private String mExtra;
    private String mSource;
    public String tid;
    public int objType = 1;
    public SparseArray<String> feedBackReasonMap = null;
    private Integer fMw = 0;
    public int cRg = 0;
    public int cRh = 0;

    public void setWeight(String str) {
        this.fMs = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void rt(int i) {
        this.fMt = i;
    }

    public void zU(String str) {
        this.fMu = str;
    }

    public int bvq() {
        return this.fMt;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String aAj() {
        return this.mSource + "#" + this.fMt + "#" + this.fMu;
    }

    public String getWeight() {
        return this.fMs;
    }

    public String getSource() {
        return this.mSource;
    }

    public String bvr() {
        return this.fMu;
    }

    public String bvs() {
        return this.fMv;
    }

    public void zV(String str) {
        this.fMv = str;
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

    public Integer bvt() {
        return this.fMw;
    }

    public void j(Integer num) {
        this.fMw = num;
    }

    public an zW(String str) {
        return af(str, false);
    }

    public an af(String str, boolean z) {
        bj aAg = aAg();
        if (aAg == null || str.length() == 0) {
            return null;
        }
        an cy = new an(str).cy("fid", String.valueOf(aAg.getFid())).cy("tid", String.valueOf(aAg.getTid())).cy("obj_id", getExtra()).cy("obj_param1", getWeight()).X(TiebaInitialize.Params.OBJ_PARAM2, 1).cy("obj_source", getSource()).X("obj_locate", bvq()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.l.buX());
        if (!z) {
            cy.X("obj_type", bvu());
        } else {
            if (aAg.cTO > 0) {
                cy.X("midpageflag", 1);
            } else {
                cy.X("midpageflag", 0);
            }
            cy.cy(TiebaInitialize.Params.AB_TAG, bvr());
            cy.X("is_vertical", bvt().intValue());
        }
        if (aAg.aDM() != null && aAg.aDM().cLc() != null && aAg.aDM().cLc().aTS() != null && aAg.aDM().cLc().aTS().size() > 0) {
            cy.X(TiebaInitialize.Params.OBJ_TO, aAg.aDM().khb ? 2 : 1);
        }
        return cy;
    }

    public an ax(String str, int i) {
        bj aAg = aAg();
        if (aAg == null) {
            return null;
        }
        an cy = new an(str).cy("fid", String.valueOf(aAg.getFid())).cy("tid", String.valueOf(aAg.getTid())).X(TiebaInitialize.Params.OBJ_PARAM2, 1).cy("obj_param1", getWeight()).cy("obj_source", getSource()).X("obj_locate", bvq()).cy("obj_name", bvr()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.l.buX());
        if (i == 0) {
            cy.X("obj_type", bvu());
        } else {
            cy.X("obj_type", i);
        }
        cy.cy("obj_id", getExtra());
        return cy;
    }

    private int bvu() {
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
        this.fMx = i;
    }

    public boolean bvv() {
        return this.fMx == 1;
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
        alVar.weight = this.fMs;
        alVar.source = this.mSource;
        alVar.extra = this.mExtra;
        alVar.threadType = aAg().threadType;
        return alVar;
    }
}
