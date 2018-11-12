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
    private String cQZ;
    private int cRa;
    private String cRb;
    private String cRc;
    public int cRf;
    private String mExtra;
    private String mSource;
    public String tid;
    public int aBP = 1;
    public int cRd = 0;
    public SparseArray<String> aoB = null;
    private Integer cRe = 0;

    public void setWeight(String str) {
        this.cQZ = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void km(int i) {
        this.cRa = i;
    }

    public void mh(String str) {
        this.cRb = str;
    }

    public int aoa() {
        return this.cRa;
    }

    public String aob() {
        return this.mSource + "#" + this.cRa + "#" + this.cRb;
    }

    public String getWeight() {
        return this.cQZ;
    }

    public String getSource() {
        return this.mSource;
    }

    public String aoc() {
        return this.cRb;
    }

    public String aod() {
        return this.cRc;
    }

    public void mi(String str) {
        this.cRc = str;
    }

    public bb YL() {
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

    public Integer aoe() {
        return this.cRe;
    }

    public void c(Integer num) {
        this.cRe = num;
    }

    public am mj(String str) {
        return w(str, false);
    }

    public am w(String str, boolean z) {
        bb YL = YL();
        if (YL == null) {
            return null;
        }
        am ax = new am(str).ax(ImageViewerConfig.FORUM_ID, String.valueOf(YL.getFid())).ax("tid", String.valueOf(YL.getTid())).ax(VideoPlayActivityConfig.OBJ_ID, getExtra()).ax("obj_param1", getWeight()).x("obj_param2", 1).ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).x("obj_locate", aoa()).ax("uid", TbadkCoreApplication.getCurrentAccount()).ax("obj_param3", com.baidu.tieba.card.o.anH());
        if (!z) {
            ax.x("obj_type", aof());
        } else {
            if (YL.arR > 0) {
                ax.x("midpageflag", 1);
            } else {
                ax.x("midpageflag", 0);
            }
            ax.ax("ab_tag", aoc());
            ax.x("is_vertical", aoe().intValue());
        }
        if (YL.zT() != null && YL.zT().bBz() != null && YL.zT().bBz().QT() != null && YL.zT().bBz().QT().size() > 0) {
            ax.x("obj_to", YL.zT().heY ? 2 : 1);
        }
        return ax;
    }

    public am Z(String str, int i) {
        bb YL = YL();
        if (YL == null) {
            return null;
        }
        am ax = new am(str).ax(ImageViewerConfig.FORUM_ID, String.valueOf(YL.getFid())).ax("tid", String.valueOf(YL.getTid())).x(VideoPlayActivityConfig.OBJ_ID, R(YL)).x("obj_param2", 1).ax("obj_param1", getWeight()).ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).x("obj_locate", aoa()).ax("obj_name", aoc()).ax("uid", TbadkCoreApplication.getCurrentAccount()).ax("obj_param3", com.baidu.tieba.card.o.anH());
        if (i == 0) {
            ax.x("obj_type", aof());
        } else {
            ax.x("obj_type", i);
        }
        ax.ax(VideoPlayActivityConfig.OBJ_ID, getExtra());
        return ax;
    }

    private int aof() {
        int i;
        int i2 = 0;
        bb YL = YL();
        if (YL == null) {
            return 0;
        }
        ArrayList<MediaData> yN = YL.yN();
        if (yN == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = yN.iterator();
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
        bb YL = YL();
        if (YL != null) {
            return YL.getImages();
        }
        return null;
    }

    private int R(bb bbVar) {
        if (bbVar.zF() == null || bbVar.zF().channelId <= 0) {
            return 0;
        }
        return (int) bbVar.zF().channelId;
    }

    public void kn(int i) {
        this.cRf = i;
    }

    public boolean aog() {
        return this.cRf == 1;
    }
}
