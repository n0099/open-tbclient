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
/* loaded from: classes2.dex */
public abstract class c extends b implements ae {
    private int cHA;
    private String cHB;
    private String cHC;
    private String cHE;
    public int cHG;
    private String cHz;
    private String mSource;
    public String tid;
    public int awp = 1;
    public int cHD = 0;
    public SparseArray<String> aiT = null;
    private Integer cHF = 0;

    public void setWeight(String str) {
        this.cHz = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void jv(int i) {
        this.cHA = i;
    }

    public void lD(String str) {
        this.cHB = str;
    }

    public int akW() {
        return this.cHA;
    }

    public String akX() {
        return this.mSource + "#" + this.cHA + "#" + this.cHB;
    }

    public String getWeight() {
        return this.cHz;
    }

    public String getSource() {
        return this.mSource;
    }

    public String akY() {
        return this.cHB;
    }

    public String akZ() {
        return this.cHC;
    }

    public void lE(String str) {
        this.cHC = str;
    }

    public bb UT() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void lF(String str) {
        this.cHE = str;
    }

    public String getExtra() {
        return this.cHE;
    }

    public Integer ala() {
        return this.cHF;
    }

    public void c(Integer num) {
        this.cHF = num;
    }

    public am lG(String str) {
        return p(str, false);
    }

    public am p(String str, boolean z) {
        bb UT = UT();
        if (UT == null) {
            return null;
        }
        am al = new am(str).al(ImageViewerConfig.FORUM_ID, String.valueOf(UT.getFid())).al("tid", String.valueOf(UT.getTid())).al(VideoPlayActivityConfig.OBJ_ID, getExtra()).al("obj_param1", getWeight()).w("obj_param2", 1).al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).w("obj_locate", akW()).al("uid", TbadkCoreApplication.getCurrentAccount()).al("obj_param3", com.baidu.tieba.card.o.akD());
        if (!z) {
            al.w("obj_type", alb());
        } else {
            if (UT.amj > 0) {
                al.w("midpageflag", 1);
            } else {
                al.w("midpageflag", 0);
            }
            al.al("ab_tag", akY());
            al.w("is_vertical", ala().intValue());
        }
        if (UT.xD() != null && UT.xD().byO() != null && UT.xD().byO().OP() != null && UT.xD().byO().OP().size() > 0) {
            al.w("obj_to", UT.xD().gWf ? 2 : 1);
        }
        return al;
    }

    public am V(String str, int i) {
        bb UT = UT();
        if (UT == null) {
            return null;
        }
        am al = new am(str).al(ImageViewerConfig.FORUM_ID, String.valueOf(UT.getFid())).al("tid", String.valueOf(UT.getTid())).w(VideoPlayActivityConfig.OBJ_ID, R(UT)).w("obj_param2", 1).al("obj_param1", getWeight()).al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).w("obj_locate", akW()).al("obj_name", akY()).al("uid", TbadkCoreApplication.getCurrentAccount()).al("obj_param3", com.baidu.tieba.card.o.akD());
        if (i == 0) {
            al.w("obj_type", alb());
        } else {
            al.w("obj_type", i);
        }
        al.al(VideoPlayActivityConfig.OBJ_ID, getExtra());
        return al;
    }

    private int alb() {
        int i;
        int i2 = 0;
        bb UT = UT();
        if (UT == null) {
            return 0;
        }
        ArrayList<MediaData> wx = UT.wx();
        if (wx == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = wx.iterator();
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
        bb UT = UT();
        if (UT != null) {
            return UT.getImages();
        }
        return null;
    }

    private int R(bb bbVar) {
        if (bbVar.xp() == null || bbVar.xp().channelId <= 0) {
            return 0;
        }
        return (int) bbVar.xp().channelId;
    }

    public void jw(int i) {
        this.cHG = i;
    }

    public boolean alc() {
        return this.cHG == 1;
    }
}
