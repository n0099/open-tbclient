package com.baidu.tieba.card.data;

import android.util.SparseArray;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ak;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class c extends b implements ae {
    public String WT;
    private String bMX;
    private int bMY;
    private String bMZ;
    private String bNa;
    private String bNc;
    private String mSource;
    public int bNb = 0;
    public SparseArray<String> WU = null;

    public void setWeight(String str) {
        this.bMX = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void hQ(int i) {
        this.bMY = i;
    }

    public void jp(String str) {
        this.bMZ = str;
    }

    public int XQ() {
        return this.bMY;
    }

    public String XR() {
        return this.mSource + "#" + this.bMY + "#" + this.bMZ;
    }

    public String getWeight() {
        return this.bMX;
    }

    public String getSource() {
        return this.mSource;
    }

    public String XS() {
        return this.bMZ;
    }

    public String XT() {
        return this.bNa;
    }

    public void jq(String str) {
        this.bNa = str;
    }

    public bh Nd() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void setExtra(String str) {
        this.bNc = str;
    }

    public String getExtra() {
        return this.bNc;
    }

    public ak jr(String str) {
        return u(str, false);
    }

    public ak u(String str, boolean z) {
        bh Nd = Nd();
        if (Nd == null) {
            return null;
        }
        ak ac = new ak(str).ac("fid", String.valueOf(Nd.getFid())).ac("tid", String.valueOf(Nd.getTid())).ac("obj_id", getExtra()).ac("obj_param1", getWeight()).r("obj_param2", 1).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", XQ()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ac("obj_param3", com.baidu.tieba.card.m.XC());
        if (!z) {
            ac.r("obj_type", XU());
        } else {
            ac.ac("ab_tag", XS());
        }
        if (Nd.sE() != null && Nd.sE().aBY() != null && Nd.sE().aBY().Ix() != null && Nd.sE().aBY().Ix().size() > 0) {
            ac.r("obj_to", Nd.sE().ghf ? 2 : 1);
        }
        return ac;
    }

    public ak J(String str, int i) {
        bh Nd = Nd();
        if (Nd == null) {
            return null;
        }
        ak ac = new ak(str).ac("fid", String.valueOf(Nd.getFid())).ac("tid", String.valueOf(Nd.getTid())).r("obj_id", z(Nd)).r("obj_param2", 1).ac("obj_param1", getWeight()).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", XQ()).ac("obj_name", XS()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ac("obj_param3", com.baidu.tieba.card.m.XC());
        if (i == 0) {
            ac.r("obj_type", XU());
        } else {
            ac.r("obj_type", i);
        }
        ac.ac("obj_id", getExtra());
        return ac;
    }

    private int XU() {
        int i;
        int i2 = 0;
        bh Nd = Nd();
        if (Nd == null) {
            return 0;
        }
        ArrayList<MediaData> ry = Nd.ry();
        if (ry == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = ry.iterator();
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
        bh Nd = Nd();
        if (Nd != null) {
            return Nd.getImages();
        }
        return null;
    }

    private int z(bh bhVar) {
        if (bhVar.ss() == null || bhVar.ss().channelId <= 0) {
            return 0;
        }
        return (int) bhVar.ss().channelId;
    }
}
