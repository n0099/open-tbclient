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
    private String bUB;
    private int bUC;
    private String bUD;
    private String bUE;
    private String bUG;
    private String mSource;
    public int bUF = 0;
    public SparseArray<String> Xm = null;

    public void setWeight(String str) {
        this.bUB = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void ij(int i) {
        this.bUC = i;
    }

    public void jN(String str) {
        this.bUD = str;
    }

    public int aaa() {
        return this.bUC;
    }

    public String aab() {
        return this.mSource + "#" + this.bUC + "#" + this.bUD;
    }

    public String getWeight() {
        return this.bUB;
    }

    public String getSource() {
        return this.mSource;
    }

    public String aac() {
        return this.bUD;
    }

    public String aad() {
        return this.bUE;
    }

    public void jO(String str) {
        this.bUE = str;
    }

    public bh Np() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void setExtra(String str) {
        this.bUG = str;
    }

    public String getExtra() {
        return this.bUG;
    }

    public ak jP(String str) {
        return s(str, false);
    }

    public ak s(String str, boolean z) {
        bh Np = Np();
        if (Np == null) {
            return null;
        }
        ak ac = new ak(str).ac(ImageViewerConfig.FORUM_ID, String.valueOf(Np.getFid())).ac("tid", String.valueOf(Np.getTid())).ac("obj_id", getExtra()).ac("obj_param1", getWeight()).r("obj_param2", 1).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", aaa()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ac("obj_param3", com.baidu.tieba.card.m.ZM());
        if (!z) {
            ac.r("obj_type", aae());
        } else {
            if (Np.aao > 0) {
                ac.r("midpageflag", 1);
            } else {
                ac.r("midpageflag", 0);
            }
            ac.ac("ab_tag", aac());
        }
        if (Np.sL() != null && Np.sL().aEt() != null && Np.sL().aEt().II() != null && Np.sL().aEt().II().size() > 0) {
            ac.r("obj_to", Np.sL().gpQ ? 2 : 1);
        }
        return ac;
    }

    public ak P(String str, int i) {
        bh Np = Np();
        if (Np == null) {
            return null;
        }
        ak ac = new ak(str).ac(ImageViewerConfig.FORUM_ID, String.valueOf(Np.getFid())).ac("tid", String.valueOf(Np.getTid())).r("obj_id", z(Np)).r("obj_param2", 1).ac("obj_param1", getWeight()).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", aaa()).ac("obj_name", aac()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ac("obj_param3", com.baidu.tieba.card.m.ZM());
        if (i == 0) {
            ac.r("obj_type", aae());
        } else {
            ac.r("obj_type", i);
        }
        ac.ac("obj_id", getExtra());
        return ac;
    }

    private int aae() {
        int i;
        int i2 = 0;
        bh Np = Np();
        if (Np == null) {
            return 0;
        }
        ArrayList<MediaData> rE = Np.rE();
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
        bh Np = Np();
        if (Np != null) {
            return Np.getImages();
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
