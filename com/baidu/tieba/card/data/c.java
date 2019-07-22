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
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public abstract class c extends com.baidu.tbadk.core.data.a implements ae {
    private String eFq;
    private int eFr;
    private String eFs;
    private String eFt;
    private String eFu;
    public int eFw;
    private String mSource;
    public bg threadData;
    public String tid;
    public int objType = 1;
    public SparseArray<String> bHL = null;
    private Integer eFv = 0;
    public int bJg = 0;
    public int bJh = 0;

    public void setWeight(String str) {
        this.eFq = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void pI(int i) {
        this.eFr = i;
    }

    public void vy(String str) {
        this.eFs = str;
    }

    public int aZX() {
        return this.eFr;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String acA() {
        return this.mSource + "#" + this.eFr + "#" + this.eFs;
    }

    public String getWeight() {
        return this.eFq;
    }

    public String getSource() {
        return this.mSource;
    }

    public String aZY() {
        return this.eFs;
    }

    public String aZZ() {
        return this.eFt;
    }

    public void vz(String str) {
        this.eFt = str;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bg acx() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void vA(String str) {
        this.eFu = str;
    }

    public String baa() {
        return this.eFu;
    }

    public Integer bab() {
        return this.eFv;
    }

    public void d(Integer num) {
        this.eFv = num;
    }

    public an vB(String str) {
        return W(str, false);
    }

    public an W(String str, boolean z) {
        bg acx = acx();
        if (acx == null || str.length() == 0) {
            return null;
        }
        an bT = new an(str).bT("fid", String.valueOf(acx.getFid())).bT("tid", String.valueOf(acx.getTid())).bT(VideoPlayActivityConfig.OBJ_ID, baa()).bT("obj_param1", getWeight()).P("obj_param2", 1).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).P("obj_locate", aZX()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_param3", com.baidu.tieba.card.n.aZE());
        if (!z) {
            bT.P("obj_type", bac());
        } else {
            if (acx.bLO > 0) {
                bT.P("midpageflag", 1);
            } else {
                bT.P("midpageflag", 0);
            }
            bT.bT("ab_tag", aZY());
            bT.P("is_vertical", bab().intValue());
        }
        if (acx.afV() != null && acx.afV().cpr() != null && acx.afV().cpr().ayL() != null && acx.afV().cpr().ayL().size() > 0) {
            bT.P("obj_to", acx.afV().jfE ? 2 : 1);
        }
        return bT;
    }

    public an as(String str, int i) {
        bg acx = acx();
        if (acx == null) {
            return null;
        }
        an bT = new an(str).bT("fid", String.valueOf(acx.getFid())).bT("tid", String.valueOf(acx.getTid())).P(VideoPlayActivityConfig.OBJ_ID, U(acx)).P("obj_param2", 1).bT("obj_param1", getWeight()).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).P("obj_locate", aZX()).bT("obj_name", aZY()).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT("obj_param3", com.baidu.tieba.card.n.aZE());
        if (i == 0) {
            bT.P("obj_type", bac());
        } else {
            bT.P("obj_type", i);
        }
        bT.bT(VideoPlayActivityConfig.OBJ_ID, baa());
        return bT;
    }

    private int bac() {
        int i;
        int i2 = 0;
        bg acx = acx();
        if (acx == null) {
            return 0;
        }
        ArrayList<MediaData> aeH = acx.aeH();
        if (aeH == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = aeH.iterator();
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
        bg acx = acx();
        if (acx != null) {
            return acx.getImages();
        }
        return null;
    }

    private int U(bg bgVar) {
        if (bgVar.afH() == null || bgVar.afH().channelId <= 0) {
            return 0;
        }
        return (int) bgVar.afH().channelId;
    }

    public void pJ(int i) {
        this.eFw = i;
    }

    public boolean bad() {
        return this.eFw == 1;
    }

    @Override // com.baidu.tbadk.core.data.a
    public aj acz() {
        if (acx() == null || this.bHL == null || this.bHL.size() <= 0) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.setTid(acx().getTid());
        ajVar.setFid(acx().getFid());
        ajVar.b(this.bHL);
        ajVar.weight = this.eFq;
        ajVar.source = this.mSource;
        ajVar.extra = this.eFu;
        ajVar.threadType = acx().threadType;
        return ajVar;
    }
}
