package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
public class n extends c {
    public static final BdUniqueId bEr = BdUniqueId.gen();
    public static final BdUniqueId bEs = BdUniqueId.gen();
    public static String bEt = "";
    public static String bEu = "";
    public static String bEv = "";
    public static String bEw = "";
    public static String bEx = "";
    public static String bEy = "";
    public static String bEz = "";
    public bm bai;
    public boolean bEm = false;
    public boolean bEA = true;
    public int sourceType = 0;

    public n(bm bmVar) {
        this.bai = bmVar;
    }

    public static boolean x(bm bmVar) {
        return (bmVar == null || bmVar.rI() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.bai == null) {
            return bEr;
        }
        if (this.bai.ru() || this.bai.rv()) {
            return bEs;
        }
        return bEr;
    }

    @Override // com.baidu.tieba.card.data.c
    public bm Mv() {
        return this.bai;
    }

    public au Wb() {
        au v = v(bEw, true);
        if (v != null && Mv() != null) {
            bm Mv = Mv();
            v.r("obj_name", Mv.sE() != null && (Mv.sE().azb() != null || Mv.sE().Ic() != null) ? 1 : 0);
        }
        return v;
    }

    public au y(bm bmVar) {
        return (bmVar.sv() == null || bmVar.sv().channelId <= 0) ? v(bEx, true) : v(bEy, true);
    }

    public au Wd() {
        return v(bEu, true);
    }

    public au z(bm bmVar) {
        return (bmVar.sv() == null || bmVar.sv().channelId <= 0) ? v(bEt, true) : v(bEz, true);
    }
}
