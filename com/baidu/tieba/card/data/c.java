package com.baidu.tieba.card.data;

import android.util.SparseArray;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.at;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class c extends b implements ag {
    public String SK;
    private String bnX;
    private int bnY;
    private String bnZ;
    private String boa;
    public SparseArray<String> bob = null;
    private String mSource;

    public void setWeight(String str) {
        this.bnX = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void gL(int i) {
        this.bnY = i;
    }

    public void ii(String str) {
        this.bnZ = str;
    }

    public int Rz() {
        return this.bnY;
    }

    public String RA() {
        return String.valueOf(this.mSource) + "#" + this.bnY + "#" + this.bnZ;
    }

    public String getWeight() {
        return this.bnX;
    }

    public String getSource() {
        return this.mSource;
    }

    public String RB() {
        return this.bnZ;
    }

    public String RC() {
        return this.boa;
    }

    public void ij(String str) {
        this.boa = str;
    }

    public bh Ji() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public ar ik(String str) {
        return z(str, false);
    }

    public ar z(String str, boolean z) {
        bh Ji = Ji();
        if (Ji == null) {
            return null;
        }
        ar ab = new ar(str).ab("fid", String.valueOf(Ji.getFid())).ab("tid", String.valueOf(Ji.getTid())).s("obj_id", m(Ji)).s("obj_param2", 1).ab("obj_param1", getWeight()).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).s("obj_locate", Rz()).ab("obj_name", RB()).ab(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ab("obj_param3", at.Rr());
        if (!z) {
            ab.s("obj_type", RD());
            return ab;
        }
        return ab;
    }

    private int RD() {
        int i;
        bh Ji = Ji();
        if (Ji == null) {
            return 0;
        }
        ArrayList<MediaData> rG = Ji.rG();
        if (rG == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = rG.iterator();
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

    @Override // com.baidu.tbadk.core.util.ag
    public ArrayList<PreLoadImageInfo> getImages() {
        bh Ji = Ji();
        if (Ji != null) {
            return Ji.getImages();
        }
        return null;
    }

    private int m(bh bhVar) {
        if (bhVar.sz() == null || bhVar.sz().channelId <= 0) {
            return 0;
        }
        return (int) bhVar.sz().channelId;
    }
}
