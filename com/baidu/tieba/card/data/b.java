package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.ar;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes21.dex */
public abstract class b extends com.baidu.tbadk.core.data.a implements ah {
    public static BdUniqueId[][] imC;
    public by eCR;
    private String imD;
    private int imE;
    private String imF;
    private String imG;
    public int imI;
    private String mExtra;
    private String mSource;
    public String tid;
    public static final BdUniqueId imr = BdUniqueId.gen();
    public static final BdUniqueId ims = BdUniqueId.gen();
    public static final BdUniqueId imt = BdUniqueId.gen();
    public static final BdUniqueId imu = BdUniqueId.gen();
    public static final BdUniqueId imv = BdUniqueId.gen();
    public static final BdUniqueId imw = BdUniqueId.gen();
    public static final BdUniqueId imx = BdUniqueId.gen();
    public static final BdUniqueId imy = BdUniqueId.gen();
    public static final BdUniqueId imz = BdUniqueId.gen();
    public static final ArrayList<BdUniqueId> imA = new ArrayList<>();
    public static final ArrayList<BdUniqueId> imB = new ArrayList<>();
    public int objType = 1;
    private Integer imH = 0;
    public int eIP = 0;
    public int eIQ = 0;
    public boolean eIy = false;
    public boolean eIO = false;
    public boolean eID = false;
    public boolean imJ = false;
    public boolean eIC = false;
    public boolean eIz = false;
    public boolean imK = false;
    public boolean eIK = false;
    public boolean eIM = false;
    public boolean eIN = false;
    public boolean imL = false;
    public boolean eIF = false;
    public boolean eIE = false;
    public boolean imM = false;

    static {
        imA.add(imr);
        imA.add(ims);
        imB.add(imw);
        imB.add(imt);
        imB.add(imv);
        imB.add(imu);
        imC = (BdUniqueId[][]) Array.newInstance(BdUniqueId.class, imA.size(), imB.size());
        for (int i = 0; i < imA.size(); i++) {
            for (int i2 = 0; i2 < imB.size(); i2++) {
                imC[i][i2] = BdUniqueId.gen();
            }
        }
    }

    public void setWeight(String str) {
        this.imD = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void ym(int i) {
        this.imE = i;
    }

    public void Js(String str) {
        this.imF = str;
    }

    public int css() {
        return this.imE;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String bmq() {
        return this.mSource + "#" + this.imE + "#" + this.imF;
    }

    public String getWeight() {
        return this.imD;
    }

    public String getSource() {
        return this.mSource;
    }

    public String cst() {
        return this.imF;
    }

    public String csu() {
        return this.imG;
    }

    public void Jt(String str) {
        this.imG = str;
    }

    @Override // com.baidu.tbadk.core.data.a
    public by bmn() {
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

    public Integer csv() {
        return this.imH;
    }

    public void n(Integer num) {
        this.imH = num;
    }

    public ar Ju(String str) {
        return aJ(str, false);
    }

    public ar aJ(String str, boolean z) {
        by bmn = bmn();
        if (bmn == null || str.length() == 0) {
            return null;
        }
        ar dY = new ar(str).dY("fid", String.valueOf(bmn.getFid())).dY("tid", String.valueOf(bmn.getTid())).dY("nid", bmn.getNid()).dY("obj_id", getExtra()).dY("obj_param1", getWeight()).al(TiebaInitialize.Params.OBJ_PARAM2, 1).dY("obj_source", getSource()).al("obj_locate", css()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.n.crX()).dY("ab_tag", cst());
        if (!z) {
            dY.al("obj_type", csw());
        } else {
            if (bmn.eLF > 0) {
                dY.al("midpageflag", 1);
            } else {
                dY.al("midpageflag", 0);
            }
            dY.al("is_vertical", csv().intValue());
        }
        if (bmn.bqu() != null && bmn.bqu().dPi() != null && bmn.bqu().dPi().bIC() != null && bmn.bqu().dPi().bIC().size() > 0) {
            dY.al(TiebaInitialize.Params.OBJ_TO, bmn.bqu().nmn ? 2 : 1);
        }
        return dY;
    }

    public ar aN(String str, int i) {
        by bmn = bmn();
        if (bmn == null) {
            return null;
        }
        ar dY = new ar(str).dY("fid", String.valueOf(bmn.getFid())).dY("tid", String.valueOf(bmn.getTid())).al(TiebaInitialize.Params.OBJ_PARAM2, 1).dY("obj_param1", getWeight()).dY("obj_source", getSource()).al("obj_locate", css()).dY("obj_name", cst()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.n.crX());
        if (i == 0) {
            dY.al("obj_type", csw());
        } else {
            dY.al("obj_type", i);
        }
        dY.dY("obj_id", getExtra());
        return dY;
    }

    private int csw() {
        int i;
        int i2 = 0;
        by bmn = bmn();
        if (bmn == null) {
            return 0;
        }
        ArrayList<MediaData> boY = bmn.boY();
        if (boY == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = boY.iterator();
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

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        by bmn = bmn();
        if (bmn != null) {
            return bmn.getImages();
        }
        return null;
    }

    public void yn(int i) {
        this.imI = i;
    }

    public boolean csx() {
        return this.imI == 1;
    }

    @Override // com.baidu.tbadk.core.data.a
    public at bmp() {
        if (bmn() == null || this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        at atVar = new at();
        atVar.setTid(bmn().getTid());
        atVar.setFid(bmn().getFid());
        atVar.setNid(bmn().getNid());
        atVar.setFeedBackReasonMap(this.feedBackReasonMap);
        atVar.weight = this.imD;
        atVar.source = this.mSource;
        atVar.extra = this.mExtra;
        atVar.threadType = bmn().threadType;
        return atVar;
    }

    public ar csy() {
        return null;
    }

    public ar csz() {
        return null;
    }

    public ar csA() {
        return null;
    }

    public ar csB() {
        return null;
    }

    public ar Jv(String str) {
        return null;
    }

    public boolean bnv() {
        return false;
    }
}
