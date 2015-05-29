package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class c {
    private BdUniqueId uniqueId;

    public c(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }

    public b dW(int i) {
        b bVar = new b(i);
        bVar.setUniqueId(this.uniqueId);
        return bVar;
    }

    public b z(int i, int i2) {
        b bVar = new b(i);
        bVar.setUniqueId(this.uniqueId);
        bVar.dV(i2);
        return bVar;
    }

    public b i(int i, boolean z) {
        b bVar = new b(i);
        bVar.setUniqueId(this.uniqueId);
        bVar.aZ(z);
        return bVar;
    }
}
