package com.baidu.tieba.card.data;

import android.util.SparseArray;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ak;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class c extends b implements ae {
    private String cdi;
    private int cdj;
    private String cdk;
    private String cdl;
    private String cdn;
    private String mSource;
    public String tid;
    public int cdm = 0;
    public SparseArray<String> XE = null;

    public void setWeight(String str) {
        this.cdi = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void iE(int i) {
        this.cdj = i;
    }

    public void jU(String str) {
        this.cdk = str;
    }

    public int abV() {
        return this.cdj;
    }

    public String abW() {
        return this.mSource + "#" + this.cdj + "#" + this.cdk;
    }

    public String getWeight() {
        return this.cdi;
    }

    public String getSource() {
        return this.mSource;
    }

    public String abX() {
        return this.cdk;
    }

    public String abY() {
        return this.cdl;
    }

    public void jV(String str) {
        this.cdl = str;
    }

    public bd Ox() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void setExtra(String str) {
        this.cdn = str;
    }

    public String getExtra() {
        return this.cdn;
    }

    public ak jW(String str) {
        return t(str, false);
    }

    public ak t(String str, boolean z) {
        bd Ox = Ox();
        if (Ox == null) {
            return null;
        }
        ak ac = new ak(str).ac(ImageViewerConfig.FORUM_ID, String.valueOf(Ox.getFid())).ac("tid", String.valueOf(Ox.getTid())).ac("obj_id", getExtra()).ac("obj_param1", getWeight()).r("obj_param2", 1).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", abV()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ac("obj_param3", com.baidu.tieba.card.k.abH());
        if (!z) {
            ac.r("obj_type", abZ());
        } else {
            if (Ox.aaG > 0) {
                ac.r("midpageflag", 1);
            } else {
                ac.r("midpageflag", 0);
            }
            ac.ac("ab_tag", abX());
        }
        if (Ox.sO() != null && Ox.sO().bwr() != null && Ox.sO().bwr().Jq() != null && Ox.sO().bwr().Jq().size() > 0) {
            ac.r("obj_to", Ox.sO().gzM ? 2 : 1);
        }
        return ac;
    }

    public ak R(String str, int i) {
        bd Ox = Ox();
        if (Ox == null) {
            return null;
        }
        ak ac = new ak(str).ac(ImageViewerConfig.FORUM_ID, String.valueOf(Ox.getFid())).ac("tid", String.valueOf(Ox.getTid())).r("obj_id", C(Ox)).r("obj_param2", 1).ac("obj_param1", getWeight()).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", abV()).ac("obj_name", abX()).ac(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ac("obj_param3", com.baidu.tieba.card.k.abH());
        if (i == 0) {
            ac.r("obj_type", abZ());
        } else {
            ac.r("obj_type", i);
        }
        ac.ac("obj_id", getExtra());
        return ac;
    }

    private int abZ() {
        int i;
        int i2 = 0;
        bd Ox = Ox();
        if (Ox == null) {
            return 0;
        }
        ArrayList<MediaData> rI = Ox.rI();
        if (rI == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = rI.iterator();
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
        bd Ox = Ox();
        if (Ox != null) {
            return Ox.getImages();
        }
        return null;
    }

    private int C(bd bdVar) {
        if (bdVar.sC() == null || bdVar.sC().channelId <= 0) {
            return 0;
        }
        return (int) bdVar.sC().channelId;
    }
}
