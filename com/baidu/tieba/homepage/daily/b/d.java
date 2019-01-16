package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId evH = BdUniqueId.gen();
    private String evI;
    private String evJ;
    private boolean evK;

    public String aLE() {
        return this.evI;
    }

    public void pD(String str) {
        this.evI = str;
    }

    public String aLF() {
        return this.evJ;
    }

    public void pE(String str) {
        this.evJ = str;
    }

    public boolean aLG() {
        return this.evK;
    }

    public void hP(boolean z) {
        this.evK = z;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return evH;
    }
}
