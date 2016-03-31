package com.baidu.tieba.card.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes.dex */
public class v extends c {
    public static final BdUniqueId aWk = BdUniqueId.gen();
    public static final BdUniqueId aWl = BdUniqueId.gen();
    public static String aWm = "";
    public static String aWn = "";
    public static String aWo = "";
    public static String aWp = "";
    public static String aWq = "";
    public as aWf;
    public boolean aWe = false;
    public boolean aWr = true;

    public v(as asVar) {
        this.aWf = asVar;
    }

    public static boolean b(as asVar) {
        return (asVar == null || asVar.tC() == null) ? false : true;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        if (this.aWf == null) {
            return aWk;
        }
        if (this.aWf.tq()) {
            return aWl;
        }
        return aWk;
    }

    @Override // com.baidu.tieba.card.a.c
    public as LC() {
        return this.aWf;
    }

    public aw LN() {
        return hh(aWp);
    }

    public aw LO() {
        return hh(aWq);
    }

    public aw LP() {
        return hh(aWn);
    }

    public aw LQ() {
        return hh(aWm);
    }

    public aw LY() {
        return hh(aWo);
    }
}
