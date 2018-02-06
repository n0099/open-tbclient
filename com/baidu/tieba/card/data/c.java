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
    private String cZN;
    private int cZO;
    private String cZP;
    private String cZQ;
    private String cZS;
    private String mSource;
    public String tid;
    public int cZR = 0;
    public SparseArray<String> aNr = null;

    public void setWeight(String str) {
        this.cZN = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void lD(int i) {
        this.cZO = i;
    }

    public void kv(String str) {
        this.cZP = str;
    }

    public int alB() {
        return this.cZO;
    }

    public String alC() {
        return this.mSource + "#" + this.cZO + "#" + this.cZP;
    }

    public String getWeight() {
        return this.cZN;
    }

    public String getSource() {
        return this.mSource;
    }

    public String alD() {
        return this.cZP;
    }

    public String alE() {
        return this.cZQ;
    }

    public void kw(String str) {
        this.cZQ = str;
    }

    public bd WE() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void setExtra(String str) {
        this.cZS = str;
    }

    public String getExtra() {
        return this.cZS;
    }

    public ak kx(String str) {
        return s(str, false);
    }

    public ak s(String str, boolean z) {
        bd WE = WE();
        if (WE == null) {
            return null;
        }
        ak ab = new ak(str).ab(ImageViewerConfig.FORUM_ID, String.valueOf(WE.getFid())).ab("tid", String.valueOf(WE.getTid())).ab("obj_id", getExtra()).ab("obj_param1", getWeight()).s("obj_param2", 1).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).s("obj_locate", alB()).ab("uid", TbadkCoreApplication.getCurrentAccount()).ab("obj_param3", com.baidu.tieba.card.j.alg());
        if (!z) {
            ab.s("obj_type", alF());
        } else {
            if (WE.aQu > 0) {
                ab.s("midpageflag", 1);
            } else {
                ab.s("midpageflag", 0);
            }
            ab.ab("ab_tag", alD());
        }
        if (WE.AA() != null && WE.AA().bwX() != null && WE.AA().bwX().Ri() != null && WE.AA().bwX().Ri().size() > 0) {
            ab.s("obj_to", WE.AA().hbv ? 2 : 1);
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
