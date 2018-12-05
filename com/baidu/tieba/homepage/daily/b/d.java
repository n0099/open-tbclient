package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId esk = BdUniqueId.gen();
    private String esl;
    private String esm;
    private boolean esn;

    public String aKr() {
        return this.esl;
    }

    public void pk(String str) {
        this.esl = str;
    }

    public String aKs() {
        return this.esm;
    }

    public void pl(String str) {
        this.esm = str;
    }

    public boolean aKt() {
        return this.esn;
    }

    public void hM(boolean z) {
        this.esn = z;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return esk;
    }
}
