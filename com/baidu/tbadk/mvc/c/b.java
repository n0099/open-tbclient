package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class b {
    private int eQg;
    private boolean eQh = true;
    private com.baidu.tbadk.mvc.b.a eQi;
    private com.baidu.tbadk.mvc.d.b eQj;
    private com.baidu.tbadk.mvc.a.a eQk;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.eQg = i;
        this.eQi = aVar;
        this.eQj = bVar;
        this.eQk = aVar2;
    }

    public int btu() {
        return this.eQg;
    }

    public com.baidu.tbadk.mvc.b.a btv() {
        return this.eQi;
    }

    public com.baidu.tbadk.mvc.d.b btw() {
        return this.eQj;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.eQj = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean btx() {
        return this.eQh;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
