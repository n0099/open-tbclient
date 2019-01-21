package com.baidu.tieba.frs.g.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes6.dex */
public class b implements h {
    public static final BdUniqueId eod = BdUniqueId.gen();
    private String url;

    public b(String str) {
        this.url = str;
    }

    public String getUrl() {
        return this.url;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return eod;
    }
}
