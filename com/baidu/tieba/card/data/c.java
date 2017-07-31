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
    public String XS;
    private String bJm;
    private int bJn;
    private String bJo;
    private String bJp;
    private String mSource;
    public int bJq = 0;
    public SparseArray<String> XT = null;

    public void setWeight(String str) {
        this.bJm = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void hv(int i) {
        this.bJn = i;
    }

    public void jh(String str) {
        this.bJo = str;
    }

    public int WF() {
        return this.bJn;
    }

    public String WG() {
        return this.mSource + "#" + this.bJn + "#" + this.bJo;
    }

    public String getWeight() {
        return this.bJm;
    }

    public String getSource() {
        return this.mSource;
    }

    public String WH() {
        return this.bJo;
    }

    public String WI() {
        return this.bJp;
    }

    public void ji(String str) {
        this.bJp = str;
    }

    public bl MF() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public aj jj(String str) {
        return v(str, false);
    }

    public aj v(String str, boolean z) {
        bl MF = MF();
        if (MF == null) {
            return null;
        }
        aj aa = new aj(str).aa("fid", String.valueOf(MF.getFid())).aa("tid", String.valueOf(MF.getTid())).r("obj_id", A(MF)).aa("obj_param1", getWeight()).r("obj_param2", 1).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", WF()).aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).aa("obj_param3", com.baidu.tieba.card.m.Ws());
        if (!z) {
            aa.r("obj_type", WJ());
            return aa;
        }
        aa.aa("ab_tag", WH());
        return aa;
    }

    public aj J(String str, int i) {
        bl MF = MF();
        if (MF == null) {
            return null;
        }
        aj aa = new aj(str).aa("fid", String.valueOf(MF.getFid())).aa("tid", String.valueOf(MF.getTid())).r("obj_id", A(MF)).r("obj_param2", 1).aa("obj_param1", getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", WF()).aa("obj_name", WH()).aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).aa("obj_param3", com.baidu.tieba.card.m.Ws());
        if (i == 0) {
            aa.r("obj_type", WJ());
            return aa;
        }
        aa.r("obj_type", i);
        return aa;
    }

    private int WJ() {
        int i;
        int i2 = 0;
        bl MF = MF();
        if (MF == null) {
            return 0;
        }
        ArrayList<MediaData> rP = MF.rP();
        if (rP == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = rP.iterator();
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
        if (blVar.sJ() == null || blVar.sJ().channelId <= 0) {
            return 0;
        }
        return (int) blVar.sJ().channelId;
    }
}
