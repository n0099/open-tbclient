package com.baidu.tieba.frs.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class h implements v {
    public static final BdUniqueId bZQ = BdUniqueId.gen();
    public String stType;
    public String url;

    public h(String str) {
        this.url = str;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bZQ;
    }
}
