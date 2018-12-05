package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes6.dex */
public class l extends c implements com.baidu.tbadk.core.util.e.a {
    public static final BdUniqueId cYh = BdUniqueId.gen();
    public static final BdUniqueId cYi = BdUniqueId.gen();
    public static String cYj = "";
    public static String cYk = "";
    public static String cYl = "";
    public static String cYm = "";
    public static String cYn = "";
    public static String cYo = "";
    public bb bMJ;
    public boolean cYg = false;
    public boolean cYp = true;
    public int sourceType = 0;

    public l(bb bbVar) {
        this.bMJ = bbVar;
    }

    public static boolean S(bb bbVar) {
        return (bbVar == null || bbVar.zY() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.bMJ == null) {
            return cYh;
        }
        if (this.bMJ.zJ() || this.bMJ.zK()) {
            return cYi;
        }
        return cYh;
    }

    @Override // com.baidu.tieba.card.data.c
    public bb ZR() {
        if (this.bMJ == null) {
            return this.bMJ;
        }
        if (this.bMJ.zv() == 5) {
            return this.bMJ;
        }
        this.bMJ.setResource(1);
        return this.bMJ;
    }

    public am mK(String str) {
        am amVar = new am(str);
        if (this.bMJ != null) {
            amVar.i(ImageViewerConfig.FORUM_ID, this.bMJ.getFid());
            amVar.aA("tid", this.bMJ.getTid());
            amVar.x("obj_type", 2);
            amVar.x("obj_param1", apT() ? 2 : 1);
            if (this.bMJ.zG() != null) {
                amVar.aA(VideoPlayActivityConfig.OBJ_ID, this.bMJ.zG().getUserId());
            }
        }
        return amVar;
    }

    public am apY() {
        am y = y(cYl, true);
        if (y != null && ZR() != null) {
            bb ZR = ZR();
            y.x("obj_name", ZR.AX() != null && (ZR.AX().bDu() != null || ZR.AX().Sh() != null) ? 1 : 0);
            if (ZR.zG() != null) {
                y.x("ab_type", ZR.zG().hadConcerned() ? 1 : 0);
            }
        }
        return y;
    }

    public am T(bb bbVar) {
        return (bbVar.AJ() == null || bbVar.AJ().channelId <= 0) ? y(cYm, true) : y(cYn, true);
    }

    public am aqa() {
        return y(cYk, true);
    }

    public am U(bb bbVar) {
        return (bbVar.AJ() == null || bbVar.AJ().channelId <= 0) ? y(cYj, true) : y(cYo, true);
    }

    @Override // com.baidu.tbadk.core.util.e.a
    public String getVideoUrl() {
        if (this.bMJ == null || this.bMJ.zY() == null || this.bMJ.zY().video_url == null) {
            return null;
        }
        return this.bMJ.zY().video_url;
    }
}
