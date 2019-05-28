package com.baidu.tieba.card.data;

import android.util.SparseArray;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.am;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public abstract class c extends com.baidu.tbadk.core.data.a implements ae {
    public int eAA;
    private String eAu;
    private int eAv;
    private String eAw;
    private String eAx;
    private String eAy;
    private String mSource;
    public bg threadData;
    public String tid;
    public int objType = 1;
    public SparseArray<String> bGK = null;
    private Integer eAz = 0;
    public int bIf = 0;
    public int bIg = 0;

    public void setWeight(String str) {
        this.eAu = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void ps(int i) {
        this.eAv = i;
    }

    public void uU(String str) {
        this.eAw = str;
    }

    public int aXZ() {
        return this.eAv;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String aby() {
        return this.mSource + "#" + this.eAv + "#" + this.eAw;
    }

    public String getWeight() {
        return this.eAu;
    }

    public String getSource() {
        return this.mSource;
    }

    public String aYa() {
        return this.eAw;
    }

    public String aYb() {
        return this.eAx;
    }

    public void uV(String str) {
        this.eAx = str;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bg abv() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void uW(String str) {
        this.eAy = str;
    }

    public String getExtra() {
        return this.eAy;
    }

    public Integer aYc() {
        return this.eAz;
    }

    public void d(Integer num) {
        this.eAz = num;
    }

    public am uX(String str) {
        return U(str, false);
    }

    public am U(String str, boolean z) {
        bg abv = abv();
        if (abv == null || str.length() == 0) {
            return null;
        }
        am bT = new am(str).bT("fid", String.valueOf(abv.getFid())).bT("tid", String.valueOf(abv.getTid())).bT(VideoPlayActivityConfig.OBJ_ID, getExtra()).bT("obj_param1", getWeight()).P("obj_param2", 1).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).P("obj_locate", aXZ()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_param3", com.baidu.tieba.card.n.aXH());
        if (!z) {
            bT.P("obj_type", aYd());
        } else {
            if (abv.bKN > 0) {
                bT.P("midpageflag", 1);
            } else {
                bT.P("midpageflag", 0);
            }
            bT.bT("ab_tag", aYa());
            bT.P("is_vertical", aYc().intValue());
        }
        if (abv.aeT() != null && abv.aeT().cmy() != null && abv.aeT().cmy().axz() != null && abv.aeT().cmy().axz().size() > 0) {
            bT.P("obj_to", abv.aeT().iZj ? 2 : 1);
        }
        return bT;
    }

    public am ar(String str, int i) {
        bg abv = abv();
        if (abv == null) {
            return null;
        }
        am bT = new am(str).bT("fid", String.valueOf(abv.getFid())).bT("tid", String.valueOf(abv.getTid())).P(VideoPlayActivityConfig.OBJ_ID, U(abv)).P("obj_param2", 1).bT("obj_param1", getWeight()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).P("obj_locate", aXZ()).bT("obj_name", aYa()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_param3", com.baidu.tieba.card.n.aXH());
        if (i == 0) {
            bT.P("obj_type", aYd());
        } else {
            bT.P("obj_type", i);
        }
        bT.bT(VideoPlayActivityConfig.OBJ_ID, getExtra());
        return bT;
    }

    private int aYd() {
        int i;
        int i2 = 0;
        bg abv = abv();
        if (abv == null) {
            return 0;
        }
        ArrayList<MediaData> adF = abv.adF();
        if (adF == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = adF.iterator();
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
        bg abv = abv();
        if (abv != null) {
            return abv.getImages();
        }
        return null;
    }

    private int U(bg bgVar) {
        if (bgVar.aeF() == null || bgVar.aeF().channelId <= 0) {
            return 0;
        }
        return (int) bgVar.aeF().channelId;
    }

    public void pt(int i) {
        this.eAA = i;
    }

    public boolean aYe() {
        return this.eAA == 1;
    }

    @Override // com.baidu.tbadk.core.data.a
    public aj abx() {
        if (abv() == null || this.bGK == null || this.bGK.size() <= 0) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.setTid(abv().getTid());
        ajVar.setFid(abv().getFid());
        ajVar.b(this.bGK);
        ajVar.weight = this.eAu;
        ajVar.source = this.mSource;
        ajVar.extra = this.eAy;
        ajVar.threadType = abv().threadType;
        return ajVar;
    }
}
