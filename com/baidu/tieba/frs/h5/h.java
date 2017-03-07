package com.baidu.tieba.frs.h5;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class h implements v {
    public static final BdUniqueId bXK = BdUniqueId.gen();
    public String stType;
    public String url;

    public h(String str) {
        this.url = str;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bXK;
    }
}
