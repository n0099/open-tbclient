package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class c {
    private BdUniqueId Xt;

    public c(BdUniqueId bdUniqueId) {
        this.Xt = bdUniqueId;
    }

    public b dj(int i) {
        b bVar = new b(i);
        bVar.setUniqueId(this.Xt);
        return bVar;
    }

    public b i(int i, boolean z) {
        b bVar = new b(i);
        bVar.setUniqueId(this.Xt);
        bVar.az(z);
        return bVar;
    }
}
