package com.baidu.tieba.card.data;

import android.util.SparseArray;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.at;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class c extends b implements ah {
    public String WD;
    public SparseArray<String> WE = null;
    private String buT;
    private int buU;
    private String buV;
    private String buW;
    private String mSource;

    public void setWeight(String str) {
        this.buT = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void gI(int i) {
        this.buU = i;
    }

    public void hY(String str) {
        this.buV = str;
    }

    public int Sx() {
        return this.buU;
    }

    public String Sy() {
        return String.valueOf(this.mSource) + "#" + this.buU + "#" + this.buV;
    }

    public String getWeight() {
        return this.buT;
    }

    public String getSource() {
        return this.mSource;
    }

    public String Sz() {
        return this.buV;
    }

    public String SA() {
        return this.buW;
    }

    public void hZ(String str) {
        this.buW = str;
    }

    public bj JN() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public as ia(String str) {
        return A(str, false);
    }

    public as A(String str, boolean z) {
        bj JN = JN();
        if (JN == null) {
            return null;
        }
        as Z = new as(str).Z("fid", String.valueOf(JN.getFid())).Z("tid", String.valueOf(JN.getTid())).s("obj_id", m(JN)).s("obj_param2", 1).Z("obj_param1", getWeight()).Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).s("obj_locate", Sx()).Z("obj_name", Sz()).Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).Z("obj_param3", at.Sp());
        if (!z) {
            Z.s("obj_type", SB());
            return Z;
        }
        return Z;
    }

    private int SB() {
        int i;
        bj JN = JN();
        if (JN == null) {
            return 0;
        }
        ArrayList<MediaData> sa = JN.sa();
        if (sa == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = sa.iterator();
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
        bj JN = JN();
        if (JN != null) {
            return JN.getImages();
        }
        return null;
    }

    private int m(bj bjVar) {
        if (bjVar.sU() == null || bjVar.sU().channelId <= 0) {
            return 0;
        }
        return (int) bjVar.sU().channelId;
    }
}
