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
    private String cPT;
    private int cPU;
    private String cPV;
    private String cPW;
    public int cPZ;
    private String mExtra;
    private String mSource;
    public String tid;
    public int aBa = 1;
    public int cPX = 0;
    public SparseArray<String> anO = null;
    private Integer cPY = 0;

    public void setWeight(String str) {
        this.cPT = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void jT(int i) {
        this.cPU = i;
    }

    public void mg(String str) {
        this.cPV = str;
    }

    public int aoz() {
        return this.cPU;
    }

    public String aoA() {
        return this.mSource + "#" + this.cPU + "#" + this.cPV;
    }

    public String getWeight() {
        return this.cPT;
    }

    public String getSource() {
        return this.mSource;
    }

    public String aoB() {
        return this.cPV;
    }

    public String aoC() {
        return this.cPW;
    }

    public void mh(String str) {
        this.cPW = str;
    }

    public bb YB() {
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

    public Integer aoD() {
        return this.cPY;
    }

    public void c(Integer num) {
        this.cPY = num;
    }

    public am mi(String str) {
        return w(str, false);
    }

    public am w(String str, boolean z) {
        bb YB = YB();
        if (YB == null) {
            return null;
        }
        am ax = new am(str).ax(ImageViewerConfig.FORUM_ID, String.valueOf(YB.getFid())).ax("tid", String.valueOf(YB.getTid())).ax(VideoPlayActivityConfig.OBJ_ID, getExtra()).ax("obj_param1", getWeight()).x("obj_param2", 1).ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).x("obj_locate", aoz()).ax("uid", TbadkCoreApplication.getCurrentAccount()).ax("obj_param3", com.baidu.tieba.card.o.aog());
        if (!z) {
            ax.x("obj_type", aoE());
        } else {
            if (YB.are > 0) {
                ax.x("midpageflag", 1);
            } else {
                ax.x("midpageflag", 0);
            }
            ax.ax("ab_tag", aoB());
            ax.x("is_vertical", aoD().intValue());
        }
        if (YB.zM() != null && YB.zM().bCd() != null && YB.zM().bCd().QK() != null && YB.zM().bCd().QK().size() > 0) {
            ax.x("obj_to", YB.zM().hdB ? 2 : 1);
        }
        return ax;
    }

    public am Z(String str, int i) {
        bb YB = YB();
        if (YB == null) {
            return null;
        }
        am ax = new am(str).ax(ImageViewerConfig.FORUM_ID, String.valueOf(YB.getFid())).ax("tid", String.valueOf(YB.getTid())).x(VideoPlayActivityConfig.OBJ_ID, R(YB)).x("obj_param2", 1).ax("obj_param1", getWeight()).ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).x("obj_locate", aoz()).ax("obj_name", aoB()).ax("uid", TbadkCoreApplication.getCurrentAccount()).ax("obj_param3", com.baidu.tieba.card.o.aog());
        if (i == 0) {
            ax.x("obj_type", aoE());
        } else {
            ax.x("obj_type", i);
        }
        ax.ax(VideoPlayActivityConfig.OBJ_ID, getExtra());
        return ax;
    }

    private int aoE() {
        int i;
        int i2 = 0;
        bb YB = YB();
        if (YB == null) {
            return 0;
        }
        ArrayList<MediaData> yG = YB.yG();
        if (yG == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = yG.iterator();
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
        bb YB = YB();
        if (YB != null) {
            return YB.getImages();
        }
        return null;
    }

    private int R(bb bbVar) {
        if (bbVar.zy() == null || bbVar.zy().channelId <= 0) {
            return 0;
        }
        return (int) bbVar.zy().channelId;
    }

    public void jU(int i) {
        this.cPZ = i;
    }

    public boolean aoF() {
        return this.cPZ == 1;
    }
}
