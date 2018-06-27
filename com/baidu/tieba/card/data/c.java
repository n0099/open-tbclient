package com.baidu.tieba.card.data;

import android.util.SparseArray;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.an;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class c extends b implements af {
    private String czf;
    private int czg;
    private String czh;
    private String czi;
    public int czm;
    private String mExtra;
    private String mSource;
    public String tid;
    public int czj = 1;
    public int czk = 0;
    public SparseArray<String> agZ = null;
    private Integer czl = 0;

    public void setWeight(String str) {
        this.czf = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void iL(int i) {
        this.czg = i;
    }

    public void lb(String str) {
        this.czh = str;
    }

    public int aiJ() {
        return this.czg;
    }

    public String aiK() {
        return this.mSource + "#" + this.czg + "#" + this.czh;
    }

    public String getWeight() {
        return this.czf;
    }

    public String getSource() {
        return this.mSource;
    }

    public String aiL() {
        return this.czh;
    }

    public String aiM() {
        return this.czi;
    }

    public void lc(String str) {
        this.czi = str;
    }

    public bc SV() {
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

    public Integer aiN() {
        return this.czl;
    }

    public void c(Integer num) {
        this.czl = num;
    }

    public an ld(String str) {
        return p(str, false);
    }

    public an p(String str, boolean z) {
        bc SV = SV();
        if (SV == null) {
            return null;
        }
        an ah = new an(str).ah(ImageViewerConfig.FORUM_ID, String.valueOf(SV.getFid())).ah("tid", String.valueOf(SV.getTid())).ah(VideoPlayActivityConfig.OBJ_ID, getExtra()).ah("obj_param1", getWeight()).r("obj_param2", 1).ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", aiJ()).ah("uid", TbadkCoreApplication.getCurrentAccount()).ah("obj_param3", com.baidu.tieba.card.o.aiq());
        if (!z) {
            ah.r("obj_type", aiO());
        } else {
            if (SV.aki > 0) {
                ah.r("midpageflag", 1);
            } else {
                ah.r("midpageflag", 0);
            }
            ah.ah("ab_tag", aiL());
            ah.r("is_vertical", aiN().intValue());
        }
        if (SV.wI() != null && SV.wI().bxE() != null && SV.wI().bxE().Nz() != null && SV.wI().bxE().Nz().size() > 0) {
            ah.r("obj_to", SV.wI().gNB ? 2 : 1);
        }
        return ah;
    }

    public an U(String str, int i) {
        bc SV = SV();
        if (SV == null) {
            return null;
        }
        an ah = new an(str).ah(ImageViewerConfig.FORUM_ID, String.valueOf(SV.getFid())).ah("tid", String.valueOf(SV.getTid())).r(VideoPlayActivityConfig.OBJ_ID, O(SV)).r("obj_param2", 1).ah("obj_param1", getWeight()).ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).r("obj_locate", aiJ()).ah("obj_name", aiL()).ah("uid", TbadkCoreApplication.getCurrentAccount()).ah("obj_param3", com.baidu.tieba.card.o.aiq());
        if (i == 0) {
            ah.r("obj_type", aiO());
        } else {
            ah.r("obj_type", i);
        }
        ah.ah(VideoPlayActivityConfig.OBJ_ID, getExtra());
        return ah;
    }

    private int aiO() {
        int i;
        int i2 = 0;
        bc SV = SV();
        if (SV == null) {
            return 0;
        }
        ArrayList<MediaData> vG = SV.vG();
        if (vG == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = vG.iterator();
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
        bc SV = SV();
        if (SV != null) {
            return SV.getImages();
        }
        return null;
    }

    private int O(bc bcVar) {
        if (bcVar.ww() == null || bcVar.ww().channelId <= 0) {
            return 0;
        }
        return (int) bcVar.ww().channelId;
    }

    public void iM(int i) {
        this.czm = i;
    }

    public boolean aiP() {
        return this.czm == 1;
    }
}
