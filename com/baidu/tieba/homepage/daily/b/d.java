package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId elp = BdUniqueId.gen();
    private String elq;
    private String elr;
    private boolean els;

    public String aIA() {
        return this.elq;
    }

    public void oI(String str) {
        this.elq = str;
    }

    public String aIB() {
        return this.elr;
    }

    public void oJ(String str) {
        this.elr = str;
    }

    public boolean aIC() {
        return this.els;
    }

    public void hK(boolean z) {
        this.els = z;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return elp;
    }
}
