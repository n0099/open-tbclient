package com.baidu.tieba.homepage.daily.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId euZ = BdUniqueId.gen();
    private String eva;

    public String aLf() {
        return this.eva;
    }

    public void pm(String str) {
        this.eva = str;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return euZ;
    }
}
