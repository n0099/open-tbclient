package com.baidu.tieba.frs.h5;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
/* loaded from: classes.dex */
public class g implements u {
    public static final BdUniqueId bap = BdUniqueId.gen();
    public String stType;
    public String url;

    public g(String str) {
        this.url = str;
    }

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return bap;
    }
}
