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
/* loaded from: classes5.dex */
public abstract class c extends com.baidu.tbadk.core.data.a implements ae {
    public bj cMR;
    private String fGJ;
    private int fGK;
    private String fGL;
    private String fGM;
    public int fGO;
    private String mExtra;
    private String mSource;
    public String tid;
    public int objType = 1;
    public SparseArray<String> feedBackReasonMap = null;
    private Integer fGN = 0;
    public int cMS = 0;
    public int cMT = 0;

    public void setWeight(String str) {
        this.fGJ = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void rh(int i) {
        this.fGK = i;
    }

    public void zu(String str) {
        this.fGL = str;
    }

    public int bsI() {
        return this.fGK;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String axA() {
        return this.mSource + "#" + this.fGK + "#" + this.fGL;
    }

    public String getWeight() {
        return this.fGJ;
    }

    public String getSource() {
        return this.mSource;
    }

    public String bsJ() {
        return this.fGL;
    }

    public String bsK() {
        return this.fGM;
    }

    public void zv(String str) {
        this.fGM = str;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bj axx() {
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

    public Integer bsL() {
        return this.fGN;
    }

    public void j(Integer num) {
        this.fGN = num;
    }

    public an zw(String str) {
        return af(str, false);
    }

    public an af(String str, boolean z) {
        bj axx = axx();
        if (axx == null || str.length() == 0) {
            return null;
        }
        an cp = new an(str).cp("fid", String.valueOf(axx.getFid())).cp("tid", String.valueOf(axx.getTid())).cp("obj_id", getExtra()).cp("obj_param1", getWeight()).Z(TiebaInitialize.Params.OBJ_PARAM2, 1).cp("obj_source", getSource()).Z("obj_locate", bsI()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.l.bsp());
        if (!z) {
            cp.Z("obj_type", bsM());
        } else {
            if (axx.cPB > 0) {
                cp.Z("midpageflag", 1);
            } else {
                cp.Z("midpageflag", 0);
            }
            cp.cp(TiebaInitialize.Params.AB_TAG, bsJ());
            cp.Z("is_vertical", bsL().intValue());
        }
        if (axx.aBe() != null && axx.aBe().cIv() != null && axx.aBe().cIv().aRf() != null && axx.aBe().cIv().aRf().size() > 0) {
            cp.Z(TiebaInitialize.Params.OBJ_TO, axx.aBe().kcq ? 2 : 1);
        }
        return cp;
    }

    public an ay(String str, int i) {
        bj axx = axx();
        if (axx == null) {
            return null;
        }
        an cp = new an(str).cp("fid", String.valueOf(axx.getFid())).cp("tid", String.valueOf(axx.getTid())).Z(TiebaInitialize.Params.OBJ_PARAM2, 1).cp("obj_param1", getWeight()).cp("obj_source", getSource()).Z("obj_locate", bsI()).cp("obj_name", bsJ()).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.l.bsp());
        if (i == 0) {
            cp.Z("obj_type", bsM());
        } else {
            cp.Z("obj_type", i);
        }
        cp.cp("obj_id", getExtra());
        return cp;
    }

    private int bsM() {
        int i;
        int i2 = 0;
        bj axx = axx();
        if (axx == null) {
            return 0;
        }
        ArrayList<MediaData> azO = axx.azO();
        if (azO == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = azO.iterator();
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
        bj axx = axx();
        if (axx != null) {
            return axx.getImages();
        }
        return null;
    }

    public void ri(int i) {
        this.fGO = i;
    }

    public boolean bsN() {
        return this.fGO == 1;
    }

    @Override // com.baidu.tbadk.core.data.a
    public al axz() {
        if (axx() == null || this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        al alVar = new al();
        alVar.setTid(axx().getTid());
        alVar.setFid(axx().getFid());
        alVar.setFeedBackReasonMap(this.feedBackReasonMap);
        alVar.weight = this.fGJ;
        alVar.source = this.mSource;
        alVar.extra = this.mExtra;
        alVar.threadType = axx().threadType;
        return alVar;
    }
}
