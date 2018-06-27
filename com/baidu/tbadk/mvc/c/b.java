package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int aSg;
    private boolean aSh = true;
    private com.baidu.tbadk.mvc.b.a aSi;
    private com.baidu.tbadk.mvc.d.b aSj;
    private com.baidu.tbadk.mvc.a.a aSk;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.aSg = i;
        this.aSi = aVar;
        this.aSj = bVar;
        this.aSk = aVar2;
    }

    public int JD() {
        return this.aSg;
    }

    public com.baidu.tbadk.mvc.b.a JE() {
        return this.aSi;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean JF() {
        return this.aSh;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
