package com.baidu.tieba.card.data;

import android.util.SparseArray;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.am;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class c extends b implements ae {
    private String dbk;
    private int dbl;
    private String dbm;
    private String dbn;
    public int dbq;
    private String mExtra;
    private String mSource;
    public String tid;
    public int aFT = 1;
    public int dbo = 0;
    public SparseArray<String> asF = null;
    private Integer dbp = 0;

    public void setWeight(String str) {
        this.dbk = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void kP(int i) {
        this.dbl = i;
    }

    public void mZ(String str) {
        this.dbm = str;
    }

    public int aqZ() {
        return this.dbl;
    }

    public String ara() {
        return this.mSource + "#" + this.dbl + "#" + this.dbm;
    }

    public String getWeight() {
        return this.dbk;
    }

    public String getSource() {
        return this.mSource;
    }

    public String arb() {
        return this.dbm;
    }

    public String arc() {
        return this.dbn;
    }

    public void na(String str) {
        this.dbn = str;
    }

    public bb aaq() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void setExtra(String str) {
        this.mExtra = str;
    }

    public String getExtra() {
        return this.mExtra;
    }

    public Integer ard() {
        return this.dbp;
    }

    public void c(Integer num) {
        this.dbp = num;
    }

    public am nb(String str) {
        return y(str, false);
    }

    public am y(String str, boolean z) {
        bb aaq = aaq();
        if (aaq == null) {
            return null;
        }
        am aB = new am(str).aB(ImageViewerConfig.FORUM_ID, String.valueOf(aaq.getFid())).aB("tid", String.valueOf(aaq.getTid())).aB(VideoPlayActivityConfig.OBJ_ID, getExtra()).aB("obj_param1", getWeight()).y("obj_param2", 1).aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).y("obj_locate", aqZ()).aB("uid", TbadkCoreApplication.getCurrentAccount()).aB("obj_param3", com.baidu.tieba.card.o.aqG());
        if (!z) {
            aB.y("obj_type", are());
        } else {
            if (aaq.avU > 0) {
                aB.y("midpageflag", 1);
            } else {
                aB.y("midpageflag", 0);
            }
            aB.aB("ab_tag", arb());
            aB.y("is_vertical", ard().intValue());
        }
        if (aaq.Bk() != null && aaq.Bk().bEU() != null && aaq.Bk().bEU().Sx() != null && aaq.Bk().bEU().Sx().size() > 0) {
            aB.y("obj_to", aaq.Bk().hqj ? 2 : 1);
        }
        return aB;
    }

    public am ab(String str, int i) {
        bb aaq = aaq();
        if (aaq == null) {
            return null;
        }
        am aB = new am(str).aB(ImageViewerConfig.FORUM_ID, String.valueOf(aaq.getFid())).aB("tid", String.valueOf(aaq.getTid())).y(VideoPlayActivityConfig.OBJ_ID, R(aaq)).y("obj_param2", 1).aB("obj_param1", getWeight()).aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).y("obj_locate", aqZ()).aB("obj_name", arb()).aB("uid", TbadkCoreApplication.getCurrentAccount()).aB("obj_param3", com.baidu.tieba.card.o.aqG());
        if (i == 0) {
            aB.y("obj_type", are());
        } else {
            aB.y("obj_type", i);
        }
        aB.aB(VideoPlayActivityConfig.OBJ_ID, getExtra());
        return aB;
    }

    private int are() {
        int i;
        int i2 = 0;
        bb aaq = aaq();
        if (aaq == null) {
            return 0;
        }
        ArrayList<MediaData> Ae = aaq.Ae();
        if (Ae == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = Ae.iterator();
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
        bb aaq = aaq();
        if (aaq != null) {
            return aaq.getImages();
        }
        return null;
    }

    private int R(bb bbVar) {
        if (bbVar.AW() == null || bbVar.AW().channelId <= 0) {
            return 0;
        }
        return (int) bbVar.AW().channelId;
    }

    public void kQ(int i) {
        this.dbq = i;
    }

    public boolean arf() {
        return this.dbq == 1;
    }
}
