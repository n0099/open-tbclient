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
    private int crA;
    private String crB;
    private String crC;
    private String crz;
    private String mExtra;
    private String mSource;
    public String tid;
    public int crD = 0;
    public SparseArray<String> YI = null;
    private Integer crE = 0;

    public void setWeight(String str) {
        this.crz = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void iN(int i) {
        this.crA = i;
    }

    public void ky(String str) {
        this.crB = str;
    }

    public int afI() {
        return this.crA;
    }

    public String afJ() {
        return this.mSource + "#" + this.crA + "#" + this.crB;
    }

    public String getWeight() {
        return this.crz;
    }

    public String getSource() {
        return this.mSource;
    }

    public String afK() {
        return this.crB;
    }

    public String afL() {
        return this.crC;
    }

    public void kz(String str) {
        this.crC = str;
    }

    public bd Pe() {
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
        return this.crE;
    }

    public void c(Integer num) {
        this.crE = num;
    }

    public al kA(String str) {
        return p(str, false);
    }

    public al p(String str, boolean z) {
        bd Pe = Pe();
        if (Pe == null) {
            return null;
        }
        al ac = new al(str).ac(ImageViewerConfig.FORUM_ID, String.valueOf(Pe.getFid())).ac("tid", String.valueOf(Pe.getTid())).ac(VideoPlayActivityConfig.OBJ_ID, getExtra()).ac("obj_param1", getWeight()).r("obj_param2", 1).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", afI()).ac("uid", TbadkCoreApplication.getCurrentAccount()).ac("obj_param3", com.baidu.tieba.card.o.afp());
        if (!z) {
            ac.r("obj_type", afN());
        } else {
            if (Pe.abJ > 0) {
                ac.r("midpageflag", 1);
            } else {
                ac.r("midpageflag", 0);
            }
            ac.ac("ab_tag", afK());
            ac.r("is_vertical", afM().intValue());
        }
        if (Pe.tc() != null && Pe.tc().bsb() != null && Pe.tc().bsb().JJ() != null && Pe.tc().bsb().JJ().size() > 0) {
            ac.r("obj_to", Pe.tc().gwX ? 2 : 1);
        }
        return ac;
    }

    public al U(String str, int i) {
        bd Pe = Pe();
        if (Pe == null) {
            return null;
        }
        al ac = new al(str).ac(ImageViewerConfig.FORUM_ID, String.valueOf(Pe.getFid())).ac("tid", String.valueOf(Pe.getTid())).r(VideoPlayActivityConfig.OBJ_ID, M(Pe)).r("obj_param2", 1).ac("obj_param1", getWeight()).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", afI()).ac("obj_name", afK()).ac("uid", TbadkCoreApplication.getCurrentAccount()).ac("obj_param3", com.baidu.tieba.card.o.afp());
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
        bd Pe = Pe();
        if (Pe == null) {
            return 0;
        }
        ArrayList<MediaData> sa = Pe.sa();
        if (sa == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = sa.iterator();
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
        bd Pe = Pe();
        if (Pe != null) {
            return Pe.getImages();
        }
        return null;
    }

    private int M(bd bdVar) {
        if (bdVar.sQ() == null || bdVar.sQ().channelId <= 0) {
            return 0;
        }
        return (int) bdVar.sQ().channelId;
    }
}
