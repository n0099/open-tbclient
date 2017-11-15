package com.baidu.tieba.card.data;

import android.util.SparseArray;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ak;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class c extends b implements ae {
    public String Xl;
    private String bUO;
    private int bUP;
    private String bUQ;
    private String bUR;
    private String bUT;
    private String mSource;
    public int bUS = 0;
    public SparseArray<String> Xm = null;

    public void setWeight(String str) {
        this.bUO = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void ih(int i) {
        this.bUP = i;
    }

    public void jO(String str) {
        this.bUQ = str;
    }

    public int aam() {
        return this.bUP;
    }

    public String aan() {
        return this.mSource + "#" + this.bUP + "#" + this.bUQ;
    }

    public String getWeight() {
        return this.bUO;
    }

    public String getSource() {
        return this.mSource;
    }

    public String aao() {
        return this.bUQ;
    }

    public String aap() {
        return this.bUR;
    }

    public void jP(String str) {
        this.bUR = str;
    }

    public bh NA() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void setExtra(String str) {
        this.bUT = str;
    }

    public String getExtra() {
        return this.bUT;
    }

    public ak jQ(String str) {
        return s(str, false);
    }

    public ak s(String str, boolean z) {
        bh NA = NA();
        if (NA == null) {
            return null;
        }
        ak ac = new ak(str).ac(ImageViewerConfig.FORUM_ID, String.valueOf(NA.getFid())).ac("tid", String.valueOf(NA.getTid())).ac("obj_id", getExtra()).ac("obj_param1", getWeight()).r("obj_param2", 1).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", aam()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ac("obj_param3", com.baidu.tieba.card.m.ZY());
        if (!z) {
            ac.r("obj_type", aaq());
        } else {
            if (NA.aao > 0) {
                ac.r("midpageflag", 1);
            } else {
                ac.r("midpageflag", 0);
            }
            ac.ac("ab_tag", aao());
        }
        if (NA.sL() != null && NA.sL().aEx() != null && NA.sL().aEx().IT() != null && NA.sL().aEx().IT().size() > 0) {
            ac.r("obj_to", NA.sL().gqT ? 2 : 1);
        }
        return ac;
    }

    public ak P(String str, int i) {
        bh NA = NA();
        if (NA == null) {
            return null;
        }
        ak ac = new ak(str).ac(ImageViewerConfig.FORUM_ID, String.valueOf(NA.getFid())).ac("tid", String.valueOf(NA.getTid())).r("obj_id", z(NA)).r("obj_param2", 1).ac("obj_param1", getWeight()).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", aam()).ac("obj_name", aao()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ac("obj_param3", com.baidu.tieba.card.m.ZY());
        if (i == 0) {
            ac.r("obj_type", aaq());
        } else {
            ac.r("obj_type", i);
        }
        ac.ac("obj_id", getExtra());
        return ac;
    }

    private int aaq() {
        int i;
        int i2 = 0;
        bh NA = NA();
        if (NA == null) {
            return 0;
        }
        ArrayList<MediaData> rE = NA.rE();
        if (rE == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = rE.iterator();
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
        bh NA = NA();
        if (NA != null) {
            return NA.getImages();
        }
        return null;
    }

    private int z(bh bhVar) {
        if (bhVar.sz() == null || bhVar.sz().channelId <= 0) {
            return 0;
        }
        return (int) bhVar.sz().channelId;
    }
}
