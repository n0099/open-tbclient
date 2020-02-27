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
    public bj cRe;
    private String fMq;
    private int fMr;
    private String fMs;
    private String fMt;
    public int fMv;
    private String mExtra;
    private String mSource;
    public String tid;
    public int objType = 1;
    public SparseArray<String> feedBackReasonMap = null;
    private Integer fMu = 0;
    public int cRf = 0;
    public int cRg = 0;

    public void setWeight(String str) {
        this.fMq = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void rt(int i) {
        this.fMr = i;
    }

    public void zU(String str) {
        this.fMs = str;
    }

    public int bvo() {
        return this.fMr;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String aAh() {
        return this.mSource + "#" + this.fMr + "#" + this.fMs;
    }

    public String getWeight() {
        return this.fMq;
    }

    public String getSource() {
        return this.mSource;
    }

    public String bvp() {
        return this.fMs;
    }

    public String bvq() {
        return this.fMt;
    }

    public void zV(String str) {
        this.fMt = str;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj aAe() {
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

    public Integer bvr() {
        return this.fMu;
    }

    public void j(Integer num) {
        this.fMu = num;
    }

    public an zW(String str) {
        return af(str, false);
    }

    public an af(String str, boolean z) {
        bj aAe = aAe();
        if (aAe == null || str.length() == 0) {
            return null;
        }
        an cy = new an(str).cy("fid", String.valueOf(aAe.getFid())).cy("tid", String.valueOf(aAe.getTid())).cy("obj_id", getExtra()).cy("obj_param1", getWeight()).X(TiebaInitialize.Params.OBJ_PARAM2, 1).cy("obj_source", getSource()).X("obj_locate", bvo()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.l.buV());
        if (!z) {
            cy.X("obj_type", bvs());
        } else {
            if (aAe.cTN > 0) {
                cy.X("midpageflag", 1);
            } else {
                cy.X("midpageflag", 0);
            }
            cy.cy(TiebaInitialize.Params.AB_TAG, bvp());
            cy.X("is_vertical", bvr().intValue());
        }
        if (aAe.aDK() != null && aAe.aDK().cLa() != null && aAe.aDK().cLa().aTQ() != null && aAe.aDK().cLa().aTQ().size() > 0) {
            cy.X(TiebaInitialize.Params.OBJ_TO, aAe.aDK().kgZ ? 2 : 1);
        }
        return cy;
    }

    public an ax(String str, int i) {
        bj aAe = aAe();
        if (aAe == null) {
            return null;
        }
        an cy = new an(str).cy("fid", String.valueOf(aAe.getFid())).cy("tid", String.valueOf(aAe.getTid())).X(TiebaInitialize.Params.OBJ_PARAM2, 1).cy("obj_param1", getWeight()).cy("obj_source", getSource()).X("obj_locate", bvo()).cy("obj_name", bvp()).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.l.buV());
        if (i == 0) {
            cy.X("obj_type", bvs());
        } else {
            cy.X("obj_type", i);
        }
        cy.cy("obj_id", getExtra());
        return cy;
    }

    private int bvs() {
        int i;
        int i2 = 0;
        bj aAe = aAe();
        if (aAe == null) {
            return 0;
        }
        ArrayList<MediaData> aCw = aAe.aCw();
        if (aCw == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = aCw.iterator();
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
        bj aAe = aAe();
        if (aAe != null) {
            return aAe.getImages();
        }
        return null;
    }

    public void ru(int i) {
        this.fMv = i;
    }

    public boolean bvt() {
        return this.fMv == 1;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al aAg() {
        if (aAe() == null || this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        al alVar = new al();
        alVar.setTid(aAe().getTid());
        alVar.setFid(aAe().getFid());
        alVar.setFeedBackReasonMap(this.feedBackReasonMap);
        alVar.weight = this.fMq;
        alVar.source = this.mSource;
        alVar.extra = this.mExtra;
        alVar.threadType = aAe().threadType;
        return alVar;
    }
}
