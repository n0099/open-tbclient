package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes6.dex */
public class l extends c implements com.baidu.tbadk.core.util.e.a {
    public static final BdUniqueId cRA = BdUniqueId.gen();
    public static final BdUniqueId cRB = BdUniqueId.gen();
    public static String cRC = "";
    public static String cRD = "";
    public static String cRE = "";
    public static String cRF = "";
    public static String cRG = "";
    public static String cRH = "";
    public bb bIU;
    public boolean cRz = false;
    public boolean cRI = true;
    public int sourceType = 0;

    public l(bb bbVar) {
        this.bIU = bbVar;
    }

    public static boolean S(bb bbVar) {
        return (bbVar == null || bbVar.yU() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.bIU == null) {
            return cRA;
        }
        if (this.bIU.yF() || this.bIU.yG()) {
            return cRB;
        }
        return cRA;
    }

    @Override // com.baidu.tieba.card.data.c
    public bb YL() {
        if (this.bIU == null) {
            return this.bIU;
        }
        if (this.bIU.yr() == 5) {
            return this.bIU;
        }
        this.bIU.setResource(1);
        return this.bIU;
    }

    public am ml(String str) {
        am amVar = new am(str);
        if (this.bIU != null) {
            amVar.h(ImageViewerConfig.FORUM_ID, this.bIU.getFid());
            amVar.ax("tid", this.bIU.getTid());
            amVar.x("obj_type", 2);
            amVar.x("obj_param1", aog() ? 2 : 1);
            if (this.bIU.yC() != null) {
                amVar.ax(VideoPlayActivityConfig.OBJ_ID, this.bIU.yC().getUserId());
            }
        }
        return amVar;
    }

    public am aol() {
        am w = w(cRE, true);
        if (w != null && YL() != null) {
            bb YL = YL();
            w.x("obj_name", YL.zT() != null && (YL.zT().bBz() != null || YL.zT().Rb() != null) ? 1 : 0);
            if (YL.yC() != null) {
                w.x("ab_type", YL.yC().hadConcerned() ? 1 : 0);
            }
        }
        return w;
    }

    public am T(bb bbVar) {
        return (bbVar.zF() == null || bbVar.zF().channelId <= 0) ? w(cRF, true) : w(cRG, true);
    }

    public am aon() {
        return w(cRD, true);
    }

    public am U(bb bbVar) {
        return (bbVar.zF() == null || bbVar.zF().channelId <= 0) ? w(cRC, true) : w(cRH, true);
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public String getVideoUrl() {
        if (this.bIU == null || this.bIU.yU() == null || this.bIU.yU().video_url == null) {
            return null;
        }
        return this.bIU.yU().video_url;
    }
}
