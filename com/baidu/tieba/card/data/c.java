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
/* loaded from: classes6.dex */
public abstract class c extends com.baidu.tbadk.core.data.a implements ae {
    public bj cNb;
    private String fJT;
    private int fJU;
    private String fJV;
    private String fJW;
    public int fJY;
    private String mExtra;
    private String mSource;
    public String tid;
    public int objType = 1;
    public SparseArray<String> feedBackReasonMap = null;
    private Integer fJX = 0;
    public int cNc = 0;
    public int cNd = 0;

    public void setWeight(String str) {
        this.fJT = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void rm(int i) {
        this.fJU = i;
    }

    public void zE(String str) {
        this.fJV = str;
    }

    public int btK() {
        return this.fJU;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String axT() {
        return this.mSource + "#" + this.fJU + "#" + this.fJV;
    }

    public String getWeight() {
        return this.fJT;
    }

    public String getSource() {
        return this.mSource;
    }

    public String btL() {
        return this.fJV;
    }

    public String btM() {
        return this.fJW;
    }

    public void zF(String str) {
        this.fJW = str;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj axQ() {
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

    public Integer btN() {
        return this.fJX;
    }

    public void j(Integer num) {
        this.fJX = num;
    }

    public an zG(String str) {
        return af(str, false);
    }

    public an af(String str, boolean z) {
        bj axQ = axQ();
        if (axQ == null || str.length() == 0) {
            return null;
        }
        an cp = new an(str).cp("fid", String.valueOf(axQ.getFid())).cp("tid", String.valueOf(axQ.getTid())).cp("obj_id", getExtra()).cp("obj_param1", getWeight()).Z(TiebaInitialize.Params.OBJ_PARAM2, 1).cp("obj_source", getSource()).Z("obj_locate", btK()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.l.btr());
        if (!z) {
            cp.Z("obj_type", btO());
        } else {
            if (axQ.cPL > 0) {
                cp.Z("midpageflag", 1);
            } else {
                cp.Z("midpageflag", 0);
            }
            cp.cp(TiebaInitialize.Params.AB_TAG, btL());
            cp.Z("is_vertical", btN().intValue());
        }
        if (axQ.aBx() != null && axQ.aBx().cJB() != null && axQ.aBx().cJB().aRz() != null && axQ.aBx().cJB().aRz().size() > 0) {
            cp.Z(TiebaInitialize.Params.OBJ_TO, axQ.aBx().kfY ? 2 : 1);
        }
        return cp;
    }

    public an az(String str, int i) {
        bj axQ = axQ();
        if (axQ == null) {
            return null;
        }
        an cp = new an(str).cp("fid", String.valueOf(axQ.getFid())).cp("tid", String.valueOf(axQ.getTid())).Z(TiebaInitialize.Params.OBJ_PARAM2, 1).cp("obj_param1", getWeight()).cp("obj_source", getSource()).Z("obj_locate", btK()).cp("obj_name", btL()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.l.btr());
        if (i == 0) {
            cp.Z("obj_type", btO());
        } else {
            cp.Z("obj_type", i);
        }
        cp.cp("obj_id", getExtra());
        return cp;
    }

    private int btO() {
        int i;
        int i2 = 0;
        bj axQ = axQ();
        if (axQ == null) {
            return 0;
        }
        ArrayList<MediaData> aAh = axQ.aAh();
        if (aAh == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = aAh.iterator();
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
        bj axQ = axQ();
        if (axQ != null) {
            return axQ.getImages();
        }
        return null;
    }

    public void rn(int i) {
        this.fJY = i;
    }

    public boolean btP() {
        return this.fJY == 1;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al axS() {
        if (axQ() == null || this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        al alVar = new al();
        alVar.setTid(axQ().getTid());
        alVar.setFid(axQ().getFid());
        alVar.setFeedBackReasonMap(this.feedBackReasonMap);
        alVar.weight = this.fJT;
        alVar.source = this.mSource;
        alVar.extra = this.mExtra;
        alVar.threadType = axQ().threadType;
        return alVar;
    }
}
