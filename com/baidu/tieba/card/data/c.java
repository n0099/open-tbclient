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
    public String WT;
    public SparseArray<String> WU = null;
    private String bxc;
    private int bxd;
    private String bxe;
    private String bxf;
    private String mSource;

    public void setWeight(String str) {
        this.bxc = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void gR(int i) {
        this.bxd = i;
    }

    public void id(String str) {
        this.bxe = str;
    }

    public int TX() {
        return this.bxd;
    }

    public String TY() {
        return String.valueOf(this.mSource) + "#" + this.bxd + "#" + this.bxe;
    }

    public String getWeight() {
        return this.bxc;
    }

    public String getSource() {
        return this.mSource;
    }

    public String TZ() {
        return this.bxe;
    }

    public String Ua() {
        return this.bxf;
    }

    public void ie(String str) {
        this.bxf = str;
    }

    public bi Kn() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    /* renamed from: if  reason: not valid java name */
    public as m16if(String str) {
        return A(str, false);
    }

    public as A(String str, boolean z) {
        bi Kn = Kn();
        if (Kn == null) {
            return null;
        }
        as aa = new as(str).aa("fid", String.valueOf(Kn.getFid())).aa("tid", String.valueOf(Kn.getTid())).s("obj_id", m(Kn)).aa("obj_param1", getWeight()).s("obj_param2", 1).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).s("obj_locate", TX()).aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).aa("obj_param3", at.TP());
        if (!z) {
            aa.s("obj_type", Ub());
            return aa;
        }
        aa.aa("ab_tag", TZ());
        return aa;
    }

    private int Ub() {
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
