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
    public String Ww;
    private String bIc;
    private int bId;
    private String bIe;
    private String bIf;
    private String mSource;
    public int bIg = 0;
    public SparseArray<String> Wx = null;

    public void setWeight(String str) {
        this.bIc = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void hu(int i) {
        this.bId = i;
    }

    public void jc(String str) {
        this.bIe = str;
    }

    public int WA() {
        return this.bId;
    }

    public String WB() {
        return this.mSource + "#" + this.bId + "#" + this.bIe;
    }

    public String getWeight() {
        return this.bIc;
    }

    public String getSource() {
        return this.mSource;
    }

    public String WC() {
        return this.bIe;
    }

    public String WD() {
        return this.bIf;
    }

    public void jd(String str) {
        this.bIf = str;
    }

    public bl MA() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public aj je(String str) {
        return v(str, false);
    }

    public aj v(String str, boolean z) {
        bl MA = MA();
        if (MA == null) {
            return null;
        }
        aj aa = new aj(str).aa("fid", String.valueOf(MA.getFid())).aa("tid", String.valueOf(MA.getTid())).r("obj_id", A(MA)).aa("obj_param1", getWeight()).r("obj_param2", 1).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", WA()).aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).aa("obj_param3", com.baidu.tieba.card.m.Wn());
        if (!z) {
            aa.r("obj_type", WE());
            return aa;
        }
        aa.aa("ab_tag", WC());
        return aa;
    }

    public aj J(String str, int i) {
        bl MA = MA();
        if (MA == null) {
            return null;
        }
        aj aa = new aj(str).aa("fid", String.valueOf(MA.getFid())).aa("tid", String.valueOf(MA.getTid())).r("obj_id", A(MA)).r("obj_param2", 1).aa("obj_param1", getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", WA()).aa("obj_name", WC()).aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).aa("obj_param3", com.baidu.tieba.card.m.Wn());
        if (i == 0) {
            aa.r("obj_type", WE());
            return aa;
        }
        aa.r("obj_type", i);
        return aa;
    }

    private int WE() {
        int i;
        int i2 = 0;
        bl MA = MA();
        if (MA == null) {
            return 0;
        }
        ArrayList<MediaData> rF = MA.rF();
        if (rF == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = rF.iterator();
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
        bl MA = MA();
        if (MA != null) {
            return MA.getImages();
        }
        return null;
    }

    private int A(bl blVar) {
        if (blVar.sz() == null || blVar.sz().channelId <= 0) {
            return 0;
        }
        return (int) blVar.sz().channelId;
    }
}
