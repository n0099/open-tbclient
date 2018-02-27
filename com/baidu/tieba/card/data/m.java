package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public class m extends c {
    public static final BdUniqueId dae = BdUniqueId.gen();
    public static final BdUniqueId daf = BdUniqueId.gen();
    public static String dag = "";
    public static String dah = "";
    public static String dai = "";
    public static String daj = "";
    public static String dak = "";
    public static String dal = "";
    public static String dam = "";
    public bd bZf;
    public boolean cZZ = false;
    public boolean dan = true;
    public int sourceType = 0;

    public m(bd bdVar) {
        this.bZf = bdVar;
    }

    public static boolean M(bd bdVar) {
        return (bdVar == null || bdVar.zF() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (this.bZf == null) {
            return dae;
        }
        if (this.bZf.zr() || this.bZf.zs()) {
            return daf;
        }
        return dae;
    }

    @Override // com.baidu.tieba.card.data.c
    public bd WD() {
        return this.bZf;
    }

    public ak kz(String str) {
        ak akVar = new ak(str);
        if (this.bZf != null) {
            akVar.f(ImageViewerConfig.FORUM_ID, this.bZf.getFid());
            akVar.ab("tid", this.bZf.getTid());
            akVar.s("obj_type", 2);
            if (this.bZf.zn() != null) {
                akVar.ab("obj_id", this.bZf.zn().getUserId());
            }
        }
        return akVar;
    }

    public ak alJ() {
        ak r = r(daj, true);
        if (r != null && WD() != null) {
            bd WD = WD();
            r.s("obj_name", WD.AA() != null && (WD.AA().bwW() != null || WD.AA().Rp() != null) ? 1 : 0);
            if (WD.zn() != null) {
                r.s("ab_type", WD.zn().hadConcerned() ? 1 : 0);
            }
        }
        return r;
    }

    public ak N(bd bdVar) {
        return (bdVar.Ao() == null || bdVar.Ao().channelId <= 0) ? r(dak, true) : r(dal, true);
    }

    public ak alL() {
        return r(dah, true);
    }

    public ak O(bd bdVar) {
        return (bdVar.Ao() == null || bdVar.Ao().channelId <= 0) ? r(dag, true) : r(dam, true);
    }
}
