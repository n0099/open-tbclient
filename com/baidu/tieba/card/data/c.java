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
    private String cBK;
    private int cBL;
    private String cBM;
    private String cBN;
    private String cBQ;
    public int cBS;
    private String mSource;
    public String tid;
    public int cBO = 1;
    public int cBP = 0;
    public SparseArray<String> agt = null;
    private Integer cBR = 0;

    public void setWeight(String str) {
        this.cBK = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void iX(int i) {
        this.cBL = i;
    }

    public void kZ(String str) {
        this.cBM = str;
    }

    public int aji() {
        return this.cBL;
    }

    public String ajj() {
        return this.mSource + "#" + this.cBL + "#" + this.cBM;
    }

    public String getWeight() {
        return this.cBK;
    }

    public String getSource() {
        return this.mSource;
    }

    public String ajk() {
        return this.cBM;
    }

    public String ajl() {
        return this.cBN;
    }

    public void la(String str) {
        this.cBN = str;
    }

    public bb Td() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void lb(String str) {
        this.cBQ = str;
    }

    public String getExtra() {
        return this.cBQ;
    }

    public Integer ajm() {
        return this.cBR;
    }

    public void c(Integer num) {
        this.cBR = num;
    }

    public an lc(String str) {
        return o(str, false);
    }

    public an o(String str, boolean z) {
        bb Td = Td();
        if (Td == null) {
            return null;
        }
        an af = new an(str).af(ImageViewerConfig.FORUM_ID, String.valueOf(Td.getFid())).af("tid", String.valueOf(Td.getTid())).af(VideoPlayActivityConfig.OBJ_ID, getExtra()).af("obj_param1", getWeight()).r("obj_param2", 1).af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", aji()).af("uid", TbadkCoreApplication.getCurrentAccount()).af("obj_param3", com.baidu.tieba.card.o.aiP());
        if (!z) {
            af.r("obj_type", ajn());
        } else {
            if (Td.ajF > 0) {
                af.r("midpageflag", 1);
            } else {
                af.r("midpageflag", 0);
            }
            af.af("ab_tag", ajk());
            af.r("is_vertical", ajm().intValue());
        }
        if (Td.wx() != null && Td.wx().bwh() != null && Td.wx().bwh().Nx() != null && Td.wx().bwh().Nx().size() > 0) {
            af.r("obj_to", Td.wx().gOz ? 2 : 1);
        }
        return af;
    }

    public an Q(String str, int i) {
        bb Td = Td();
        if (Td == null) {
            return null;
        }
        an af = new an(str).af(ImageViewerConfig.FORUM_ID, String.valueOf(Td.getFid())).af("tid", String.valueOf(Td.getTid())).r(VideoPlayActivityConfig.OBJ_ID, Q(Td)).r("obj_param2", 1).af("obj_param1", getWeight()).af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", aji()).af("obj_name", ajk()).af("uid", TbadkCoreApplication.getCurrentAccount()).af("obj_param3", com.baidu.tieba.card.o.aiP());
        if (i == 0) {
            af.r("obj_type", ajn());
        } else {
            af.r("obj_type", i);
        }
        af.af(VideoPlayActivityConfig.OBJ_ID, getExtra());
        return af;
    }

    private int ajn() {
        int i;
        int i2 = 0;
        bb Td = Td();
        if (Td == null) {
            return 0;
        }
        ArrayList<MediaData> vv = Td.vv();
        if (vv == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = vv.iterator();
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
        bb Td = Td();
        if (Td != null) {
            return Td.getImages();
        }
        return null;
    }

    private int Q(bb bbVar) {
        if (bbVar.wl() == null || bbVar.wl().channelId <= 0) {
            return 0;
        }
        return (int) bbVar.wl().channelId;
    }

    public void iY(int i) {
        this.cBS = i;
    }

    public boolean ajo() {
        return this.cBS == 1;
    }
}
