package com.baidu.tieba.card.data;

import android.util.SparseArray;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.at;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class c extends b implements aj {
    public String Wg;
    private String bDQ;
    private int bDR;
    private String bDS;
    private String bDT;
    private String mSource;
    public int bDU = 0;
    public SparseArray<String> Wh = null;

    public void setWeight(String str) {
        this.bDQ = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void ho(int i) {
        this.bDR = i;
    }

    public void iN(String str) {
        this.bDS = str;
    }

    public int VS() {
        return this.bDR;
    }

    public String VT() {
        return String.valueOf(this.mSource) + "#" + this.bDR + "#" + this.bDS;
    }

    public String getWeight() {
        return this.bDQ;
    }

    public String getSource() {
        return this.mSource;
    }

    public String VU() {
        return this.bDS;
    }

    public String VV() {
        return this.bDT;
    }

    public void iO(String str) {
        this.bDT = str;
    }

    public bm Mv() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public au iP(String str) {
        return v(str, false);
    }

    public au v(String str, boolean z) {
        bm Mv = Mv();
        if (Mv == null) {
            return null;
        }
        au Z = new au(str).Z("fid", String.valueOf(Mv.getFid())).Z("tid", String.valueOf(Mv.getTid())).r("obj_id", w(Mv)).Z("obj_param1", getWeight()).r("obj_param2", 1).Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", VS()).Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).Z("obj_param3", at.VG());
        if (!z) {
            Z.r("obj_type", VW());
            return Z;
        }
        Z.Z("ab_tag", VU());
        return Z;
    }

    public au K(String str, int i) {
        bm Mv = Mv();
        if (Mv == null) {
            return null;
        }
        au Z = new au(str).Z("fid", String.valueOf(Mv.getFid())).Z("tid", String.valueOf(Mv.getTid())).r("obj_id", w(Mv)).r("obj_param2", 1).Z("obj_param1", getWeight()).Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", VS()).Z("obj_name", VU()).Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).Z("obj_param3", at.VG());
        if (i == 0) {
            Z.r("obj_type", VW());
            return Z;
        }
        Z.r("obj_type", i);
        return Z;
    }

    private int VW() {
        int i;
        bm Mv = Mv();
        if (Mv == null) {
            return 0;
        }
        ArrayList<MediaData> rB = Mv.rB();
        if (rB == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = rB.iterator();
            i = 0;
            while (it.hasNext()) {
                MediaData next = it.next();
                if (next != null && next.getType() == 3) {
                    i++;
                }
            }
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.util.aj
    public ArrayList<PreLoadImageInfo> getImages() {
        bm Mv = Mv();
        if (Mv != null) {
            return Mv.getImages();
        }
        return null;
    }

    private int w(bm bmVar) {
        if (bmVar.sv() == null || bmVar.sv().channelId <= 0) {
            return 0;
        }
        return (int) bmVar.sv().channelId;
    }
}
