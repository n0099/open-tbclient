package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class m extends c {
    public bd bZr;
    public static final BdUniqueId daq = BdUniqueId.gen();
    public static final BdUniqueId dar = BdUniqueId.gen();
    public static String das = "";
    public static String dau = "";
    public static String dav = "";
    public static String daw = "";
    public static String dax = "";
    public static String daz = "";
    public static String daA = "";
    public boolean dal = false;
    public boolean daB = true;
    public int sourceType = 0;

    public m(bd bdVar) {
        this.bZr = bdVar;
    }

    public static boolean M(bd bdVar) {
        return (bdVar == null || bdVar.zF() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (this.bZr == null) {
            return daq;
        }
        if (this.bZr.zr() || this.bZr.zs()) {
            return dar;
        }
        return daq;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd WE() {
        return this.bZr;
    }

    public ak kz(String str) {
        ak akVar = new ak(str);
        if (this.bZr != null) {
            akVar.f(ImageViewerConfig.FORUM_ID, this.bZr.getFid());
            akVar.ab("tid", this.bZr.getTid());
            akVar.s("obj_type", 2);
            if (this.bZr.zn() != null) {
                akVar.ab("obj_id", this.bZr.zn().getUserId());
            }
        }
        return akVar;
    }

    public ak alK() {
        ak s = s(daw, true);
        if (s != null && WE() != null) {
            bd WE = WE();
            s.s("obj_name", WE.AA() != null && (WE.AA().bwX() != null || WE.AA().Rq() != null) ? 1 : 0);
            if (WE.zn() != null) {
                s.s("ab_type", WE.zn().hadConcerned() ? 1 : 0);
            }
        }
        return s;
    }

    public ak N(bd bdVar) {
        return (bdVar.Ao() == null || bdVar.Ao().channelId <= 0) ? s(dax, true) : s(daz, true);
    }

    public ak alM() {
        return s(dau, true);
    }

    public ak O(bd bdVar) {
        return (bdVar.Ao() == null || bdVar.Ao().channelId <= 0) ? s(das, true) : s(daA, true);
    }
}
