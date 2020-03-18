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
    public bj cRt;
    private String fNn;
    private int fNo;
    private String fNp;
    private String fNq;
    public int fNs;
    private String mExtra;
    private String mSource;
    public String tid;
    public int objType = 1;
    public SparseArray<String> feedBackReasonMap = null;
    private Integer fNr = 0;
    public int cRu = 0;
    public int cRv = 0;

    public void setWeight(String str) {
        this.fNn = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void rv(int i) {
        this.fNo = i;
    }

    public void zW(String str) {
        this.fNp = str;
    }

    public int bvw() {
        return this.fNo;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String aAm() {
        return this.mSource + "#" + this.fNo + "#" + this.fNp;
    }

    public String getWeight() {
        return this.fNn;
    }

    public String getSource() {
        return this.mSource;
    }

    public String bvx() {
        return this.fNp;
    }

    public String bvy() {
        return this.fNq;
    }

    public void zX(String str) {
        this.fNq = str;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj aAj() {
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

    public Integer bvz() {
        return this.fNr;
    }

    public void j(Integer num) {
        this.fNr = num;
    }

    public an zY(String str) {
        return af(str, false);
    }

    public an af(String str, boolean z) {
        bj aAj = aAj();
        if (aAj == null || str.length() == 0) {
            return null;
        }
        an cx = new an(str).cx("fid", String.valueOf(aAj.getFid())).cx("tid", String.valueOf(aAj.getTid())).cx("obj_id", getExtra()).cx("obj_param1", getWeight()).X(TiebaInitialize.Params.OBJ_PARAM2, 1).cx("obj_source", getSource()).X("obj_locate", bvw()).cx("uid", TbadkCoreApplication.getCurrentAccount()).cx(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.l.bvd());
        if (!z) {
            cx.X("obj_type", bvA());
        } else {
            if (aAj.cUc > 0) {
                cx.X("midpageflag", 1);
            } else {
                cx.X("midpageflag", 0);
            }
            cx.cx(TiebaInitialize.Params.AB_TAG, bvx());
            cx.X("is_vertical", bvz().intValue());
        }
        if (aAj.aDQ() != null && aAj.aDQ().cLx() != null && aAj.aDQ().cLx().aTX() != null && aAj.aDQ().cLx().aTX().size() > 0) {
            cx.X(TiebaInitialize.Params.OBJ_TO, aAj.aDQ().kiQ ? 2 : 1);
        }
        return cx;
    }

    public an ax(String str, int i) {
        bj aAj = aAj();
        if (aAj == null) {
            return null;
        }
        an cx = new an(str).cx("fid", String.valueOf(aAj.getFid())).cx("tid", String.valueOf(aAj.getTid())).X(TiebaInitialize.Params.OBJ_PARAM2, 1).cx("obj_param1", getWeight()).cx("obj_source", getSource()).X("obj_locate", bvw()).cx("obj_name", bvx()).cx("uid", TbadkCoreApplication.getCurrentAccount()).cx(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.l.bvd());
        if (i == 0) {
            cx.X("obj_type", bvA());
        } else {
            cx.X("obj_type", i);
        }
        cx.cx("obj_id", getExtra());
        return cx;
    }

    private int bvA() {
        int i;
        int i2 = 0;
        bj aAj = aAj();
        if (aAj == null) {
            return 0;
        }
        ArrayList<MediaData> aCB = aAj.aCB();
        if (aCB == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = aCB.iterator();
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
        bj aAj = aAj();
        if (aAj != null) {
            return aAj.getImages();
        }
        return null;
    }

    public void rw(int i) {
        this.fNs = i;
    }

    public boolean bvB() {
        return this.fNs == 1;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al aAl() {
        if (aAj() == null || this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        al alVar = new al();
        alVar.setTid(aAj().getTid());
        alVar.setFid(aAj().getFid());
        alVar.setFeedBackReasonMap(this.feedBackReasonMap);
        alVar.weight = this.fNn;
        alVar.source = this.mSource;
        alVar.extra = this.mExtra;
        alVar.threadType = aAj().threadType;
        return alVar;
    }
}
