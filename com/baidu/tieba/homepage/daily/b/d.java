package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ejV = BdUniqueId.gen();
    private String ejW;
    private String ejX;
    private boolean ejY;

    public String aJc() {
        return this.ejW;
    }

    public void oH(String str) {
        this.ejW = str;
    }

    public String aJd() {
        return this.ejX;
    }

    public void oI(String str) {
        this.ejX = str;
    }

    public boolean aJe() {
        return this.ejY;
    }

    public void hA(boolean z) {
        this.ejY = z;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return ejV;
    }
}
