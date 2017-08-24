package com.baidu.tieba.card.data;

import android.util.SparseArray;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.aj;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class c extends b implements ad {
    public String XV;
    private String bJW;
    private int bJX;
    private String bJY;
    private String bJZ;
    private String mSource;
    public int bKa = 0;
    public SparseArray<String> XW = null;

    public void setWeight(String str) {
        this.bJW = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void hw(int i) {
        this.bJX = i;
    }

    public void jl(String str) {
        this.bJY = str;
    }

    public int WY() {
        return this.bJX;
    }

    public String WZ() {
        return this.mSource + "#" + this.bJX + "#" + this.bJY;
    }

    public String getWeight() {
        return this.bJW;
    }

    public String getSource() {
        return this.mSource;
    }

    public String Xa() {
        return this.bJY;
    }

    public String Xb() {
        return this.bJZ;
    }

    public void jm(String str) {
        this.bJZ = str;
    }

    public bl MF() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public aj jn(String str) {
        return v(str, false);
    }

    public aj v(String str, boolean z) {
        bl MF = MF();
        if (MF == null) {
            return null;
        }
        aj aa = new aj(str).aa("fid", String.valueOf(MF.getFid())).aa("tid", String.valueOf(MF.getTid())).r("obj_id", A(MF)).aa("obj_param1", getWeight()).r("obj_param2", 1).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", WY()).aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).aa("obj_param3", com.baidu.tieba.card.m.WL());
        if (!z) {
            aa.r("obj_type", Xc());
            return aa;
        }
        aa.aa("ab_tag", Xa());
        return aa;
    }

    public aj J(String str, int i) {
        bl MF = MF();
        if (MF == null) {
            return null;
        }
        aj aa = new aj(str).aa("fid", String.valueOf(MF.getFid())).aa("tid", String.valueOf(MF.getTid())).r("obj_id", A(MF)).r("obj_param2", 1).aa("obj_param1", getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", WY()).aa("obj_name", Xa()).aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).aa("obj_param3", com.baidu.tieba.card.m.WL());
        if (i == 0) {
            aa.r("obj_type", Xc());
            return aa;
        }
        aa.r("obj_type", i);
        return aa;
    }

    private int Xc() {
        int i;
        int i2 = 0;
        bl MF = MF();
        if (MF == null) {
            return 0;
        }
        ArrayList<MediaData> rQ = MF.rQ();
        if (rQ == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = rQ.iterator();
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

    @Override // com.baidu.tbadk.core.util.ad
    public ArrayList<PreLoadImageInfo> getImages() {
        bl MF = MF();
        if (MF != null) {
            return MF.getImages();
        }
        return null;
    }

    private int A(bl blVar) {
        if (blVar.sK() == null || blVar.sK().channelId <= 0) {
            return 0;
        }
        return (int) blVar.sK().channelId;
    }
}
