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
    private String eHg;
    private int eHh;
    private String eHi;
    private String eHj;
    private String eHk;
    public int eHm;
    private String mSource;
    public bh threadData;
    public String tid;
    public int objType = 1;
    public SparseArray<String> bIk = null;
    private Integer eHl = 0;
    public int bJJ = 0;
    public int bJK = 0;

    public void setWeight(String str) {
        this.eHg = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void pN(int i) {
        this.eHh = i;
    }

    public void vY(String str) {
        this.eHi = str;
    }

    public int baD() {
        return this.eHh;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String acF() {
        return this.mSource + "#" + this.eHh + "#" + this.eHi;
    }

    public String getWeight() {
        return this.eHg;
    }

    public String getSource() {
        return this.mSource;
    }

    public String baE() {
        return this.eHi;
    }

    public String baF() {
        return this.eHj;
    }

    public void vZ(String str) {
        this.eHj = str;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bh acC() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void wa(String str) {
        this.eHk = str;
    }

    public String baG() {
        return this.eHk;
    }

    public Integer baH() {
        return this.eHl;
    }

    public void d(Integer num) {
        this.eHl = num;
    }

    public an wb(String str) {
        return W(str, false);
    }

    public an W(String str, boolean z) {
        bh acC = acC();
        if (acC == null || str.length() == 0) {
            return null;
        }
        an bT = new an(str).bT("fid", String.valueOf(acC.getFid())).bT("tid", String.valueOf(acC.getTid())).bT(VideoPlayActivityConfig.OBJ_ID, baG()).bT("obj_param1", getWeight()).P("obj_param2", 1).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).P("obj_locate", baD()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_param3", com.baidu.tieba.card.n.bak());
        if (!z) {
            bT.P("obj_type", baI());
        } else {
            if (acC.bMr > 0) {
                bT.P("midpageflag", 1);
            } else {
                bT.P("midpageflag", 0);
            }
            bT.bT("ab_tag", baE());
            bT.P("is_vertical", baH().intValue());
        }
        if (acC.aga() != null && acC.aga().cqB() != null && acC.aga().cqB().ayZ() != null && acC.aga().cqB().ayZ().size() > 0) {
            bT.P("obj_to", acC.aga().jjh ? 2 : 1);
        }
        return bT;
    }

    public an au(String str, int i) {
        bh acC = acC();
        if (acC == null) {
            return null;
        }
        an bT = new an(str).bT("fid", String.valueOf(acC.getFid())).bT("tid", String.valueOf(acC.getTid())).P(VideoPlayActivityConfig.OBJ_ID, W(acC)).P("obj_param2", 1).bT("obj_param1", getWeight()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).P("obj_locate", baD()).bT("obj_name", baE()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_param3", com.baidu.tieba.card.n.bak());
        if (i == 0) {
            bT.P("obj_type", baI());
        } else {
            bT.P("obj_type", i);
        }
        bT.bT(VideoPlayActivityConfig.OBJ_ID, baG());
        return bT;
    }

    private int baI() {
        int i;
        int i2 = 0;
        bh acC = acC();
        if (acC == null) {
            return 0;
        }
        ArrayList<MediaData> aeM = acC.aeM();
        if (aeM == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = aeM.iterator();
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
        bh acC = acC();
        if (acC != null) {
            return acC.getImages();
        }
        return null;
    }

    private int W(bh bhVar) {
        if (bhVar.afM() == null || bhVar.afM().channelId <= 0) {
            return 0;
        }
        return (int) bhVar.afM().channelId;
    }

    public void pO(int i) {
        this.eHm = i;
    }

    public boolean baJ() {
        return this.eHm == 1;
    }

    @Override // com.baidu.tbadk.core.data.a
    public aj acE() {
        if (acC() == null || this.bIk == null || this.bIk.size() <= 0) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.setTid(acC().getTid());
        ajVar.setFid(acC().getFid());
        ajVar.b(this.bIk);
        ajVar.weight = this.eHg;
        ajVar.source = this.mSource;
        ajVar.extra = this.eHk;
        ajVar.threadType = acC().threadType;
        return ajVar;
    }
}
