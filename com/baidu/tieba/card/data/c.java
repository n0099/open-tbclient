package com.baidu.tieba.card.data;

import android.util.SparseArray;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.am;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class c extends b implements af {
    private String cBl;
    private int cBm;
    private String cBn;
    private String cBo;
    public int cBs;
    private String mExtra;
    private String mSource;
    public String tid;
    public int cBp = 1;
    public int cBq = 0;
    public SparseArray<String> agK = null;
    private Integer cBr = 0;

    public void setWeight(String str) {
        this.cBl = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void iN(int i) {
        this.cBm = i;
    }

    public void le(String str) {
        this.cBn = str;
    }

    public int ajp() {
        return this.cBm;
    }

    public String ajq() {
        return this.mSource + "#" + this.cBm + "#" + this.cBn;
    }

    public String getWeight() {
        return this.cBl;
    }

    public String getSource() {
        return this.mSource;
    }

    public String ajr() {
        return this.cBn;
    }

    public String ajs() {
        return this.cBo;
    }

    public void lf(String str) {
        this.cBo = str;
    }

    public bd Sz() {
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

    public Integer ajt() {
        return this.cBr;
    }

    public void c(Integer num) {
        this.cBr = num;
    }

    public am lg(String str) {
        return p(str, false);
    }

    public am p(String str, boolean z) {
        bd Sz = Sz();
        if (Sz == null) {
            return null;
        }
        am ah = new am(str).ah(ImageViewerConfig.FORUM_ID, String.valueOf(Sz.getFid())).ah("tid", String.valueOf(Sz.getTid())).ah(VideoPlayActivityConfig.OBJ_ID, getExtra()).ah("obj_param1", getWeight()).r("obj_param2", 1).ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", ajp()).ah("uid", TbadkCoreApplication.getCurrentAccount()).ah("obj_param3", com.baidu.tieba.card.o.aiY());
        if (!z) {
            ah.r("obj_type", aju());
        } else {
            if (Sz.ajN > 0) {
                ah.r("midpageflag", 1);
            } else {
                ah.r("midpageflag", 0);
            }
            ah.ah("ab_tag", ajr());
            ah.r("is_vertical", ajt().intValue());
        }
        if (Sz.wy() != null && Sz.wy().bxb() != null && Sz.wy().bxb().Ng() != null && Sz.wy().bxb().Ng().size() > 0) {
            ah.r("obj_to", Sz.wy().gJA ? 2 : 1);
        }
        return ah;
    }

    public am W(String str, int i) {
        bd Sz = Sz();
        if (Sz == null) {
            return null;
        }
        am ah = new am(str).ah(ImageViewerConfig.FORUM_ID, String.valueOf(Sz.getFid())).ah("tid", String.valueOf(Sz.getTid())).r(VideoPlayActivityConfig.OBJ_ID, M(Sz)).r("obj_param2", 1).ah("obj_param1", getWeight()).ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", ajp()).ah("obj_name", ajr()).ah("uid", TbadkCoreApplication.getCurrentAccount()).ah("obj_param3", com.baidu.tieba.card.o.aiY());
        if (i == 0) {
            ah.r("obj_type", aju());
        } else {
            ah.r("obj_type", i);
        }
        ah.ah(VideoPlayActivityConfig.OBJ_ID, getExtra());
        return ah;
    }

    private int aju() {
        int i;
        int i2 = 0;
        bd Sz = Sz();
        if (Sz == null) {
            return 0;
        }
        ArrayList<MediaData> vw = Sz.vw();
        if (vw == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = vw.iterator();
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

    @Override // com.baidu.tbadk.core.util.af
    public ArrayList<PreLoadImageInfo> getImages() {
        bd Sz = Sz();
        if (Sz != null) {
            return Sz.getImages();
        }
        return null;
    }

    private int M(bd bdVar) {
        if (bdVar.wm() == null || bdVar.wm().channelId <= 0) {
            return 0;
        }
        return (int) bdVar.wm().channelId;
    }

    public void iO(int i) {
        this.cBs = i;
    }

    public boolean ajv() {
        return this.cBs == 1;
    }
}
