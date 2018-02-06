package com.baidu.tbadk.mvc.c;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class b {
    private int byv;
    private boolean byw = true;
    private com.baidu.tbadk.mvc.b.a byx;
    private com.baidu.tbadk.mvc.d.b byy;
    private com.baidu.tbadk.mvc.a.a byz;
    private Object extra;
    private BdUniqueId uniqueId;

    public b(int i, com.baidu.tbadk.mvc.b.a aVar, com.baidu.tbadk.mvc.d.b bVar, com.baidu.tbadk.mvc.a.a aVar2) {
        this.byv = i;
        this.byx = aVar;
        this.byy = bVar;
        this.byz = aVar2;
    }

    public int Nd() {
        return this.byv;
    }

    public com.baidu.tbadk.mvc.b.a Ne() {
        return this.byx;
    }

    public Object getExtra() {
        return this.extra;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public boolean Nf() {
        return this.byw;
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.uniqueId = bdUniqueId;
    }
}
