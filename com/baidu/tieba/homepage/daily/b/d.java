package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ejU = BdUniqueId.gen();
    private String ejV;
    private String ejW;
    private boolean ejX;

    public String aJc() {
        return this.ejV;
    }

    public void oH(String str) {
        this.ejV = str;
    }

    public String aJd() {
        return this.ejW;
    }

    public void oI(String str) {
        this.ejW = str;
    }

    public boolean aJe() {
        return this.ejX;
    }

    public void hA(boolean z) {
        this.ejX = z;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return ejU;
    }
}
