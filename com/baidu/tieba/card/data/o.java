package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.av;
/* loaded from: classes.dex */
public class o extends c {
    public static final BdUniqueId bfq = BdUniqueId.gen();
    public static final BdUniqueId bfr = BdUniqueId.gen();
    public static String bfs = "";
    public static String bft = "";
    public static String bfu = "";
    public static String bfv = "";
    public static String bfw = "";
    public bk beS;
    public boolean bfl = false;
    public boolean bfx = true;
    public int sourceType = 0;

    public o(bk bkVar) {
        this.beS = bkVar;
    }

    public static boolean g(bk bkVar) {
        return (bkVar == null || bkVar.sf() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (this.beS == null) {
            return bfq;
        }
        if (this.beS.rR() || this.beS.rS()) {
            return bfr;
        }
        return bfq;
    }

    @Override // com.baidu.tieba.card.data.c
    public bk Jz() {
        return this.beS;
    }

    public av PD() {
        return hX(bfv);
    }

    public av PE() {
        return hX(bfw);
    }

    public av PF() {
        return hX(bft);
    }

    public av PG() {
        return hX(bfs);
    }

    public av PO() {
        return x(bfu, true);
    }
}
