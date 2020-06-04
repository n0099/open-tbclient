package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int eqs;
    private boolean eqt = true;
    private com.baidu.tbadk.mvc.b.a equ;
    private com.baidu.tbadk.mvc.d.b eqv;
    private com.baidu.tbadk.mvc.a.a eqw;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.eqs = i;
        this.equ = aVar;
        this.eqv = bVar;
        this.eqw = aVar2;
    }

    public int beS() {
        return this.eqs;
    }

    public com.baidu.tbadk.mvc.b.a beT() {
        return this.equ;
    }

    public com.baidu.tbadk.mvc.d.b beU() {
        return this.eqv;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.eqv = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean beV() {
        return this.eqt;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
