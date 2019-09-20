package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int czh;
    private boolean czi = true;
    private com.baidu.tbadk.mvc.b.a czj;
    private com.baidu.tbadk.mvc.d.b czk;
    private com.baidu.tbadk.mvc.a.a czl;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.czh = i;
        this.czj = aVar;
        this.czk = bVar;
        this.czl = aVar2;
    }

    public int aux() {
        return this.czh;
    }

    public com.baidu.tbadk.mvc.b.a auy() {
        return this.czj;
    }

    public com.baidu.tbadk.mvc.d.b auz() {
        return this.czk;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.czk = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean auA() {
        return this.czi;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
