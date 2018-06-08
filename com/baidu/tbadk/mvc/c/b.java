package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int aRk;
    private boolean aRl = true;
    private com.baidu.tbadk.mvc.b.a aRm;
    private com.baidu.tbadk.mvc.d.b aRn;
    private com.baidu.tbadk.mvc.a.a aRo;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.aRk = i;
        this.aRm = aVar;
        this.aRn = bVar;
        this.aRo = aVar2;
    }

    public int Jl() {
        return this.aRk;
    }

    public com.baidu.tbadk.mvc.b.a Jm() {
        return this.aRm;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean Jn() {
        return this.aRl;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
