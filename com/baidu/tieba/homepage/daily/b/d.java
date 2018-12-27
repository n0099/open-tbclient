package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId evb = BdUniqueId.gen();
    private String evc;
    private String evd;
    private boolean eve;

    public String aLg() {
        return this.evc;
    }

    public void pn(String str) {
        this.evc = str;
    }

    public String aLh() {
        return this.evd;
    }

    public void po(String str) {
        this.evd = str;
    }

    public boolean aLi() {
        return this.eve;
    }

    public void hP(boolean z) {
        this.eve = z;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return evb;
    }
}
