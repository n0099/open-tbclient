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
    private String cWF;
    private int cWG;
    private String cWH;
    private String cWI;
    private String cWK;
    private String mSource;
    public String tid;
    public int cWJ = 0;
    public SparseArray<String> aLV = null;

    public void setWeight(String str) {
        this.cWF = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void lH(int i) {
        this.cWG = i;
    }

    public void kg(String str) {
        this.cWH = str;
    }

    public int akN() {
        return this.cWG;
    }

    public String akO() {
        return this.mSource + "#" + this.cWG + "#" + this.cWH;
    }

    public String getWeight() {
        return this.cWF;
    }

    public String getSource() {
        return this.mSource;
    }

    public String akP() {
        return this.cWH;
    }

    public String akQ() {
        return this.cWI;
    }

    public void kh(String str) {
        this.cWI = str;
    }

    public bd VK() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void setExtra(String str) {
        this.cWK = str;
    }

    public String getExtra() {
        return this.cWK;
    }

    public ak ki(String str) {
        return t(str, false);
    }

    public ak t(String str, boolean z) {
        bd VK = VK();
        if (VK == null) {
            return null;
        }
        ak ab = new ak(str).ab(ImageViewerConfig.FORUM_ID, String.valueOf(VK.getFid())).ab("tid", String.valueOf(VK.getTid())).ab("obj_id", getExtra()).ab("obj_param1", getWeight()).s("obj_param2", 1).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).s("obj_locate", akN()).ab("uid", TbadkCoreApplication.getCurrentAccount()).ab("obj_param3", com.baidu.tieba.card.k.aks());
        if (!z) {
            ab.s("obj_type", akR());
        } else {
            if (VK.aOX > 0) {
                ab.s("midpageflag", 1);
            } else {
                ab.s("midpageflag", 0);
            }
            ab.ab("ab_tag", akP());
        }
        if (VK.Ag() != null && VK.Ag().bvK() != null && VK.Ag().bvK().QB() != null && VK.Ag().bvK().QB().size() > 0) {
            ab.s("obj_to", VK.Ag().gYN ? 2 : 1);
        }
        return ab;
    }

    public ak W(String str, int i) {
        bd VK = VK();
        if (VK == null) {
            return null;
        }
        ak ab = new ak(str).ab(ImageViewerConfig.FORUM_ID, String.valueOf(VK.getFid())).ab("tid", String.valueOf(VK.getTid())).s("obj_id", I(VK)).s("obj_param2", 1).ab("obj_param1", getWeight()).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).s("obj_locate", akN()).ab("obj_name", akP()).ab("uid", TbadkCoreApplication.getCurrentAccount()).ab("obj_param3", com.baidu.tieba.card.k.aks());
        if (i == 0) {
            ab.s("obj_type", akR());
        } else {
            ab.s("obj_type", i);
        }
        ab.ab("obj_id", getExtra());
        return ab;
    }

    private int akR() {
        int i;
        int i2 = 0;
        bd VK = VK();
        if (VK == null) {
            return 0;
        }
        ArrayList<MediaData> zd = VK.zd();
        if (zd == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = zd.iterator();
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
        bd VK = VK();
        if (VK != null) {
            return VK.getImages();
        }
        return null;
    }

    private int I(bd bdVar) {
        if (bdVar.zU() == null || bdVar.zU().channelId <= 0) {
            return 0;
        }
        return (int) bdVar.zU().channelId;
    }
}
