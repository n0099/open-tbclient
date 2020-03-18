package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int dCq;
    private boolean dCr = true;
    private com.baidu.tbadk.mvc.b.a dCs;
    private com.baidu.tbadk.mvc.d.b dCt;
    private com.baidu.tbadk.mvc.a.a dCu;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.dCq = i;
        this.dCs = aVar;
        this.dCt = bVar;
        this.dCu = aVar2;
    }

    public int aQs() {
        return this.dCq;
    }

    public com.baidu.tbadk.mvc.b.a aQt() {
        return this.dCs;
    }

    public com.baidu.tbadk.mvc.d.b aQu() {
        return this.dCt;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.dCt = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean aQv() {
        return this.dCr;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
