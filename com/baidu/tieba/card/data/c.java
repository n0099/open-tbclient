package com.baidu.tieba.card.data;

import android.util.SparseArray;
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
    private String cdB;
    private String cdw;
    private int cdx;
    private String cdy;
    private String cdz;
    private String mSource;
    public String tid;
    public int cdA = 0;
    public SparseArray<String> Xy = null;

    public void setWeight(String str) {
        this.cdw = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void iG(int i) {
        this.cdx = i;
    }

    public void jS(String str) {
        this.cdy = str;
    }

    public int ace() {
        return this.cdx;
    }

    public String acf() {
        return this.mSource + "#" + this.cdx + "#" + this.cdy;
    }

    public String getWeight() {
        return this.cdw;
    }

    public String getSource() {
        return this.mSource;
    }

    public String acg() {
        return this.cdy;
    }

    public String ach() {
        return this.cdz;
    }

    public void jT(String str) {
        this.cdz = str;
    }

    public bd Ox() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void setExtra(String str) {
        this.cdB = str;
    }

    public String getExtra() {
        return this.cdB;
    }

    public ak jU(String str) {
        return u(str, false);
    }

    public ak u(String str, boolean z) {
        bd Ox = Ox();
        if (Ox == null) {
            return null;
        }
        ak ac = new ak(str).ac(ImageViewerConfig.FORUM_ID, String.valueOf(Ox.getFid())).ac("tid", String.valueOf(Ox.getTid())).ac("obj_id", getExtra()).ac("obj_param1", getWeight()).r("obj_param2", 1).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", ace()).ac("uid", TbadkCoreApplication.getCurrentAccount()).ac("obj_param3", com.baidu.tieba.card.k.abJ());
        if (!z) {
            ac.r("obj_type", aci());
        } else {
            if (Ox.aaA > 0) {
                ac.r("midpageflag", 1);
            } else {
                ac.r("midpageflag", 0);
            }
            ac.ac("ab_tag", acg());
        }
        if (Ox.sM() != null && Ox.sM().bwX() != null && Ox.sM().bwX().Jr() != null && Ox.sM().bwX().Jr().size() > 0) {
            ac.r("obj_to", Ox.sM().gCv ? 2 : 1);
        }
        return ac;
    }

    public ak S(String str, int i) {
        bd Ox = Ox();
        if (Ox == null) {
            return null;
        }
        ak ac = new ak(str).ac(ImageViewerConfig.FORUM_ID, String.valueOf(Ox.getFid())).ac("tid", String.valueOf(Ox.getTid())).r("obj_id", E(Ox)).r("obj_param2", 1).ac("obj_param1", getWeight()).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", ace()).ac("obj_name", acg()).ac("uid", TbadkCoreApplication.getCurrentAccount()).ac("obj_param3", com.baidu.tieba.card.k.abJ());
        if (i == 0) {
            ac.r("obj_type", aci());
        } else {
            ac.r("obj_type", i);
        }
        ac.ac("obj_id", getExtra());
        return ac;
    }

    private int aci() {
        int i;
        int i2 = 0;
        bd Ox = Ox();
        if (Ox == null) {
            return 0;
        }
        ArrayList<MediaData> rG = Ox.rG();
        if (rG == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = rG.iterator();
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

    private int E(bd bdVar) {
        if (bdVar.sA() == null || bdVar.sA().channelId <= 0) {
            return 0;
        }
        return (int) bdVar.sA().channelId;
    }
}
