package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int aIJ;
    private boolean aIK = true;
    private com.baidu.tbadk.mvc.b.a aIL;
    private com.baidu.tbadk.mvc.d.b aIM;
    private com.baidu.tbadk.mvc.a.a aIN;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.aIJ = i;
        this.aIL = aVar;
        this.aIM = bVar;
        this.aIN = aVar2;
    }

    public int FD() {
        return this.aIJ;
    }

    public com.baidu.tbadk.mvc.b.a FE() {
        return this.aIL;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean FF() {
        return this.aIK;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
