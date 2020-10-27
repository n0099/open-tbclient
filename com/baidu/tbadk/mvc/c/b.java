package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private Object extra;
    private int fnI;
    private boolean fnJ = true;
    private com.baidu.tbadk.mvc.b.a fnK;
    private com.baidu.tbadk.mvc.d.b fnL;
    private com.baidu.tbadk.mvc.a.a fnM;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.fnI = i;
        this.fnK = aVar;
        this.fnL = bVar;
        this.fnM = aVar2;
    }

    public int bzc() {
        return this.fnI;
    }

    public com.baidu.tbadk.mvc.b.a bzd() {
        return this.fnK;
    }

    public com.baidu.tbadk.mvc.d.b bze() {
        return this.fnL;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.fnL = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean bzf() {
        return this.fnJ;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
