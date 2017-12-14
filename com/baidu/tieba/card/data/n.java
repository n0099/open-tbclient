package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class n extends c {
    public static final BdUniqueId cdY = BdUniqueId.gen();
    public static final BdUniqueId cdZ = BdUniqueId.gen();
    public static String cea = "";
    public static String ceb = "";
    public static String cec = "";
    public static String ced = "";
    public static String cee = "";
    public static String cef = "";
    public static String ceg = "";
    public bd bjE;
    public boolean cdT = false;
    public boolean ceh = true;
    public int sourceType = 0;

    public n(bd bdVar) {
        this.bjE = bdVar;
    }

    public static boolean F(bd bdVar) {
        return (bdVar == null || bdVar.rN() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.bjE == null) {
            return cdY;
        }
        if (this.bjE.rz() || this.bjE.rA()) {
            return cdZ;
        }
        return cdY;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd Ox() {
        return this.bjE;
    }

    public ak jW(String str) {
        ak akVar = new ak(str);
        if (this.bjE != null) {
            akVar.f(ImageViewerConfig.FORUM_ID, this.bjE.getFid());
            akVar.ac("tid", this.bjE.getTid());
            akVar.r("obj_type", 2);
            if (this.bjE.rv() != null) {
                akVar.ac("obj_id", this.bjE.rv().getUserId());
            }
        }
        return akVar;
    }

    public ak aco() {
        ak u = u(ced, true);
        if (u != null && Ox() != null) {
            bd Ox = Ox();
            u.r("obj_name", Ox.sM() != null && (Ox.sM().bwY() != null || Ox.sM().Jz() != null) ? 1 : 0);
            if (Ox.rv() != null) {
                u.r("ab_type", Ox.rv().hadConcerned() ? 1 : 0);
            }
        }
        return u;
    }

    public ak G(bd bdVar) {
        return (bdVar.sA() == null || bdVar.sA().channelId <= 0) ? u(cee, true) : u(cef, true);
    }

    public ak acq() {
        return u(ceb, true);
    }

    public ak H(bd bdVar) {
        return (bdVar.sA() == null || bdVar.sA().channelId <= 0) ? u(cea, true) : u(ceg, true);
    }
}
