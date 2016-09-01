package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
public class o extends c {
    public static final BdUniqueId bbZ = BdUniqueId.gen();
    public static final BdUniqueId bca = BdUniqueId.gen();
    public static String bcb = "";
    public static String bcc = "";
    public static String bcd = "";
    public static String bce = "";
    public static String bcf = "";
    public bg bbC;
    public boolean bbU = false;
    public boolean bcg = true;

    public o(bg bgVar) {
        this.bbC = bgVar;
    }

    public static boolean c(bg bgVar) {
        return (bgVar == null || bgVar.rR() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.bbC == null) {
            return bbZ;
        }
        if (this.bbC.rD() || this.bbC.rE()) {
            return bca;
        }
        return bbZ;
    }

    @Override // com.baidu.tieba.card.data.c
    public bg Kw() {
        return this.bbC;
    }

    public ay NY() {
        return hM(bce);
    }

    public ay NZ() {
        return hM(bcf);
    }

    public ay Oa() {
        return hM(bcc);
    }

    public ay Ob() {
        return hM(bcb);
    }

    public ay Oj() {
        return w(bcd, true);
    }
}
