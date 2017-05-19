package com.baidu.tieba.card.data;

import android.util.SparseArray;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.ap;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class c extends b implements ah {
    public String Wl;
    private String bxa;
    private int bxb;
    private String bxc;
    private String bxd;
    private String mSource;
    public int bxe = 0;
    public SparseArray<String> Wm = null;

    public void setWeight(String str) {
        this.bxa = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void gN(int i) {
        this.bxb = i;
    }

    public void ic(String str) {
        this.bxc = str;
    }

    public int Tq() {
        return this.bxb;
    }

    public String Tr() {
        return String.valueOf(this.mSource) + "#" + this.bxb + "#" + this.bxc;
    }

    public String getWeight() {
        return this.bxa;
    }

    public String getSource() {
        return this.mSource;
    }

    public String Ts() {
        return this.bxc;
    }

    public String Tt() {
        return this.bxd;
    }

    public void id(String str) {
        this.bxd = str;
    }

    public bk JB() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public as ie(String str) {
        return A(str, false);
    }

    public as A(String str, boolean z) {
        bk JB = JB();
        if (JB == null) {
            return null;
        }
        as aa = new as(str).aa("fid", String.valueOf(JB.getFid())).aa("tid", String.valueOf(JB.getTid())).s("obj_id", r(JB)).aa("obj_param1", getWeight()).s("obj_param2", 1).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).s("obj_locate", Tq()).aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).aa("obj_param3", ap.Th());
        if (!z) {
            aa.s("obj_type", Tu());
            return aa;
        }
        aa.aa("ab_tag", Ts());
        return aa;
    }

    public as I(String str, int i) {
        bk JB = JB();
        if (JB == null) {
            return null;
        }
        as aa = new as(str).aa("fid", String.valueOf(JB.getFid())).aa("tid", String.valueOf(JB.getTid())).s("obj_id", r(JB)).s("obj_param2", 1).aa("obj_param1", getWeight()).aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).s("obj_locate", Tq()).aa("obj_name", Ts()).aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).aa("obj_param3", ap.Th());
        if (i == 0) {
            aa.s("obj_type", Tu());
            return aa;
        }
        aa.s("obj_type", i);
        return aa;
    }

    private int Tu() {
        int i;
        bk JB = JB();
        if (JB == null) {
            return 0;
        }
        ArrayList<MediaData> rI = JB.rI();
        if (rI == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = rI.iterator();
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
        bk JB = JB();
        if (JB != null) {
            return JB.getImages();
        }
        return null;
    }

    private int r(bk bkVar) {
        if (bkVar.sC() == null || bkVar.sC().channelId <= 0) {
            return 0;
        }
        return (int) bkVar.sC().channelId;
    }
}
