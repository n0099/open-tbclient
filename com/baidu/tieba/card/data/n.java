package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class n extends c {
    public static final BdUniqueId cec = BdUniqueId.gen();
    public static final BdUniqueId ced = BdUniqueId.gen();
    public static String cee = "";
    public static String cef = "";
    public static String ceg = "";
    public static String ceh = "";
    public static String cei = "";
    public static String cej = "";
    public static String cek = "";
    public bd bjI;
    public boolean cdX = false;
    public boolean cel = true;
    public int sourceType = 0;

    public n(bd bdVar) {
        this.bjI = bdVar;
    }

    public static boolean F(bd bdVar) {
        return (bdVar == null || bdVar.rN() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (this.bjI == null) {
            return cec;
        }
        if (this.bjI.rz() || this.bjI.rA()) {
            return ced;
        }
        return cec;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd Ox() {
        return this.bjI;
    }

    public ak jW(String str) {
        ak akVar = new ak(str);
        if (this.bjI != null) {
            akVar.f(ImageViewerConfig.FORUM_ID, this.bjI.getFid());
            akVar.ac("tid", this.bjI.getTid());
            akVar.r("obj_type", 2);
            if (this.bjI.rv() != null) {
                akVar.ac("obj_id", this.bjI.rv().getUserId());
            }
        }
        return akVar;
    }

    public ak acn() {
        ak u = u(ceh, true);
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
        return (bdVar.sA() == null || bdVar.sA().channelId <= 0) ? u(cei, true) : u(cej, true);
    }

    public ak acp() {
        return u(cef, true);
    }

    public ak H(bd bdVar) {
        return (bdVar.sA() == null || bdVar.sA().channelId <= 0) ? u(cee, true) : u(cek, true);
    }
}
