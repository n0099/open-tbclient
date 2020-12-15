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
    public static BdUniqueId[][] imE;
    public by eCR;
    private String imF;
    private int imG;
    private String imH;
    private String imI;
    public int imK;
    private String mExtra;
    private String mSource;
    public String tid;
    public static final BdUniqueId imt = BdUniqueId.gen();
    public static final BdUniqueId imu = BdUniqueId.gen();
    public static final BdUniqueId imv = BdUniqueId.gen();
    public static final BdUniqueId imw = BdUniqueId.gen();
    public static final BdUniqueId imx = BdUniqueId.gen();
    public static final BdUniqueId imy = BdUniqueId.gen();
    public static final BdUniqueId imz = BdUniqueId.gen();
    public static final BdUniqueId imA = BdUniqueId.gen();
    public static final BdUniqueId imB = BdUniqueId.gen();
    public static final ArrayList<BdUniqueId> imC = new ArrayList<>();
    public static final ArrayList<BdUniqueId> imD = new ArrayList<>();
    public int objType = 1;
    private Integer imJ = 0;
    public int eIP = 0;
    public int eIQ = 0;
    public boolean eIy = false;
    public boolean eIO = false;
    public boolean eID = false;
    public boolean imL = false;
    public boolean eIC = false;
    public boolean eIz = false;
    public boolean imM = false;
    public boolean eIK = false;
    public boolean eIM = false;
    public boolean eIN = false;
    public boolean imN = false;
    public boolean eIF = false;
    public boolean eIE = false;
    public boolean imO = false;

    static {
        imC.add(imt);
        imC.add(imu);
        imD.add(imy);
        imD.add(imv);
        imD.add(imx);
        imD.add(imw);
        imE = (BdUniqueId[][]) Array.newInstance(BdUniqueId.class, imC.size(), imD.size());
        for (int i = 0; i < imC.size(); i++) {
            for (int i2 = 0; i2 < imD.size(); i2++) {
                imE[i][i2] = BdUniqueId.gen();
            }
        }
    }

    public void setWeight(String str) {
        this.imF = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void ym(int i) {
        this.imG = i;
    }

    public void Js(String str) {
        this.imH = str;
    }

    public int cst() {
        return this.imG;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String bmq() {
        return this.mSource + "#" + this.imG + "#" + this.imH;
    }

    public String getWeight() {
        return this.imF;
    }

    public String getSource() {
        return this.mSource;
    }

    public String csu() {
        return this.imH;
    }

    public String csv() {
        return this.imI;
    }

    public void Jt(String str) {
        this.imI = str;
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

    public Integer csw() {
        return this.imJ;
    }

    public void n(Integer num) {
        this.imJ = num;
    }

    public ar Ju(String str) {
        return aJ(str, false);
    }

    public ar aJ(String str, boolean z) {
        by bmn = bmn();
        if (bmn == null || str.length() == 0) {
            return null;
        }
        ar dY = new ar(str).dY("fid", String.valueOf(bmn.getFid())).dY("tid", String.valueOf(bmn.getTid())).dY("nid", bmn.getNid()).dY("obj_id", getExtra()).dY("obj_param1", getWeight()).al(TiebaInitialize.Params.OBJ_PARAM2, 1).dY("obj_source", getSource()).al("obj_locate", cst()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.n.crY()).dY("ab_tag", csu());
        if (!z) {
            dY.al("obj_type", csx());
        } else {
            if (bmn.eLF > 0) {
                dY.al("midpageflag", 1);
            } else {
                dY.al("midpageflag", 0);
            }
            dY.al("is_vertical", csw().intValue());
        }
        if (bmn.bqu() != null && bmn.bqu().dPj() != null && bmn.bqu().dPj().bIC() != null && bmn.bqu().dPj().bIC().size() > 0) {
            dY.al(TiebaInitialize.Params.OBJ_TO, bmn.bqu().nmp ? 2 : 1);
        }
        return dY;
    }

    public ar aN(String str, int i) {
        by bmn = bmn();
        if (bmn == null) {
            return null;
        }
        ar dY = new ar(str).dY("fid", String.valueOf(bmn.getFid())).dY("tid", String.valueOf(bmn.getTid())).al(TiebaInitialize.Params.OBJ_PARAM2, 1).dY("obj_param1", getWeight()).dY("obj_source", getSource()).al("obj_locate", cst()).dY("obj_name", csu()).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.n.crY());
        if (i == 0) {
            dY.al("obj_type", csx());
        } else {
            dY.al("obj_type", i);
        }
        dY.dY("obj_id", getExtra());
        return dY;
    }

    private int csx() {
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
        this.imK = i;
    }

    public boolean csy() {
        return this.imK == 1;
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
        atVar.weight = this.imF;
        atVar.source = this.mSource;
        atVar.extra = this.mExtra;
        atVar.threadType = bmn().threadType;
        return atVar;
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

    public ar csC() {
        return null;
    }

    public ar Jv(String str) {
        return null;
    }

    public boolean bnv() {
        return false;
    }
}
