package com.baidu.tieba.card.data;

import android.util.SparseArray;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ak;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class c extends b implements ae {
    public String Xe;
    private String bMO;
    private int bMP;
    private String bMQ;
    private String bMR;
    private String mSource;
    public int bMS = 0;
    public SparseArray<String> Xf = null;

    public void setWeight(String str) {
        this.bMO = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void hH(int i) {
        this.bMP = i;
    }

    public void jw(String str) {
        this.bMQ = str;
    }

    public int Yb() {
        return this.bMP;
    }

    public String Yc() {
        return this.mSource + "#" + this.bMP + "#" + this.bMQ;
    }

    public String getWeight() {
        return this.bMO;
    }

    public String getSource() {
        return this.mSource;
    }

    public String Yd() {
        return this.bMQ;
    }

    public String Ye() {
        return this.bMR;
    }

    public void jx(String str) {
        this.bMR = str;
    }

    public bj MR() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public ak jy(String str) {
        return v(str, false);
    }

    public ak v(String str, boolean z) {
        bj MR = MR();
        if (MR == null) {
            return null;
        }
        ak ad = new ak(str).ad("fid", String.valueOf(MR.getFid())).ad("tid", String.valueOf(MR.getTid())).r("obj_id", E(MR)).ad("obj_param1", getWeight()).r("obj_param2", 1).ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", Yb()).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ad("obj_param3", com.baidu.tieba.card.m.XP());
        if (!z) {
            ad.r("obj_type", Yf());
        } else {
            ad.ad("ab_tag", Yd());
        }
        if (MR.sR() != null && MR.sR().aDg() != null && MR.sR().aDg().Iv() != null && MR.sR().aDg().Iv().size() > 0) {
            ad.r("obj_to", MR.sR().giQ ? 2 : 1);
        }
        return ad;
    }

    public ak J(String str, int i) {
        bj MR = MR();
        if (MR == null) {
            return null;
        }
        ak ad = new ak(str).ad("fid", String.valueOf(MR.getFid())).ad("tid", String.valueOf(MR.getTid())).r("obj_id", E(MR)).r("obj_param2", 1).ad("obj_param1", getWeight()).ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", Yb()).ad("obj_name", Yd()).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ad("obj_param3", com.baidu.tieba.card.m.XP());
        if (i == 0) {
            ad.r("obj_type", Yf());
            return ad;
        }
        ad.r("obj_type", i);
        return ad;
    }

    private int Yf() {
        int i;
        int i2 = 0;
        bj MR = MR();
        if (MR == null) {
            return 0;
        }
        ArrayList<MediaData> rL = MR.rL();
        if (rL == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = rL.iterator();
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
        bj MR = MR();
        if (MR != null) {
            return MR.getImages();
        }
        return null;
    }

    private int E(bj bjVar) {
        if (bjVar.sF() == null || bjVar.sF().channelId <= 0) {
            return 0;
        }
        return (int) bjVar.sF().channelId;
    }
}
