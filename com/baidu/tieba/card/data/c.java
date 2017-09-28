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
    public String Xf;
    private String bNj;
    private int bNk;
    private String bNl;
    private String bNm;
    private String bNo;
    private String mSource;
    public int bNn = 0;
    public SparseArray<String> Xg = null;

    public void setWeight(String str) {
        this.bNj = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void hR(int i) {
        this.bNk = i;
    }

    public void jr(String str) {
        this.bNl = str;
    }

    public int XU() {
        return this.bNk;
    }

    public String XV() {
        return this.mSource + "#" + this.bNk + "#" + this.bNl;
    }

    public String getWeight() {
        return this.bNj;
    }

    public String getSource() {
        return this.mSource;
    }

    public String XW() {
        return this.bNl;
    }

    public String XX() {
        return this.bNm;
    }

    public void js(String str) {
        this.bNm = str;
    }

    public bh Nj() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void setExtra(String str) {
        this.bNo = str;
    }

    public String getExtra() {
        return this.bNo;
    }

    public ak jt(String str) {
        return u(str, false);
    }

    public ak u(String str, boolean z) {
        bh Nj = Nj();
        if (Nj == null) {
            return null;
        }
        ak ad = new ak(str).ad("fid", String.valueOf(Nj.getFid())).ad("tid", String.valueOf(Nj.getTid())).ad("obj_id", getExtra()).ad("obj_param1", getWeight()).r("obj_param2", 1).ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", XU()).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ad("obj_param3", com.baidu.tieba.card.m.XG());
        if (!z) {
            ad.r("obj_type", XY());
        } else {
            ad.ad("ab_tag", XW());
        }
        if (Nj.sL() != null && Nj.sL().aCd() != null && Nj.sL().aCd().ID() != null && Nj.sL().aCd().ID().size() > 0) {
            ad.r("obj_to", Nj.sL().ghu ? 2 : 1);
        }
        return ad;
    }

    public ak J(String str, int i) {
        bh Nj = Nj();
        if (Nj == null) {
            return null;
        }
        ak ad = new ak(str).ad("fid", String.valueOf(Nj.getFid())).ad("tid", String.valueOf(Nj.getTid())).r("obj_id", z(Nj)).r("obj_param2", 1).ad("obj_param1", getWeight()).ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", XU()).ad("obj_name", XW()).ad(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()).ad("obj_param3", com.baidu.tieba.card.m.XG());
        if (i == 0) {
            ad.r("obj_type", XY());
        } else {
            ad.r("obj_type", i);
        }
        ad.ad("obj_id", getExtra());
        return ad;
    }

    private int XY() {
        int i;
        int i2 = 0;
        bh Nj = Nj();
        if (Nj == null) {
            return 0;
        }
        ArrayList<MediaData> rF = Nj.rF();
        if (rF == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = rF.iterator();
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
        bh Nj = Nj();
        if (Nj != null) {
            return Nj.getImages();
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
