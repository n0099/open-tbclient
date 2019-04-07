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
    private String ekE;
    private int ekF;
    private String ekG;
    private String ekH;
    private String ekI;
    public int ekK;
    private String mSource;
    public String tid;
    public int objType = 1;
    public SparseArray<String> bzx = null;
    private Integer ekJ = 0;
    public int bAQ = 0;
    public int bAR = 0;

    public void setWeight(String str) {
        this.ekE = str;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void oo(int i) {
        this.ekF = i;
    }

    public void tB(String str) {
        this.ekG = str;
    }

    public int aQN() {
        return this.ekF;
    }

    @Override // com.baidu.tbadk.core.data.a
    public String WR() {
        return this.mSource + "#" + this.ekF + "#" + this.ekG;
    }

    public String getWeight() {
        return this.ekE;
    }

    public String getSource() {
        return this.mSource;
    }

    public String aQO() {
        return this.ekG;
    }

    public String aQP() {
        return this.ekH;
    }

    public void tC(String str) {
        this.ekH = str;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bg WO() {
        return null;
    }

    public boolean isValid() {
        return true;
    }

    public void tD(String str) {
        this.ekI = str;
    }

    public String getExtra() {
        return this.ekI;
    }

    public Integer aQQ() {
        return this.ekJ;
    }

    public void d(Integer num) {
        this.ekJ = num;
    }

    public am tE(String str) {
        return S(str, false);
    }

    public am S(String str, boolean z) {
        bg WO = WO();
        if (WO == null) {
            return null;
        }
        am bJ = new am(str).bJ(ImageViewerConfig.FORUM_ID, String.valueOf(WO.getFid())).bJ("tid", String.valueOf(WO.getTid())).bJ(VideoPlayActivityConfig.OBJ_ID, getExtra()).bJ("obj_param1", getWeight()).T("obj_param2", 1).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).T("obj_locate", aQN()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ("obj_param3", com.baidu.tieba.card.n.aQv());
        if (!z) {
            bJ.T("obj_type", aQR());
        } else {
            if (WO.bDw > 0) {
                bJ.T("midpageflag", 1);
            } else {
                bJ.T("midpageflag", 0);
            }
            bJ.bJ("ab_tag", aQO());
            bJ.T("is_vertical", aQQ().intValue());
        }
        if (WO.aam() != null && WO.aam().cer() != null && WO.aam().cer().ast() != null && WO.aam().cer().ast().size() > 0) {
            bJ.T("obj_to", WO.aam().iGr ? 2 : 1);
        }
        return bJ;
    }

    public am av(String str, int i) {
        bg WO = WO();
        if (WO == null) {
            return null;
        }
        am bJ = new am(str).bJ(ImageViewerConfig.FORUM_ID, String.valueOf(WO.getFid())).bJ("tid", String.valueOf(WO.getTid())).T(VideoPlayActivityConfig.OBJ_ID, U(WO)).T("obj_param2", 1).bJ("obj_param1", getWeight()).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, getSource()).T("obj_locate", aQN()).bJ("obj_name", aQO()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ("obj_param3", com.baidu.tieba.card.n.aQv());
        if (i == 0) {
            bJ.T("obj_type", aQR());
        } else {
            bJ.T("obj_type", i);
        }
        bJ.bJ(VideoPlayActivityConfig.OBJ_ID, getExtra());
        return bJ;
    }

    private int aQR() {
        int i;
        int i2 = 0;
        bg WO = WO();
        if (WO == null) {
            return 0;
        }
        ArrayList<MediaData> YY = WO.YY();
        if (YY == null) {
            i = 0;
        } else {
            Iterator<MediaData> it = YY.iterator();
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
        bg WO = WO();
        if (WO != null) {
            return WO.getImages();
        }
        return null;
    }

    private int U(bg bgVar) {
        if (bgVar.ZY() == null || bgVar.ZY().channelId <= 0) {
            return 0;
        }
        return (int) bgVar.ZY().channelId;
    }

    public void op(int i) {
        this.ekK = i;
    }

    public boolean aQS() {
        return this.ekK == 1;
    }

    @Override // com.baidu.tbadk.core.data.a
    public aj WQ() {
        if (WO() == null || this.bzx == null || this.bzx.size() <= 0) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.setTid(WO().getTid());
        ajVar.setFid(WO().getFid());
        ajVar.b(this.bzx);
        ajVar.weight = this.ekE;
        ajVar.source = this.mSource;
        ajVar.extra = this.ekI;
        ajVar.threadType = WO().threadType;
        return ajVar;
    }
}
