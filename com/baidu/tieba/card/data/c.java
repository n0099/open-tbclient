package com.baidu.tieba.card.data;

import android.util.SparseArray;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.al;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class c extends b implements ae {
    private String csI;
    private int csJ;
    private String csK;
    private String csL;
    private String mExtra;
    private String mSource;
    public String tid;
    public int csM = 0;
    public SparseArray<String> YI = null;
    private Integer csN = 0;

    public void setWeight(String str) {
        this.csI = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void iM(int i) {
        this.csJ = i;
    }

    public void kB(String str) {
        this.csK = str;
    }

    public int afI() {
        return this.csJ;
    }

    public String afJ() {
        return this.mSource + "#" + this.csJ + "#" + this.csK;
    }

    public String getWeight() {
        return this.csI;
    }

    public String getSource() {
        return this.mSource;
    }

    public String afK() {
        return this.csK;
    }

    public String afL() {
        return this.csL;
    }

    public void kC(String str) {
        this.csL = str;
    }

    public bd Pb() {
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

    public Integer afM() {
        return this.csN;
    }

    public void c(Integer num) {
        this.csN = num;
    }

    public al kD(String str) {
        return p(str, false);
    }

    public al p(String str, boolean z) {
        bd Pb = Pb();
        if (Pb == null) {
            return null;
        }
        al ac = new al(str).ac(ImageViewerConfig.FORUM_ID, String.valueOf(Pb.getFid())).ac("tid", String.valueOf(Pb.getTid())).ac(VideoPlayActivityConfig.OBJ_ID, getExtra()).ac("obj_param1", getWeight()).r("obj_param2", 1).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", afI()).ac("uid", TbadkCoreApplication.getCurrentAccount()).ac("obj_param3", com.baidu.tieba.card.o.afp());
        if (!z) {
            ac.r("obj_type", afN());
        } else {
            if (Pb.abK > 0) {
                ac.r("midpageflag", 1);
            } else {
                ac.r("midpageflag", 0);
            }
            ac.ac("ab_tag", afK());
            ac.r("is_vertical", afM().intValue());
        }
        if (Pb.tb() != null && Pb.tb().brZ() != null && Pb.tb().brZ().JH() != null && Pb.tb().brZ().JH().size() > 0) {
            ac.r("obj_to", Pb.tb().gyb ? 2 : 1);
        }
        return ac;
    }

    public al U(String str, int i) {
        bd Pb = Pb();
        if (Pb == null) {
            return null;
        }
        al ac = new al(str).ac(ImageViewerConfig.FORUM_ID, String.valueOf(Pb.getFid())).ac("tid", String.valueOf(Pb.getTid())).r(VideoPlayActivityConfig.OBJ_ID, M(Pb)).r("obj_param2", 1).ac("obj_param1", getWeight()).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", afI()).ac("obj_name", afK()).ac("uid", TbadkCoreApplication.getCurrentAccount()).ac("obj_param3", com.baidu.tieba.card.o.afp());
        if (i == 0) {
            ac.r("obj_type", afN());
        } else {
            ac.r("obj_type", i);
        }
        ac.ac(VideoPlayActivityConfig.OBJ_ID, getExtra());
        return ac;
    }

    private int afN() {
        int i;
        int i2 = 0;
        bd Pb = Pb();
        if (Pb == null) {
            return 0;
        }
        ArrayList<MediaData> rZ = Pb.rZ();
        if (rZ == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = rZ.iterator();
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
        bd Pb = Pb();
        if (Pb != null) {
            return Pb.getImages();
        }
        return null;
    }

    private int M(bd bdVar) {
        if (bdVar.sP() == null || bdVar.sP().channelId <= 0) {
            return 0;
        }
        return (int) bdVar.sP().channelId;
    }
}
