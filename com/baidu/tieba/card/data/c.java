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
    private String cZE;
    private int cZF;
    private String cZG;
    private String cZH;
    private String cZJ;
    private String mSource;
    public String tid;
    public int cZI = 0;
    public SparseArray<String> aNh = null;

    public void setWeight(String str) {
        this.cZE = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void lD(int i) {
        this.cZF = i;
    }

    public void kv(String str) {
        this.cZG = str;
    }

    public int alB() {
        return this.cZF;
    }

    public String alC() {
        return this.mSource + "#" + this.cZF + "#" + this.cZG;
    }

    public String getWeight() {
        return this.cZE;
    }

    public String getSource() {
        return this.mSource;
    }

    public String alD() {
        return this.cZG;
    }

    public String alE() {
        return this.cZH;
    }

    public void kw(String str) {
        this.cZH = str;
    }

    public bd WE() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void setExtra(String str) {
        this.cZJ = str;
    }

    public String getExtra() {
        return this.cZJ;
    }

    public ak kx(String str) {
        return r(str, false);
    }

    public ak r(String str, boolean z) {
        bd WE = WE();
        if (WE == null) {
            return null;
        }
        ak ab = new ak(str).ab(ImageViewerConfig.FORUM_ID, String.valueOf(WE.getFid())).ab("tid", String.valueOf(WE.getTid())).ab("obj_id", getExtra()).ab("obj_param1", getWeight()).s("obj_param2", 1).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).s("obj_locate", alB()).ab("uid", TbadkCoreApplication.getCurrentAccount()).ab("obj_param3", com.baidu.tieba.card.j.alg());
        if (!z) {
            ab.s("obj_type", alF());
        } else {
            if (WE.aQk > 0) {
                ab.s("midpageflag", 1);
            } else {
                ab.s("midpageflag", 0);
            }
            ab.ab("ab_tag", alD());
        }
        if (WE.AA() != null && WE.AA().bxb() != null && WE.AA().bxb().Ri() != null && WE.AA().bxb().Ri().size() > 0) {
            ab.s("obj_to", WE.AA().hbE ? 2 : 1);
        }
        return ab;
    }

    public ak U(String str, int i) {
        bd WE = WE();
        if (WE == null) {
            return null;
        }
        ak ab = new ak(str).ab(ImageViewerConfig.FORUM_ID, String.valueOf(WE.getFid())).ab("tid", String.valueOf(WE.getTid())).s("obj_id", L(WE)).s("obj_param2", 1).ab("obj_param1", getWeight()).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).s("obj_locate", alB()).ab("obj_name", alD()).ab("uid", TbadkCoreApplication.getCurrentAccount()).ab("obj_param3", com.baidu.tieba.card.j.alg());
        if (i == 0) {
            ab.s("obj_type", alF());
        } else {
            ab.s("obj_type", i);
        }
        ab.ab("obj_id", getExtra());
        return ab;
    }

    private int alF() {
        int i;
        int i2 = 0;
        bd WE = WE();
        if (WE == null) {
            return 0;
        }
        ArrayList<MediaData> zy = WE.zy();
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
        bd WE = WE();
        if (WE != null) {
            return WE.getImages();
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
