package com.baidu.tieba.card.data;

import android.util.SparseArray;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.am;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public abstract class c extends com.baidu.tbadk.core.data.a implements ae {
    private String ekS;
    private int ekT;
    private String ekU;
    private String ekV;
    private String ekW;
    public int ekY;
    private String mSource;
    public String tid;
    public int objType = 1;
    public SparseArray<String> bzu = null;
    private Integer ekX = 0;
    public int bAN = 0;
    public int bAO = 0;

    public void setWeight(String str) {
        this.ekS = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void os(int i) {
        this.ekT = i;
    }

    public void tC(String str) {
        this.ekU = str;
    }

    public int aQP() {
        return this.ekT;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String WU() {
        return this.mSource + "#" + this.ekT + "#" + this.ekU;
    }

    public String getWeight() {
        return this.ekS;
    }

    public String getSource() {
        return this.mSource;
    }

    public String aQQ() {
        return this.ekU;
    }

    public String aQR() {
        return this.ekV;
    }

    public void tD(String str) {
        this.ekV = str;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bg WR() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void tE(String str) {
        this.ekW = str;
    }

    public String getExtra() {
        return this.ekW;
    }

    public Integer aQS() {
        return this.ekX;
    }

    public void d(Integer num) {
        this.ekX = num;
    }

    public am tF(String str) {
        return S(str, false);
    }

    public am S(String str, boolean z) {
        bg WR = WR();
        if (WR == null) {
            return null;
        }
        am bJ = new am(str).bJ(ImageViewerConfig.FORUM_ID, String.valueOf(WR.getFid())).bJ("tid", String.valueOf(WR.getTid())).bJ(VideoPlayActivityConfig.OBJ_ID, getExtra()).bJ("obj_param1", getWeight()).T("obj_param2", 1).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).T("obj_locate", aQP()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ("obj_param3", com.baidu.tieba.card.n.aQx());
        if (!z) {
            bJ.T("obj_type", aQT());
        } else {
            if (WR.bDt > 0) {
                bJ.T("midpageflag", 1);
            } else {
                bJ.T("midpageflag", 0);
            }
            bJ.bJ("ab_tag", aQQ());
            bJ.T("is_vertical", aQS().intValue());
        }
        if (WR.aap() != null && WR.aap().cev() != null && WR.aap().cev().asw() != null && WR.aap().cev().asw().size() > 0) {
            bJ.T("obj_to", WR.aap().iGH ? 2 : 1);
        }
        return bJ;
    }

    public am av(String str, int i) {
        bg WR = WR();
        if (WR == null) {
            return null;
        }
        am bJ = new am(str).bJ(ImageViewerConfig.FORUM_ID, String.valueOf(WR.getFid())).bJ("tid", String.valueOf(WR.getTid())).T(VideoPlayActivityConfig.OBJ_ID, V(WR)).T("obj_param2", 1).bJ("obj_param1", getWeight()).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).T("obj_locate", aQP()).bJ("obj_name", aQQ()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ("obj_param3", com.baidu.tieba.card.n.aQx());
        if (i == 0) {
            bJ.T("obj_type", aQT());
        } else {
            bJ.T("obj_type", i);
        }
        bJ.bJ(VideoPlayActivityConfig.OBJ_ID, getExtra());
        return bJ;
    }

    private int aQT() {
        int i;
        int i2 = 0;
        bg WR = WR();
        if (WR == null) {
            return 0;
        }
        ArrayList<MediaData> Zb = WR.Zb();
        if (Zb == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = Zb.iterator();
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
        bg WR = WR();
        if (WR != null) {
            return WR.getImages();
        }
        return null;
    }

    private int V(bg bgVar) {
        if (bgVar.aab() == null || bgVar.aab().channelId <= 0) {
            return 0;
        }
        return (int) bgVar.aab().channelId;
    }

    public void ot(int i) {
        this.ekY = i;
    }

    public boolean aQU() {
        return this.ekY == 1;
    }

    @Override // com.baidu.tbadk.core.data.a
    public aj WT() {
        if (WR() == null || this.bzu == null || this.bzu.size() <= 0) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.setTid(WR().getTid());
        ajVar.setFid(WR().getFid());
        ajVar.b(this.bzu);
        ajVar.weight = this.ekS;
        ajVar.source = this.mSource;
        ajVar.extra = this.ekW;
        ajVar.threadType = WR().threadType;
        return ajVar;
    }
}
