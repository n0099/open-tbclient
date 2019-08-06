package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId geE = BdUniqueId.gen();
    private String geF;

    public String bvr() {
        return this.geF;
    }

    public void ya(String str) {
        this.geF = str;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return geE;
    }
}
