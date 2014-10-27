package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class c {
    private BdUniqueId Xp;

    public c(BdUniqueId bdUniqueId) {
        this.Xp = bdUniqueId;
    }

    public b dj(int i) {
        b bVar = new b(i);
        bVar.setUniqueId(this.Xp);
        return bVar;
    }

    public b i(int i, boolean z) {
        b bVar = new b(i);
        bVar.setUniqueId(this.Xp);
        bVar.az(z);
        return bVar;
    }
}
