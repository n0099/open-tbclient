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
    private String daA;
    private String daB;
    public int daE;
    private String dax;
    private int daz;
    private String mExtra;
    private String mSource;
    public String tid;
    public int aFq = 1;
    public int daC = 0;
    public SparseArray<String> asc = null;
    private Integer daD = 0;

    public void setWeight(String str) {
        this.dax = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void kP(int i) {
        this.daz = i;
    }

    public void mJ(String str) {
        this.daA = str;
    }

    public int aqC() {
        return this.daz;
    }

    public String aqD() {
        return this.mSource + "#" + this.daz + "#" + this.daA;
    }

    public String getWeight() {
        return this.dax;
    }

    public String getSource() {
        return this.mSource;
    }

    public String aqE() {
        return this.daA;
    }

    public String aqF() {
        return this.daB;
    }

    public void mK(String str) {
        this.daB = str;
    }

    public bb ZT() {
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

    public Integer aqG() {
        return this.daD;
    }

    public void c(Integer num) {
        this.daD = num;
    }

    public am mL(String str) {
        return y(str, false);
    }

    public am y(String str, boolean z) {
        bb ZT = ZT();
        if (ZT == null) {
            return null;
        }
        am aA = new am(str).aA(ImageViewerConfig.FORUM_ID, String.valueOf(ZT.getFid())).aA("tid", String.valueOf(ZT.getTid())).aA(VideoPlayActivityConfig.OBJ_ID, getExtra()).aA("obj_param1", getWeight()).x("obj_param2", 1).aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).x("obj_locate", aqC()).aA("uid", TbadkCoreApplication.getCurrentAccount()).aA("obj_param3", com.baidu.tieba.card.o.aqj());
        if (!z) {
            aA.x("obj_type", aqH());
        } else {
            if (ZT.avr > 0) {
                aA.x("midpageflag", 1);
            } else {
                aA.x("midpageflag", 0);
            }
            aA.aA("ab_tag", aqE());
            aA.x("is_vertical", aqG().intValue());
        }
        if (ZT.AX() != null && ZT.AX().bEl() != null && ZT.AX().bEl().Sb() != null && ZT.AX().bEl().Sb().size() > 0) {
            aA.x("obj_to", ZT.AX().hpd ? 2 : 1);
        }
        return aA;
    }

    public am ab(String str, int i) {
        bb ZT = ZT();
        if (ZT == null) {
            return null;
        }
        am aA = new am(str).aA(ImageViewerConfig.FORUM_ID, String.valueOf(ZT.getFid())).aA("tid", String.valueOf(ZT.getTid())).x(VideoPlayActivityConfig.OBJ_ID, R(ZT)).x("obj_param2", 1).aA("obj_param1", getWeight()).aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).x("obj_locate", aqC()).aA("obj_name", aqE()).aA("uid", TbadkCoreApplication.getCurrentAccount()).aA("obj_param3", com.baidu.tieba.card.o.aqj());
        if (i == 0) {
            aA.x("obj_type", aqH());
        } else {
            aA.x("obj_type", i);
        }
        aA.aA(VideoPlayActivityConfig.OBJ_ID, getExtra());
        return aA;
    }

    private int aqH() {
        int i;
        int i2 = 0;
        bb ZT = ZT();
        if (ZT == null) {
            return 0;
        }
        ArrayList<MediaData> zR = ZT.zR();
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
        bb ZT = ZT();
        if (ZT != null) {
            return ZT.getImages();
        }
        return null;
    }

    private int R(bb bbVar) {
        if (bbVar.AJ() == null || bbVar.AJ().channelId <= 0) {
            return 0;
        }
        return (int) bbVar.AJ().channelId;
    }

    public void kQ(int i) {
        this.daE = i;
    }

    public boolean aqI() {
        return this.daE == 1;
    }
}
