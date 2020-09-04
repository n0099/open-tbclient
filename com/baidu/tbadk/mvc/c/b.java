package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int eQk;
    private boolean eQl = true;
    private com.baidu.tbadk.mvc.b.a eQm;
    private com.baidu.tbadk.mvc.d.b eQn;
    private com.baidu.tbadk.mvc.a.a eQo;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.eQk = i;
        this.eQm = aVar;
        this.eQn = bVar;
        this.eQo = aVar2;
    }

    public int btv() {
        return this.eQk;
    }

    public com.baidu.tbadk.mvc.b.a btw() {
        return this.eQm;
    }

    public com.baidu.tbadk.mvc.d.b btx() {
        return this.eQn;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.eQn = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean bty() {
        return this.eQl;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
