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
    private String ekW;
    private int ekX;
    private String ekY;
    private String ekZ;
    private String ela;
    public int elc;
    private String mSource;
    public String tid;
    public int objType = 1;
    public SparseArray<String> bzs = null;
    private Integer elb = 0;
    public int bAL = 0;
    public int bAM = 0;

    public void setWeight(String str) {
        this.ekW = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void os(int i) {
        this.ekX = i;
    }

    public void tD(String str) {
        this.ekY = str;
    }

    public int aQP() {
        return this.ekX;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String WU() {
        return this.mSource + "#" + this.ekX + "#" + this.ekY;
    }

    public String getWeight() {
        return this.ekW;
    }

    public String getSource() {
        return this.mSource;
    }

    public String aQQ() {
        return this.ekY;
    }

    public String aQR() {
        return this.ekZ;
    }

    public void tE(String str) {
        this.ekZ = str;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bg WR() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void tF(String str) {
        this.ela = str;
    }

    public String getExtra() {
        return this.ela;
    }

    public Integer aQS() {
        return this.elb;
    }

    public void d(Integer num) {
        this.elb = num;
    }

    public am tG(String str) {
        return R(str, false);
    }

    public am R(String str, boolean z) {
        bg WR = WR();
        if (WR == null) {
            return null;
        }
        am bJ = new am(str).bJ(ImageViewerConfig.FORUM_ID, String.valueOf(WR.getFid())).bJ("tid", String.valueOf(WR.getTid())).bJ(VideoPlayActivityConfig.OBJ_ID, getExtra()).bJ("obj_param1", getWeight()).T("obj_param2", 1).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).T("obj_locate", aQP()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ("obj_param3", com.baidu.tieba.card.n.aQx());
        if (!z) {
            bJ.T("obj_type", aQT());
        } else {
            if (WR.bDr > 0) {
                bJ.T("midpageflag", 1);
            } else {
                bJ.T("midpageflag", 0);
            }
            bJ.bJ("ab_tag", aQQ());
            bJ.T("is_vertical", aQS().intValue());
        }
        if (WR.aap() != null && WR.aap().ces() != null && WR.aap().ces().asw() != null && WR.aap().ces().asw().size() > 0) {
            bJ.T("obj_to", WR.aap().iGO ? 2 : 1);
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
        this.elc = i;
    }

    public boolean aQU() {
        return this.elc == 1;
    }

    @Override // com.baidu.tbadk.core.data.a
    public aj WT() {
        if (WR() == null || this.bzs == null || this.bzs.size() <= 0) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.setTid(WR().getTid());
        ajVar.setFid(WR().getFid());
        ajVar.b(this.bzs);
        ajVar.weight = this.ekW;
        ajVar.source = this.mSource;
        ajVar.extra = this.ela;
        ajVar.threadType = WR().threadType;
        return ajVar;
    }
}
