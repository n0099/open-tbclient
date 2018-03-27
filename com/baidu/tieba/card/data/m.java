package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class m extends c {
    public static final BdUniqueId dah = BdUniqueId.gen();
    public static final BdUniqueId dai = BdUniqueId.gen();
    public static String daj = "";
    public static String dak = "";
    public static String dal = "";
    public static String dam = "";
    public static String dan = "";
    public static String dao = "";
    public static String dap = "";
    public bd bZi;
    public boolean dac = false;
    public boolean daq = true;
    public int sourceType = 0;

    public m(bd bdVar) {
        this.bZi = bdVar;
    }

    public static boolean M(bd bdVar) {
        return (bdVar == null || bdVar.zF() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (this.bZi == null) {
            return dah;
        }
        if (this.bZi.zr() || this.bZi.zs()) {
            return dai;
        }
        return dah;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd WE() {
        return this.bZi;
    }

    public ak kz(String str) {
        ak akVar = new ak(str);
        if (this.bZi != null) {
            akVar.f(ImageViewerConfig.FORUM_ID, this.bZi.getFid());
            akVar.ab("tid", this.bZi.getTid());
            akVar.s("obj_type", 2);
            if (this.bZi.zn() != null) {
                akVar.ab("obj_id", this.bZi.zn().getUserId());
            }
        }
        return akVar;
    }

    public ak alK() {
        ak r = r(dam, true);
        if (r != null && WE() != null) {
            bd WE = WE();
            r.s("obj_name", WE.AA() != null && (WE.AA().bxb() != null || WE.AA().Rq() != null) ? 1 : 0);
            if (WE.zn() != null) {
                r.s("ab_type", WE.zn().hadConcerned() ? 1 : 0);
            }
        }
        return r;
    }

    public ak N(bd bdVar) {
        return (bdVar.Ao() == null || bdVar.Ao().channelId <= 0) ? r(dan, true) : r(dao, true);
    }

    public ak alM() {
        return r(dak, true);
    }

    public ak O(bd bdVar) {
        return (bdVar.Ao() == null || bdVar.Ao().channelId <= 0) ? r(daj, true) : r(dap, true);
    }
}
