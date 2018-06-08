package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes2.dex */
public class l extends c {
    public static final BdUniqueId cBN = BdUniqueId.gen();
    public static final BdUniqueId cBO = BdUniqueId.gen();
    public static String cBP = "";
    public static String cBQ = "";
    public static String cBR = "";
    public static String cBS = "";
    public static String cBT = "";
    public static String cBU = "";
    public static String cBV = "";
    public bd brC;
    public boolean cBM = false;
    public boolean cBW = true;
    public int sourceType = 0;

    public l(bd bdVar) {
        this.brC = bdVar;
    }

    public static boolean N(bd bdVar) {
        return (bdVar == null || bdVar.vD() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (this.brC == null) {
            return cBN;
        }
        if (this.brC.vp() || this.brC.vq()) {
            return cBO;
        }
        return cBN;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd Sz() {
        if (this.brC == null) {
            return this.brC;
        }
        if (this.brC.vc() == 5) {
            return this.brC;
        }
        this.brC.setResource(1);
        return this.brC;
    }

    public am li(String str) {
        am amVar = new am(str);
        if (this.brC != null) {
            amVar.f(ImageViewerConfig.FORUM_ID, this.brC.getFid());
            amVar.ah("tid", this.brC.getTid());
            amVar.r("obj_type", 2);
            amVar.r("obj_param1", ajv() ? 2 : 1);
            if (this.brC.vm() != null) {
                amVar.ah(VideoPlayActivityConfig.OBJ_ID, this.brC.vm().getUserId());
            }
        }
        return amVar;
    }

    public am ajA() {
        am p = p(cBS, true);
        if (p != null && Sz() != null) {
            bd Sz = Sz();
            p.r("obj_name", Sz.wy() != null && (Sz.wy().bxb() != null || Sz.wy().No() != null) ? 1 : 0);
            if (Sz.vm() != null) {
                p.r("ab_type", Sz.vm().hadConcerned() ? 1 : 0);
            }
        }
        return p;
    }

    public am O(bd bdVar) {
        return (bdVar.wm() == null || bdVar.wm().channelId <= 0) ? p(cBT, true) : p(cBU, true);
    }

    public am ajC() {
        return p(cBQ, true);
    }

    public am P(bd bdVar) {
        return (bdVar.wm() == null || bdVar.wm().channelId <= 0) ? p(cBP, true) : p(cBV, true);
    }
}
