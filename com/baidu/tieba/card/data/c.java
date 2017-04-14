package com.baidu.tieba.card.data;

import android.util.SparseArray;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.at;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class c extends b implements ah {
    public String WS;
    public SparseArray<String> WT = null;
    private String buL;
    private int buM;
    private String buN;
    private String buO;
    private String mSource;

    public void setWeight(String str) {
        this.buL = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void gL(int i) {
        this.buM = i;
    }

    public void ic(String str) {
        this.buN = str;
    }

    public int SV() {
        return this.buM;
    }

    public String SW() {
        return String.valueOf(this.mSource) + "#" + this.buM + "#" + this.buN;
    }

    public String getWeight() {
        return this.buL;
    }

    public String getSource() {
        return this.mSource;
    }

    public String SX() {
        return this.buN;
    }

    public String SY() {
        return this.buO;
    }

    public void id(String str) {
        this.buO = str;
    }

    public bi Kn() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public as ie(String str) {
        return A(str, false);
    }

    public as A(String str, boolean z) {
        bi Kn = Kn();
        if (Kn == null) {
            return null;
        }
        as aa = new as(str).aa("fid", String.valueOf(Kn.getFid())).aa("tid", String.valueOf(Kn.getTid())).s("obj_id", m(Kn)).s("obj_param2", 1).aa("obj_param1", getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).s("obj_locate", SV()).aa("obj_name", SX()).aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).aa("obj_param3", at.SN());
        if (!z) {
            aa.s("obj_type", SZ());
            return aa;
        }
        return aa;
    }

    private int SZ() {
        int i;
        bi Kn = Kn();
        if (Kn == null) {
            return 0;
        }
        ArrayList<MediaData> sy = Kn.sy();
        if (sy == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = sy.iterator();
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

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        bi Kn = Kn();
        if (Kn != null) {
            return Kn.getImages();
        }
        return null;
    }

    private int m(bi biVar) {
        if (biVar.ts() == null || biVar.ts().channelId <= 0) {
            return 0;
        }
        return (int) biVar.ts().channelId;
    }
}
