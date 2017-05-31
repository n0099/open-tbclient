package com.baidu.tieba.card.data;

import android.util.SparseArray;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.at;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class c extends b implements ah {
    public String Wg;
    private String bCX;
    private int bCY;
    private String bCZ;
    private String bDa;
    private String mSource;
    public int bDb = 0;
    public SparseArray<String> Wh = null;

    public void setWeight(String str) {
        this.bCX = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void hl(int i) {
        this.bCY = i;
    }

    public void ig(String str) {
        this.bCZ = str;
    }

    public int UB() {
        return this.bCY;
    }

    public String UC() {
        return String.valueOf(this.mSource) + "#" + this.bCY + "#" + this.bCZ;
    }

    public String getWeight() {
        return this.bCX;
    }

    public String getSource() {
        return this.mSource;
    }

    public String UD() {
        return this.bCZ;
    }

    public String UE() {
        return this.bDa;
    }

    public void ih(String str) {
        this.bDa = str;
    }

    public bl LH() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public as ht(String str) {
        return x(str, false);
    }

    public as x(String str, boolean z) {
        bl LH = LH();
        if (LH == null) {
            return null;
        }
        as Z = new as(str).Z("fid", String.valueOf(LH.getFid())).Z("tid", String.valueOf(LH.getTid())).r("obj_id", v(LH)).Z("obj_param1", getWeight()).r("obj_param2", 1).Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", UB()).Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).Z("obj_param3", at.Up());
        if (!z) {
            Z.r("obj_type", UF());
            return Z;
        }
        Z.Z("ab_tag", UD());
        return Z;
    }

    public as I(String str, int i) {
        bl LH = LH();
        if (LH == null) {
            return null;
        }
        as Z = new as(str).Z("fid", String.valueOf(LH.getFid())).Z("tid", String.valueOf(LH.getTid())).r("obj_id", v(LH)).r("obj_param2", 1).Z("obj_param1", getWeight()).Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", UB()).Z("obj_name", UD()).Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).Z("obj_param3", at.Up());
        if (i == 0) {
            Z.r("obj_type", UF());
            return Z;
        }
        Z.r("obj_type", i);
        return Z;
    }

    private int UF() {
        int i;
        bl LH = LH();
        if (LH == null) {
            return 0;
        }
        ArrayList<MediaData> rE = LH.rE();
        if (rE == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = rE.iterator();
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
        bl LH = LH();
        if (LH != null) {
            return LH.getImages();
        }
        return null;
    }

    private int v(bl blVar) {
        if (blVar.sx() == null || blVar.sx().channelId <= 0) {
            return 0;
        }
        return (int) blVar.sx().channelId;
    }
}
