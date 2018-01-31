package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class n extends c {
    public static final BdUniqueId cXD = BdUniqueId.gen();
    public static final BdUniqueId cXE = BdUniqueId.gen();
    public static String cXF = "";
    public static String cXG = "";
    public static String cXH = "";
    public static String cXI = "";
    public static String cXJ = "";
    public static String cXK = "";
    public static String cXL = "";
    public bd bXi;
    public boolean cXy = false;
    public boolean cXM = true;
    public int sourceType = 0;

    public n(bd bdVar) {
        this.bXi = bdVar;
    }

    public static boolean J(bd bdVar) {
        return (bdVar == null || bdVar.zl() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (this.bXi == null) {
            return cXD;
        }
        if (this.bXi.yX() || this.bXi.yY()) {
            return cXE;
        }
        return cXD;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd VM() {
        return this.bXi;
    }

    public ak kr(String str) {
        ak akVar = new ak(str);
        if (this.bXi != null) {
            akVar.f(ImageViewerConfig.FORUM_ID, this.bXi.getFid());
            akVar.aa("tid", this.bXi.getTid());
            akVar.s("obj_type", 2);
            if (this.bXi.yT() != null) {
                akVar.aa("obj_id", this.bXi.yT().getUserId());
            }
        }
        return akVar;
    }

    public ak alb() {
        ak t = t(cXI, true);
        if (t != null && VM() != null) {
            bd VM = VM();
            t.s("obj_name", VM.Ah() != null && (VM.Ah().bvM() != null || VM.Ah().QL() != null) ? 1 : 0);
            if (VM.yT() != null) {
                t.s("ab_type", VM.yT().hadConcerned() ? 1 : 0);
            }
        }
        return t;
    }

    public ak K(bd bdVar) {
        return (bdVar.zV() == null || bdVar.zV().channelId <= 0) ? t(cXJ, true) : t(cXK, true);
    }

    public ak ald() {
        return t(cXG, true);
    }

    public ak L(bd bdVar) {
        return (bdVar.zV() == null || bdVar.zV().channelId <= 0) ? t(cXF, true) : t(cXL, true);
    }
}
