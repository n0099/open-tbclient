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
    private String bNF;
    private int bNG;
    private String bNH;
    private String bNI;
    private String mSource;
    public int bNJ = 0;
    public SparseArray<String> Xf = null;

    public void setWeight(String str) {
        this.bNF = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void hJ(int i) {
        this.bNG = i;
    }

    public void jy(String str) {
        this.bNH = str;
    }

    public int Ym() {
        return this.bNG;
    }

    public String Yn() {
        return this.mSource + "#" + this.bNG + "#" + this.bNH;
    }

    public String getWeight() {
        return this.bNF;
    }

    public String getSource() {
        return this.mSource;
    }

    public String Yo() {
        return this.bNH;
    }

    public String Yp() {
        return this.bNI;
    }

    public void jz(String str) {
        this.bNI = str;
    }

    public bj MR() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public ak jA(String str) {
        return v(str, false);
    }

    public ak v(String str, boolean z) {
        bj MR = MR();
        if (MR == null) {
            return null;
        }
        ak ad = new ak(str).ad("fid", String.valueOf(MR.getFid())).ad("tid", String.valueOf(MR.getTid())).r("obj_id", E(MR)).ad("obj_param1", getWeight()).r("obj_param2", 1).ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", Ym()).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ad("obj_param3", com.baidu.tieba.card.m.Ya());
        if (!z) {
            ad.r("obj_type", Yq());
        } else {
            ad.ad("ab_tag", Yo());
        }
        if (MR.sR() != null && MR.sR().aDr() != null && MR.sR().aDr().Iv() != null && MR.sR().aDr().Iv().size() > 0) {
            ad.r("obj_to", MR.sR().gjK ? 2 : 1);
        }
        return ad;
    }

    public ak J(String str, int i) {
        bj MR = MR();
        if (MR == null) {
            return null;
        }
        ak ad = new ak(str).ad("fid", String.valueOf(MR.getFid())).ad("tid", String.valueOf(MR.getTid())).r("obj_id", E(MR)).r("obj_param2", 1).ad("obj_param1", getWeight()).ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", Ym()).ad("obj_name", Yo()).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ad("obj_param3", com.baidu.tieba.card.m.Ya());
        if (i == 0) {
            ad.r("obj_type", Yq());
            return ad;
        }
        ad.r("obj_type", i);
        return ad;
    }

    private int Yq() {
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
