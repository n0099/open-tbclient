package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.aq;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class b extends com.baidu.tbadk.core.data.a implements ag {
    public static final BdUniqueId iyN = BdUniqueId.gen();
    public static final BdUniqueId iyO = BdUniqueId.gen();
    public static final BdUniqueId iyP = BdUniqueId.gen();
    public static final BdUniqueId iyQ = BdUniqueId.gen();
    public static final BdUniqueId iyR = BdUniqueId.gen();
    public static final BdUniqueId iyS = BdUniqueId.gen();
    public static final BdUniqueId iyT = BdUniqueId.gen();
    public static final BdUniqueId iyU = BdUniqueId.gen();
    public static final BdUniqueId iyV = BdUniqueId.gen();
    public static final BdUniqueId iyW = BdUniqueId.gen();
    public static final ArrayList<BdUniqueId> iyX = new ArrayList<>();
    public static final ArrayList<BdUniqueId> iyY = new ArrayList<>();
    public static BdUniqueId[][] iyZ;
    public bz eMv;
    private String iza;
    private int izb;
    private String izc;
    private String izd;
    public int izf;
    private String mExtra;
    private String mSource;
    public String tid;
    public int objType = 1;
    private Integer ize = 0;
    public int eSI = 0;
    public int eSJ = 0;
    public boolean eSq = false;
    public boolean eSH = false;
    public boolean eSv = false;
    public boolean izg = false;
    public boolean eSu = false;
    public boolean eSr = false;
    public boolean izh = false;
    public boolean eSD = false;
    public boolean eSF = false;
    public boolean eSG = false;
    public boolean izi = false;
    public boolean eSx = false;
    public boolean eSw = false;
    public boolean izj = false;

    static {
        iyX.add(iyN);
        iyX.add(iyO);
        iyY.add(iyS);
        iyY.add(iyP);
        iyY.add(iyR);
        iyY.add(iyQ);
        iyZ = (BdUniqueId[][]) Array.newInstance(BdUniqueId.class, iyX.size(), iyY.size());
        for (int i = 0; i < iyX.size(); i++) {
            for (int i2 = 0; i2 < iyY.size(); i2++) {
                iyZ[i][i2] = BdUniqueId.gen();
            }
        }
    }

    public void setWeight(String str) {
        this.iza = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void yA(int i) {
        this.izb = i;
    }

    public void Jq(String str) {
        this.izc = str;
    }

    public int cvm() {
        return this.izb;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String boR() {
        return this.mSource + "#" + this.izb + "#" + this.izc;
    }

    public String getWeight() {
        return this.iza;
    }

    public String getSource() {
        return this.mSource;
    }

    public String cvn() {
        return this.izc;
    }

    public String cvo() {
        return this.izd;
    }

    public void Jr(String str) {
        this.izd = str;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bz boO() {
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

    public Integer cvp() {
        return this.ize;
    }

    public void p(Integer num) {
        this.ize = num;
    }

    public aq Js(String str) {
        return aA(str, false);
    }

    public aq aA(String str, boolean z) {
        bz boO = boO();
        if (boO == null || str.length() == 0) {
            return null;
        }
        aq dX = new aq(str).dX("fid", String.valueOf(boO.getFid())).dX("tid", String.valueOf(boO.getTid())).dX(IntentConfig.NID, boO.bpO()).dX("obj_id", getExtra()).dX("obj_param1", getWeight()).an(TiebaInitialize.Params.OBJ_PARAM2, 1).dX("obj_source", getSource()).an("obj_locate", cvm()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.cuR()).dX("ab_tag", cvn());
        if (!z) {
            dX.an("obj_type", cvq());
        } else {
            if (boO.eVz > 0) {
                dX.an("midpageflag", 1);
            } else {
                dX.an("midpageflag", 0);
            }
            dX.an("is_vertical", cvp().intValue());
        }
        if (boO.bsW() != null && boO.bsW().dPf() != null && boO.bsW().dPf().bKW() != null && boO.bsW().dPf().bKW().size() > 0) {
            dX.an(TiebaInitialize.Params.OBJ_TO, boO.bsW().nsb ? 2 : 1);
        }
        return dX;
    }

    public aq aV(String str, int i) {
        bz boO = boO();
        if (boO == null) {
            return null;
        }
        aq dX = new aq(str).dX("fid", String.valueOf(boO.getFid())).dX("tid", String.valueOf(boO.getTid())).an(TiebaInitialize.Params.OBJ_PARAM2, 1).dX("obj_param1", getWeight()).dX("obj_source", getSource()).an("obj_locate", cvm()).dX("obj_name", cvn()).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.cuR());
        if (i == 0) {
            dX.an("obj_type", cvq());
        } else {
            dX.an("obj_type", i);
        }
        dX.dX("obj_id", getExtra());
        return dX;
    }

    private int cvq() {
        int i;
        int i2 = 0;
        bz boO = boO();
        if (boO == null) {
            return 0;
        }
        ArrayList<MediaData> brz = boO.brz();
        if (brz == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = brz.iterator();
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

    @Override // com.baidu.tbadk.core.util.ag
    public ArrayList<PreLoadImageInfo> getImages() {
        bz boO = boO();
        if (boO != null) {
            return boO.getImages();
        }
        return null;
    }

    public void yB(int i) {
        this.izf = i;
    }

    public boolean cvr() {
        return this.izf == 1;
    }

    @Override // com.baidu.tbadk.core.data.a
    public at boQ() {
        if (boO() == null || this.feedBackReasonMap == null || this.feedBackReasonMap.size() <= 0) {
            return null;
        }
        at atVar = new at();
        atVar.setTid(boO().getTid());
        atVar.setFid(boO().getFid());
        atVar.setNid(boO().bpO());
        atVar.setFeedBackReasonMap(this.feedBackReasonMap);
        atVar.weight = this.iza;
        atVar.source = this.mSource;
        atVar.extra = this.mExtra;
        atVar.threadType = boO().threadType;
        return atVar;
    }

    public aq cvs() {
        return null;
    }

    public aq cvt() {
        return null;
    }

    public aq cvu() {
        return null;
    }

    public aq cvv() {
        return null;
    }

    public aq Jt(String str) {
        return null;
    }

    public boolean bpV() {
        return false;
    }
}
