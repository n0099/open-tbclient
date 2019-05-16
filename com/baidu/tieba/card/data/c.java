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
    private String eAt;
    private int eAu;
    private String eAv;
    private String eAw;
    private String eAx;
    public int eAz;
    private String mSource;
    public bg threadData;
    public String tid;
    public int objType = 1;
    public SparseArray<String> bGK = null;
    private Integer eAy = 0;
    public int bIf = 0;
    public int bIg = 0;

    public void setWeight(String str) {
        this.eAt = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void ps(int i) {
        this.eAu = i;
    }

    public void uU(String str) {
        this.eAv = str;
    }

    public int aXW() {
        return this.eAu;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String aby() {
        return this.mSource + "#" + this.eAu + "#" + this.eAv;
    }

    public String getWeight() {
        return this.eAt;
    }

    public String getSource() {
        return this.mSource;
    }

    public String aXX() {
        return this.eAv;
    }

    public String aXY() {
        return this.eAw;
    }

    public void uV(String str) {
        this.eAw = str;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bg abv() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void uW(String str) {
        this.eAx = str;
    }

    public String getExtra() {
        return this.eAx;
    }

    public Integer aXZ() {
        return this.eAy;
    }

    public void d(Integer num) {
        this.eAy = num;
    }

    public am uX(String str) {
        return U(str, false);
    }

    public am U(String str, boolean z) {
        bg abv = abv();
        if (abv == null || str.length() == 0) {
            return null;
        }
        am bT = new am(str).bT("fid", String.valueOf(abv.getFid())).bT("tid", String.valueOf(abv.getTid())).bT(VideoPlayActivityConfig.OBJ_ID, getExtra()).bT("obj_param1", getWeight()).P("obj_param2", 1).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).P("obj_locate", aXW()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_param3", com.baidu.tieba.card.n.aXE());
        if (!z) {
            bT.P("obj_type", aYa());
        } else {
            if (abv.bKN > 0) {
                bT.P("midpageflag", 1);
            } else {
                bT.P("midpageflag", 0);
            }
            bT.bT("ab_tag", aXX());
            bT.P("is_vertical", aXZ().intValue());
        }
        if (abv.aeT() != null && abv.aeT().cmw() != null && abv.aeT().cmw().axy() != null && abv.aeT().cmw().axy().size() > 0) {
            bT.P("obj_to", abv.aeT().iZh ? 2 : 1);
        }
        return bT;
    }

    public am ar(String str, int i) {
        bg abv = abv();
        if (abv == null) {
            return null;
        }
        am bT = new am(str).bT("fid", String.valueOf(abv.getFid())).bT("tid", String.valueOf(abv.getTid())).P(VideoPlayActivityConfig.OBJ_ID, U(abv)).P("obj_param2", 1).bT("obj_param1", getWeight()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).P("obj_locate", aXW()).bT("obj_name", aXX()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_param3", com.baidu.tieba.card.n.aXE());
        if (i == 0) {
            bT.P("obj_type", aYa());
        } else {
            bT.P("obj_type", i);
        }
        bT.bT(VideoPlayActivityConfig.OBJ_ID, getExtra());
        return bT;
    }

    private int aYa() {
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
        this.eAz = i;
    }

    public boolean aYb() {
        return this.eAz == 1;
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
        ajVar.weight = this.eAt;
        ajVar.source = this.mSource;
        ajVar.extra = this.eAx;
        ajVar.threadType = abv().threadType;
        return ajVar;
    }
}
