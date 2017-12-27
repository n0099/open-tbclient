package com.baidu.tieba.card.data;

import android.util.SparseArray;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ak;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class c extends b implements ae {
    private String cSd;
    private int cSe;
    private String cSf;
    private String cSg;
    private String cSi;
    private String mSource;
    public String tid;
    public int cSh = 0;
    public SparseArray<String> aLZ = null;

    public void setWeight(String str) {
        this.cSd = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void lE(int i) {
        this.cSe = i;
    }

    public void jX(String str) {
        this.cSf = str;
    }

    public int ajK() {
        return this.cSe;
    }

    public String ajL() {
        return this.mSource + "#" + this.cSe + "#" + this.cSf;
    }

    public String getWeight() {
        return this.cSd;
    }

    public String getSource() {
        return this.mSource;
    }

    public String ajM() {
        return this.cSf;
    }

    public String ajN() {
        return this.cSg;
    }

    public void jY(String str) {
        this.cSg = str;
    }

    public be VW() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void jZ(String str) {
        this.cSi = str;
    }

    public String getExtra() {
        return this.cSi;
    }

    public ak ka(String str) {
        return t(str, false);
    }

    public ak t(String str, boolean z) {
        be VW = VW();
        if (VW == null) {
            return null;
        }
        ak ab = new ak(str).ab(ImageViewerConfig.FORUM_ID, String.valueOf(VW.getFid())).ab("tid", String.valueOf(VW.getTid())).ab("obj_id", getExtra()).ab("obj_param1", getWeight()).s("obj_param2", 1).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).s("obj_locate", ajK()).ab("uid", TbadkCoreApplication.getCurrentAccount()).ab("obj_param3", com.baidu.tieba.card.k.ajp());
        if (!z) {
            ab.s("obj_type", ajO());
        } else {
            if (VW.aOZ > 0) {
                ab.s("midpageflag", 1);
            } else {
                ab.s("midpageflag", 0);
            }
            ab.ab("ab_tag", ajM());
        }
        if (VW.Ao() != null && VW.Ao().bCo() != null && VW.Ao().bCo().QN() != null && VW.Ao().bCo().QN().size() > 0) {
            ab.s("obj_to", VW.Ao().hjn ? 2 : 1);
        }
        return ab;
    }

    public ak U(String str, int i) {
        be VW = VW();
        if (VW == null) {
            return null;
        }
        ak ab = new ak(str).ab(ImageViewerConfig.FORUM_ID, String.valueOf(VW.getFid())).ab("tid", String.valueOf(VW.getTid())).s("obj_id", I(VW)).s("obj_param2", 1).ab("obj_param1", getWeight()).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).s("obj_locate", ajK()).ab("obj_name", ajM()).ab("uid", TbadkCoreApplication.getCurrentAccount()).ab("obj_param3", com.baidu.tieba.card.k.ajp());
        if (i == 0) {
            ab.s("obj_type", ajO());
        } else {
            ab.s("obj_type", i);
        }
        ab.ab("obj_id", getExtra());
        return ab;
    }

    private int ajO() {
        int i;
        int i2 = 0;
        be VW = VW();
        if (VW == null) {
            return 0;
        }
        ArrayList<MediaData> zi = VW.zi();
        if (zi == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = zi.iterator();
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
        be VW = VW();
        if (VW != null) {
            return VW.getImages();
        }
        return null;
    }

    private int I(be beVar) {
        if (beVar.Ac() == null || beVar.Ac().channelId <= 0) {
            return 0;
        }
        return (int) beVar.Ac().channelId;
    }
}
