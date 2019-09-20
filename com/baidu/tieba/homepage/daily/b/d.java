package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ggx = BdUniqueId.gen();
    private boolean ggA;
    private String ggy;
    private String ggz;

    public String bwg() {
        return this.ggy;
    }

    public void yA(String str) {
        this.ggy = str;
    }

    public String bwh() {
        return this.ggz;
    }

    public void yB(String str) {
        this.ggz = str;
    }

    public boolean bwi() {
        return this.ggA;
    }

    public void lm(boolean z) {
        this.ggA = z;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ggx;
    }
}
