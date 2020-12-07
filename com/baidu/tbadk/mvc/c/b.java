package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private Object extra;
    private boolean fAA = true;
    private com.baidu.tbadk.mvc.b.a fAB;
    private com.baidu.tbadk.mvc.d.b fAC;
    private com.baidu.tbadk.mvc.a.a fAD;
    private int fAz;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.fAz = i;
        this.fAB = aVar;
        this.fAC = bVar;
        this.fAD = aVar2;
    }

    public int bEt() {
        return this.fAz;
    }

    public com.baidu.tbadk.mvc.b.a bEu() {
        return this.fAB;
    }

    public com.baidu.tbadk.mvc.d.b bEv() {
        return this.fAC;
    }

    public void a(com.baidu.tbadk.mvc.d.b bVar) {
        this.fAC = bVar;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean bEw() {
        return this.fAA;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
