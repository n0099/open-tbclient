package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId evI = BdUniqueId.gen();
    private String evJ;
    private String evK;
    private boolean evL;

    public String aLE() {
        return this.evJ;
    }

    public void pD(String str) {
        this.evJ = str;
    }

    public String aLF() {
        return this.evK;
    }

    public void pE(String str) {
        this.evK = str;
    }

    public boolean aLG() {
        return this.evL;
    }

    public void hP(boolean z) {
        this.evL = z;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return evI;
    }
}
