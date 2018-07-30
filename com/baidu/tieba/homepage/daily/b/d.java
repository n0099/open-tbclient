package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dUN = BdUniqueId.gen();
    private String dUO;
    private String dUP;
    private boolean dUQ;

    public String aDA() {
        return this.dUO;
    }

    public void nw(String str) {
        this.dUO = str;
    }

    public String aDB() {
        return this.dUP;
    }

    public void nx(String str) {
        this.dUP = str;
    }

    public boolean aDC() {
        return this.dUQ;
    }

    public void gK(boolean z) {
        this.dUQ = z;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dUN;
    }
}
