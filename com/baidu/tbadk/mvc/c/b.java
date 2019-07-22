package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int cye;
    private boolean cyf = true;
    private com.baidu.tbadk.mvc.b.a cyg;
    private com.baidu.tbadk.mvc.d.b cyh;
    private com.baidu.tbadk.mvc.a.a cyi;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.cye = i;
        this.cyg = aVar;
        this.cyh = bVar;
        this.cyi = aVar2;
    }

    public int auj() {
        return this.cye;
    }

    public com.baidu.tbadk.mvc.b.a auk() {
        return this.cyg;
    }

    public com.baidu.tbadk.mvc.d.b aul() {
        return this.cyh;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.cyh = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean aum() {
        return this.cyf;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
