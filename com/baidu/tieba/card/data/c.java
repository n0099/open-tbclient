package com.baidu.tieba.card.data;

import android.util.SparseArray;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public abstract class c extends com.baidu.tbadk.core.data.a implements ae {
    private String eFA;
    private String eFB;
    public int eFD;
    private String eFx;
    private int eFy;
    private String eFz;
    private String mSource;
    public bh threadData;
    public String tid;
    public int objType = 1;
    public SparseArray<String> bHM = null;
    private Integer eFC = 0;
    public int bJl = 0;
    public int bJm = 0;

    public void setWeight(String str) {
        this.eFx = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void pJ(int i) {
        this.eFy = i;
    }

    public void vz(String str) {
        this.eFz = str;
    }

    public int aZZ() {
        return this.eFy;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String acB() {
        return this.mSource + "#" + this.eFy + "#" + this.eFz;
    }

    public String getWeight() {
        return this.eFx;
    }

    public String getSource() {
        return this.mSource;
    }

    public String baa() {
        return this.eFz;
    }

    public String bab() {
        return this.eFA;
    }

    public void vA(String str) {
        this.eFA = str;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bh acy() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void vB(String str) {
        this.eFB = str;
    }

    public String bac() {
        return this.eFB;
    }

    public Integer bad() {
        return this.eFC;
    }

    public void d(Integer num) {
        this.eFC = num;
    }

    public an vC(String str) {
        return W(str, false);
    }

    public an W(String str, boolean z) {
        bh acy = acy();
        if (acy == null || str.length() == 0) {
            return null;
        }
        an bT = new an(str).bT("fid", String.valueOf(acy.getFid())).bT("tid", String.valueOf(acy.getTid())).bT(VideoPlayActivityConfig.OBJ_ID, bac()).bT("obj_param1", getWeight()).P("obj_param2", 1).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).P("obj_locate", aZZ()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_param3", com.baidu.tieba.card.n.aZG());
        if (!z) {
            bT.P("obj_type", bae());
        } else {
            if (acy.bLT > 0) {
                bT.P("midpageflag", 1);
            } else {
                bT.P("midpageflag", 0);
            }
            bT.bT("ab_tag", baa());
            bT.P("is_vertical", bad().intValue());
        }
        if (acy.afW() != null && acy.afW().cpN() != null && acy.afW().cpN().ayN() != null && acy.afW().cpN().ayN().size() > 0) {
            bT.P("obj_to", acy.afW().jgL ? 2 : 1);
        }
        return bT;
    }

    public an as(String str, int i) {
        bh acy = acy();
        if (acy == null) {
            return null;
        }
        an bT = new an(str).bT("fid", String.valueOf(acy.getFid())).bT("tid", String.valueOf(acy.getTid())).P(VideoPlayActivityConfig.OBJ_ID, V(acy)).P("obj_param2", 1).bT("obj_param1", getWeight()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).P("obj_locate", aZZ()).bT("obj_name", baa()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_param3", com.baidu.tieba.card.n.aZG());
        if (i == 0) {
            bT.P("obj_type", bae());
        } else {
            bT.P("obj_type", i);
        }
        bT.bT(VideoPlayActivityConfig.OBJ_ID, bac());
        return bT;
    }

    private int bae() {
        int i;
        int i2 = 0;
        bh acy = acy();
        if (acy == null) {
            return 0;
        }
        ArrayList<MediaData> aeI = acy.aeI();
        if (aeI == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = aeI.iterator();
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
        bh acy = acy();
        if (acy != null) {
            return acy.getImages();
        }
        return null;
    }

    private int V(bh bhVar) {
        if (bhVar.afI() == null || bhVar.afI().channelId <= 0) {
            return 0;
        }
        return (int) bhVar.afI().channelId;
    }

    public void pK(int i) {
        this.eFD = i;
    }

    public boolean baf() {
        return this.eFD == 1;
    }

    @Override // com.baidu.tbadk.core.data.a
    public aj acA() {
        if (acy() == null || this.bHM == null || this.bHM.size() <= 0) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.setTid(acy().getTid());
        ajVar.setFid(acy().getFid());
        ajVar.b(this.bHM);
        ajVar.weight = this.eFx;
        ajVar.source = this.mSource;
        ajVar.extra = this.eFB;
        ajVar.threadType = acy().threadType;
        return ajVar;
    }
}
