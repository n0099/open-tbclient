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
    private String cZB;
    private int cZC;
    private String cZD;
    private String cZE;
    private String cZG;
    private String mSource;
    public String tid;
    public int cZF = 0;
    public SparseArray<String> aNg = null;

    public void setWeight(String str) {
        this.cZB = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void lD(int i) {
        this.cZC = i;
    }

    public void kv(String str) {
        this.cZD = str;
    }

    public int alA() {
        return this.cZC;
    }

    public String alB() {
        return this.mSource + "#" + this.cZC + "#" + this.cZD;
    }

    public String getWeight() {
        return this.cZB;
    }

    public String getSource() {
        return this.mSource;
    }

    public String alC() {
        return this.cZD;
    }

    public String alD() {
        return this.cZE;
    }

    public void kw(String str) {
        this.cZE = str;
    }

    public bd WD() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void setExtra(String str) {
        this.cZG = str;
    }

    public String getExtra() {
        return this.cZG;
    }

    public ak kx(String str) {
        return r(str, false);
    }

    public ak r(String str, boolean z) {
        bd WD = WD();
        if (WD == null) {
            return null;
        }
        ak ab = new ak(str).ab(ImageViewerConfig.FORUM_ID, String.valueOf(WD.getFid())).ab("tid", String.valueOf(WD.getTid())).ab("obj_id", getExtra()).ab("obj_param1", getWeight()).s("obj_param2", 1).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).s("obj_locate", alA()).ab("uid", TbadkCoreApplication.getCurrentAccount()).ab("obj_param3", com.baidu.tieba.card.j.alf());
        if (!z) {
            ab.s("obj_type", alE());
        } else {
            if (WD.aQj > 0) {
                ab.s("midpageflag", 1);
            } else {
                ab.s("midpageflag", 0);
            }
            ab.ab("ab_tag", alC());
        }
        if (WD.AA() != null && WD.AA().bwW() != null && WD.AA().bwW().Rh() != null && WD.AA().bwW().Rh().size() > 0) {
            ab.s("obj_to", WD.AA().hbg ? 2 : 1);
        }
        return ab;
    }

    public ak U(String str, int i) {
        bd WD = WD();
        if (WD == null) {
            return null;
        }
        ak ab = new ak(str).ab(ImageViewerConfig.FORUM_ID, String.valueOf(WD.getFid())).ab("tid", String.valueOf(WD.getTid())).s("obj_id", L(WD)).s("obj_param2", 1).ab("obj_param1", getWeight()).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).s("obj_locate", alA()).ab("obj_name", alC()).ab("uid", TbadkCoreApplication.getCurrentAccount()).ab("obj_param3", com.baidu.tieba.card.j.alf());
        if (i == 0) {
            ab.s("obj_type", alE());
        } else {
            ab.s("obj_type", i);
        }
        ab.ab("obj_id", getExtra());
        return ab;
    }

    private int alE() {
        int i;
        int i2 = 0;
        bd WD = WD();
        if (WD == null) {
            return 0;
        }
        ArrayList<MediaData> zy = WD.zy();
        if (zy == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = zy.iterator();
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
        bd WD = WD();
        if (WD != null) {
            return WD.getImages();
        }
        return null;
    }

    private int L(bd bdVar) {
        if (bdVar.Ao() == null || bdVar.Ao().channelId <= 0) {
            return 0;
        }
        return (int) bdVar.Ao().channelId;
    }
}
