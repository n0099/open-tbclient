package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class n extends c {
    public static final BdUniqueId cXi = BdUniqueId.gen();
    public static final BdUniqueId cXj = BdUniqueId.gen();
    public static String cXk = "";
    public static String cXl = "";
    public static String cXm = "";
    public static String cXn = "";
    public static String cXo = "";
    public static String cXp = "";
    public static String cXq = "";
    public bd bXa;
    public boolean cXd = false;
    public boolean cXr = true;
    public int sourceType = 0;

    public n(bd bdVar) {
        this.bXa = bdVar;
    }

    public static boolean J(bd bdVar) {
        return (bdVar == null || bdVar.zk() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (this.bXa == null) {
            return cXi;
        }
        if (this.bXa.yW() || this.bXa.yX()) {
            return cXj;
        }
        return cXi;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd VK() {
        return this.bXa;
    }

    public ak kk(String str) {
        ak akVar = new ak(str);
        if (this.bXa != null) {
            akVar.f(ImageViewerConfig.FORUM_ID, this.bXa.getFid());
            akVar.ab("tid", this.bXa.getTid());
            akVar.s("obj_type", 2);
            if (this.bXa.yS() != null) {
                akVar.ab("obj_id", this.bXa.yS().getUserId());
            }
        }
        return akVar;
    }

    public ak akW() {
        ak t = t(cXn, true);
        if (t != null && VK() != null) {
            bd VK = VK();
            t.s("obj_name", VK.Ag() != null && (VK.Ag().bvK() != null || VK.Ag().QJ() != null) ? 1 : 0);
            if (VK.yS() != null) {
                t.s("ab_type", VK.yS().hadConcerned() ? 1 : 0);
            }
        }
        return t;
    }

    public ak K(bd bdVar) {
        return (bdVar.zU() == null || bdVar.zU().channelId <= 0) ? t(cXo, true) : t(cXp, true);
    }

    public ak akY() {
        return t(cXl, true);
    }

    public ak L(bd bdVar) {
        return (bdVar.zU() == null || bdVar.zU().channelId <= 0) ? t(cXk, true) : t(cXq, true);
    }
}
