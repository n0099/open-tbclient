package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int byl;
    private boolean bym = true;
    private com.baidu.tbadk.mvc.b.a byn;
    private com.baidu.tbadk.mvc.d.b byo;
    private com.baidu.tbadk.mvc.a.a byp;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.byl = i;
        this.byn = aVar;
        this.byo = bVar;
        this.byp = aVar2;
    }

    public int Nd() {
        return this.byl;
    }

    public com.baidu.tbadk.mvc.b.a Ne() {
        return this.byn;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean Nf() {
        return this.bym;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
