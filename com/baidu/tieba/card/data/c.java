package com.baidu.tieba.card.data;

import android.util.SparseArray;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class c extends b implements af {
    private String cBH;
    private int cBI;
    private String cBJ;
    private String cBK;
    private String cBN;
    public int cBP;
    private String mSource;
    public String tid;
    public int cBL = 1;
    public int cBM = 0;
    public SparseArray<String> agt = null;
    private Integer cBO = 0;

    public void setWeight(String str) {
        this.cBH = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void iW(int i) {
        this.cBI = i;
    }

    public void lb(String str) {
        this.cBJ = str;
    }

    public int ajl() {
        return this.cBI;
    }

    public String ajm() {
        return this.mSource + "#" + this.cBI + "#" + this.cBJ;
    }

    public String getWeight() {
        return this.cBH;
    }

    public String getSource() {
        return this.mSource;
    }

    public String ajn() {
        return this.cBJ;
    }

    public String ajo() {
        return this.cBK;
    }

    public void lc(String str) {
        this.cBK = str;
    }

    public bb Tg() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void ld(String str) {
        this.cBN = str;
    }

    public String getExtra() {
        return this.cBN;
    }

    public Integer ajp() {
        return this.cBO;
    }

    public void c(Integer num) {
        this.cBO = num;
    }

    public an le(String str) {
        return o(str, false);
    }

    public an o(String str, boolean z) {
        bb Tg = Tg();
        if (Tg == null) {
            return null;
        }
        an ae = new an(str).ae(ImageViewerConfig.FORUM_ID, String.valueOf(Tg.getFid())).ae("tid", String.valueOf(Tg.getTid())).ae(VideoPlayActivityConfig.OBJ_ID, getExtra()).ae("obj_param1", getWeight()).r("obj_param2", 1).ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", ajl()).ae("uid", TbadkCoreApplication.getCurrentAccount()).ae("obj_param3", com.baidu.tieba.card.o.aiS());
        if (!z) {
            ae.r("obj_type", ajq());
        } else {
            if (Tg.ajF > 0) {
                ae.r("midpageflag", 1);
            } else {
                ae.r("midpageflag", 0);
            }
            ae.ae("ab_tag", ajn());
            ae.r("is_vertical", ajp().intValue());
        }
        if (Tg.ww() != null && Tg.ww().bwi() != null && Tg.ww().bwi().Nw() != null && Tg.ww().bwi().Nw().size() > 0) {
            ae.r("obj_to", Tg.ww().gOB ? 2 : 1);
        }
        return ae;
    }

    public an Q(String str, int i) {
        bb Tg = Tg();
        if (Tg == null) {
            return null;
        }
        an ae = new an(str).ae(ImageViewerConfig.FORUM_ID, String.valueOf(Tg.getFid())).ae("tid", String.valueOf(Tg.getTid())).r(VideoPlayActivityConfig.OBJ_ID, Q(Tg)).r("obj_param2", 1).ae("obj_param1", getWeight()).ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", ajl()).ae("obj_name", ajn()).ae("uid", TbadkCoreApplication.getCurrentAccount()).ae("obj_param3", com.baidu.tieba.card.o.aiS());
        if (i == 0) {
            ae.r("obj_type", ajq());
        } else {
            ae.r("obj_type", i);
        }
        ae.ae(VideoPlayActivityConfig.OBJ_ID, getExtra());
        return ae;
    }

    private int ajq() {
        int i;
        int i2 = 0;
        bb Tg = Tg();
        if (Tg == null) {
            return 0;
        }
        ArrayList<MediaData> vu = Tg.vu();
        if (vu == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = vu.iterator();
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
        bb Tg = Tg();
        if (Tg != null) {
            return Tg.getImages();
        }
        return null;
    }

    private int Q(bb bbVar) {
        if (bbVar.wk() == null || bbVar.wk().channelId <= 0) {
            return 0;
        }
        return (int) bbVar.wk().channelId;
    }

    public void iX(int i) {
        this.cBP = i;
    }

    public boolean ajr() {
        return this.cBP == 1;
    }
}
