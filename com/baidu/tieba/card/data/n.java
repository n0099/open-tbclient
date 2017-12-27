package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class n extends c {
    public static final BdUniqueId cSG = BdUniqueId.gen();
    public static final BdUniqueId cSH = BdUniqueId.gen();
    public static String cSI = "";
    public static String cSJ = "";
    public static String cSK = "";
    public static String cSL = "";
    public static String cSM = "";
    public static String cSN = "";
    public static String cSO = "";
    public be bWT;
    public boolean cSB = false;
    public boolean cSP = true;
    public int sourceType = 0;

    public n(be beVar) {
        this.bWT = beVar;
    }

    public static boolean J(be beVar) {
        return (beVar == null || beVar.zp() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (this.bWT == null) {
            return cSG;
        }
        if (this.bWT.zb() || this.bWT.zc()) {
            return cSH;
        }
        return cSG;
    }

    @Override // com.baidu.tieba.card.data.c
    public be VW() {
        return this.bWT;
    }

    public ak kc(String str) {
        ak akVar = new ak(str);
        if (this.bWT != null) {
            akVar.f(ImageViewerConfig.FORUM_ID, this.bWT.getFid());
            akVar.ab("tid", this.bWT.getTid());
            akVar.s("obj_type", 2);
            if (this.bWT.yX() != null) {
                akVar.ab("obj_id", this.bWT.yX().getUserId());
            }
        }
        return akVar;
    }

    public ak ajT() {
        ak t = t(cSL, true);
        if (t != null && VW() != null) {
            be VW = VW();
            t.s("obj_name", VW.Ao() != null && (VW.Ao().bCo() != null || VW.Ao().QV() != null) ? 1 : 0);
            if (VW.yX() != null) {
                t.s("ab_type", VW.yX().hadConcerned() ? 1 : 0);
            }
        }
        return t;
    }

    public ak K(be beVar) {
        return (beVar.Ac() == null || beVar.Ac().channelId <= 0) ? t(cSM, true) : t(cSN, true);
    }

    public ak ajV() {
        return t(cSJ, true);
    }

    public ak L(be beVar) {
        return (beVar.Ac() == null || beVar.Ac().channelId <= 0) ? t(cSI, true) : t(cSO, true);
    }
}
