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
    private String cXG;
    private int cXH;
    private String cXI;
    private String cXJ;
    public int cXM;
    private String mExtra;
    private String mSource;
    public String tid;
    public int aFp = 1;
    public int cXK = 0;
    public SparseArray<String> asc = null;
    private Integer cXL = 0;

    public void setWeight(String str) {
        this.cXG = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void kC(int i) {
        this.cXH = i;
    }

    public void mG(String str) {
        this.cXI = str;
    }

    public int apN() {
        return this.cXH;
    }

    public String apO() {
        return this.mSource + "#" + this.cXH + "#" + this.cXI;
    }

    public String getWeight() {
        return this.cXG;
    }

    public String getSource() {
        return this.mSource;
    }

    public String apP() {
        return this.cXI;
    }

    public String apQ() {
        return this.cXJ;
    }

    public void mH(String str) {
        this.cXJ = str;
    }

    public bb ZR() {
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

    public Integer apR() {
        return this.cXL;
    }

    public void c(Integer num) {
        this.cXL = num;
    }

    public am mI(String str) {
        return y(str, false);
    }

    public am y(String str, boolean z) {
        bb ZR = ZR();
        if (ZR == null) {
            return null;
        }
        am aA = new am(str).aA(ImageViewerConfig.FORUM_ID, String.valueOf(ZR.getFid())).aA("tid", String.valueOf(ZR.getTid())).aA(VideoPlayActivityConfig.OBJ_ID, getExtra()).aA("obj_param1", getWeight()).x("obj_param2", 1).aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).x("obj_locate", apN()).aA("uid", TbadkCoreApplication.getCurrentAccount()).aA("obj_param3", com.baidu.tieba.card.o.apu());
        if (!z) {
            aA.x("obj_type", apS());
        } else {
            if (ZR.avr > 0) {
                aA.x("midpageflag", 1);
            } else {
                aA.x("midpageflag", 0);
            }
            aA.aA("ab_tag", apP());
            aA.x("is_vertical", apR().intValue());
        }
        if (ZR.AX() != null && ZR.AX().bDt() != null && ZR.AX().bDt().RZ() != null && ZR.AX().bDt().RZ().size() > 0) {
            aA.x("obj_to", ZR.AX().hlS ? 2 : 1);
        }
        return aA;
    }

    public am aa(String str, int i) {
        bb ZR = ZR();
        if (ZR == null) {
            return null;
        }
        am aA = new am(str).aA(ImageViewerConfig.FORUM_ID, String.valueOf(ZR.getFid())).aA("tid", String.valueOf(ZR.getTid())).x(VideoPlayActivityConfig.OBJ_ID, R(ZR)).x("obj_param2", 1).aA("obj_param1", getWeight()).aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).x("obj_locate", apN()).aA("obj_name", apP()).aA("uid", TbadkCoreApplication.getCurrentAccount()).aA("obj_param3", com.baidu.tieba.card.o.apu());
        if (i == 0) {
            aA.x("obj_type", apS());
        } else {
            aA.x("obj_type", i);
        }
        aA.aA(VideoPlayActivityConfig.OBJ_ID, getExtra());
        return aA;
    }

    private int apS() {
        int i;
        int i2 = 0;
        bb ZR = ZR();
        if (ZR == null) {
            return 0;
        }
        ArrayList<MediaData> zR = ZR.zR();
        if (zR == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = zR.iterator();
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
        bb ZR = ZR();
        if (ZR != null) {
            return ZR.getImages();
        }
        return null;
    }

    private int R(bb bbVar) {
        if (bbVar.AJ() == null || bbVar.AJ().channelId <= 0) {
            return 0;
        }
        return (int) bbVar.AJ().channelId;
    }

    public void kD(int i) {
        this.cXM = i;
    }

    public boolean apT() {
        return this.cXM == 1;
    }
}
